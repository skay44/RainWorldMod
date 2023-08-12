package io.github.skay44.slugcat.client.renderer;

import io.github.skay44.slugcat.RainWorldMod;
import io.github.skay44.slugcat.entitiy.ThrownSpearEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import org.joml.Matrix3d;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class ThrownSpearRenderer extends EntityRenderer<ThrownSpearEntity> {

    private static final Identifier TEXTURE_ID = RainWorldMod.getId("textures/block/rebar.png");

    public ThrownSpearRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(ThrownSpearEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumerProvider, int light) {
        super.render(entity,yaw,tickDelta,matrices,vertexConsumerProvider,light);
        MatrixStack.Entry entry = matrices.peek();
        VertexConsumer buffer = vertexConsumerProvider.getBuffer(RenderLayer.getEntitySolid(TEXTURE_ID));
        Matrix4f position = entry.getPositionMatrix();
        Matrix3f normal = entry.getNormalMatrix();


//        buffer.vertex(position, 0f,0f,0f).color(1f,1f,1f,1f).texture(0f,0f).overlay(0).light(light).normal(normal, 1f,0f,0f).next();
//        buffer.vertex(position, 0f,0f,0f).color(1f,1f,1f,1f).texture(0f,0f).overlay(0).light(light).normal(normal, 1f,0f,0f).next();
//        buffer.vertex(position, 0f,0f,0f).color(1f,1f,1f,1f).texture(0f,0f).overlay(0).light(light).normal(normal, 1f,0f,0f).next();
//        buffer.vertex(position, 0f,0f,0f).color(1f,1f,1f,1f).texture(0f,0f).overlay(0).light(light).normal(normal, 1f,0f,0f).next();
    }


    @Override
    public Identifier getTexture(ThrownSpearEntity entity) {
        return TEXTURE_ID;
    }
}
