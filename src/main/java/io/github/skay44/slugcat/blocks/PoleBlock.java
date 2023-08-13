package io.github.skay44.slugcat.blocks;

import io.github.skay44.slugcat.items.ModItems;
import io.github.skay44.slugcat.utilities.FallbackLoot;
import io.github.skay44.slugcat.utilities.Voxels;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.ArrayList;
import java.util.List;

public class PoleBlock extends Block implements Waterloggable, FallbackLoot {

    public static final BooleanProperty AXIS_X = BooleanProperty.of("axis_x");
    public static final BooleanProperty AXIS_Y = BooleanProperty.of("axis_y");
    public static final BooleanProperty AXIS_Z = BooleanProperty.of("axis_z");
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public PoleBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(AXIS_X,false).with(AXIS_Y,false).with(AXIS_Z,false).with(WATERLOGGED, false));

    }

    private static final VoxelShape VOXEL_SHAPE_X = Voxels.box(0,7,7,16,9,9);
    private static final VoxelShape VOXEL_SHAPE_Y = Voxels.box(7,0,7,9,16,9);
    private static final VoxelShape VOXEL_SHAPE_Z = Voxels.box(7,7,0,9,9,16);

    //Always on
    private static final VoxelShape VOXEL_SHAPE_CORE = Voxels.box(7,7,7,9,9,9);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape combined = VoxelShapes.empty();
        boolean x,y,z;
        x = state.get(AXIS_X);
        y = state.get(AXIS_Y);
        z = state.get(AXIS_Z);
        if(x){
            combined = Voxels.combine(combined,VOXEL_SHAPE_X);
        }
        if(y){
            combined = Voxels.combine(combined,VOXEL_SHAPE_Y);
        }
        if(z){
            combined = Voxels.combine(combined,VOXEL_SHAPE_Z);
        }
        else if(!x && !y){
            return VOXEL_SHAPE_CORE;
        }
        return combined;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = super.getPlacementState(ctx);
        Direction.Axis axis = ctx.getPlacementDirections()[0].getAxis();
        FluidState fluid = ctx.getWorld().getFluidState(ctx.getBlockPos());

        return state.with(axisToProperty(axis), true).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
    }

    private BooleanProperty axisToProperty(Direction.Axis axis){
        return switch (axis){
            case X -> AXIS_X;
            case Y -> AXIS_Y;
            case Z -> AXIS_Z;
        };
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }

        return super.getFluidState(state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!player.getAbilities().allowModifyWorld)
            return ActionResult.PASS;

        ItemStack stack = player.getStackInHand(hand);
        if(stack.getItem() != ModItems.REBAR){
            return ActionResult.PASS;
        }

        BooleanProperty axis = axisToProperty(hit.getSide().getAxis());

        if(state.get(axis))
            return ActionResult.PASS;
        //items -> blocks -> placing on the ground

        world.setBlockState(pos,state.with(axis,true));
        world.playSound(null,pos,soundGroup.getPlaceSound(), SoundCategory.BLOCKS,0.7f+player.getRandom().nextFloat()*0.3f,0.85f+player.getRandom().nextFloat()*0.3f);

        if (!player.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS_X, AXIS_Y, AXIS_Z, WATERLOGGED);
    }

    @Override
    public List<ItemStack> getDefaultStacks(BlockState state, LootContextParameterSet.Builder builder, Identifier identifier, LootContextParameterSet lootContext, ServerWorld world, LootTable lootTable) {
        List<ItemStack> list = new ArrayList<>();
        if(state.get(AXIS_X)) list.add(new ItemStack(ModItems.REBAR));
        if(state.get(AXIS_Y)) list.add(new ItemStack(ModItems.REBAR));
        if(state.get(AXIS_Z)) list.add(new ItemStack(ModItems.REBAR));
        return list;
    }
}
