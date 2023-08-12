package io.github.skay44.slugcat.utilities;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.List;

@FunctionalInterface
public interface FallbackLoot {
    List<ItemStack> getDefaultStacks(BlockState state, LootContextParameterSet.Builder builder, Identifier identifier, LootContextParameterSet lootContext, ServerWorld world, LootTable lootTable);
}
