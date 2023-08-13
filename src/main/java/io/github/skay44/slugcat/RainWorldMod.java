package io.github.skay44.slugcat;

import io.github.skay44.slugcat.blocks.ModBlocks;
import io.github.skay44.slugcat.client.renderer.ThrownSpearRenderer;
import io.github.skay44.slugcat.entitiy.ModEntities;
import io.github.skay44.slugcat.entitiy.ThrownSpearEntity;
import io.github.skay44.slugcat.items.ModItems;
import io.github.skay44.slugcat.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RainWorldMod implements ModInitializer {
    public static final String NAMESPACE = "slugcat";
    public static final Logger LOGGER = LoggerFactory.getLogger("Slugcat");

    public static Identifier getId(String path){
        return new Identifier(NAMESPACE, path);
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing RW mod");
        ModBlocks.initializeBlocks();
        ModItems.initializeItems();
        ModSounds.initializeSounds(); //cursed just to load class
        ModEntities.initializeEntities();
        LOGGER.info("Finished initialazing RW mod");

        EntityRendererRegistry.register(ModEntities.THROWN_SPEAR_ENTITY_TYPE, ThrownSpearRenderer::new);
    }
}
