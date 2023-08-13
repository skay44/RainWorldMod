package io.github.skay44.slugcat.entitiy;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import io.github.skay44.slugcat.RainWorldMod;

public class ModEntities {

    private static Object CubeEntity;
    @SuppressWarnings("unchecked")
    public static final EntityType<ThrownSpearEntity> THROWN_SPEAR_ENTITY_TYPE = (EntityType<ThrownSpearEntity>)(Object)FabricEntityTypeBuilder.create(SpawnGroup.MISC, ThrownSpearEntity::new ).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build();

    public static void initializeEntities(){
        Registry.register(Registries.ENTITY_TYPE, RainWorldMod.getId("thrown_spear"),THROWN_SPEAR_ENTITY_TYPE);
    }
}
