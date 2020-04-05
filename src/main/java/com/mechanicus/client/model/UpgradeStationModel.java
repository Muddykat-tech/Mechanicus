package com.mechanicus.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.entity.Entity;

public class UpgradeStationModel extends Model 
{
  //fields	
   RendererModel leftpart;
    RendererModel rightpart;
    RendererModel base;
  
  public UpgradeStationModel()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      leftpart = new RendererModel(this, 0, 0);
      leftpart.addBox(-4F, -9F, -1F, 8, 13, 3);
      leftpart.setRotationPoint(-11F, 20F, 11F);
      leftpart.setTextureSize(64, 32);
      leftpart.mirror = true;
      setRotation(leftpart, 0F, -0.7853982F, 0F);
      rightpart = new RendererModel(this, 0, 0);
      rightpart.addBox(-4F, -13F, -1F, 8, 13, 3);
      rightpart.setRotationPoint(11F, 24F, 11F);
      rightpart.setTextureSize(64, 32);
      rightpart.mirror = true;
      setRotation(rightpart, 0F, 0.7853982F, 0F);
      base = new RendererModel(this, 0, 0);
      base.addBox(-12F, 0F, -12F, 24, 2, 24);
      base.setRotationPoint(0F, 22F, 0F);
      base.setTextureSize(64, 32);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      
  }
  
  public void render(float scale)
  {
    leftpart.render(scale);
    rightpart.render(scale);
    base.render(scale);
  }
  
  private void setRotation(RendererModel model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  

}
