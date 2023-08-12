package io.github.skay44.slugcat.mixin;

import io.github.skay44.slugcat.utilities.FallbackLoot;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {
    @Inject(method = "getDroppedStacks", at = @At(value="RETURN", ordinal = 1), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private void onDefaultLoot(BlockState state, LootContextParameterSet.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir, Identifier identifier, LootContextParameterSet lootContextParameterSet, ServerWorld serverWorld, LootTable lootTable){
        if(lootTable == LootTable.EMPTY && state.getBlock() instanceof FallbackLoot fallbackLoot){
            cir.setReturnValue( fallbackLoot.getDefaultStacks(state, builder, identifier, lootContextParameterSet, serverWorld, lootTable));
        }
    }
}
