package io.github.skay44.slugcat.mixin;

import io.github.skay44.slugcat.blocks.ModBlocks;
import io.github.skay44.slugcat.blocks.PoleBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Optional;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Shadow private Optional<BlockPos> climbingPos;

    //camc
    @Inject(method = "isClimbing",
            at = @At(value = "INVOKE_ASSIGN",target = "Lnet/minecraft/entity/LivingEntity;getBlockStateAtPos()Lnet/minecraft/block/BlockState;"),
            locals = LocalCapture.CAPTURE_FAILHARD,
            cancellable = true
    )
    private void isClimbingHandler(CallbackInfoReturnable<Boolean> cir, BlockPos pos, BlockState state){
        if(state.getBlock() == ModBlocks.REBAR){
            //state.get zwraca wartosc tego stanu moze byc int albo bool
            if(state.get(PoleBlock.AXIS_Y)){
                climbingPos = Optional.of(pos);
                cir.setReturnValue(true);
            }

            //cir.setReturnValue(state.get(PoleBlock.AXIS_Y));

        }
    }

}
