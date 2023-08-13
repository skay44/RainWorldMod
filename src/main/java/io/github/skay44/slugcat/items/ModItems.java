package io.github.skay44.slugcat.items;

import io.github.skay44.slugcat.RainWorldMod;
import io.github.skay44.slugcat.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ModItems {

    private static final RegistryKey<ItemGroup> MAIN_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, RainWorldMod.getId("main_group"));
    private static final List<ItemStack> blocks = new ArrayList<>();
    private static final List<ItemStack> edible = new ArrayList<>();
    private static final List<ItemStack> items = new ArrayList<>();

    private static void registerItem(Item item, String id, @Nullable List<ItemStack> sections) {
        Registry.register(Registries.ITEM, RainWorldMod.getId(id), item);
        ItemStack stack = new ItemStack(item);
        items.add(stack);

        if (sections != null) {
            sections.add(stack);
        }
    }

    public static final Item OUTSKIRTS_BLOCK = new BlockItem(ModBlocks.OUTSKIRTS_BLOCK, new Item.Settings());
    public static final Item OUTSKIRTS_STAIRS = new BlockItem(ModBlocks.OUTSKIRTS_STAIRS, new Item.Settings());
    public static final Item CRACKED_OUTSKIRTS_BLOCK = new BlockItem(ModBlocks.CRACKED_OUTSKIRTS_BLOCK, new Item.Settings());
    public static final Item CRACKED_OUTSKIRTS_STAIRS =  new BlockItem(ModBlocks.CRACKED_OUTSKIRTS_STAIRS, new Item.Settings());
    public static final Item OUTSKIRTS_TILES = new BlockItem(ModBlocks.OUTSKIRTS_TILES, new Item.Settings());
    public static final Item OUTSKIRTS_TILES_STAIRS = new BlockItem(ModBlocks.OUTSKIRTS_TILES_STAIRS, new Item.Settings());
    public static final Item OUTSKIRTS_SMOOTH_BLOCK = new BlockItem(ModBlocks.OUTSKIRTS_SMOOTH_BLOCK, new Item.Settings());
    public static final Item OUTSKIRTS_SMOOTH_STAIRS = new BlockItem(ModBlocks.OUTSKIRTS_SMOOTH_STAIRS, new Item.Settings());

    public static final Item REBAR = new PoleItem(ModBlocks.REBAR, new Item.Settings());

    public static final Item BLUE_FRUIT = new Item(new Item.Settings().food(ModFoods.BLUE_FRUIT));
    public static final Item BUBBLE_SEED_DRY = new Item(new Item.Settings());
    public static final Item BUBBLE_SEED_SWOLLEN = new Item(new Item.Settings().food(ModFoods.BUBBLE_SEED));

    public static void initializeItems(){
        registerItem(OUTSKIRTS_BLOCK, "outskirts_block", blocks);
        registerItem(OUTSKIRTS_STAIRS, "outskirts_stairs", blocks);
        registerItem(CRACKED_OUTSKIRTS_BLOCK, "cracked_outskirts_block", blocks);
        registerItem(CRACKED_OUTSKIRTS_STAIRS, "cracked_outskirts_stairs", blocks);
        registerItem(OUTSKIRTS_TILES, "outskirts_tiles", blocks);
        registerItem(OUTSKIRTS_TILES_STAIRS, "outskirts_tiles_stairs", blocks);
        registerItem(OUTSKIRTS_SMOOTH_BLOCK, "outskirts_smooth_block", blocks);
        registerItem(OUTSKIRTS_SMOOTH_STAIRS, "outskirts_smooth_stairs", blocks);
        registerItem(BLUE_FRUIT, "blue_fruit", edible);
        registerItem(BUBBLE_SEED_DRY, "bubble_seed_dry", edible);
        registerItem(BUBBLE_SEED_SWOLLEN, "bubble_seed_swollen", edible);
        registerItem(REBAR, "rebar", blocks);

        Registry.register(Registries.ITEM_GROUP, MAIN_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(REBAR))
                .displayName(Text.translatable("itemGroup.slugcat.main_group"))
                .build());

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> content.addAll(blocks));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.addAll(edible));
        ItemGroupEvents.modifyEntriesEvent(MAIN_GROUP).register(content -> content.addAll(items));
    }
}
