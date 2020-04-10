package com.mechanicus.registry;

import com.mechanicus.client.gui.screen.ServoScreen;
import com.mechanicus.common.gui.container.ServoSkullContainer;
import com.mechanicus.lib.MLib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

public class ContainerRegistry {

	@ObjectHolder(MLib.MODID + ":servo_skull_container")
	public static ContainerType<ServoSkullContainer> SERVO_SKULL;
	
	public static void parseRegistry(RegistryEvent.Register<ContainerType<?>> event) {
        event.getRegistry().register(IForgeContainerType.create((windowID, inv, data) ->
        {
        	int entityID = data.readVarInt();
        	return new ServoSkullContainer(windowID, inv, entityID);
        }).setRegistryName("servo_skull_container"));
	}
	
	public static void registerScreens () {
		ScreenManager.registerFactory(SERVO_SKULL, ServoScreen::new);
	}
} 
 