package com.mechanicus.client.model;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;

public class FakePlayerModel extends Model {

	public RendererModel bipedHead;
	public RendererModel bipedHeadwear;
	public RendererModel bipedBody;
	public RendererModel bipedRightArm;
	public RendererModel bipedLeftArm;
	public RendererModel bipedRightLeg;
	public RendererModel bipedLeftLeg;

	public FakePlayerModel(float modelSize) {
	      this(modelSize, 0.0F, 64, 32);
	   }

	public FakePlayerModel(float modelSize, float p_i1149_2_, int textureWidthIn, int textureHeightIn) {
	      this.textureWidth = textureWidthIn;
	      this.textureHeight = textureHeightIn;
	      this.bipedHead = new RendererModel(this, 0, 0);
	      this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, modelSize);
	      this.bipedHead.setRotationPoint(0.0F, 0.0F + p_i1149_2_, 0.0F);
	      this.bipedHeadwear = new RendererModel(this, 32, 0);
	      this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, modelSize + 0.5F);
	      this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + p_i1149_2_, 0.0F);
	      this.bipedBody = new RendererModel(this, 16, 16);
	      this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, modelSize);
	      this.bipedBody.setRotationPoint(0.0F, 0.0F + p_i1149_2_, 0.0F);
	      this.bipedRightArm = new RendererModel(this, 40, 16);
	      this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, modelSize);
	      this.bipedRightArm.setRotationPoint(-5.0F, 2.0F + p_i1149_2_, 0.0F);
	      this.bipedLeftArm = new RendererModel(this, 40, 16);
	      this.bipedLeftArm.mirror = true;
	      this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, modelSize);
	      this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + p_i1149_2_, 0.0F);
	      this.bipedRightLeg = new RendererModel(this, 0, 16);
	      this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize);
	      this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F + p_i1149_2_, 0.0F);
	      this.bipedLeftLeg = new RendererModel(this, 0, 16);
	      this.bipedLeftLeg.mirror = true;
	      this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize);
	      this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F + p_i1149_2_, 0.0F);
	   }
	
	public void render(float scale) {
	      GlStateManager.pushMatrix();
	     
         this.bipedHead.render(scale);
         this.bipedBody.render(scale);
         this.bipedRightArm.render(scale);
         this.bipedLeftArm.render(scale);
         this.bipedRightLeg.render(scale);
         this.bipedLeftLeg.render(scale);
         this.bipedHeadwear.render(scale);
	      
	      GlStateManager.popMatrix();
	   }
}
