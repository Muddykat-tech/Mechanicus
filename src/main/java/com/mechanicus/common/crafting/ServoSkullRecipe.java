package com.mechanicus.common.crafting;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ServoSkullRecipe {

	private ArrayList<Item> inputs  = new ArrayList<Item>();
	private ArrayList<Item> outputs = new ArrayList<Item>();
	
	public ServoSkullRecipe(ArrayList<Item> input, ArrayList<Item> output) {
		inputs = input;
		outputs = output;
	}
	
	public ArrayList<Item> getInputs(){
		return inputs;
	}
	
	public ArrayList<Item> getOutputs(){
		return outputs;
	}

	public boolean hasChoiceOutput() {
		if(outputs.size() > 1) {
			return true;
		} else{
			return false;
		}
	}
	
}
