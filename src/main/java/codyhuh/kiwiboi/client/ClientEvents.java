package codyhuh.kiwiboi.client;

import codyhuh.kiwiboi.KiwiBoi;
import codyhuh.kiwiboi.client.render.KiwiRenderer;
import codyhuh.kiwiboi.registry.KBEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = KiwiBoi.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(KBEntities.KIWI.get(), KiwiRenderer::new);
    }
}