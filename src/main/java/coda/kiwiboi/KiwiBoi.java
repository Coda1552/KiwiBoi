package coda.kiwiboi;

import coda.kiwiboi.common.entities.Kiwi;
import coda.kiwiboi.registry.KBEntities;
import coda.kiwiboi.registry.KBItems;
import coda.kiwiboi.registry.KBPaintings;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
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
        KBPaintings.PAINTINGS.register(bus);

        bus.addListener(this::registerAttributes);
        bus.addListener(this::populateTabs);
    }

    private void registerAttributes(EntityAttributeCreationEvent e) {
        e.put(KBEntities.KIWI.get(), Kiwi.createMobAttributes().build());
    }

    private void populateTabs(CreativeModeTabEvent.BuildContents e) {

        if (e.getTab() == CreativeModeTabs.SPAWN_EGGS) {
            e.accept(KBItems.KIWI_SPAWN_EGG.get());
        }
        if (e.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            e.accept(KBItems.KIWICAKE.get());
        }
    }

}


