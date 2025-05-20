package net.dakotapride.garnished.event;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.dakotapride.garnished.item.hatchet.HatchetUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
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
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

import java.util.Objects;

@EventBusSubscriber
public class KilledEntityEvent {

    @SubscribeEvent
    private static void getHatchetLootEnchantmentDropsFromHatchetLootTable(LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();
        //Collection<ItemEntity> itemcollection = event.getDrops();

        EntityType<?> type = entity.getType();

        LootTable lootTable;
        LootParams lootContextParameterSet;
        Player player;
        ObjectArrayList<ItemStack> list;
        LootParams.Builder builder;
        LootContextParam<DamageSource> ctxParameters;

        if (entity.getServer() != null && attacker instanceof LivingEntity livingAttacker) {

            if (HatchetUtils.hasRavaging(livingAttacker, livingAttacker.getMainHandItem()) && HatchetUtils.isAffectedByRavaging(entity)) {
                lootTable = entity.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(BuiltInRegistries.ENTITY_TYPE.getKey(type).getNamespace(), "entities/ravaging/" + type.toShortString())));

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

                System.out.println(ResourceLocation.fromNamespaceAndPath(BuiltInRegistries.ENTITY_TYPE.getKey(type).getNamespace(), "entities/ravaging/" + type.toShortString()));
            } else if (HatchetUtils.hasSalvaging(livingAttacker, livingAttacker.getMainHandItem()) && HatchetUtils.isAffectedBySalvaging(entity)) {
                lootTable = entity.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(BuiltInRegistries.ENTITY_TYPE.getKey(type).getNamespace(), "entities/salvaging/" + type.toShortString())));

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

                System.out.println(ResourceLocation.fromNamespaceAndPath(BuiltInRegistries.ENTITY_TYPE.getKey(type).getNamespace(), "entities/salvaging/" + type.toShortString()));
            }

        }

    }

}
