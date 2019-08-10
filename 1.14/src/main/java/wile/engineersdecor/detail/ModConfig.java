/*
 * @file ModConfig.java
 * @author Stefan Wilhelm (wile)
 * @copyright (C) 2018 Stefan Wilhelm
 * @license MIT (see https://opensource.org/licenses/MIT)
 *
 * Main class for module settings. Handles reading and
 * saving the config file.
 */
package wile.engineersdecor.detail;

import wile.engineersdecor.ModContent;
import wile.engineersdecor.ModEngineersDecor;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.commons.lang3.tuple.Pair;
import wile.engineersdecor.blocks.*;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class ModConfig
{
  //--------------------------------------------------------------------------------------------------------------------

  public static final CommonConfig COMMON;
  public static final ServerConfig SERVER;
  public static final ClientConfig CLIENT;
  public static final ForgeConfigSpec COMMON_CONFIG_SPEC;
  public static final ForgeConfigSpec SERVER_CONFIG_SPEC;
  public static final ForgeConfigSpec CLIENT_CONFIG_SPEC;

  static {
    final Pair<CommonConfig, ForgeConfigSpec> common_ = (new ForgeConfigSpec.Builder()).configure(CommonConfig::new);
    COMMON_CONFIG_SPEC = common_.getRight();
    COMMON = common_.getLeft();
    final Pair<ServerConfig, ForgeConfigSpec> server_ = (new ForgeConfigSpec.Builder()).configure(ServerConfig::new);
    SERVER_CONFIG_SPEC = server_.getRight();
    SERVER = server_.getLeft();
    final Pair<ClientConfig, ForgeConfigSpec> client_ = (new ForgeConfigSpec.Builder()).configure(ClientConfig::new);
    CLIENT_CONFIG_SPEC = client_.getRight();
    CLIENT = client_.getLeft();
  }

  @SubscribeEvent
  public static void onLoad(final net.minecraftforge.fml.config.ModConfig.Loading configEvent)
  { apply(); ModEngineersDecor.logger().info("Loaded config file {}", configEvent.getConfig().getFileName()); }

  @SubscribeEvent
  public static void onFileChange(final net.minecraftforge.fml.config.ModConfig.ConfigReloading configEvent)
  { ModEngineersDecor.logger().info("Config file changed {}", configEvent.getConfig().getFileName()); }

  //--------------------------------------------------------------------------------------------------------------------

  public static class ClientConfig
  {
    public final ForgeConfigSpec.BooleanValue without_tooltips;

    ClientConfig(ForgeConfigSpec.Builder builder)
    {
      builder.comment("Settings not loaded on servers.")
             .push("client");
      // --- OPTOUTS ------------------------------------------------------------
      {
        builder.comment("Opt-out settings")
               .push("optout");
        without_tooltips = builder
          .translation(ModEngineersDecor.MODID + ".config.without_tooltips")
          .comment("Disable CTRL-SHIFT item tooltip display.")
          .define("without_tooltips", false);
      }
      builder.pop();
    }
  }

  //--------------------------------------------------------------------------------------------------------------------

  public static class ServerConfig
  {
    ServerConfig(ForgeConfigSpec.Builder builder)
    {
      builder.comment("Settings not loaded on clients.")
             .push("server");
      builder.pop();
    }
  }

  //--------------------------------------------------------------------------------------------------------------------

  public static class CommonConfig
  {
    // Optout
    public final ForgeConfigSpec.ConfigValue<String> pattern_excludes;
    public final ForgeConfigSpec.ConfigValue<String> pattern_includes;
    public final ForgeConfigSpec.BooleanValue without_clinker_bricks;
    public final ForgeConfigSpec.BooleanValue without_slag_bricks;
    public final ForgeConfigSpec.BooleanValue without_rebar_concrete;
    public final ForgeConfigSpec.BooleanValue without_walls;
    public final ForgeConfigSpec.BooleanValue without_stairs;
    public final ForgeConfigSpec.BooleanValue without_ie_concrete_wall;
    public final ForgeConfigSpec.BooleanValue without_panzer_glass;
    public final ForgeConfigSpec.BooleanValue without_crafting_table;
    public final ForgeConfigSpec.BooleanValue without_lab_furnace;
    public final ForgeConfigSpec.BooleanValue without_electrical_furnace;
    public final ForgeConfigSpec.BooleanValue without_treated_wood_furniture;
    public final ForgeConfigSpec.BooleanValue without_windows;
    public final ForgeConfigSpec.BooleanValue without_light_sources;
    public final ForgeConfigSpec.BooleanValue without_ladders;
    public final ForgeConfigSpec.BooleanValue without_chair_sitting;
    public final ForgeConfigSpec.BooleanValue without_mob_chair_sitting;
    public final ForgeConfigSpec.BooleanValue without_ladder_speed_boost;
    public final ForgeConfigSpec.BooleanValue without_crafting_table_history;
    public final ForgeConfigSpec.BooleanValue without_valves;
    public final ForgeConfigSpec.BooleanValue without_passive_fluid_accumulator;
    public final ForgeConfigSpec.BooleanValue without_waste_incinerator;
    public final ForgeConfigSpec.BooleanValue without_sign_plates;
    public final ForgeConfigSpec.BooleanValue without_factory_dropper;
    public final ForgeConfigSpec.BooleanValue without_slabs;
    public final ForgeConfigSpec.BooleanValue without_halfslabs;
    public final ForgeConfigSpec.BooleanValue without_direct_slab_pickup;
    public final ForgeConfigSpec.BooleanValue without_poles;
    public final ForgeConfigSpec.BooleanValue without_hsupports;
    // Misc
    public final ForgeConfigSpec.BooleanValue with_experimental;
    public final ForgeConfigSpec.BooleanValue without_recipes;
    // Tweaks
    public final ForgeConfigSpec.IntValue furnace_smelting_speed_percent;
    public final ForgeConfigSpec.IntValue furnace_fuel_efficiency_percent;
    public final ForgeConfigSpec.IntValue furnace_boost_energy_consumption;
    public final ForgeConfigSpec.IntValue e_furnace_speed_percent;
    public final ForgeConfigSpec.IntValue e_furnace_power_consumption;
    public final ForgeConfigSpec.BooleanValue e_furnace_automatic_pulling;
    public final ForgeConfigSpec.DoubleValue chair_mob_sitting_probability_percent;
    public final ForgeConfigSpec.DoubleValue chair_mob_standup_probability_percent;
    public final ForgeConfigSpec.BooleanValue with_crafting_quickmove_buttons;
    public final ForgeConfigSpec.IntValue pipevalve_max_flowrate;
    public final ForgeConfigSpec.IntValue pipevalve_redstone_gain;

    CommonConfig(ForgeConfigSpec.Builder builder)
    {
      builder.comment("Settings affecting the logical server side, but are also configurable in single player.")
             .push("server");
      // --- OPTOUTS ------------------------------------------------------------
      {
        builder.comment("Opt-out settings")
               .push("optout");
        pattern_excludes = builder
          .translation(ModEngineersDecor.MODID + ".config.pattern_excludes")
          .comment("Opt-out any block by its registry name ('*' wildcard matching, "
            + "comma separated list, whitespaces ignored. You must match the whole name, "
            + "means maybe add '*' also at the begin and end. Example: '*wood*,*steel*' "
            + "excludes everything that has 'wood' or 'steel' in the registry name. "
            + "The matching result is also traced in the log file. ")
          .define("pattern_excludes", "");
        pattern_includes = builder
          .translation(ModEngineersDecor.MODID + ".config.pattern_includes")
          .comment("Prevent blocks from being opt'ed by registry name ('*' wildcard matching, "
            + "comma separated list, whitespaces ignored. Evaluated before all other opt-out checks. "
            + "You must match the whole name, means maybe add '*' also at the begin and end. Example: "
            + "'*wood*,*steel*' includes everything that has 'wood' or 'steel' in the registry name."
            + "The matching result is also traced in the log file.")
          .define("pattern_includes", "");
        without_clinker_bricks = builder
          .translation(ModEngineersDecor.MODID + ".config.without_clinker_bricks")
          .comment("Disable clinker bricks and derived blocks.")
          .define("without_clinker_bricks", false);
        without_slag_bricks = builder
          .translation(ModEngineersDecor.MODID + ".config.without_slag_bricks")
          .comment("Disable slag bricks and derived blocks.")
          .define("without_slag_bricks", false);
        without_rebar_concrete = builder
          .translation(ModEngineersDecor.MODID + ".config.without_rebar_concrete")
          .comment("Disable rebar concrete and derived blocks.")
          .define("without_rebar_concrete", false);
        without_walls = builder
          .translation(ModEngineersDecor.MODID + ".config.without_walls")
          .comment("Disable all mod wall blocks.")
          .define("without_walls", false);
        without_stairs = builder
          .translation(ModEngineersDecor.MODID + ".config.without_stairs")
          .comment("Disable all mod stairs blocks.")
          .define("without_stairs", false);
        without_ie_concrete_wall = builder
          .translation(ModEngineersDecor.MODID + ".config.without_ie_concrete_wall")
          .comment("Disable IE concrete wall.")
          .define("without_ie_concrete_wall", false);
        without_panzer_glass = builder
          .translation(ModEngineersDecor.MODID + ".config.without_panzer_glass")
          .comment("Disable panzer glass and derived blocks.")
          .define("without_panzer_glass", false);
        without_crafting_table = builder
          .translation(ModEngineersDecor.MODID + ".config.without_crafting_table")
          .comment("Disable treated wood crafting table.")
          .define("without_crafting_table", false);
        without_lab_furnace = builder
          .translation(ModEngineersDecor.MODID + ".config.without_lab_furnace")
          .comment("Disable small lab furnace.")
          .define("without_lab_furnace", false);
        without_electrical_furnace = builder
          .translation(ModEngineersDecor.MODID + ".config.without_electrical_furnace")
          .comment("Disable small electrical pass-through furnace.")
          .define("without_electrical_furnace", false);
        without_treated_wood_furniture = builder
          .translation(ModEngineersDecor.MODID + ".config.without_treated_wood_furniture")
          .comment("Disable treated wood table, stool, windowsill, etc.")
          .define("without_treated_wood_furniture", false);
        without_windows = builder
          .translation(ModEngineersDecor.MODID + ".config.without_windows")
          .comment("Disable treated wood window, etc.")
          .define("without_windows", false);
        without_light_sources = builder
          .translation(ModEngineersDecor.MODID + ".config.without_light_sources")
          .comment("Disable light sources")
          .define("without_light_sources", false);
        without_ladders = builder
          .translation(ModEngineersDecor.MODID + ".config.without_ladders")
          .comment("Disable ladders")
          .define("without_ladders", false);
        without_chair_sitting = builder
          .translation(ModEngineersDecor.MODID + ".config.without_chair_sitting")
          .comment("Disable possibility to sit on stools and chairs.")
          .define("without_chair_sitting", false);
        without_mob_chair_sitting = builder
          .translation(ModEngineersDecor.MODID + ".config.without_mob_chair_sitting")
          .comment("Disable that mobs will sit on chairs and stools.")
          .define("without_mob_chair_sitting", false);
        without_ladder_speed_boost = builder
          .translation(ModEngineersDecor.MODID + ".config.without_ladder_speed_boost")
          .comment("Disable the speed boost of ladders in this mod.")
          .define("without_ladder_speed_boost", false);
        without_crafting_table_history = builder
          .translation(ModEngineersDecor.MODID + ".config.without_crafting_table_history")
          .comment("Disable history refabrication feature of the treated wood crafting table.")
          .define("without_crafting_table_history", false);
        without_valves = builder
          .translation(ModEngineersDecor.MODID + ".config.without_valves")
          .comment("Disable check valve, and redstone controlled valves.")
          .define("without_valves", false);
        without_passive_fluid_accumulator = builder
          .translation(ModEngineersDecor.MODID + ".config.without_passive_fluid_accumulator")
          .comment("Disable the passive fluid accumulator.")
          .define("without_passive_fluid_accumulator", false);
        without_waste_incinerator = builder
          .translation(ModEngineersDecor.MODID + ".config.without_waste_incinerator")
          .comment("Disable item disposal/trash/void incinerator device.")
          .define("without_waste_incinerator", false);
        without_sign_plates = builder
          .translation(ModEngineersDecor.MODID + ".config.without_sign_plates")
          .comment("Disable decorative sign plates (caution, hazards, etc).")
          .define("without_sign_plates", false);
        without_factory_dropper = builder
          .translation(ModEngineersDecor.MODID + ".config.without_factory_dropper")
          .comment("Disable the factory dropper.")
          .define("without_factory_dropper", false);
        without_slabs = builder
          .translation(ModEngineersDecor.MODID + ".config.without_slabs")
          .comment("Disable horizontal half-block slab.")
          .define("without_slabs", false);
        without_halfslabs = builder
          .translation(ModEngineersDecor.MODID + ".config.without_halfslabs")
          .comment("Disable stackable 1/8 block slices.")
          .define("without_halfslabs", false);
        without_direct_slab_pickup = builder
          .translation(ModEngineersDecor.MODID + ".config.without_direct_slab_pickup")
          .comment("Disable directly picking up layers from slabs and slab " +
            " slices by left clicking while looking up/down.")
          .define("without_direct_slab_pickup", false);
        without_poles = builder
          .translation(ModEngineersDecor.MODID + ".config.without_poles")
          .comment("Disable poles of any material.")
          .define("without_poles", false);
        without_hsupports = builder
          .translation(ModEngineersDecor.MODID + ".config.without_hsupports")
          .comment("Disable horizontal supports like the double-T support.")
          .define("without_hsupports", false);
        without_recipes = builder
          .translation(ModEngineersDecor.MODID + ".config.without_recipes")
          .comment("Disable all internal recipes, allowing to use alternative pack recipes.")
          .define("without_recipes", false);
        builder.pop();
      }
      // --- MISC ---------------------------------------------------------------
      {
        builder.comment("Miscellaneous settings")
               .push("miscellaneous");
        with_experimental = builder
          .translation(ModEngineersDecor.MODID + ".config.with_experimental")
          .comment("Enables experimental features. Use at own risk.")
          .define("with_experimental", false);
        builder.pop();
      }
      // --- TWEAKS -------------------------------------------------------------
      {
        builder.comment("Tweaks")
               .push("tweaks");
        furnace_smelting_speed_percent = builder
          .translation(ModEngineersDecor.MODID + ".config.furnace_smelting_speed_percent")
          .comment("Defines, in percent, how fast the lab furnace smelts compared to " +
            "a vanilla furnace. 100% means vanilla furnace speed, 150% means the " +
            "lab furnace is faster. The value can be changed on-the-fly for tuning.")
          .defineInRange("furnace_smelting_speed_percent", 130, 50, 500);
        furnace_fuel_efficiency_percent = builder
          .translation(ModEngineersDecor.MODID + ".config.furnace_fuel_efficiency_percent")
          .comment("Defines, in percent, how fuel efficient the lab furnace is, compared " +
            "to a vanilla furnace. 100% means vanilla furnace consumiton, 200% means " +
            "the lab furnace needs about half the fuel of a vanilla furnace, " +
            "The value can be changed on-the-fly for tuning.")
          .defineInRange("furnace_fuel_efficiency_percent", 100, 50, 250);
        furnace_boost_energy_consumption = builder
          .translation(ModEngineersDecor.MODID + ".config.furnace_boost_energy_consumption")
          .comment("Defines the energy consumption (per tick) for speeding up the smelting process. " +
            "If IE is installed, an external heater has to be inserted into an auxiliary slot " +
            "of the lab furnace. The power source needs to be able to provide at least 4 times " +
            "this consumption (fixed threshold value). The value can be changed on-the-fly for tuning. " +
            "The default value corresponds to the IE heater consumption.")
          .defineInRange("furnace_boost_energy_consumption", 24, 16, 256);
        chair_mob_sitting_probability_percent = builder
          .translation(ModEngineersDecor.MODID + ".config.chair_mob_sitting_probability_percent")
          .comment("Defines, in percent, how high the probability is that a mob sits on a chair " +
            "when colliding with it. Can be changed on-the-fly for tuning.")
          .defineInRange("chair_mob_sitting_probability_percent", 10.0, 0.0, 80.0);
        chair_mob_standup_probability_percent = builder
          .translation(ModEngineersDecor.MODID + ".config.chair_mob_standup_probability_percent")
          .comment("Defines, in percent, probable it is that a mob leaves a chair when sitting " +
            "on it. The 'dice is rolled' about every 20 ticks. There is also a minimum " +
            "Sitting time of about 3s. The config value can be changed on-the-fly for tuning.")
          .defineInRange("chair_mob_standup_probability_percent", 1.0, 1e-3, 10.0);
        with_crafting_quickmove_buttons = builder
          .translation(ModEngineersDecor.MODID + ".config.with_crafting_quickmove_buttons")
          .comment("Enables small quick-move arrows from/to player/block storage. " +
            "Makes the UI a bit too busy, therefore disabled by default.")
          .define("with_crafting_quickmove_buttons", false);
        pipevalve_max_flowrate = builder
          .translation(ModEngineersDecor.MODID + ".config.pipevalve_max_flowrate")
          .comment("Defines how many millibuckets can be transferred (per tick) through the valves. " +
            "That is technically the 'storage size' specified for blocks that want to fill " +
            "fluids into the valve (the valve has no container and forward that to the output " +
            "block), The value can be changed on-the-fly for tuning. ")
          .defineInRange("pipevalve_max_flowrate", 1000, 1, 10000);
        pipevalve_redstone_gain = builder
          .translation(ModEngineersDecor.MODID + ".config.pipevalve_redstone_gain")
          .comment("Defines how many millibuckets per redstone signal strength can be transferred per tick " +
            "through the analog redstone controlled valves. Note: power 0 is always off, power 15 is always " +
            "the max flow rate. Between power 1 and 14 this scaler will result in a flow = 'redstone slope' * 'current redstone power'. " +
            "The value can be changed on-the-fly for tuning. ")
          .defineInRange("pipevalve_redstone_gain", 20, 1, 10000);
        e_furnace_speed_percent = builder
          .translation(ModEngineersDecor.MODID + ".config.e_furnace_speed_percent")
          .comment("Defines, in percent, how fast the electrical furnace smelts compared to " +
            "a vanilla furnace. 100% means vanilla furnace speed, 150% means the " +
            "electrical furnace is faster. The value can be changed on-the-fly for tuning.")
          .defineInRange("e_furnace_speed_percent", BlockDecorFurnaceElectrical.BTileEntity.DEFAULT_SPEED_PERCENT, 50, 500);
        e_furnace_power_consumption = builder
          .translation(ModEngineersDecor.MODID + ".config.e_furnace_power_consumption")
          .comment("Defines how much RF per tick the the electrical furnace consumed (average) for smelting. " +
            "The feeders transferring items from/to adjacent have this consumption/8 for each stack transaction. " +
            "The default value is only slightly higher than a furnace with an IE external heater (and no burning fuel inside)." +
            "The config value can be changed on-the-fly for tuning.")
          .defineInRange("e_furnace_power_consumption", BlockDecorFurnaceElectrical.BTileEntity.DEFAULT_ENERGY_CONSUMPTION, 10, 256);
        e_furnace_automatic_pulling = builder
          .translation(ModEngineersDecor.MODID + ".config.e_furnace_automatic_pulling")
          .comment("Defines if the electrical furnace automatically pulls items from an inventory at the input side." +
            "The config value can be changed on-the-fly for tuning.")
          .define("e_furnace_automatic_pulling", false);
        builder.pop();
      }
    }
  }

  //--------------------------------------------------------------------------------------------------------------------
  // Optout checks
  //--------------------------------------------------------------------------------------------------------------------

  public static final boolean isOptedOut(final @Nullable Block block)
  { return isOptedOut(block, false); }

  public static final boolean isOptedOut(final @Nullable Block block, boolean with_log_details)
  {
    if(block == null) return true;
    if(block == ModContent.SIGN_MODLOGO) return true;
    if(COMMON == null) return false;
    try {
      if(!COMMON.with_experimental.get()) {
        if(block instanceof ModAuxiliaries.IExperimentalFeature) return true;
        if(ModContent.isExperimentalBlock(block)) return true;
      }
      final String rn = block.getRegistryName().getPath();
      // Hard IE dependent blocks
      if(!immersiveengineering_installed) {
        if(block == ModContent.CONCRETE_WALL) return true;
        if((block instanceof BlockDecor) && ((((BlockDecor)block).config & BlockDecor.CFG_HARD_IE_DEPENDENT) != 0)) return true;
      }
      // Force-include/exclude pattern matching
      try {
        for(String e:includes_) {
          if(rn.matches(e)) {
            if(with_log_details) ModEngineersDecor.logger().info("Optout force include: " + rn);
            return false;
          }
        }
        for(String e:excludes_) {
          if(rn.matches(e)) {
            if(with_log_details) ModEngineersDecor.logger().info("Optout force exclude: " + rn);
            return true;
          }
        }
      } catch(Throwable ex) {
        ModEngineersDecor.logger().error("optout include pattern failed, disabling.");
        includes_.clear();
        excludes_.clear();
      }
      // Early non-opt out type based evaluation
      if(block instanceof BlockDecorCraftingTable) return COMMON.without_crafting_table.get();
      if(block instanceof BlockDecorFurnaceElectrical) return COMMON.without_electrical_furnace.get();
      if((block instanceof BlockDecorFurnace) && (!(block instanceof BlockDecorFurnaceElectrical))) return COMMON.without_lab_furnace.get();
      if(block instanceof BlockDecorPassiveFluidAccumulator) return COMMON.without_passive_fluid_accumulator.get();
      if(block instanceof BlockDecorWasteIncinerator) return COMMON.without_waste_incinerator.get();
      if(block instanceof BlockDecorDropper) return COMMON.without_factory_dropper.get();
      if(block instanceof BlockDecorHalfSlab) return COMMON.without_halfslabs.get();
      if(block instanceof BlockDecorLadder) return COMMON.without_ladders.get();
      if(block instanceof BlockDecorWindow) return COMMON.without_windows.get();
      if(block instanceof BlockDecorPipeValve) return COMMON.without_valves.get();
      if(block instanceof BlockDecorHorizontalSupport) return COMMON.without_hsupports.get();
      // Type based evaluation where later filters may match, too
      if(COMMON.without_slabs.get() && (block instanceof BlockDecorSlab)) return true;
      if(COMMON.without_stairs.get() && (block instanceof BlockDecorStairs)) return true;
      if(COMMON.without_walls.get() && (block instanceof BlockDecorWall)) return true;
      if(COMMON.without_poles.get() && (block instanceof BlockDecorStraightPole)) return true;
      // String matching based evaluation
      if(COMMON.without_clinker_bricks.get() && (rn.startsWith("clinker_brick_"))) return true;
      if(COMMON.without_slag_bricks.get() && rn.startsWith("slag_brick_")) return true;
      if(COMMON.without_rebar_concrete.get() && rn.startsWith("rebar_concrete")) return true;
      if(COMMON.without_ie_concrete_wall.get() && rn.startsWith("concrete_wall")) return true;
      if(COMMON.without_panzer_glass.get() && rn.startsWith("panzerglass_")) return true;
      if(COMMON.without_light_sources.get() && rn.endsWith("_light")) return true;
      if(COMMON.without_sign_plates.get() && rn.startsWith("sign_")) return true;
      if(COMMON.without_treated_wood_furniture.get()) {
        if(block instanceof BlockDecorChair) return true;
        if(rn.equals("treated_wood_table")) return true;
        if(rn.equals("treated_wood_stool")) return true;
        if(rn.equals("treated_wood_windowsill")) return true;
      }
    } catch(Exception ex) {
      ModEngineersDecor.logger().error("Exception evaluating the optout config: '" + ex.getMessage() + "'");
    }
    return false;
  }

  public static final boolean isOptedOut(final @Nullable Item item)
  {
    if(item == null) return true;
    if(SERVER == null) return false;
    return false;
  }

  //--------------------------------------------------------------------------------------------------------------------
  // Cache
  //--------------------------------------------------------------------------------------------------------------------
  private static final ArrayList<String> includes_ = new ArrayList<String>();
  private static final ArrayList<String> excludes_ = new ArrayList<String>();
  public static boolean without_crafting_table = false;
  public static boolean immersiveengineering_installed = false;

  public static final void apply()
  {
    BlockDecorFurnace.BTileEntity.on_config(COMMON.furnace_smelting_speed_percent.get(), COMMON.furnace_fuel_efficiency_percent.get(), COMMON.furnace_boost_energy_consumption.get());
    BlockDecorChair.on_config(COMMON.without_chair_sitting.get(), COMMON.without_mob_chair_sitting.get(), COMMON.chair_mob_sitting_probability_percent.get(), COMMON.chair_mob_standup_probability_percent.get());
    BlockDecorLadder.on_config(COMMON.without_ladder_speed_boost.get());
    BlockDecorCraftingTable.on_config(COMMON.without_crafting_table_history.get(), false, COMMON.with_crafting_quickmove_buttons.get());
    BlockDecorPipeValve.on_config(COMMON.pipevalve_max_flowrate.get(), COMMON.pipevalve_redstone_gain.get());
    BlockDecorFurnaceElectrical.BTileEntity.on_config(COMMON.e_furnace_speed_percent.get(), COMMON.e_furnace_power_consumption.get(), COMMON.e_furnace_automatic_pulling.get());
    without_crafting_table = isOptedOut(ModContent.TREATED_WOOD_CRAFTING_TABLE);
    immersiveengineering_installed = ModAuxiliaries.isModLoaded("immersiveengineering");
    {
      String inc = COMMON.pattern_includes.get().toLowerCase().replaceAll(ModEngineersDecor.MODID+":", "").replaceAll("[^*_,a-z0-9]", "");
      if(COMMON.pattern_includes.get() != inc) COMMON.pattern_includes.set(inc);
      if(!inc.isEmpty()) ModEngineersDecor.logger().info("Pattern includes: '" + inc + "'");
      String[] incl = inc.split(",");
      includes_.clear();
      for(int i=0; i< incl.length; ++i) {
        incl[i] = incl[i].replaceAll("[*]", ".*?");
        if(!incl[i].isEmpty()) includes_.add(incl[i]);
      }
    }
    {
      String exc = COMMON.pattern_includes.get().toLowerCase().replaceAll(ModEngineersDecor.MODID+":", "").replaceAll("[^*_,a-z0-9]", "");
      if(!exc.isEmpty()) ModEngineersDecor.logger().info("Pattern excludes: '" + exc + "'");
      String[] excl = exc.split(",");
      excludes_.clear();
      for(int i=0; i< excl.length; ++i) {
        excl[i] = excl[i].replaceAll("[*]", ".*?");
        if(!excl[i].isEmpty()) excludes_.add(excl[i]);
      }
    }


  }

}
