package com.example.examplemod;

import com.google.common.eventbus.Subscribe;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "flex";
    public static final String NAME = "Flex Paste Sword";
    public static final String VERSION = "1.0";

    public static Item.ToolMaterial swordMaterial;
    public static Item mySword;
    public static Item flexPaste;
    public static Block flexBlock;
    public static Item slimeStick;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        swordMaterial = EnumHelper.addToolMaterial("my_sword", 4, 1000, 20.0F, 10.0F, 30);
        mySword = new CustomSword();
        flexPaste = new FlexPaste();
        flexBlock = new FlexBlock();
        slimeStick = new SlimeStick();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> " + Blocks.DIRT.getUnlocalizedName());
    }
    
    
}
