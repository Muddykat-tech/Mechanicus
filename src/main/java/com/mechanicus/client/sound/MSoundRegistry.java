package com.mechanicus.client.sound;

import java.util.List;

import com.google.common.collect.Lists;
import com.mechanicus.lib.MLib;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = MLib.MODID, bus = EventBusSubscriber.Bus.MOD)
@ObjectHolder(MLib.MODID)
public class MSoundRegistry {

	private static List<SoundEvent> sounds = Lists.newArrayList();
	public static final SoundEvent SERVO_SKULL_AMBIENT = createSound("servo.skull.ambient");

	private static SoundEvent createSound(String name) {
        ResourceLocation resourceLocation = new ResourceLocation(MLib.MODID, name);
        SoundEvent sound = new SoundEvent(resourceLocation);
        sound.setRegistryName(resourceLocation);
        sounds.add(sound);
        return sound;
    }

    @SubscribeEvent
    public static void registerSound(RegistryEvent.Register<SoundEvent> event) {
        for (SoundEvent sound : sounds) {
            event.getRegistry().register(sound);
        }
    }
	
}