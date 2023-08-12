package io.github.skay44.slugcat.mixin;

import io.github.skay44.slugcat.RainWorldMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TitleScreen.class, priority = 1001)
public class TitleScreenMixin {

    @Unique
    boolean a = false;

    @Inject(method = "tick", at = @At("HEAD"))
    private void tickHandler(CallbackInfo ci){
        if(!a){
            RainWorldMod.LOGGER.info("It works :D");
            a = true;
        }
    }
}
