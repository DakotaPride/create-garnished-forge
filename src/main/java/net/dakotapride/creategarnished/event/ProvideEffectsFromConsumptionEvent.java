package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.CreateGarnishedTags;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
public class ProvideEffectsFromConsumptionEvent {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void provideEffectsFromConsumingFoods(LivingEntityUseItemEvent.Finish event) {
        ItemStack itemStack = event.getItem();
        LivingEntity entity = event.getEntity();
        Holder<Biome> biome = entity.level().getBiome(entity.blockPosition());

        for (YoinkFromHereList list : YoinkFromHereList.values()) {
            boolean isInBiome = biome.is(list.getBiomeTagKey());

            if (itemStack.is(list.getItemTagKey()) && isInBiome) {
                pullEffect(entity, list.getEffectHolder());
            }

        }
    }

    private static void pullEffect(LivingEntity entity, Holder<MobEffect> effectHolder) {
        entity.addEffect(new MobEffectInstance(effectHolder, 120 * 20, 1, false, false, false));
    }

    enum YoinkFromHereList {
        JUNGLE(CreateGarnishedTags.JUNGLE_SPECIAL_FOODS, BiomeTags.IS_JUNGLE, MobEffects.DIG_SPEED),
        FLOWER_FOREST(CreateGarnishedTags.FLOWER_FOREST_SPECIAL_FOODS, CreateGarnishedTags.IS_ACCEPTED_FLOWER_BIOME, MobEffects.REGENERATION),
        BIRCH_FOREST(CreateGarnishedTags.BIRCH_FOREST_SPECIAL_FOODS, Tags.Biomes.IS_BIRCH_FOREST, MobEffects.MOVEMENT_SPEED),
        TAIGA(CreateGarnishedTags.TAIGA_SPECIAL_FOODS, BiomeTags.IS_TAIGA, MobEffects.INVISIBILITY),


        ;

        final TagKey<Item> itemTagKey;
        final TagKey<Biome> biomeTagKey;
        final Holder<MobEffect> effectHolder;

        YoinkFromHereList(TagKey<Item> itemTagKey, TagKey<Biome> biomeTagKey, Holder<MobEffect> effectHolder) {
            this.itemTagKey = itemTagKey;
            this.biomeTagKey = biomeTagKey;
            this.effectHolder = effectHolder;
        }

        public TagKey<Item> getItemTagKey() {
            return itemTagKey;
        }

        public TagKey<Biome> getBiomeTagKey() {
            return biomeTagKey;
        }

        public Holder<MobEffect> getEffectHolder() {
            return effectHolder;
        }
    }
}
