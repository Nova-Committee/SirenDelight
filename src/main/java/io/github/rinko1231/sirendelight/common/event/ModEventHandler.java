package io.github.rinko1231.sirendelight.common.event;

import io.github.rinko1231.sirendelight.common.ref.ItemRef;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    @SubscribeEvent
    public static void onDispenserRegister(FMLCommonSetupEvent event) {
        DispenserBlock.registerBehavior(ItemRef.SIREN_MILK_BUCKET.get(), new DefaultDispenseItemBehavior() {
            private final DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior();

            @Override
            public ItemStack execute(IBlockSource source, ItemStack stack) {
                BucketItem bucketitem = (BucketItem) stack.getItem();
                BlockPos blockpos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
                World world = source.getLevel();
                if (bucketitem.emptyBucket(null, world, blockpos, null)) {
                    bucketitem.checkExtraContent(world, stack, blockpos);
                    return new ItemStack(Items.BUCKET);
                } else {
                    return this.dispenseItemBehavior.dispense(source, stack);
                }
            }
        });
    }
}
