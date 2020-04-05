package com.mechanicus.common.block;

import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.state.IProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.IBlockReader;

public class MTEBase extends MBaseBlock {
	private final Supplier<TileEntityType<?>> tileType;
	
	public MTEBase(String name, Supplier<TileEntityType<?>> tileType, Properties blockProps, IProperty<?>... stateProps) {
		super(blockProps, name);
		this.tileType = tileType;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world)
	{
		return tileType.get().create();
	}
}
