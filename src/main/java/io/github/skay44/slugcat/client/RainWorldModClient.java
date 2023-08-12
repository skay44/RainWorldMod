package io.github.skay44.slugcat.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static io.github.skay44.slugcat.blocks.ModBlocks.BLUE_FRUIT;

public class RainWorldModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BLUE_FRUIT, RenderLayer.getCutout());
    }

}
