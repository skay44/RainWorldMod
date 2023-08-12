package io.github.skay44.slugcat.items;

import io.github.skay44.slugcat.RainWorldMod;
import io.github.skay44.slugcat.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item OUTSKIRTS_BLOCK = new BlockItem(ModBlocks.OUTSKIRTS_BLOCK, new Item.Settings());
    public static final Item OUTSKIRTS_STAIRS = new BlockItem(ModBlocks.OUTSKIRTS_STAIRS, new Item.Settings());
    public static final Item CRACKED_OUTSKIRTS_BLOCK = new BlockItem(ModBlocks.CRACKED_OUTSKIRTS_BLOCK, new Item.Settings());
    public static final Item CRACKED_OUTSKIRTS_STAIRS =  new BlockItem(ModBlocks.CRACKED_OUTSKIRTS_STAIRS, new Item.Settings());
    public static final Item OUTSKIRTS_TILES = new BlockItem(ModBlocks.OUTSKIRTS_TILES, new Item.Settings());
    public static final Item OUTSKIRTS_TILES_STAIRS = new BlockItem(ModBlocks.OUTSKIRTS_TILES_STAIRS, new Item.Settings());
    public static final Item OUTSKIRTS_SMOOTH_BLOCK = new BlockItem(ModBlocks.OUTSKIRTS_SMOOTH_BLOCK, new Item.Settings());
    public static final Item OUTSKIRTS_SMOOTH_STAIRS = new BlockItem(ModBlocks.OUTSKIRTS_SMOOTH_STAIRS, new Item.Settings());

    public static final Item REBAR = new PoleItem(ModBlocks.REBAR, new Item.Settings());

    public static final Item BLUE_FRUIT =  new Item(new Item.Settings().food(Food.BLUE_FRUIT));

    public static void initializeItems(){
        Registry.register(Registries.ITEM, RainWorldMod.getId("outskirts_block"), OUTSKIRTS_BLOCK);
        Registry.register(Registries.ITEM, RainWorldMod.getId("outskirts_stairs"), OUTSKIRTS_STAIRS);
        Registry.register(Registries.ITEM, RainWorldMod.getId("cracked_outskirts_block"), CRACKED_OUTSKIRTS_BLOCK);
        Registry.register(Registries.ITEM, RainWorldMod.getId("cracked_outskirts_stairs"), CRACKED_OUTSKIRTS_STAIRS);
        Registry.register(Registries.ITEM, RainWorldMod.getId("outskirts_tiles"), OUTSKIRTS_TILES);
        Registry.register(Registries.ITEM, RainWorldMod.getId("outskirts_tiles_stairs"), OUTSKIRTS_TILES_STAIRS);
        Registry.register(Registries.ITEM, RainWorldMod.getId("outskirts_smooth_block"), OUTSKIRTS_SMOOTH_BLOCK);
        Registry.register(Registries.ITEM, RainWorldMod.getId("outskirts_smooth_stairs"), OUTSKIRTS_SMOOTH_STAIRS);
        Registry.register(Registries.ITEM, RainWorldMod.getId( "blue_fruit"), BLUE_FRUIT);

        Registry.register(Registries.ITEM, RainWorldMod.getId("rebar"), REBAR);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.add(OUTSKIRTS_BLOCK);
            content.add(OUTSKIRTS_STAIRS);
            content.add(CRACKED_OUTSKIRTS_BLOCK);
            content.add(CRACKED_OUTSKIRTS_STAIRS);
            content.add(OUTSKIRTS_TILES);
            content.add(OUTSKIRTS_TILES_STAIRS);
            content.add(OUTSKIRTS_SMOOTH_BLOCK);
            content.add(OUTSKIRTS_SMOOTH_STAIRS);

            content.add(REBAR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.add(BLUE_FRUIT);
        });
    }
}
