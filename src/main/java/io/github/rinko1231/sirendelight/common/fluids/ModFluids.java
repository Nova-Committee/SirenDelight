package io.github.rinko1231.sirendelight.common.fluids;

import io.github.rinko1231.sirendelight.SirenDelight;
import io.github.rinko1231.sirendelight.common.blocks.ModBlocks;
import io.github.rinko1231.sirendelight.common.ref.ItemRef;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, SirenDelight.MODID);

    public static RegistryObject<FlowingFluid> SIREN_MILK_SOURCE;
    public static RegistryObject<FlowingFluid> SIREN_MILK_FLOWING;

    public static void registerFluids() {
        ForgeFlowingFluid.Properties SIREN_MILK_PROPERTIES = new ForgeFlowingFluid.Properties(
                () -> SIREN_MILK_SOURCE.get(),
                () -> SIREN_MILK_FLOWING.get(),
                FluidAttributes.builder(
                                new ResourceLocation(SirenDelight.MODID, "block/siren_milk_still"),
                                new ResourceLocation(SirenDelight.MODID, "block/siren_milk_flowing")
                        )
                        .rarity(Rarity.COMMON)
                        .luminosity(12)
                        .density(2000)
                        .viscosity(3000)
                        .temperature(1000)
        ).bucket(ItemRef.SIREN_MILK_BUCKET).block(() -> (FlowingFluidBlock) ModBlocks.SIREN_MILK_BLOCK.get());
        SIREN_MILK_SOURCE = FLUIDS.register("siren_milk_source", () -> new ForgeFlowingFluid.Source(SIREN_MILK_PROPERTIES));
        SIREN_MILK_FLOWING = FLUIDS.register("siren_milk_flowing", () -> new ForgeFlowingFluid.Flowing(SIREN_MILK_PROPERTIES));
    }
}