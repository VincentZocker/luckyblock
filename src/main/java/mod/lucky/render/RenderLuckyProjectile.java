package mod.lucky.render;

import mod.lucky.Lucky;
import mod.lucky.entity.EntityLuckyProjectile;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderLuckyProjectile extends Render<EntityLuckyProjectile> {
    public RenderLuckyProjectile(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityLuckyProjectile entity,
        double posX, double posY, double posZ,
        float unknownValue, float partialTicks) {

        try {
            if (entity.getEntityItem() != null) {
                this.renderManager.renderEntity(entity.getEntityItem(),
                    posX, posY - 0.35D, posZ,
                    0, partialTicks, true);
            }
        } catch (Exception e) {
            Lucky.error(e, "Error rendering lucky projectile");
        }
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLuckyProjectile entity) {
        return null;
    }
}