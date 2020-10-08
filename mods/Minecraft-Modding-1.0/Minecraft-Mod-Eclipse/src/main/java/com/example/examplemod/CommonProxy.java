package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityBat;

import java.rmi.registry.Registry;

@EventBusSubscriber
public class CommonProxy {
	
    public static void registerRenderItem(Item item){
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
    

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ExampleMod.mySword);
        event.getRegistry().registerAll(ExampleMod.flexPaste);
        event.getRegistry().registerAll(ExampleMod.slimeStick);
    }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	  event.getRegistry().registerAll(ExampleMod.flexBlock);
	}
    
    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
      event.getRegistry().registerAll(new ItemBlock(ExampleMod.flexBlock).setRegistryName(ExampleMod.flexBlock.getRegistryName()));
    }
    
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
    	registerRenderItem(ExampleMod.mySword);
    	registerRenderItem(ExampleMod.flexPaste);
    	registerRenderItem(Item.getItemFromBlock(ExampleMod.flexBlock));
    	registerRenderItem(ExampleMod.slimeStick);
    }
    
    @SubscribeEvent
    public static void onHurt(LivingAttackEvent event) {
    	String damageType = event.getSource().getDamageType();
    	EntityLivingBase victimEntity = event.getEntityLiving();
    	Entity attackingEntity = event.getSource().getTrueSource();
    	ItemStack heldItem = ((EntityLivingBase)attackingEntity).getHeldItem(EnumHand.MAIN_HAND);
    	if(attackingEntity instanceof EntityPlayer) {
    		if(heldItem == new ItemStack(ExampleMod.mySword)){
    			victimEntity.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 100, 255));
    		}
    	}
    }
}
