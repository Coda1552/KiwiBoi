package coda.kiwiboi.client.render;

import coda.kiwiboi.client.model.KiwiModel;
import coda.kiwiboi.common.entities.Kiwi;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class KiwiRenderer extends GeoEntityRenderer<Kiwi> {

    public KiwiRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KiwiModel());
    }

    @Override
    public RenderType getRenderType(Kiwi animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(textureLocation);
    }

    @Override
    public void renderLate(Kiwi animatable, PoseStack stackIn, float partialTicks, MultiBufferSource renderTypeBuffer, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.renderLate(animatable, stackIn, partialTicks, renderTypeBuffer, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

        if (animatable.isBaby()) {
            stackIn.scale(0.5F, 0.5F, 0.5F);
        }

        if (animatable.isPartyKiwi()) {
            stackIn.mulPose(Vector3f.YP.rotationDegrees(animatable.tickCount += 2));
        }
    }
}
