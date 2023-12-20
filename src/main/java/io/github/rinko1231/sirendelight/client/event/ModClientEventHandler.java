package io.github.rinko1231.sirendelight.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEventHandler {
    @SubscribeEvent
    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            //RenderTypeLookup.setRenderLayer(ModFluids.SIREN_MILK_FLOWING.get(), RenderType.translucent());
            //RenderTypeLookup.setRenderLayer(ModFluids.SIREN_MILK_SOURCE.get(), RenderType.translucent());
        });
    }
}