package net.dakotapride.garnished.event;

import com.simibubi.create.AllItems;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = CreateGarnished.ID)
public class GarnishedWanderingTraderTrades {

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        // Teas
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 6),
                new ItemStack(AllItems.BUILDERS_TEA.get(), 1), 2, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 6),
                new ItemStack(GarnishedItems.SWEET_TEA.get(), 1), 4, 10, 0.2f));

        // Cracked Nuts & Ungarnished Nuts
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.CRACKED_CASHEW.get(), 4), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.UNGARNISHED_CASHEW.get(), 4), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.CRACKED_WALNUT.get(), 4), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.UNGARNISHED_WALNUT.get(), 4), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.CRACKED_ALMOND.get(), 4), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.UNGARNISHED_ALMOND.get(), 4), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.CRACKED_PECAN.get(), 4), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.UNGARNISHED_PECAN.get(), 4), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.CRACKED_MACADAMIA.get(), 4), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.UNGARNISHED_MACADAMIA.get(), 4), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.CRACKED_BUHG.get(), 4), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.UNGARNISHED_BUHG.get(), 4), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.CRACKED_HAZELNUT.get(), 4), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.UNGARNISHED_HAZELNUT.get(), 4), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.CRACKED_CHESTNUT.get(), 4), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.UNGARNISHED_CHESTNUT.get(), 4), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.CRACKED_PISTACHIO.get(), 4), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.UNGARNISHED_PISTACHIO.get(), 4), 2, 10, 0.2f));

        // Misc
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 3),
                new ItemStack(GarnishedItems.CASHEW_APPLE.get(), 2), 6, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.NUT_FLOUR.get(), 4), 6, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(GarnishedItems.VENERABLE_DOUGH.get(), 2), 6, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.BOK_CHOY.get(), 3), 4, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(GarnishedItems.RAW_TENEBROUS_MEAT.get(), 1), 2, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 6),
                new ItemStack(GarnishedItems.VEX_WING.get(), 1), 3, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 6),
                new ItemStack(GarnishedItems.MEAT_SCRAPS.get(), 1), 3, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 3),
                new ItemStack(GarnishedItems.ANTIQUE_SWATHE.get(), 2), 4, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 4),
                new ItemStack(GarnishedItems.LUSTROUS_PEARL.get(), 2), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(GarnishedItems.POLAR_BEAR_HIDE.get(), 2), 4, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 32),
                new ItemStack(GarnishedBlocks.ANNIVERSARY_CAKE.get(), 1), 1, 20, 0.8f));
    }

}
