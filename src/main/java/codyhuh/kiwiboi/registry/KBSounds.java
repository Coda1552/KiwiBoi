package codyhuh.kiwiboi.registry;

import codyhuh.kiwiboi.KiwiBoi;
import codyhuh.kiwiboi.common.entities.Kiwi;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KBSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, KiwiBoi.MOD_ID);

    public static final RegistryObject<SoundEvent> KIWI_AMBIENT = create("kiwi.ambient");
    public static final RegistryObject<SoundEvent> KIWI_DEATH = create("kiwi.death");
    public static final RegistryObject<SoundEvent> KIWI_HURT = create("kiwi.hurt");

    private static RegistryObject<SoundEvent> create(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(KiwiBoi.MOD_ID, name)));
    }
}
