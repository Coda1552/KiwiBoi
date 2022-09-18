package coda.kiwiboi.client.model;

import coda.kiwiboi.KiwiBoi;
import coda.kiwiboi.common.entities.Kiwi;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KiwiModel extends AnimatedGeoModel<Kiwi> {

    @Override
    public ResourceLocation getModelResource(Kiwi object) {
        return new ResourceLocation(KiwiBoi.MOD_ID, "geo/kiwi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Kiwi object) {
        return new ResourceLocation(KiwiBoi.MOD_ID, "textures/entity/kiwi.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Kiwi animatable) {
        return new ResourceLocation(KiwiBoi.MOD_ID, "animations/kiwi.animation.json");
    }
}
