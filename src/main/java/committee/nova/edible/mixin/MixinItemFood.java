package committee.nova.edible.mixin;

import committee.nova.edible.config.CommonConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemFood.class)
public abstract class MixinItemFood {
    @Shadow
    public abstract int getMaxItemUseDuration(ItemStack p_77626_1_);

    @Inject(method = "onItemRightClick", at = @At("HEAD"), cancellable = true)
    public void inject$onItemRightClick(ItemStack stack, World world, EntityPlayer player, CallbackInfoReturnable<ItemStack> cir) {
        if (CommonConfig.isNotAlwaysEdible(stack)) return;
        player.setItemInUse(stack, getMaxItemUseDuration(stack));
        cir.setReturnValue(stack);
        cir.cancel();
    }
}
