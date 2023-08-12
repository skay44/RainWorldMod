package io.github.skay44.slugcat.mixin;

import io.github.skay44.slugcat.blocks.ModBlocks;
import io.github.skay44.slugcat.blocks.PoleBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "canClimb", at = @At("HEAD"), cancellable = true)
    private void canClimbHandler(BlockState state,CallbackInfoReturnable<Boolean> cir){
        if(state.getBlock() == ModBlocks.REBAR){
            cir.setReturnValue(state.get(PoleBlock.AXIS_Y));
        }
    }
}
