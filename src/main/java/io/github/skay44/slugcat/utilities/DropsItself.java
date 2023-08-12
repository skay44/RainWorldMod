package io.github.skay44.slugcat.utilities;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.List;

public interface DropsItself extends FallbackLoot {
    @Override
    default List<ItemStack> getDefaultStacks(BlockState state, LootContextParameterSet.Builder builder, Identifier identifier, LootContextParameterSet lootContext, ServerWorld world, LootTable lootTable){
        return Collections.singletonList(new ItemStack(state.getBlock().asItem()));
    }
}
