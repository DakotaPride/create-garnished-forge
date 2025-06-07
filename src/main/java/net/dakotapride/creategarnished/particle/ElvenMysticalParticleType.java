package net.dakotapride.creategarnished.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ElvenMysticalParticleType extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected ElvenMysticalParticleType(ClientLevel level,
                                        double x,
                                        double y,
                                        double z,
                                        float xSeedMultiplier,
                                        float ySpeedMultiplier,
                                        float zSpeedMultiplier,
                                        double xSpeed,
                                        double ySpeed,
                                        double zSpeed,
                                        float quadSizeMultiplier,
                                        SpriteSet sprites,
                                        int lifetime,
                                        float gravity,
                                        boolean hasPhysics) {
        super(level, x, y, z, 0.0F, 0.0F, 0.0F);
        this.friction = 0.96F;
        this.gravity = gravity;
        this.speedUpWhenYMotionIsBlocked = true;
        this.sprites = sprites;
        this.xd *= xSeedMultiplier;
        this.yd *= ySpeedMultiplier;
        this.zd *= zSpeedMultiplier;
        this.xd += xSpeed;
        this.yd += ySpeed;
        this.zd += zSpeed;
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 1.0F;
        this.quadSize *= 0.75F * quadSizeMultiplier;
        this.lifetime = (int)((double)lifetime / ((double)level.random.nextFloat() * 0.8 + 0.2) * (double)quadSizeMultiplier);
        this.lifetime = Math.max(this.lifetime, 1);
        this.setSpriteFromAge(sprites);
        this.hasPhysics = hasPhysics;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public float getQuadSize(float scaleFactor) {
        return this.quadSize * Mth.clamp(((float)this.age + scaleFactor) / (float)this.lifetime * 32.0F, 0.0F, 1.0F);
    }

    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new ElvenMysticalParticleType(level, x, y, z, 0.1F, 0.1F, 0.1F, xSpeed, ySpeed, zSpeed, 1.0F, sprites, 24, -0.1F, true);
        }
    }
}