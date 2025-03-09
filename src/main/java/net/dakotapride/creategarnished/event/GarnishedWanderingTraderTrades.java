package net.dakotapride.creategarnished.event;

import com.simibubi.create.AllItems;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
public class GarnishedWanderingTraderTrades {

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        // Teas
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(AllItems.BUILDERS_TEA.get(), 1), 2, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(CreateGarnishedItems.SPRINTERS_TEA.get(), 1), 2, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(CreateGarnishedItems.SWEET_TEA.get(), 1), 2, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 12),
                new ItemStack(CreateGarnishedItems.ELVEN_TEA.get(), 1), 2, 10, 0.2f));

        // Nuts
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(CreateGarnishedItems.PEANUT.get(), 4), 3, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(CreateGarnishedItems.PINE_NUT.get(), 4), 3, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(CreateGarnishedItems.HAZELNUT.get(), 4), 3, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(CreateGarnishedItems.ALMOND.get(), 4), 3, 10, 0.2f));

        // Misc
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 4),
                new ItemStack(CreateGarnishedItems.BIRCH_SAP_BOTTLE.get(), 3), 6, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 4),
                new ItemStack(CreateGarnishedItems.BEETROOT_JUICE_BOTTLE.get(), 3), 6, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 2),
                new ItemStack(CreateGarnishedItems.GINGER_ROOT.get(), 2), 4, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(CreateGarnishedItems.ELVEN_SWEET_BERRIES.get(), 4), 2, 10, 0.2f));
    }

}
