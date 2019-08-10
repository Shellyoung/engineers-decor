/*
 * @file BlockDecorStraightPole.java
 * @author Stefan Wilhelm (wile)
 * @copyright (C) 2019 Stefan Wilhelm
 * @license MIT (see https://opensource.org/licenses/MIT)
 *
 * Smaller (cutout) block with a defined facing.
 */
package wile.engineersdecor.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.world.World;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;


public class BlockDecorStraightPole extends BlockDecorDirected
{
  public BlockDecorStraightPole(long config, Block.Properties builder, final AxisAlignedBB unrotatedAABB)
  { super(config, builder, unrotatedAABB); }

  @Override
  @Nullable
  public BlockState getStateForPlacement(BlockItemUseContext context)
  {
    Direction facing = context.getFace();
    BlockState state = getDefaultState().with(FACING, facing);
    if((config & CFG_FLIP_PLACEMENT_IF_SAME) != 0) {
      World world = context.getWorld();
      BlockPos pos = context.getPos();
      if(world.getBlockState(pos.offset(facing.getOpposite())).getBlock() instanceof BlockDecorStraightPole) {
        state = state.with(FACING, state.get(FACING).getOpposite());
      }
    }
    return state;
  }
}
