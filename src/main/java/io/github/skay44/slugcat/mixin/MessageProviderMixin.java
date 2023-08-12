package io.github.skay44.slugcat.mixin;

import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Base64;
import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
public class MessageProviderMixin {

	// Nothing to see here //

	@Final
	@Shadow
	private List<String> splashTexts;

	@Unique
	private void supply(String data) {
		splashTexts.add(new String(Base64.getDecoder().decode(data)));
	}

	@Inject(method = "apply(Ljava/util/List;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At("TAIL"))
	private void apply(List<String> list, ResourceManager resource, Profiler profiler, CallbackInfo info) {
		supply("Li4uaXMgdGhpcyByZWFjaGluZyB5b3U/");
		supply("VHJpcGxlIEFmZmlybWF0aXZlIQ==");
		supply("R29kbGlrZSBpbiBjb21wYXJpc29uIQ==");
		supply("QXd3LCBSdWZmbGVzIQ==");
		supply("Tm8gU2lnbmlmaWNhbnQgSGFyYXNzbWVudCE=");
		supply("VW5mb3J0dW5hdGUgRGV2ZWxvcG1lbnQh");
		supply("NVA=");
		supply("VGFrZSBhIGNsb3NlciBsb29rIGF0IHRoYXQgc25vdXQh");
		supply("TG9va3MgdG8gdGhlIE1vb24h");
	}

}