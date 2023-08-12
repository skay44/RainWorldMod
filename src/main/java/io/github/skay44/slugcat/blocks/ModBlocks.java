package io.github.skay44.slugcat.blocks;

import io.github.skay44.slugcat.RainWorldMod;
import io.github.skay44.slugcat.sound.ModSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
    public static final Block OUTSKIRTS_BLOCK = new DefaultDropBlock(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).strength(2f, 9.0f).requiresTool());
    public static final Block OUTSKIRTS_STAIRS = new DefaultDropStairsBlock(OUTSKIRTS_BLOCK.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).strength(2f, 9.0f).requiresTool());
    public static final Block CRACKED_OUTSKIRTS_BLOCK = new DefaultDropBlock(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).strength(2f, 9.0f).requiresTool());
    public static final Block CRACKED_OUTSKIRTS_STAIRS = new DefaultDropStairsBlock(CRACKED_OUTSKIRTS_BLOCK.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).strength(2f, 9.0f).requiresTool());
    public static final Block OUTSKIRTS_TILES = new DefaultDropBlock(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).strength(2f,9.0f).requiresTool());
    public static final Block OUTSKIRTS_TILES_STAIRS = new DefaultDropStairsBlock(OUTSKIRTS_TILES.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).strength(2f,9.0f).requiresTool());
    public static final Block OUTSKIRTS_SMOOTH_BLOCK = new DefaultDropBlock(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).strength(2f,9.0f).requiresTool());
    public static final Block OUTSKIRTS_SMOOTH_STAIRS = new DefaultDropStairsBlock(OUTSKIRTS_SMOOTH_BLOCK.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).strength(2f,9.0f).requiresTool());

    public static final Block REBAR = new PoleBlock(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).strength(3f, 9.0f).sounds(ModSounds.REBAR).requiresTool());

    public static final Block BLUE_FRUIT = new BlueFruitBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLUE).instrument(Instrument.BASEDRUM).strength(0.1f, 1.0f));

    public static void initializeBlocks(){
        Registry.register(Registries.BLOCK, RainWorldMod.getId("outskirts_block"), OUTSKIRTS_BLOCK);
        Registry.register(Registries.BLOCK, RainWorldMod.getId("outskirts_stairs"), OUTSKIRTS_STAIRS);
        Registry.register(Registries.BLOCK, RainWorldMod.getId("cracked_outskirts_block"), CRACKED_OUTSKIRTS_BLOCK);
        Registry.register(Registries.BLOCK, RainWorldMod.getId("cracked_outskirts_stairs"), CRACKED_OUTSKIRTS_STAIRS);
        Registry.register(Registries.BLOCK, RainWorldMod.getId("outskirts_tiles"), OUTSKIRTS_TILES);
        Registry.register(Registries.BLOCK, RainWorldMod.getId("outskirts_tiles_stairs"), OUTSKIRTS_TILES_STAIRS);
        Registry.register(Registries.BLOCK, RainWorldMod.getId("outskirts_smooth_block"), OUTSKIRTS_SMOOTH_BLOCK);
        Registry.register(Registries.BLOCK, RainWorldMod.getId("outskirts_smooth_stairs"), OUTSKIRTS_SMOOTH_STAIRS);

        Registry.register(Registries.BLOCK, RainWorldMod.getId("rebar"), REBAR);

        Registry.register(Registries.BLOCK, RainWorldMod.getId( "blue_fruit"), BLUE_FRUIT);
    }

}
