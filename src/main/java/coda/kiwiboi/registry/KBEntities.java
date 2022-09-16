package coda.kiwiboi.registry;

import coda.kiwiboi.KiwiBoi;
import coda.kiwiboi.common.entities.Kiwi;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KBEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, KiwiBoi.MOD_ID);

    public static final RegistryObject<EntityType<Kiwi>> KIWI = ENTITIES.register("kiwi", () -> EntityType.Builder.of(Kiwi::new, MobCategory.CREATURE).sized(0.5F, 0.7F).build(KiwiBoi.MOD_ID + "kiwi"));
}
