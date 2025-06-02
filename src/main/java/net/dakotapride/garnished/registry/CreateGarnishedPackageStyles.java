package net.dakotapride.garnished.registry;

import com.simibubi.create.AllPartialModels;
import com.simibubi.create.Create;
import com.simibubi.create.content.logistics.box.PackageItem;
import com.simibubi.create.content.logistics.box.PackageStyles;
import com.tterrag.registrate.util.entry.ItemEntry;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.resources.ResourceLocation;

import static net.dakotapride.garnished.CreateGarnished.REGISTRATE;

public class CreateGarnishedPackageStyles {
//    public static void register() {
//        PackageStyles.STYLES.add(
//                new PackageStyles.PackageStyle(
//                        "nuts",
//                        12,
//                        12,
//                        23f,
//                        false
//                ));
//    }

    public static final ItemEntry<PackageItem> NUTS_PACKAGE = REGISTRATE
            .item("nuts_package", prop -> new PackageItem(prop,
                    new PackageStyles.PackageStyle("nuts", 12, 12, 23, true)))
            .properties(prop -> prop.stacksTo(1))
            .register();

    public static void register() {
        registerPackageModel(CreateGarnishedPackageStyles.NUTS_PACKAGE.getId(), 12, 12);
    }

    public static void registerPackageModel(ResourceLocation id, int width, int height) {
        AllPartialModels.PACKAGES.put(id, PartialModel.of(id.withPrefix("item/")));
        AllPartialModels.PACKAGE_RIGGING.put(id, PartialModel.of(id.withPrefix("item/rigging_")));
    }
}
