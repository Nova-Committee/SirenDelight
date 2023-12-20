package io.github.rinko1231.sirendelight.common.groups;

import io.github.rinko1231.sirendelight.SirenDelight;
import io.github.rinko1231.sirendelight.common.ref.ItemRef;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SirenCreativeTab extends ItemGroup {
    public static final SirenCreativeTab INSTANCE = new SirenCreativeTab();

    public SirenCreativeTab() {
        super(SirenDelight.MODID);

    }

    @Override
    public ItemStack makeIcon() {
        return ItemRef.WAVE_PUDDING.get().getDefaultInstance();
    }

}
