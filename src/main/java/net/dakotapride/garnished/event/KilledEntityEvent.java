package net.dakotapride.garnished.event;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.dakotapride.garnished.item.hatchet.HatchetUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber
public class KilledEntityEvent {

    @SubscribeEvent
    public static void getHatchetLootEnchantmentDropsFromHatchetLootTable(LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();

        EntityType<?> type = entity.getType();

        LootTable lootTable;
        LootParams lootContextParameterSet;
        Player player;
        ObjectArrayList<ItemStack> list;
        LootParams.Builder builder;
        LootContextParam<DamageSource> ctxParameters;

        if (entity.getServer() != null && attacker instanceof LivingEntity livingAttacker) {

            if (HatchetUtils.hasRavaging(livingAttacker) && HatchetUtils.isAffectedByRavaging(entity)) {
                lootTable = entity.getServer().getLootData().getLootTable(new ResourceLocation(BuiltInRegistries.ENTITY_TYPE.getKey(type).getNamespace(), "entities/ravaging/" + type.toShortString()));

                builder = (new LootParams.Builder((ServerLevel) livingAttacker.level())).withParameter(LootContextParams.ORIGIN, livingAttacker.position()).withParameter(LootContextParams.THIS_ENTITY, livingAttacker);
                ctxParameters = LootContextParams.DAMAGE_SOURCE;
                if (livingAttacker instanceof Player) {
                    player = (Player) livingAttacker;
                    source = livingAttacker.damageSources().playerAttack(player);
                } else {
                    source = livingAttacker.damageSources().mobAttack(livingAttacker);
                }

                lootContextParameterSet = builder.withParameter(ctxParameters, source).create(LootContextParamSets.ENTITY);
                list = lootTable.getRandomItems(lootContextParameterSet);
                Objects.requireNonNull(entity);
                list.forEach(entity::spawnAtLocation);
            } else if (HatchetUtils.hasSalvaging(livingAttacker) && HatchetUtils.isAffectedBySalvaging(entity)) {
                lootTable = entity.getServer().getLootData().getLootTable(new ResourceLocation(BuiltInRegistries.ENTITY_TYPE.getKey(type).getNamespace(), "entities/salvaging/" + type.toShortString()));

                builder = (new LootParams.Builder((ServerLevel) livingAttacker.level())).withParameter(LootContextParams.ORIGIN, livingAttacker.position()).withParameter(LootContextParams.THIS_ENTITY, livingAttacker);
                ctxParameters = LootContextParams.DAMAGE_SOURCE;
                if (livingAttacker instanceof Player) {
                    player = (Player) livingAttacker;
                    source = livingAttacker.damageSources().playerAttack(player);
                } else {
                    source = livingAttacker.damageSources().mobAttack(livingAttacker);
                }

                lootContextParameterSet = builder.withParameter(ctxParameters, source).create(LootContextParamSets.ENTITY);
                list = lootTable.getRandomItems(lootContextParameterSet);
                Objects.requireNonNull(entity);
                list.forEach(entity::spawnAtLocation);
            }
        }

    }

}
