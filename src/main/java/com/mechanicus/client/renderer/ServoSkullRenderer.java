package com.mechanicus.client.renderer;

import javax.annotation.Nonnull;

import com.mechanicus.client.model.ServoSkullModel;
import com.mechanicus.common.entity.MEntityServoSkull;
import com.mechanicus.lib.MLib;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ServoSkullRenderer extends MobRenderer<MEntityServoSkull, ServoSkullModel<MEntityServoSkull>> {

	public ServoSkullRenderer(EntityRendererManager renderManager) {
		super(renderManager, new ServoSkullModel<>(), 0.5F);
	}
	
	@Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull MEntityServoSkull skull) {
        String name = skull.getName().getString().toLowerCase().trim();
        return this.getSkullTexture("default");
    }

    private ResourceLocation getSkullTexture(String fileName) {
        return new ResourceLocation(MLib.MODID, "textures/entity/servo_skull/" + fileName + ".png");
    }
	
}
