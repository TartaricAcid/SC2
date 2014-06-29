package vswe.stevesvehicles.modules.data.registries;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import vswe.stevesvehicles.modules.data.ModuleData;
import vswe.stevesvehicles.modules.data.ModuleRegistry;
import vswe.stevesvehicles.old.Modules.Addons.ModuleMelter;
import vswe.stevesvehicles.old.Modules.Addons.ModuleMelterExtreme;
import vswe.stevesvehicles.old.Modules.Addons.ModuleSnowCannon;
import vswe.stevesvehicles.old.StevesVehicles;
import vswe.stevesvehicles.vehicles.VehicleRegistry;

import static vswe.stevesvehicles.old.Helpers.ComponentTypes.*;


public class ModuleRegistryTemperature extends ModuleRegistry {
    public ModuleRegistryTemperature() {
        super("steves_vehicles_temperature");

        ModuleData melter = new ModuleData("melter", ModuleMelter.class, 10);

        melter.addShapedRecipe(     Blocks.nether_brick,    Blocks.glowstone,   Blocks.nether_brick,
                                    Items.glowstone_dust,   Blocks.furnace,     Items.glowstone_dust,
                                    Blocks.nether_brick,    Blocks.glowstone,   Blocks.nether_brick);

        melter.addVehicles(VehicleRegistry.CART, VehicleRegistry.BOAT);
        register(melter);


        ModuleData extreme = new ModuleData("extreme_melter", ModuleMelterExtreme.class, 19);

        extreme.addShapedRecipe(    Blocks.nether_brick,    Blocks.obsidian,        Blocks.nether_brick,
                                    melter,                 Items.lava_bucket,      melter,
                                    Blocks.nether_brick,    Blocks.obsidian,        Blocks.nether_brick);

        extreme.addVehicles(VehicleRegistry.CART, VehicleRegistry.BOAT);
        register(extreme);

        ModuleData.addNemesis(melter, extreme);


        ModuleData freezer = new ModuleData("freezer", ModuleSnowCannon.class, 24);

        extreme.addShapedRecipe(    Blocks.snow,            Items.water_bucket,     Blocks.snow,
                                    Items.water_bucket,     SIMPLE_PCB,             Items.water_bucket,
                                    Blocks.snow,            Items.water_bucket,     Blocks.snow);

        extreme.addVehicles(VehicleRegistry.CART, VehicleRegistry.BOAT);
        register(freezer);
        if (!StevesVehicles.isChristmas) {
            freezer.lock();
        }
    }
}
