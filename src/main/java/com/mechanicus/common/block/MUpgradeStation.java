package com.mechanicus.common.block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.mechanicus.client.renderer.MItemStackTileEntityRenderer;
import com.mechanicus.common.tileentities.MTEUpgradeStation;
import com.mechanicus.lib.MLib;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class MUpgradeStation extends MBaseBlock {

	public static VoxelShape shape = VoxelShapes.empty();
	public static String name;

	public MUpgradeStation(Properties properties, String registryName) {
		super(properties, registryName);
		this.name = registryName;

		this.itemBlock = new MBlockItem(this, new net.minecraft.item.Item.Properties().group(MLib.mechanicus)
				.setTEISR(() -> MItemStackTileEntityRenderer::new)).setRegistryName(registryName);

		VoxelShape base = VoxelShapes.create(-.8, 0.0, -.7, 1.6, 0.2, 1.7);
		VoxelShape side1 = VoxelShapes.empty();
		VoxelShape side2 = VoxelShapes.empty();
		shape = VoxelShapes.or(base, side1, side2);

	}

	@Override
	public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return shape;
	}

	@Override
	public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return shape;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return shape;
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
		return new MTEUpgradeStation();
	}

	public MTEUpgradeStation getTileEntity(IBlockReader blockAccess, BlockPos pos) {
		TileEntity tile = blockAccess.getTileEntity(pos);
		return (tile instanceof MTEUpgradeStation) ? (MTEUpgradeStation) tile : null;
	}

	public static String getName() {
		return name;
	}
}
