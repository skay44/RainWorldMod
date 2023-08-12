package io.github.skay44.slugcat.blocks;

import io.github.skay44.slugcat.items.ModItems;
import io.github.skay44.slugcat.utilities.FallbackLoot;
import io.github.skay44.slugcat.utilities.Voxels;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Collections;
import java.util.List;

public class BlueFruitBlock extends Block implements FallbackLoot {
    public BlueFruitBlock(Settings settings) {
        super(settings);
    }

    //			"from": [6, 5, 6],
    //			"to": [10, 11, 10],

    //			"from": [7, 11, 7],
    //			"to": [9, 12, 9],

    //Big Voxel 4
    private static final VoxelShape VOXEL_SHAPE_X = Voxels.box(6,5,6,10,11,10);
    //Small Voxel 4
    private static final VoxelShape VOXEL_SHAPE_Y = Voxels.box(7,11,7,9,12,9);

    @Override
    public List<ItemStack> getDefaultStacks(BlockState state, LootContextParameterSet.Builder builder, Identifier identifier, LootContextParameterSet lootContext, ServerWorld world, LootTable lootTable) {
        return Collections.singletonList(new ItemStack(ModItems.BLUE_FRUIT,1));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {

        return Voxels.combine(VOXEL_SHAPE_X,VOXEL_SHAPE_Y);
    }
}
