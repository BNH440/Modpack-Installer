package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlime;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class FlexBlock extends Block {

	public FlexBlock() {
		super(Material.SPONGE);
		this.setRegistryName("flex_block");
        this.setUnlocalizedName("flex_block");
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		// TODO Auto-generated constructor stub
	}
	
}
