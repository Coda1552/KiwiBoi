package coda.kiwiboi.registry;

import coda.kiwiboi.KiwiBoi;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KiwiBoi.MOD_ID);

    public static final RegistryObject<Item> KIWI_SPAWN_EGG = ITEMS.register("kiwi_spawn_egg", () -> new ForgeSpawnEggItem(KBEntities.KIWI, 0x814a31, 0x543628, new Item.Properties()));
    public static final RegistryObject<Item> KIWICAKE = ITEMS.register("kiwicake", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().fast().saturationMod(0.4F).nutrition(6).build())));
}
