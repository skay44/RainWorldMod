package io.github.skay44.slugcat.utilities;

import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class Voxels {

    public static VoxelShape box(float x1, float y1, float z1, float x2, float y2, float z2){
        return VoxelShapes.cuboid(
                Math.min(x1,x2)/16d,
                Math.min(y1,y2)/16d,
                Math.min(z1,z2)/16d,
                Math.max(x1,x2)/16d,
                Math.max(y1,y2)/16d,
                Math.max(z1,z2)/16d
        );
    }

    public static VoxelShape combine(VoxelShape a, VoxelShape b){
        return VoxelShapes.combine(a,b, BooleanBiFunction.OR);
    }
}
