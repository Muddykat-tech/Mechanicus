package com.mechanicus.common.capabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class SimpCapabilityProvider<C> implements ICapabilityProvider {
	private final C capInstance;
	private final LazyOptional<C> capOptional;
	
	private final Capability<C> capability;
	
	public SimpCapabilityProvider(Capability<C> capability, C capInstance) {
		this.capability = capability;
		this.capInstance = capInstance;
		this.capOptional = LazyOptional.of(() -> this.capInstance);
	}
	
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return capability.orEmpty(cap, capOptional);
	}

	public static <C> void attach(AttachCapabilitiesEvent<?> event, ResourceLocation key, Capability<C> cap, C capInstance) {
		SimpCapabilityProvider<C> provider = new SimpCapabilityProvider<>(cap, capInstance);
		event.addCapability(key, provider);
		event.addListener(provider.capOptional::invalidate);
	}
}
