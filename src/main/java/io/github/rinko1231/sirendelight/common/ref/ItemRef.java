package io.github.rinko1231.sirendelight.common.ref;

import io.github.rinko1231.sirendelight.SirenDelight;
import io.github.rinko1231.sirendelight.common.fluids.ModFluids;
import io.github.rinko1231.sirendelight.common.groups.SirenCreativeTab;
import io.github.rinko1231.sirendelight.common.item.BaseFoodItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;

import java.util.Locale;
import java.util.function.Supplier;

public enum ItemRef implements Supplier<Item> {
    DARK_TIDE_CHEESE(() -> BaseFoodItem.Builder.create()
            .effect(new EffectInstance(Effects.WATER_BREATHING, 400, 1))
            .properties(new Item.Properties()
                    .tab(SirenCreativeTab.INSTANCE)
                    .food(new Food.Builder()
                            .nutrition(5)
                            .saturationMod(1.0F)
                            .build()))
            .build()),
    JADE_SEA_CHEESE(() -> BaseFoodItem.Builder.create()
            .effect(new EffectInstance(Effects.WATER_BREATHING, 400, 1))
            .properties(new Item.Properties()
                    .tab(SirenCreativeTab.INSTANCE)
                    .food(new Food.Builder()
                            .nutrition(3)
                            .saturationMod(1.0F)
                            .build()))
            .build()),
    MERMAID_CREAM_PUFF(() -> BaseFoodItem.Builder.create()
            .properties(new Item.Properties()
                    .tab(SirenCreativeTab.INSTANCE)
                    .food(new Food.Builder()
                            .nutrition(3)
                            .saturationMod(1.5F)
                            .build()))
            .build()),
    MERMAID_TOFFEE(() -> BaseFoodItem.Builder.create()
            .properties(new Item.Properties()
                    .tab(SirenCreativeTab.INSTANCE)
                    .food(new Food.Builder()
                            .nutrition(3)
                            .saturationMod(1.0F)
                            .build()))
            .build()),
    REEF_MILKBEAN(() -> BaseFoodItem.Builder.create()
            .properties(new Item.Properties()
                    .tab(SirenCreativeTab.INSTANCE)
                    .food(new Food.Builder()
                            .nutrition(2)
                            .saturationMod(1.0F)
                            .build()))
            .build()),
    SEA_BREEZE_MILKSHAKE(() -> BaseFoodItem.Builder.create()
            .consumeSound(SoundEvents.GENERIC_DRINK)
            .remainder(Items.GLASS_BOTTLE::getDefaultInstance)
            .properties(new Item.Properties()
                    .tab(SirenCreativeTab.INSTANCE)
                    .stacksTo(8)
                    .food(new Food.Builder()
                            .nutrition(2)
                            .saturationMod(1.0F)
                            .build())
            )
            .build()),
    TIDE_CONCERT_MILKTEA(() -> BaseFoodItem.Builder.create()
            .consumeSound(SoundEvents.GENERIC_DRINK)
            .remainder(Items.GLASS_BOTTLE::getDefaultInstance)
            .properties(new Item.Properties()
                    .tab(SirenCreativeTab.INSTANCE)
                    .stacksTo(8)
                    .food(new Food.Builder()
                            .nutrition(2)
                            .saturationMod(1.5F)
                            .build())
            )
            .build()),
    WAVE_PUDDING(() -> BaseFoodItem.Builder.create()
            .consumeSound(SoundEvents.GENERIC_DRINK)
            .remainder(Items.BOWL::getDefaultInstance)
            .properties(new Item.Properties()
                    .tab(SirenCreativeTab.INSTANCE)
                    .stacksTo(8)
                    .food(new Food.Builder()
                            .nutrition(2)
                            .saturationMod(1.0F)
                            .build())
            )
            .build()),
    SIREN_MILK_BUCKET(() -> new BucketItem(
            () -> ModFluids.SIREN_MILK_SOURCE.get(),
            new Item.Properties()
                    .tab(SirenCreativeTab.INSTANCE)
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(SirenCreativeTab.INSTANCE)
    ));

    ItemRef(Supplier<Item> sup) {
        this.reg = SirenDelight.ITEMS.register(this.name().toLowerCase(Locale.ROOT), sup);
    }

    public static void init() {
    }

    private final RegistryObject<Item> reg;

    @Override
    public Item get() {
        return reg.get();
    }
}
