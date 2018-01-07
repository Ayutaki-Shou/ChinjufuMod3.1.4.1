package com.ayutaki.chinjufumod.init.garden;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.init.ASDecoModGarden;
import com.ayutaki.chinjufumod.init.blocks.BlockFacingSapo;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Lit_Longtourou_and extends BlockFacingSapo {

	public Lit_Longtourou_and() {
		super(Material.WOOD);

		this.setSoundType(SoundType.STONE);
		this.setHardness(1.0F);
		this.setResistance(5.0F);

		this.setLightLevel(1.0F);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side,
			float hitX, float hitY, float hitZ) {

    	if (heldItem == null) {

    		if (playerIn instanceof EntityPlayer)
				((EntityPlayer) playerIn).inventory
				.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.TORCH), 1));

    		worldIn.setBlockState(pos, ASDecoModGarden.LONGTOUROU_and
    				.getDefaultState().withProperty(FACING, state.getValue(FACING)));
    	}
    	return true;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.875D, 0.875D);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {

	    return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

	        stack.add(new ItemStack(ASDecoModGarden.LONGTOUROU_and, 1, this.damageDropped(state)));
	        stack.add(new ItemStack(Blocks.TORCH, 1, this.damageDropped(state)));

	        return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(ASDecoModGarden.LONGTOUROU_and);
	}
}
