package io.github.skay44.slugcat.entitiy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ThrownSpearEntity extends ThrownEntity {
//    protected ThrownSpearEntity(EntityType<? extends ThrownEntity> entityType, World world) {
//        super(entityType, world);
//    }

    public ThrownSpearEntity(World world, LivingEntity owner) {
        super(ModEntities.THROWN_SPEAR_ENTITY_TYPE, owner, world);
    }

    public ThrownSpearEntity(EntityType<Entity> entityEntityType, World world) {
        super(ModEntities.THROWN_SPEAR_ENTITY_TYPE, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 0;
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), i);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    protected void initDataTracker() {

    }
}
