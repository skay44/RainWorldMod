package io.github.skay44.slugcat.mixin;

import io.github.skay44.slugcat.items.ModItems;
import io.github.skay44.slugcat.sound.ModSounds;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

	@Inject(method = "applyWaterBuoyancy", at = @At("HEAD"))
	private void applyWaterBuoyancyHandler(CallbackInfo ci) {
		ItemEntity entity = (ItemEntity) (Object) this;
		ItemStack stack = entity.getStack();
		World world = entity.getWorld();

		if (stack.getItem() == ModItems.BUBBLE_SEED_DRY) {
			entity.getWorld().playSound(null, entity.getBlockPos(), ModSounds.POP, SoundCategory.NEUTRAL, 0.7f + world.getRandom().nextFloat() * 0.3f, 0.85f + world.getRandom().nextFloat() * 0.3f);
			entity.setStack(new ItemStack(ModItems.BUBBLE_SEED_SWOLLEN, stack.getCount()));
		}
	}

}
