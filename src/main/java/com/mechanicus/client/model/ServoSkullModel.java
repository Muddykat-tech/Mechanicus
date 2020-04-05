package com.mechanicus.client.model;

import javax.annotation.Nonnull;

import com.mechanicus.common.entity.MEntityServoSkull;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class ServoSkullModel<T extends MEntityServoSkull> extends EntityModel<T> {
    RendererModel basehead;
    RendererModel headfaceupper;
    RendererModel headfaceside2;
    RendererModel headtooth2;
    RendererModel headtooth1;
    RendererModel headfacenoseplate;
    RendererModel headfaceside1;
    RendererModel headfaceeyeplate1;
    RendererModel headfacenosebridge;
    RendererModel headfaceeyeplate2;
    RendererModel headattahment1;
    RendererModel headattahment2;
    RendererModel headattahment3;
    RendererModel headattahment4;
    RendererModel spineseg1;
    RendererModel spineseg2;
    RendererModel spineseg3;
    
	public ServoSkullModel() {
		  this.textureHeight = 64;
		  this.textureWidth = 64;
			
		  basehead = new RendererModel(this, 0, 0);
	      basehead.addBox(-4F, -4F, -3F, 8, 7, 7);
	      basehead.setRotationPoint(0F, 0F, 0F);
	      basehead.setTextureSize(64, 32);
	      basehead.mirror = true;
	      setRotation(basehead, 0F, 0F, 0F);
	      headfaceupper = new RendererModel(this, 31, 0);
	      headfaceupper.addBox(-4F, -4F, 0F, 8, 2, 1);
	      headfaceupper.setRotationPoint(0F, 0F, -4F);
	      headfaceupper.setTextureSize(64, 32);
	      headfaceupper.mirror = true;
	      setRotation(headfaceupper, 0F, 0F, 0F);
	      headfaceside2 = new RendererModel(this, 31, 4);
	      headfaceside2.addBox(-1F, -2F, 0F, 1, 2, 1);
	      headfaceside2.setRotationPoint(4F, 0F, -4F);
	      headfaceside2.setTextureSize(64, 32);
	      headfaceside2.mirror = true;
	      setRotation(headfaceside2, 0F, 0F, 0F);
	      headtooth2 = new RendererModel(this, 50, 0);
	      headtooth2.addBox(0F, 0F, 0F, 1, 1, 1);
	      headtooth2.setRotationPoint(-3F, 2F, -4F);
	      headtooth2.setTextureSize(64, 32);
	      headtooth2.mirror = true;
	      setRotation(headtooth2, 0F, 0F, 0F);
	      headtooth1 = new RendererModel(this, 50, 0);
	      headtooth1.addBox(0F, 0F, 0F, 1, 1, 1);
	      headtooth1.setRotationPoint(2F, 2F, -4F);
	      headtooth1.setTextureSize(64, 32);
	      headtooth1.mirror = true;
	      setRotation(headtooth1, 0F, 0F, 0F);
	      headfacenoseplate = new RendererModel(this, 31, 8);
	      headfacenoseplate.addBox(-1F, -1F, 0F, 2, 2, 1);
	      headfacenoseplate.setRotationPoint(0F, 2F, -4F);
	      headfacenoseplate.setTextureSize(64, 32);
	      headfacenoseplate.mirror = true;
	      setRotation(headfacenoseplate, 0F, 0F, 0F);
	      headfaceside1 = new RendererModel(this, 36, 4);
	      headfaceside1.addBox(-1F, -2F, 0F, 1, 2, 1);
	      headfaceside1.setRotationPoint(-3F, 0F, -4F);
	      headfaceside1.setTextureSize(64, 32);
	      headfaceside1.mirror = true;
	      setRotation(headfaceside1, 0F, 0F, 0F);
	      headfaceeyeplate1 = new RendererModel(this, 41, 4);
	      headfaceeyeplate1.addBox(-1F, -1F, 0F, 2, 2, 1);
	      headfaceeyeplate1.setRotationPoint(2F, 1F, -4F);
	      headfaceeyeplate1.setTextureSize(64, 32);
	      headfaceeyeplate1.mirror = true;
	      setRotation(headfaceeyeplate1, 0F, 0F, 0F);
	      headfacenosebridge = new RendererModel(this, 48, 4);
	      headfacenosebridge.addBox(-1F, -1F, 0F, 2, 2, 1);
	      headfacenosebridge.setRotationPoint(0F, -1F, -4F);
	      headfacenosebridge.setTextureSize(64, 32);
	      headfacenosebridge.mirror = true;
	      setRotation(headfacenosebridge, 0F, 0F, 0F);
	      headfaceeyeplate2 = new RendererModel(this, 0, 15);
	      headfaceeyeplate2.addBox(-1F, -1F, 0F, 2, 2, 1);
	      headfaceeyeplate2.setRotationPoint(-2F, 1F, -4F);
	      headfaceeyeplate2.setTextureSize(64, 32);
	      headfaceeyeplate2.mirror = true;
	      setRotation(headfaceeyeplate2, 0F, 0F, 0F);
	      headattahment1 = new RendererModel(this, 7, 15);
	      headattahment1.addBox(0F, 0F, 0F, 2, 1, 3);
	      headattahment1.setRotationPoint(2F, -5F, 2F);
	      headattahment1.setTextureSize(64, 32);
	      headattahment1.mirror = true;
	      setRotation(headattahment1, 0F, 0F, 0F);
	      headattahment2 = new RendererModel(this, 0, 20);
	      headattahment2.addBox(0F, 0F, 0F, 1, 5, 4);
	      headattahment2.setRotationPoint(4F, -5F, 1F);
	      headattahment2.setTextureSize(64, 32);
	      headattahment2.mirror = true;
	      setRotation(headattahment2, 0F, 0F, 0F);
	      headattahment3 = new RendererModel(this, 0, 30);
	      headattahment3.addBox(0F, 0F, 0F, 2, 4, 1);
	      headattahment3.setRotationPoint(2F, -4F, 4F);
	      headattahment3.setTextureSize(64, 32);
	      headattahment3.mirror = true;
	      setRotation(headattahment3, 0F, 0F, 0F);
	      headattahment4 = new RendererModel(this, 0, 36);
	      headattahment4.addBox(0F, -4F, 0F, 1, 4, 1);
	      headattahment4.setRotationPoint(3F, -4F, 1F);
	      headattahment4.setTextureSize(64, 32);
	      headattahment4.mirror = true;
	      setRotation(headattahment4, 0F, 0F, 0F);
	      spineseg1 = new RendererModel(this, 24, 15);
	      spineseg1.addBox(0F, 0F, -1F, 1, 3, 2);
	      spineseg1.setRotationPoint(-0.5F, 3F, 1F);
	      spineseg1.setTextureSize(64, 32);
	      spineseg1.mirror = true;
	      setRotation(spineseg1, 0F, 0F, 0F);
	      spineseg2 = new RendererModel(this, 24, 21);
	      spineseg2.addBox(0F, 0F, 0F, 1, 3, 2);
	      spineseg2.setRotationPoint(-0.5F, 6F, 0F);
	      spineseg2.setTextureSize(64, 32);
	      spineseg2.mirror = true;
	      setRotation(spineseg2, -0.1858931F, 0F, 0F);
	      spineseg3 = new RendererModel(this, 26, 27);
	      spineseg3.addBox(-2.997602E-15F, 0F, 0F, 1, 4, 1);
	      spineseg3.setRotationPoint(-0.5F, 9F, 0F);
	      spineseg3.setTextureSize(64, 32);
	      spineseg3.mirror = true;
	      setRotation(spineseg3, -0.5F, 0F, 0F);
	      
	      basehead.addChild(headattahment1);
	      basehead.addChild(headattahment2);
	      basehead.addChild(headattahment3);
	      basehead.addChild(headattahment4);
	      basehead.addChild(headfaceeyeplate1);
	      basehead.addChild(headfaceeyeplate2);
	      basehead.addChild(headfacenosebridge);
	      basehead.addChild(headfacenoseplate);
	      basehead.addChild(headfaceside1);
	      basehead.addChild(headfaceside2);
	      basehead.addChild(headfaceupper);
	      basehead.addChild(spineseg1);
	      basehead.addChild(spineseg2);
	      basehead.addChild(spineseg3);
	      basehead.addChild(headtooth1);
	      basehead.addChild(headtooth2);
	}

	@Override
	public void render(@Nonnull MEntityServoSkull skull, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch, float scale) {
		this.basehead.render(scale);
	}

	private void setRotation(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(@Nonnull MEntityServoSkull skull, float limbSwing, float limbSwingAmount,
			float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		this.basehead.rotateAngleX = headPitch * 0.017453292F;
		this.basehead.rotateAngleY = netHeadYaw * 0.017453292F;
		this.basehead.rotateAngleZ = (MathHelper.cos(limbSwing * 1.3324F) * 1.4F * limbSwingAmount) / 6;
	}

}
