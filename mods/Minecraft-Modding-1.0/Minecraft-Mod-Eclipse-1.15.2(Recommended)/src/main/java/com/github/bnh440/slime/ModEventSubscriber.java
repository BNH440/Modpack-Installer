package com.github.bnh440.slime;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {
    @SubscribeEvent
    public String loginEvent(PlayerEvent.NameFormat event) {
        String userName = "Mumbo Jumbo";
        return userName;
    }
}
