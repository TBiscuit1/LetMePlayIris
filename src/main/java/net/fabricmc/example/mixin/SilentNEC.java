package net.fabricmc.example.mixin;

import net.coderbot.iris.Iris;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Iris.class)
public class SilentNEC {
	@Shadow(remap = false)
	private static boolean hasNEC;

	@Inject(at = @At("TAIL"), method = "onEarlyInitialize", remap = false)
	private void onEarlyInitialize(CallbackInfo info) {
		hasNEC = false; // NEC doesn't exist Iris, it doesn't exist...
	}
}
