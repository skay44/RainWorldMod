package io.github.skay44.slugcat.mixin;

import io.github.skay44.slugcat.items.ModItems;
import io.github.skay44.slugcat.sound.ModSounds;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

	@Unique
	private void applyVelocityBoost(ItemEntity entity, float velocity, float multiplier) {
		Vec3d vec3d = entity.getVelocity();
		entity.setVelocity(vec3d.x * multiplier, velocity, vec3d.z * multiplier);
	}

	@Inject(method = "applyWaterBuoyancy", at = @At("HEAD"))
	private void applyWaterBuoyancyHandler(CallbackInfo ci) {
		ItemEntity entity = (ItemEntity) (Object) this;
		ItemStack stack = entity.getStack();
		World world = entity.getWorld();

		if (stack.getItem() == ModItems.BUBBLE_SEED_DRY) {
			float volume = 0.6f + world.getRandom().nextFloat() * 0.3f;
			float pitch = 0.8f + world.getRandom().nextFloat() * 0.4f;

			entity.getWorld().playSound(null, entity.getBlockPos(), ModSounds.POP, SoundCategory.NEUTRAL, volume, pitch);
			entity.setStack(new ItemStack(ModItems.BUBBLE_SEED_SWOLLEN, stack.getCount()));
			applyVelocityBoost(entity, 0.25f, 1.2f);
		}
	}

}
