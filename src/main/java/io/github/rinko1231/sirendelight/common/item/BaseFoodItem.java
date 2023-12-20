package io.github.rinko1231.sirendelight.common.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class BaseFoodItem extends Item {
    private final SoundEvent consumeSound;
    private ItemStack remainderCache;
    private final Supplier<ItemStack> remainder;
    private final List<EffectInstance> effects;

    private BaseFoodItem(SoundEvent consumeSound, Supplier<ItemStack> remainder, List<EffectInstance> effects, Properties pProperties) {
        super(pProperties);
        this.consumeSound = consumeSound;
        this.remainder = remainder;
        this.effects = effects;
    }

    @Override
    public SoundEvent getEatingSound() {
        return consumeSound;
    }

    public ItemStack getRemainderCache() {
        if (remainderCache == null) remainderCache = remainder.get();
        return remainderCache;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return !getRemainderCache().isEmpty();
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return getRemainderCache();
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, World pLevel, LivingEntity pEntityLiving) {
        effects.forEach(pEntityLiving::addEffect);
        if (pEntityLiving instanceof PlayerEntity && !((PlayerEntity) pEntityLiving).abilities.instabuild)
            return getRemainderCache();
        return super.finishUsingItem(pStack, pLevel, pEntityLiving);
    }

    public static class Builder {
        private SoundEvent consumeSound = SoundEvents.GENERIC_EAT;
        private Supplier<ItemStack> remainder = () -> ItemStack.EMPTY;
        private final List<EffectInstance> effects = new ArrayList<>();
        private Properties properties = new Properties();

        public static Builder create() {
            return new Builder();
        }

        private Builder() {
        }

        public Builder consumeSound(SoundEvent consumeSound) {
            this.consumeSound = consumeSound;
            return this;
        }

        public Builder remainder(Supplier<ItemStack> remainder) {
            this.remainder = remainder;
            return this;
        }

        public Builder effect(EffectInstance... effect) {
            effects.addAll(Arrays.asList(effect));
            return this;
        }

        public Builder properties(Properties properties) {
            this.properties = properties;
            return this;
        }

        public BaseFoodItem build() {
            return new BaseFoodItem(consumeSound, remainder, effects, properties);
        }
    }
}
