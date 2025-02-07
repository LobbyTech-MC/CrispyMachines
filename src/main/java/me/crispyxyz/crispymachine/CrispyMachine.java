package me.crispyxyz.crispymachine;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import javax.annotation.Nonnull;

public class CrispyMachine extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        //Config cfg = new Config(this);

        /*
         * Creating a new Category
         */
        ItemStack categoryItem = new CustomItemStack(Material.BLAST_FURNACE, "&e酥脆机器", "", "&a> 点击打开");

        // Give your Category a unique id.
        NamespacedKey categoryId = new NamespacedKey(this, "crispy_machine");
        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

        /*
         * Creating a Recipe
         */
        ItemStack[] oilRecipe = {SlimefunItems.OIL_BUCKET, SlimefunItems.OIL_BUCKET};
        ItemStack[] crispyMachineCoreRecipe = {
            SlimefunItems.STEEL_INGOT, new ItemStack(Material.LEVER), SlimefunItems.STEEL_INGOT,
            SlimefunItems.STEEL_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.STEEL_INGOT, 
            SlimefunItems.STEEL_INGOT, SlimefunItems.ENERGY_CONNECTOR, SlimefunItems.STEEL_INGOT 
        };
        ItemStack[] crispyMachineShellRecipe = {
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_PLATE,
            SlimefunItems.REINFORCED_ALLOY_INGOT, null, SlimefunItems.REINFORCED_ALLOY_INGOT, 
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_PLATE
        };
        ItemStack[] dieselGeneratorRecipe = {
            new ItemStack(Material.IRON_TRAPDOOR), new ItemStack(Material.DISPENSER), new ItemStack(Material.IRON_TRAPDOOR),
            null, new ItemStack(Material.PISTON), null,
            null, Items.CRISPY_MACHINE_CORE, null
        };
        ItemStack[] gasolineGeneratorRecipe = {
            new ItemStack(Material.IRON_TRAPDOOR), SlimefunItems.ELECTRO_MAGNET, new ItemStack(Material.IRON_TRAPDOOR),
            null, new ItemStack(Material.PISTON), null,
            null, Items.CRISPY_MACHINE_CORE, null
        };
        ItemStack[] printerRecipe = {
            SlimefunItems.STEEL_INGOT, SlimefunItems.BATTERY, SlimefunItems.STEEL_INGOT,
            SlimefunItems.MAGNET, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.MAGNET,
            SlimefunItems.STEEL_INGOT, SlimefunItems.BATTERY, SlimefunItems.STEEL_INGOT
        };
        ItemStack[] copierRecipe = {
            Items.CRISPY_MACHINE_SHELL, Items.PRINTER, Items.CRISPY_MACHINE_SHELL,
            Items.CRISPY_MACHINE_SHELL, Items.CRISPY_MACHINE_CORE, Items.CRISPY_MACHINE_SHELL,
            Items.CRISPY_MACHINE_SHELL, new ItemStack(Material.NETHERITE_BLOCK), Items.CRISPY_MACHINE_SHELL
        };
        ItemStack[] menuRecipe = {new ItemStack(Material.PAPER)};
        ItemStack[] tearOfNewtonRecipe = {
                null, new ItemStack(Material.GHAST_TEAR), null,
                new ItemStack(Material.PISTON), Items.CRISPY_MACHINE_CORE, new ItemStack(Material.PISTON),
                new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.BLAZE_POWDER)
        };



        /*
         * Registering the Item
         */
        DieselOil dieselOil = new DieselOil(itemGroup, Items.DIESEL_OIL, RecipeType.COMPRESSOR, oilRecipe);
        Gasoline gasoline = new Gasoline(itemGroup, Items.GASOLINE, RecipeType.SMELTERY, oilRecipe);
        CrispyMachineCore crispyMachineCore = new CrispyMachineCore(itemGroup, Items.CRISPY_MACHINE_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, crispyMachineCoreRecipe);
        CrispyMachineShell crispyMachineShell = new CrispyMachineShell(itemGroup, Items.CRISPY_MACHINE_SHELL, RecipeType.ENHANCED_CRAFTING_TABLE, crispyMachineShellRecipe);
        DieselGenerator dieselGenerator = new DieselGenerator(itemGroup, Items.DIESEL_GENERATOR_BIG, RecipeType.ENHANCED_CRAFTING_TABLE, dieselGeneratorRecipe);
        GasolineGenerator gasolineGenerator = new GasolineGenerator(itemGroup, Items.GASOLINE_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, gasolineGeneratorRecipe);
        Printer printer = new Printer(itemGroup, Items.PRINTER, RecipeType.ENHANCED_CRAFTING_TABLE, printerRecipe);
        GeneralTemplate generalTemplate = new GeneralTemplate(itemGroup, Items.GENERAL_TEMPLATE, new RecipeType(Items.PRINTER, "PRINTER"), new ItemStack[]{SlimefunItems.REINFORCED_ALLOY_INGOT});
        Copier copier = new Copier(itemGroup, Items.COPIER, RecipeType.NULL, copierRecipe);
        Menu menu = new Menu(itemGroup, Items.MENU, RecipeType.ENHANCED_CRAFTING_TABLE, menuRecipe);
        TearOfNewton tearOfNewton = new TearOfNewton(itemGroup, Items.TEAR_OF_NEWTON, RecipeType.ENHANCED_CRAFTING_TABLE, tearOfNewtonRecipe);

        dieselOil.register(this);
        gasoline.register(this);
        crispyMachineCore.register(this);
        crispyMachineShell.register(this);
        dieselGenerator.register(this);
        gasolineGenerator.register(this);
        printer.register(this);
        generalTemplate.register(this);
        copier.register(this);
        menu.register(this);
        tearOfNewton.register(this);

        try {
            registerExpGivers(itemGroup);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

    private void registerExpGivers(ItemGroup itemGroup) throws NoSuchFieldException {
        ItemStack[] expGiverIRecipe = {
                new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.REDSTONE), new ItemStack(Material.LAPIS_LAZULI),
                new ItemStack(Material.REDSTONE), SlimefunItems.STEEL_PLATE, new ItemStack(Material.REDSTONE),
                new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.REDSTONE), new ItemStack(Material.LAPIS_LAZULI)
        };
        ExpGiver expGiverI = new ExpGiver(itemGroup, Items.EXP_GIVER_I, RecipeType.NULL, expGiverIRecipe, 1);
        expGiverI.register(this);

        for(int i = 2; i<=10; i++) {
            ExpGiver giver = new ExpGiver(itemGroup, Items.get("EXP_GIVER_" + toRoman(i)), RecipeType.NULL, new ItemStack[]{
                    Items.get("EXP_GIVER_" + toRoman(i - 1)), Items.get("EXP_GIVER_" + toRoman(i - 1))
            }, i);
            giver.register(this);
        }
    }

    private static String toRoman(int num){
        switch (num){
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            default: return "";
        }
    }

}
