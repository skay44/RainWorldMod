package io.github.skay44.slugcat.sound;

import io.github.skay44.slugcat.RainWorldMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent REBAR_STEP = registerSound("rebar_step");
    public static final BlockSoundGroup REBAR = new BlockSoundGroup(1f,1f,
            SoundEvents.BLOCK_STONE_BREAK,
            REBAR_STEP,
            SoundEvents.BLOCK_STONE_PLACE,
            SoundEvents.BLOCK_STONE_HIT,
            SoundEvents.BLOCK_STONE_FALL);

    private static SoundEvent registerSound(String id){
        Identifier identifier = RainWorldMod.getId(id);
        SoundEvent sound = SoundEvent.of(identifier);
        Registry.register(Registries.SOUND_EVENT,identifier,sound);
        return sound;
    }

    public static void initializeSounds(){

    }
}
