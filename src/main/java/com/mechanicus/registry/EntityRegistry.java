package com.mechanicus.registry;

import java.util.List;

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mechanicus.common.entity.MEntityServoSkull;
import com.mechanicus.lib.MLib;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = MLib.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
 
	private static List<EntityType> registeredEntities = Lists.newArrayList();
	public static List<Item> spawnEggs = Lists.newArrayList(); 
	
	public static final EntityType<MEntityServoSkull> SERVO_SKULL = createEntity(MEntityServoSkull.class, MEntityServoSkull::new, 0.5F, 0.75F, 0xFFFFFF, 0xFFFFFF);
    
    private static <T extends AnimalEntity> EntityType<T> createEntity(Class<T> entityClass, EntityType.IFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation(MLib.MODID, classToString(entityClass));
        EntityType<T> entity = EntityType.Builder.create(factory, EntityClassification.CREATURE).size(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        registeredEntities.add(entity);
        Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()).group(MLib.mechanicus));
        spawnEgg.setRegistryName(new ResourceLocation(MLib.MODID, classToString(entityClass)));
        spawnEggs.add(spawnEgg);
        return entity;
    }

    private static String classToString(Class<? extends AnimalEntity> entityClass) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName()).replace("entity_", "");
    }
    
    @SubscribeEvent
	public static void parseRegistry(Register<EntityType<?>> event) {
        for (EntityType entity : registeredEntities) {
        	Preconditions.checkNotNull(entity.getRegistryName(), "registryName");
            event.getRegistry().register(entity);
            EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MEntityServoSkull::func_223316_b);
        }
	}
	
	@SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        for (Item spawnEgg : spawnEggs) {
            Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
            event.getRegistry().register(spawnEgg);
        }
    }
}
