package com.mechanicus.common.crafting;

import java.util.ArrayList;

import com.mechanicus.registry.ItemRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ServoSkullCraftingRecipes {

	
	public static ArrayList<ServoSkullRecipe> recipes = new ArrayList<ServoSkullRecipe>();
	
	public static void initialize() {
		ArrayList<Item> plasteelInput = new ArrayList<Item>();
		plasteelInput.add(Items.REDSTONE);
		plasteelInput.add(Items.GLOWSTONE_DUST);
		plasteelInput.add(Items.IRON_INGOT);
		plasteelInput.add(Items.COAL);
		
		ArrayList<Item> plasteelOutput = new ArrayList<Item>();
		plasteelOutput.add(ItemRegistry.PLASTEEL_INGOT);
		
		recipes.add(new ServoSkullRecipe(plasteelInput, plasteelOutput));
		
		ArrayList<Item> armPlasteelIn = new ArrayList<Item>();
		armPlasteelIn.add(ItemRegistry.PLASTEEL_INGOT);
		armPlasteelIn.add(ItemRegistry.PLASTEEL_INGOT);
		armPlasteelIn.add(Items.PISTON);
		armPlasteelIn.add(ItemRegistry.UNKNOWN_MACHINE_PART);
		armPlasteelIn.add(Items.REDSTONE);
		
		ArrayList<Item> armPlasteelOut = new ArrayList<Item>();
		armPlasteelOut.add(ItemRegistry.UPGRADE_RIGHT_ARM_PLASTEEL);
		armPlasteelOut.add(ItemRegistry.UPGRADE_LEFT_ARM_PLASTEEL);
		
		recipes.add(new ServoSkullRecipe(armPlasteelIn, armPlasteelOut));
		
		ArrayList<Item> plasteelInput2 = new ArrayList<Item>();
		plasteelInput2.add(Items.REDSTONE);
		plasteelInput2.add(Items.GLOWSTONE_DUST);
		plasteelInput2.add(Items.GOLD_INGOT);
		plasteelInput2.add(Items.COAL);
		
		ArrayList<Item> plasteelOutput2 = new ArrayList<Item>();
		plasteelOutput2.add(ItemRegistry.PLASTEEL_INGOT);
		plasteelOutput2.add(ItemRegistry.PLASTEEL_INGOT);

		recipes.add(new ServoSkullRecipe(plasteelInput2, plasteelOutput2));
	}
}
