package com.mechanicus.common.entity;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.mechanicus.client.sound.MSoundRegistry;
import com.mechanicus.common.crafting.ServoSkullCraftingRecipes;
import com.mechanicus.common.crafting.ServoSkullRecipe;
import com.mechanicus.common.entity.helper.ServoSkullContainerProvider;
import com.mechanicus.registry.EntityRegistry;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class MEntityServoSkull extends AnimalEntity implements IInventoryChangedListener {
	protected Inventory inventory;

	public MEntityServoSkull(EntityType<? extends MEntityServoSkull> type, World worldIn) {
		super(type, worldIn);
		this.stepHeight = 1.0f;
		this.setupInventory();
	}

	private void setupInventory() {
		Inventory inventory = this.inventory;
		this.inventory = new Inventory(this.getInventorySize());
		if (inventory != null) {
			inventory.removeListener(this);
			int i = Math.min(inventory.getSizeInventory(), this.inventory.getSizeInventory());

			for (int j = 0; j < i; ++j) {
				ItemStack itemstack = inventory.getStackInSlot(j);
				if (!itemstack.isEmpty()) {
					this.inventory.setInventorySlotContents(j, itemstack.copy());
				}
			}
		}

		this.inventory.addListener(this);
		this.itemHandler = net.minecraftforge.common.util.LazyOptional
				.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
	}

	private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(
			net.minecraftforge.common.capabilities.Capability<T> capability,
			@Nullable net.minecraft.util.Direction facing) {
		if (this.isAlive() && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY
				&& itemHandler != null)
			return itemHandler.cast();
		return super.getCapability(capability, facing);
	}

	@Override
	public void remove(boolean keepData) {
		super.remove(keepData);
		if (!keepData && itemHandler != null) {
			itemHandler.invalidate();
			itemHandler = null;
		}
	}

	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		if (player.isSneaking() && player.getHeldItemMainhand().isEmpty()) {
			World world = player.world;

			ItemEntity itm = new ItemEntity(world, player.getPosition().getX(), player.getPosition().getY(),
					player.getPosition().getZ(), new ItemStack(EntityRegistry.spawnEggs.get(0)));
			world.addEntity(itm);
			this.remove();
		} else {
			if (!player.world.isRemote) {
				NetworkHooks.openGui((ServerPlayerEntity) player, new ServoSkullContainerProvider(this.getEntityId()),  
					(data) -> {
						data.writeVarInt(this.getEntityId());
					});
			}
		}
		return super.processInteract(player, hand);
	}
	boolean startCraft = false;
	boolean hasRecipe = false;
	@Override
	public void tick() {
		ArrayList<Item> inputs = new ArrayList<Item>();
		
		for(int i = 0; i < 5; i++) {
			if(!this.inventory.getStackInSlot(i).isEmpty()) {
				inputs.add(this.inventory.getStackInSlot(i).getItem());
			}
		}
		
		boolean hasTakenInputs = false;
		
		//single output recipe not working?
		//input consumption not working
		for(ServoSkullRecipe rec : ServoSkullCraftingRecipes.recipes) {
			if(inputs.containsAll(rec.getInputs())) {
				
				if(startCraft == false) {
					if(rec.hasChoiceOutput()) {
						this.inventory.setInventorySlotContents(5,new ItemStack(rec.getOutputs().get(0)));
						this.inventory.setInventorySlotContents(6,new ItemStack(rec.getOutputs().get(1)));
						hasTakenInputs = true;
						hasRecipe = true;
					} else {
						this.inventory.setInventorySlotContents(5,new ItemStack(rec.getOutputs().get(0)));
						hasTakenInputs = true;
						hasRecipe = true;
					}
					startCraft = true;
				}
				
				if(startCraft == true) {
					if(rec.hasChoiceOutput()) {
						if(this.inventory.getStackInSlot(5).isEmpty() || this.inventory.getStackInSlot(6).isEmpty()) {
							if(!hasTakenInputs) {
								for(int k = 0; k < 7; k++) {
									this.inventory.decrStackSize(k, 1);
								}
								hasTakenInputs = true;
							}
							
							startCraft = false;
						}
					} else {
						if(this.inventory.getStackInSlot(5).isEmpty()) {
							if(!hasTakenInputs) {
								for(int k = 0; k < 5; k++) {
									this.inventory.decrStackSize(k, 1);
								}
								hasTakenInputs = true;
							}
							startCraft = false;
						}
					}
				}
				
				this.inventory.markDirty();
			} else {
				if(startCraft == true && !hasRecipe) {
					this.inventory.setInventorySlotContents(5,ItemStack.EMPTY);
					this.inventory.setInventorySlotContents(6,ItemStack.EMPTY);
				}
			}
			
		}
		super.tick();
	}
	
	@Override
	protected void dropLoot(DamageSource p_213354_1_, boolean p_213354_2_) {
		World world = this.world;
		ItemEntity itm = new ItemEntity(world, this.getPosition().getX(), this.getPosition().getY(),
				this.getPosition().getZ(), new ItemStack(EntityRegistry.spawnEggs.get(0)));
		world.addEntity(itm);
		super.dropLoot(p_213354_1_, p_213354_2_);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.16D);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return MSoundRegistry.SERVO_SKULL_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return MSoundRegistry.SERVO_SKULL_AMBIENT;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
		this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return inventory;
	}

	protected int getInventorySize() {
		return 7;
	}

	@Override
	public void onInventoryChanged(IInventory invBasic) {
		
	}
}
