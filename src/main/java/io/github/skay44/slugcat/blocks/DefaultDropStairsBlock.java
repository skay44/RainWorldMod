package io.github.skay44.slugcat.blocks;

import io.github.skay44.slugcat.utilities.DropsItself;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class DefaultDropStairsBlock extends StairsBlock implements DropsItself {

    public DefaultDropStairsBlock(BlockState baseBlockState, Settings settings) {
        super(baseBlockState, settings);
    }
}
