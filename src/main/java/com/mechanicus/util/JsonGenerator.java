package com.mechanicus.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.stream.JsonWriter;
import com.mechanicus.lib.MLib;

public class JsonGenerator {
	
	public void generateDefaultItem(String registryName)
	{
		try
		{
			File file = new File("../src/main/resources/assets/"+ MLib.MODID + "/models/item/"+registryName+".json");
			if(!file.exists())
			{
				JsonWriter jsonWriter = new JsonWriter(new FileWriter(file));
				jsonWriter.setIndent(" "); //this makes it more readable for humans!
				jsonWriter.beginObject();
				jsonWriter.name("parent").value("item/generated");
				jsonWriter.name("textures");
				jsonWriter.beginObject();
					jsonWriter.name("layer0");
					jsonWriter.value(MLib.MODID +":items/" + registryName);
				jsonWriter.endObject();
				jsonWriter.endObject();
				jsonWriter.close();
			}
		} catch(IOException e)
		{

		}

	}
	
	public void generateDefaultBlock(String registryName) throws IOException {
		File state = new File("../src/main/resources/assets/"+ MLib.MODID +"/blockstates/" + registryName + ".json");
		if(!state.exists()) {
			JsonWriter jsonWriter = new JsonWriter(new FileWriter(state)); 
			jsonWriter.setIndent(" "); //this makes it more readable for humans!
			jsonWriter.beginObject();
				jsonWriter.name("variants");
				jsonWriter.beginObject();
					jsonWriter.name("");
					jsonWriter.beginObject();
						jsonWriter.name("model");
						jsonWriter.value(MLib.MODID +":block/" + registryName);
					jsonWriter.endObject();
				jsonWriter.endObject();
			jsonWriter.endObject();
		    jsonWriter.close();
		}
		
		File block = new File("../src/main/resources/assets/"+ MLib.MODID + "/models/block/" + registryName + ".json");
		if(!block.exists()) {
			JsonWriter jsonWriter = new JsonWriter(new FileWriter(block)); 
			jsonWriter.setIndent(" "); //this makes it more readable for humans!
			jsonWriter.beginObject();
				jsonWriter.name("parent").value("block/cube_all");
				jsonWriter.name("textures");
				jsonWriter.beginObject();
					jsonWriter.name("all");
					jsonWriter.value(MLib.MODID +":blocks/" + registryName);
				jsonWriter.endObject();
			jsonWriter.endObject();
		    jsonWriter.close();
		}
		
		File item = new File("../src/main/resources/assets/"+ MLib.MODID + "/models/item/" + registryName + ".json");
		if(!item.exists()) {
			JsonWriter jsonWriter = new JsonWriter(new FileWriter(item)); 
			jsonWriter.setIndent(" "); //this makes it more readable for humans!
			jsonWriter.beginObject();
				jsonWriter.name("parent").value(MLib.MODID + ":block/" + registryName);
			jsonWriter.endObject();
		    jsonWriter.close();
		}
	}
}
