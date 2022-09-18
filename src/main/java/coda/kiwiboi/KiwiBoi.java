package coda.kiwiboi;

import coda.kiwiboi.common.entities.Kiwi;
import coda.kiwiboi.registry.KBEntities;
import coda.kiwiboi.registry.KBItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
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
    }

    private void registerAttributes(EntityAttributeCreationEvent e) {
        e.put(KBEntities.KIWI.get(), Kiwi.createMobAttributes().build());
    }
}


