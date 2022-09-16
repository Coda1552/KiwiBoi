package coda.kiwiboi;

import coda.kiwiboi.common.entities.Kiwi;
import coda.kiwiboi.registry.KBEntities;
import coda.kiwiboi.registry.KBItems;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(KiwiBoi.MOD_ID)
public class KiwiBoi {
    public static final String MOD_ID = "kiwiboi";

    public KiwiBoi() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        KBItems.ITEMS.register(bus);
        KBEntities.ENTITIES.register(bus);

        bus.addListener(this::registerAttributes);
        forgeBus.addListener(this::addSpawns);
    }

    private void registerAttributes(EntityAttributeCreationEvent e) {
        e.put(KBEntities.KIWI.get(), Kiwi.createMobAttributes().build());
    }

    private void addSpawns(BiomeLoadingEvent e) {
        if (e.getCategory().equals(Biome.BiomeCategory.TAIGA)) {
            e.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(KBEntities.KIWI.get(), 10, 1, 3));
        }
    }
}
