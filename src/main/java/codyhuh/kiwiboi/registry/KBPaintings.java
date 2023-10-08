package codyhuh.kiwiboi.registry;

import codyhuh.kiwiboi.KiwiBoi;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KBPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, KiwiBoi.MOD_ID);

    public static final RegistryObject<PaintingVariant> WEIRD_PENGUIN = PAINTINGS.register("weird_penguin", () -> new PaintingVariant(16, 16));
}
