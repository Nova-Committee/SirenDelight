package io.github.rinko1231.sirendelight.common.blocks;

import io.github.rinko1231.sirendelight.SirenDelight;
import io.github.rinko1231.sirendelight.common.fluids.ModFluids;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SirenDelight.MODID);
    // fluids
    public static final RegistryObject<Block> SIREN_MILK_BLOCK = BLOCKS.register("siren_milk", () ->
            new FlowingFluidBlock(ModFluids.SIREN_MILK_SOURCE, AbstractBlock.Properties.of(Material.LAVA).noCollission().strength(100.0F)
                    .lightLevel((state) -> 12).noDrops()));
}