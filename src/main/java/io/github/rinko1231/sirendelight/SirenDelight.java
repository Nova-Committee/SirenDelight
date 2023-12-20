package io.github.rinko1231.sirendelight;

import io.github.rinko1231.sirendelight.common.blocks.ModBlocks;
import io.github.rinko1231.sirendelight.common.fluids.ModFluids;
import io.github.rinko1231.sirendelight.common.ref.ItemRef;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(SirenDelight.MODID)
public class SirenDelight {
    public static final String MODID = "sirendelight";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public SirenDelight() {
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModFluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModFluids.registerFluids();
        ItemRef.init();
    }


}
