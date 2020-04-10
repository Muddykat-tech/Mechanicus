package com.mechanicus.client.renderer;

import javax.vecmath.Vector3d;

import org.lwjgl.opengl.GL11;

import com.mechanicus.client.model.FakePlayerModel;
import com.mechanicus.client.model.UpgradeStationModel;
import com.mechanicus.common.tileentities.MTEUpgradeStation;
import com.mechanicus.lib.MLib;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UpgradeStationRenderer extends TileEntityRenderer<MTEUpgradeStation> {
	private UpgradeStationModel model = new UpgradeStationModel();

	private static final ResourceLocation TEX_UPGRADE_STATION = new ResourceLocation(MLib.MODID,"textures/machines/upgrade_station.png");
	private static final ResourceLocation TEX_PMODEL = new ResourceLocation(MLib.MODID,"textures/machines/player_model.png");

	@Override
	public void render(MTEUpgradeStation tile, double x, double y, double z, float partialTickTime, int destroyStage) {
		GlStateManager.pushMatrix();
        GlStateManager.translatef((float)x + 0.4f, (float)y + 2.4F, (float)z + 0.5f);
        GlStateManager.rotatef(180F, 1F, 0F, 0F);
        GlStateManager.color4f(1f, 1f, 1f, 1f);
		this.bindTexture(TEX_UPGRADE_STATION);
		this.model.render(0.1f);
		
		this.bindTexture(TEX_PMODEL);
		GlStateManager.enableBlend();
		GlStateManager.disableAlphaTest();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		
		
		float rot = tile.getHoloRot();
		GlStateManager.rotatef(rot, 0F, 1F, 0F);
		FakePlayerModel pmodel = new FakePlayerModel(0.1F);
		pmodel.render(0.066f);
		GlStateManager.enableAlphaTest();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
	}
	
	@Override
	public boolean isGlobalRenderer(MTEUpgradeStation te) {
		// TODO Auto-generated method stub
		return true;
	}
}
