/*
 * @file ModBlocks.java
 * @author Stefan Wilhelm (wile)
 * @copyright (C) 2018 Stefan Wilhelm
 * @license MIT (see https://opensource.org/licenses/MIT)
 *
 * Definition and initialisation of blocks of this
 * module, along with their tile entities if applicable.
 *
 * Note: Straight forward definition of different blocks/entities
 *       to make recipes, models and texture definitions easier.
 */
package wile.engineersdecor.blocks;

import wile.engineersdecor.ModEngineersDecor;
import wile.engineersdecor.detail.ModAuxiliaries;
import wile.engineersdecor.detail.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class ModBlocks
{
  //--------------------------------------------------------------------------------------------------------------------
  //-- Blocks
  //--------------------------------------------------------------------------------------------------------------------

  public static final BlockDecorFull CLINKER_BRICK_BLOCK = new BlockDecorFull("clinker_brick_block", 0, Material.ROCK, 2f, 15f, SoundType.STONE);
  public static final BlockDecorStairs CLINKER_BRICK_STAIRS = new BlockDecorStairs("clinker_brick_stairs", CLINKER_BRICK_BLOCK.getDefaultState());
  public static final BlockDecorWall CLINKER_BRICK_WALL = new BlockDecorWall("clinker_brick_wall", BlockDecor.CFG_DEFAULT, Material.ROCK, 2f, 20f, SoundType.STONE);
  public static final BlockDecorSlab CLINKER_BRICK_SLAB = new BlockDecorSlab("clinker_brick_slab", BlockDecor.CFG_DEFAULT, Material.ROCK, 2f, 20f, SoundType.STONE);

  public static final BlockDecorFull CLINKER_BRICK_STAINED_BLOCK = new BlockDecorFull("clinker_brick_stained_block", 0, Material.ROCK, 2f, 15f, SoundType.STONE);
  public static final BlockDecorStairs CLINKER_BRICK_STAINED_STAIRS = new BlockDecorStairs("clinker_brick_stained_stairs", CLINKER_BRICK_STAINED_BLOCK.getDefaultState());
  public static final BlockDecorSlab CLINKER_BRICK_STAINED_SLAB = new BlockDecorSlab("clinker_brick_stained_slab", BlockDecor.CFG_DEFAULT, Material.ROCK, 2f, 20f, SoundType.STONE);

  public static final BlockDecorFull SLAG_BRICK_BLOCK  = new BlockDecorFull("slag_brick_block", 0, Material.ROCK, 2f, 15f, SoundType.STONE);
  public static final BlockDecorStairs SLAG_BRICK_STAIRS = new BlockDecorStairs("slag_brick_stairs", SLAG_BRICK_BLOCK.getDefaultState());
  public static final BlockDecorWall SLAG_BRICK_WALL = new BlockDecorWall("slag_brick_wall", BlockDecor.CFG_DEFAULT, Material.ROCK, 2f, 15f, SoundType.STONE);
  public static final BlockDecorSlab SLAG_BRICK_SLAB = new BlockDecorSlab("slag_brick_slab", BlockDecor.CFG_DEFAULT, Material.ROCK, 2f, 15f, SoundType.STONE);

  public static final BlockDecorFull REBAR_CONCRETE_BLOCK = new BlockDecorFull("rebar_concrete", 0, Material.ROCK, 5f, 2000f, SoundType.STONE);
  public static final BlockDecorStairs REBAR_CONCRETE_STAIRS = new BlockDecorStairs("rebar_concrete_stairs", REBAR_CONCRETE_BLOCK.getDefaultState());
  public static final BlockDecorWall REBAR_CONCRETE_WALL = new BlockDecorWall("rebar_concrete_wall", BlockDecor.CFG_DEFAULT, Material.ROCK, 5f, 2000f, SoundType.STONE);
  public static final BlockDecorSlab REBAR_CONCRETE_SLAB = new BlockDecorSlab("rebar_concrete_slab", BlockDecor.CFG_DEFAULT, Material.ROCK, 5f, 2000f, SoundType.STONE);

  public static final BlockDecorFull REBAR_CONCRETE_TILE = new BlockDecorFull("rebar_concrete_tile", 0, Material.ROCK, 5f, 2000f, SoundType.STONE);
  public static final BlockDecorStairs REBAR_CONCRETE_TILE_STAIRS = new BlockDecorStairs("rebar_concrete_tile_stairs", REBAR_CONCRETE_TILE.getDefaultState());
  public static final BlockDecorSlab REBAR_CONCRETE_TILE_SLAB = new BlockDecorSlab("rebar_concrete_tile_slab", BlockDecor.CFG_DEFAULT, Material.ROCK, 5f, 2000f, SoundType.STONE);

  public static final BlockDecorWall CONCRETE_WALL = new BlockDecorWall("concrete_wall", BlockDecor.CFG_DEFAULT, Material.ROCK, 5f, 20f, SoundType.STONE);

  public static final BlockDecorLadder METAL_RUNG_LADDER = new BlockDecorLadder("metal_rung_ladder", 0, Material.IRON, 0.5f, 20f, SoundType.METAL);
  public static final BlockDecorLadder METAL_RUNG_STEPS = new BlockDecorLadder("metal_rung_steps", 0, Material.IRON, 0.5f, 20f, SoundType.METAL);
  public static final BlockDecorLadder TREATED_WOOD_LADDER = new BlockDecorLadder("treated_wood_ladder", 0, Material.WOOD, 0.5f, 10f, SoundType.WOOD);

  public static final BlockDecorGlassBlock PANZERGLASS_BLOCK = new BlockDecorGlassBlock("panzerglass_block", 0, Material.GLASS, 1f, 2000f, SoundType.GLASS);
  public static final BlockDecorSlab PANZERGLASS_SLAB = new BlockDecorSlab("panzerglass_slab", BlockDecor.CFG_TRANSLUCENT, Material.GLASS, 1f, 2000f, SoundType.GLASS);

  //--------------------------------------------------------------------------------------------------------------------

  public static final BlockDecorCraftingTable TREATED_WOOD_CRAFTING_TABLE = new BlockDecorCraftingTable(
    "treated_wood_crafting_table",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HORIZIONTAL|BlockDecor.CFG_LOOK_PLACEMENT|BlockDecor.CFG_OPPOSITE_PLACEMENT,
    Material.WOOD, 1.0f, 15f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(1,0,1, 15,15.9,15)
  );

  public static final BlockDecorFurnace SMALL_LAB_FURNACE = new BlockDecorFurnace(
    "small_lab_furnace",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HORIZIONTAL|BlockDecor.CFG_LOOK_PLACEMENT|BlockDecor.CFG_OPPOSITE_PLACEMENT|
      BlockDecor.CFG_ELECTRICAL,
    Material.IRON, 0.5f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(1,0,1, 15,15,16)
  );

  public static final BlockDecorFurnaceElectrical SMALL_ELECTRICAL_FURNACE = new BlockDecorFurnaceElectrical(
    "small_electrical_furnace",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HORIZIONTAL|BlockDecor.CFG_LOOK_PLACEMENT|BlockDecor.CFG_ELECTRICAL,
    Material.IRON, 0.5f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(0,0,0, 16,16,16)
  );

  public static final BlockDecorDropper FACTORY_DROPPER = new BlockDecorDropper(
    "factory_dropper",
    BlockDecor.CFG_LOOK_PLACEMENT|BlockDecor.CFG_REDSTONE_CONTROLLED,
    Material.IRON, 1f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(0,0,0, 16,16,15)
  );

  public static final BlockDecorWasteIncinerator SMALL_WASTE_INCINERATOR = new BlockDecorWasteIncinerator(
    "small_waste_incinerator",
    BlockDecor.CFG_DEFAULT|BlockDecor.CFG_ELECTRICAL,
    Material.IRON, 1f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(0,0,0, 16,16,16)
  );

  public static final BlockDecorMineralSmelter SMALL_MINERAL_SMELTER = new BlockDecorMineralSmelter(
    "small_mineral_smelter",
    BlockDecor.CFG_LOOK_PLACEMENT,
    Material.IRON, 1f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(1.1,0,1.1, 14.9,16,14.9)
  );

  //--------------------------------------------------------------------------------------------------------------------

  public static final BlockDecorPipeValve STRAIGHT_CHECK_VALVE = new BlockDecorPipeValve(
    "straight_pipe_valve",
    BlockDecor.CFG_FACING_PLACEMENT|BlockDecor.CFG_OPPOSITE_PLACEMENT|BlockDecor.CFG_FLIP_PLACEMENT_SHIFTCLICK|
      BlockDecor.CFG_CUTOUT,
    Material.IRON, 0.7f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(4,4,0, 12,12,16)
  );

  public static final BlockDecorPipeValve STRAIGHT_REDSTONE_VALVE = new BlockDecorPipeValve(
    "straight_pipe_valve_redstone",
    BlockDecor.CFG_FACING_PLACEMENT|BlockDecor.CFG_OPPOSITE_PLACEMENT|BlockDecor.CFG_FLIP_PLACEMENT_SHIFTCLICK|
      BlockDecor.CFG_CUTOUT|BlockDecor.CFG_REDSTONE_CONTROLLED,
    Material.IRON, 0.7f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(4,4,0, 12,12,16)
  );

  public static final BlockDecorPipeValve STRAIGHT_REDSTONE_ANALOG_VALVE = new BlockDecorPipeValve(
    "straight_pipe_valve_redstone_analog",
    BlockDecor.CFG_FACING_PLACEMENT|BlockDecor.CFG_OPPOSITE_PLACEMENT|BlockDecor.CFG_FLIP_PLACEMENT_SHIFTCLICK|
      BlockDecor.CFG_CUTOUT|BlockDecor.CFG_REDSTONE_CONTROLLED|BlockDecor.CFG_ANALOG,
    Material.IRON, 0.7f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(4,4,0, 12,12,16)
  );

  public static final BlockDecorPassiveFluidAccumulator PASSIVE_FLUID_ACCUMULATOR = new BlockDecorPassiveFluidAccumulator(
    "passive_fluid_accumulator",
    BlockDecor.CFG_FACING_PLACEMENT|BlockDecor.CFG_OPPOSITE_PLACEMENT|BlockDecor.CFG_FLIP_PLACEMENT_SHIFTCLICK|
      BlockDecor.CFG_CUTOUT,
    Material.IRON, 0.7f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(0,0,0, 16,16,16)
  );

  //--------------------------------------------------------------------------------------------------------------------

  public static final BlockDecorStraightPole TREATED_WOOD_POLE = new BlockDecorStraightPole(
    "treated_wood_pole",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_FACING_PLACEMENT,
    Material.WOOD, 1.0f, 10f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(5.8,5.8,0, 10.2,10.2,16)
  );

  public static final BlockDecorStraightPole TREATED_WOOD_POLE_HEAD = new BlockDecorStraightPole(
    "treated_wood_pole_head",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_FACING_PLACEMENT|BlockDecor.CFG_FLIP_PLACEMENT_IF_SAME,
    Material.WOOD, 1.0f, 10f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(5.8,5.8,0, 10.2,10.2,16)
  );

  public static final BlockDecorStraightPole TREATED_WOOD_POLE_SUPPORT = new BlockDecorStraightPole(
    "treated_wood_pole_support",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_FACING_PLACEMENT|BlockDecor.CFG_FLIP_PLACEMENT_IF_SAME,
    Material.WOOD, 1.0f, 10f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(5.8,5.8,0, 10.2,10.2,16)
  );

  public static final BlockDecorStraightPole THIN_STEEL_POLE = new BlockDecorStraightPole(
    "thin_steel_pole",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_FACING_PLACEMENT,
    Material.IRON, 2.0f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(6,6,0, 10,10,16)
  );

  public static final BlockDecorStraightPole THIN_STEEL_POLE_HEAD = new BlockDecorStraightPole(
    "thin_steel_pole_head",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_FACING_PLACEMENT|BlockDecor.CFG_FLIP_PLACEMENT_IF_SAME,
    Material.IRON, 2.0f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(6,6,0, 10,10,16)
  );

  public static final BlockDecorStraightPole THICK_STEEL_POLE = new BlockDecorStraightPole(
    "thick_steel_pole",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_FACING_PLACEMENT,
    Material.IRON, 2.0f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(5,5,0, 11,11,16)
  );

  public static final BlockDecorStraightPole THICK_STEEL_POLE_HEAD = new BlockDecorStraightPole(
    "thick_steel_pole_head",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_FACING_PLACEMENT|BlockDecor.CFG_FLIP_PLACEMENT_IF_SAME,
    Material.IRON, 2.0f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(5,5,0, 11,11,16)
  );

  public static final BlockDecorHorizontalSupport STEEL_DOUBLE_T_SUPPORT = new BlockDecorHorizontalSupport(
    "steel_double_t_support",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HORIZIONTAL|BlockDecor.CFG_LOOK_PLACEMENT,
    Material.IRON, 2.0f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(5,11,0, 11,16,16)
  );

  //--------------------------------------------------------------------------------------------------------------------

  public static final BlockDecor TREATED_WOOD_TABLE = new BlockDecor(
    "treated_wood_table",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HORIZIONTAL|BlockDecor.CFG_LOOK_PLACEMENT,
    Material.WOOD, 1.0f, 15f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(1,0,1, 15,15.9,15)
  );

  public static final BlockDecorChair TREATED_WOOD_STOOL = new BlockDecorChair(
    "treated_wood_stool",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HORIZIONTAL|BlockDecor.CFG_LOOK_PLACEMENT,
    Material.WOOD, 1.0f, 15f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(4.1,0,4.1, 11.8,8.8,11.8)
  );

  public static final BlockDecor TREATED_WOOD_SIDE_TABLE = new BlockDecor(
    "treated_wood_side_table",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HORIZIONTAL|BlockDecor.CFG_LOOK_PLACEMENT,
    Material.WOOD, 1.0f, 15f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(2,0,2, 14,15.9,14)
  );

  public static final BlockDecorDirected TREATED_WOOD_WINDOWSILL = new BlockDecorDirected(
    "treated_wood_windowsill",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HORIZIONTAL|BlockDecor.CFG_FACING_PLACEMENT,
    Material.WOOD, 1.0f, 10f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(0.5,15,10.5, 15.5,16,16)
  );

  public static final BlockDecorDirected INSET_LIGHT_IRON = new BlockDecorDirected(
    "iron_inset_light",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_OPPOSITE_PLACEMENT|(14<<BlockDecor.CFG_LIGHT_VALUE_SHIFT),
    Material.IRON, 0.5f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(5.2,5.2,15.7, 10.8,10.8,16.0)
  );

  public static final BlockDecor STEEL_TABLE = new BlockDecor(
    "steel_table",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HORIZIONTAL|BlockDecor.CFG_LOOK_PLACEMENT,
    Material.IRON, 1.0f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(0,0,0, 16,16,16)
  );

  public static final BlockDecorFloorGrating STEEL_FLOOR_GRATING = new BlockDecorFloorGrating(
    "steel_floor_grating",
    BlockDecor.CFG_CUTOUT,
    Material.IRON, 1.0f, 15f, SoundType.METAL,
    ModAuxiliaries.getPixeledAABB(0,14,0, 16,16,16)
  );

  //--------------------------------------------------------------------------------------------------------------------

  public static final BlockDecorWindow TREATED_WOOD_WINDOW = new BlockDecorWindow(
    "treated_wood_window",
    BlockDecor.CFG_TRANSLUCENT|BlockDecor.CFG_LOOK_PLACEMENT,
    Material.WOOD, 0.5f, 10f, SoundType.GLASS,
    ModAuxiliaries.getPixeledAABB(0,0,7, 16,16,9)
  );

  public static final BlockDecorWindow STEEL_FRAMED_WINDOW = new BlockDecorWindow(
    "steel_framed_window",
    BlockDecor.CFG_TRANSLUCENT|BlockDecor.CFG_LOOK_PLACEMENT,
    Material.IRON, 0.5f, 15f, SoundType.GLASS,
    ModAuxiliaries.getPixeledAABB(0,0,7.5, 16,16,8.5)
  );

  //--------------------------------------------------------------------------------------------------------------------

  public static final BlockDecorDirected SIGN_MODLOGO = new BlockDecorDirected(
    "sign_decor",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_OPPOSITE_PLACEMENT|(1<<BlockDecor.CFG_LIGHT_VALUE_SHIFT),
    Material.WOOD, 0.1f, 1000f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(0,0,15.6, 16,16,16)
  );

  public static final BlockDecorDirected SIGN_HOTWIRE = new BlockDecorDirected(
    "sign_hotwire",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_OPPOSITE_PLACEMENT|(1<<BlockDecor.CFG_LIGHT_VALUE_SHIFT),
    Material.WOOD, 0.1f, 1f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(2,2,15.6, 14,14,16)
  );

  public static final BlockDecorDirected SIGN_MINDSTEP = new BlockDecorDirected(
    "sign_mindstep",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_OPPOSITE_PLACEMENT|(1<<BlockDecor.CFG_LIGHT_VALUE_SHIFT),
    Material.WOOD, 0.1f, 1f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(2,2,15.6, 14,14,16)
  );

  public static final BlockDecorDirected SIGN_DANGER = new BlockDecorDirected(
    "sign_danger",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_OPPOSITE_PLACEMENT|(1<<BlockDecor.CFG_LIGHT_VALUE_SHIFT),
    Material.WOOD, 0.1f, 1f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(2,2,15.6, 14,14,16)
  );

  public static final BlockDecorDirected SIGN_DEFENSE = new BlockDecorDirected(
    "sign_defense",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_OPPOSITE_PLACEMENT|(1<<BlockDecor.CFG_LIGHT_VALUE_SHIFT),
    Material.WOOD, 0.1f, 1f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(2,2,15.6, 14,14,16)
  );

  public static final BlockDecorDirected SIGN_FACTORY_AREA = new BlockDecorDirected(
    "sign_factoryarea",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_OPPOSITE_PLACEMENT,
    Material.WOOD, 0.1f, 1f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(2,2,15.6, 15,15,16)
  );

  public static final BlockDecorDirected SIGN_EXIT = new BlockDecorDirected(
    "sign_exit",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_OPPOSITE_PLACEMENT,
    Material.WOOD, 0.1f, 1f, SoundType.WOOD,
    ModAuxiliaries.getPixeledAABB(3,7,15.6, 13,13,16)
  );

  //--------------------------------------------------------------------------------------------------------------------

  public static final BlockDecorHalfSlab HALFSLAB_REBARCONCRETE = new BlockDecorHalfSlab(
    "halfslab_rebar_concrete",
    BlockDecor.CFG_CUTOUT,
    Material.ROCK, 2f, 2000f, SoundType.STONE
  );
  public static final BlockDecorHalfSlab HALFSLAB_CONCRETE = new BlockDecorHalfSlab(
    "halfslab_concrete",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HARD_IE_DEPENDENT,
    Material.ROCK, 1.0f, 10f, SoundType.STONE
  );
  public static final BlockDecorHalfSlab HALFSLAB_TREATEDWOOD = new BlockDecorHalfSlab(
    "halfslab_treated_wood",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HARD_IE_DEPENDENT,
    Material.WOOD, 0.6f, 4f, SoundType.WOOD
  );
  public static final BlockDecorHalfSlab HALFSLAB_SHEETMETALIRON = new BlockDecorHalfSlab(
    "halfslab_sheetmetal_iron",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HARD_IE_DEPENDENT,
    Material.IRON, 0.8f, 10f, SoundType.METAL
  );
  public static final BlockDecorHalfSlab HALFSLAB_SHEETMETALSTEEL = new BlockDecorHalfSlab(
    "halfslab_sheetmetal_steel",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HARD_IE_DEPENDENT,
    Material.IRON, 0.8f, 10f, SoundType.METAL
  );
  public static final BlockDecorHalfSlab HALFSLAB_SHEETMETALCOPPER = new BlockDecorHalfSlab(
    "halfslab_sheetmetal_copper",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HARD_IE_DEPENDENT,
    Material.IRON, 0.8f, 10f, SoundType.METAL
  );
  public static final BlockDecorHalfSlab HALFSLAB_SHEETMETALGOLD = new BlockDecorHalfSlab(
    "halfslab_sheetmetal_gold",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HARD_IE_DEPENDENT,
    Material.IRON, 0.6f, 10f, SoundType.METAL
  );
  public static final BlockDecorHalfSlab HALFSLAB_SHEETMETALALUMINIUM = new BlockDecorHalfSlab(
    "halfslab_sheetmetal_aluminum",
    BlockDecor.CFG_CUTOUT|BlockDecor.CFG_HARD_IE_DEPENDENT,
    Material.IRON, 0.6f, 10f, SoundType.METAL
  );

  //--------------------------------------------------------------------------------------------------------------------
  //-- Tile entities
  //--------------------------------------------------------------------------------------------------------------------

  private static class TileEntityRegistrationData
  {
    public final Class<? extends TileEntity> clazz;
    public final ResourceLocation key;
    public TileEntityRegistrationData(Class<? extends TileEntity> c, String k) { clazz=c; key = new ResourceLocation(ModEngineersDecor.MODID, k); }
  }

  private static final TileEntityRegistrationData TREATED_WOOD_CRAFTING_TABLE_TEI = new TileEntityRegistrationData(
    BlockDecorCraftingTable.BTileEntity.class, "te_crafting_table"
  );
  private static final TileEntityRegistrationData SMALL_LAB_FURNACE_TEI = new TileEntityRegistrationData(
    BlockDecorFurnace.BTileEntity.class, "te_small_lab_furnace"
  );
  private static final TileEntityRegistrationData SMALL_ELECTRICAL_FURNACE_TEI = new TileEntityRegistrationData(
    BlockDecorFurnaceElectrical.BTileEntity.class, "te_electrical_lab_furnace"
  );
  private static final TileEntityRegistrationData STRAIGHT_PIPE_VALVE_TEI = new TileEntityRegistrationData(
    BlockDecorPipeValve.BTileEntity.class, "te_pipe_valve"
  );
  private static final TileEntityRegistrationData PASSIVE_FLUID_ACCUMULATOR_TEI = new TileEntityRegistrationData(
    BlockDecorPassiveFluidAccumulator.BTileEntity.class, "te_passive_fluid_accumulator"
  );
  private static final TileEntityRegistrationData WASTE_INCINERATOR_TEI = new TileEntityRegistrationData(
    BlockDecorWasteIncinerator.BTileEntity.class, "te_small_waste_incinerator"
  );
  private static final TileEntityRegistrationData FACTORY_DROPPER_TEI = new TileEntityRegistrationData(
    BlockDecorDropper.BTileEntity.class, "te_factory_dropper"
  );

  private static final TileEntityRegistrationData SMALL_MINERAL_SMELTER_TEI = new TileEntityRegistrationData(
    BlockDecorMineralSmelter.BTileEntity.class, "te_small_mineral_smelter"
  );

  //--------------------------------------------------------------------------------------------------------------------
  //-- Registration list
  //--------------------------------------------------------------------------------------------------------------------

  private static final Object content[] = {
    TREATED_WOOD_CRAFTING_TABLE, TREATED_WOOD_CRAFTING_TABLE_TEI,
    SMALL_LAB_FURNACE, SMALL_LAB_FURNACE_TEI,
    SMALL_ELECTRICAL_FURNACE, SMALL_ELECTRICAL_FURNACE_TEI,
    FACTORY_DROPPER, FACTORY_DROPPER_TEI,
    SMALL_WASTE_INCINERATOR, WASTE_INCINERATOR_TEI,
    STRAIGHT_CHECK_VALVE, STRAIGHT_REDSTONE_VALVE, STRAIGHT_REDSTONE_ANALOG_VALVE, STRAIGHT_PIPE_VALVE_TEI,
    PASSIVE_FLUID_ACCUMULATOR, PASSIVE_FLUID_ACCUMULATOR_TEI,
    CLINKER_BRICK_BLOCK,
    CLINKER_BRICK_SLAB,
    CLINKER_BRICK_STAIRS,
    CLINKER_BRICK_WALL,
    CLINKER_BRICK_STAINED_BLOCK,
    CLINKER_BRICK_STAINED_SLAB,
    CLINKER_BRICK_STAINED_STAIRS,
    SLAG_BRICK_BLOCK,
    SLAG_BRICK_SLAB,
    SLAG_BRICK_STAIRS,
    SLAG_BRICK_WALL,
    REBAR_CONCRETE_BLOCK,
    REBAR_CONCRETE_SLAB,
    REBAR_CONCRETE_STAIRS,
    REBAR_CONCRETE_WALL,
    REBAR_CONCRETE_TILE,
    REBAR_CONCRETE_TILE_SLAB,
    REBAR_CONCRETE_TILE_STAIRS,
    CONCRETE_WALL,
    PANZERGLASS_BLOCK,
    METAL_RUNG_LADDER,
    METAL_RUNG_STEPS,
    TREATED_WOOD_LADDER,
    TREATED_WOOD_POLE,
    TREATED_WOOD_TABLE,
    STEEL_TABLE,
    TREATED_WOOD_STOOL,
    TREATED_WOOD_WINDOW,
    STEEL_FRAMED_WINDOW,
    TREATED_WOOD_WINDOWSILL,
    INSET_LIGHT_IRON,
    TREATED_WOOD_POLE_SUPPORT,
    TREATED_WOOD_POLE_HEAD,
    THIN_STEEL_POLE,
    THICK_STEEL_POLE,
    THIN_STEEL_POLE_HEAD,
    THICK_STEEL_POLE_HEAD,
    STEEL_DOUBLE_T_SUPPORT,
    STEEL_FLOOR_GRATING,
    SIGN_HOTWIRE, SIGN_DANGER, SIGN_DEFENSE, SIGN_FACTORY_AREA, SIGN_EXIT, SIGN_MODLOGO,
    TREATED_WOOD_SIDE_TABLE,
    HALFSLAB_REBARCONCRETE, HALFSLAB_CONCRETE, HALFSLAB_TREATEDWOOD,
    HALFSLAB_SHEETMETALIRON, HALFSLAB_SHEETMETALSTEEL, HALFSLAB_SHEETMETALCOPPER,
    HALFSLAB_SHEETMETALGOLD, HALFSLAB_SHEETMETALALUMINIUM,
  };

  private static final Object dev_content[] = {
    SMALL_MINERAL_SMELTER, SMALL_MINERAL_SMELTER_TEI,
    PANZERGLASS_SLAB, // check if another class is needed due to is_side_visible
    SIGN_MINDSTEP,
  };

  //--------------------------------------------------------------------------------------------------------------------
  //-- Init
  //--------------------------------------------------------------------------------------------------------------------

  private static ArrayList<Block> registeredBlocks = new ArrayList<>();
  private static ArrayList<TileEntityRegistrationData> registeredTileEntityInits = new ArrayList<>();

  @Nonnull
  public static List<Block> getRegisteredBlocks()
  { return Collections.unmodifiableList(registeredBlocks); }

  // Invoked from CommonProxy.registerBlocks()
  public static final void registerBlocks(RegistryEvent.Register<Block> event)
  {
    // Config based registry selection
    final boolean ie_installed = Loader.isModLoaded("immersiveengineering");
    int num_block_registrations_skipped = 0;
    int num_block_registrations_skipped_noie = 0;
    final boolean woor = ModConfig.isWithoutOptOutRegistration();
    for(Object e:content) {
      if(e instanceof Block) {
        if((!ie_installed) && ((e instanceof BlockDecor) && ((((BlockDecor)e).config & BlockDecor.CFG_HARD_IE_DEPENDENT)!=0))) {
          ++num_block_registrations_skipped;
          ++num_block_registrations_skipped_noie;
          continue;
        }
        if((woor) && (e != SIGN_MODLOGO) && (ModConfig.isOptedOut((Block)e))) {
          ModEngineersDecor.logger.info("Registration opt-out: " + ((Block) e).getRegistryName().getPath());
          ++num_block_registrations_skipped;
          continue;
        }
        registeredBlocks.add((Block) e);
      } else if(e instanceof TileEntityRegistrationData) {
        registeredTileEntityInits.add((TileEntityRegistrationData)e);
      }
    }
    if(ModConfig.zmisc.with_experimental) {
      for(Object e:dev_content) {
        if(e instanceof Block) {
          registeredBlocks.add((Block) e);
        } else if(e instanceof TileEntityRegistrationData) {
          registeredTileEntityInits.add((TileEntityRegistrationData) e);
        }
      }
    }
    for(Block e:registeredBlocks) event.getRegistry().register(e);
    ModEngineersDecor.logger.info("Registered " + Integer.toString(registeredBlocks.size()) + " blocks.");
    if(num_block_registrations_skipped > 0) ModEngineersDecor.logger.info("Skipped registration of " + num_block_registrations_skipped + " blocks, " + num_block_registrations_skipped_noie + " because IE is not installed.");
    for(TileEntityRegistrationData e:registeredTileEntityInits) GameRegistry.registerTileEntity(e.clazz, e.key);
    ModEngineersDecor.logger.info("Registered " + Integer.toString(registeredTileEntityInits.size()) + " tile entities.");
  }

  // Invoked from ClientProxy.registerModels()
  @SideOnly(Side.CLIENT)
  public static final void initModels()
  {
    for(Block e:registeredBlocks) {
      ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(e), 0, new ModelResourceLocation(e.getRegistryName(), "inventory"));
    }
  }

  // Invoked from CommonProxy.registerItems()
  public static final void registerItemBlocks(RegistryEvent.Register<Item> event)
  {
    int n = 0;
    for(Block e:registeredBlocks) {
      ResourceLocation rl = e.getRegistryName();
      if(rl == null) continue;
      event.getRegistry().register(new ItemBlock(e).setRegistryName(rl));
      ++n;
    }
  }

}
