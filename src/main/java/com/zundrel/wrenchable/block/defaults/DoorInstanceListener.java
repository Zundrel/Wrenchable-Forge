package com.zundrel.wrenchable.block.defaults;

import com.zundrel.wrenchable.WrenchableUtilities;
import com.zundrel.wrenchable.block.InstanceListener;
import com.zundrel.wrenchable.modkeys.api.ModKeys;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DoorInstanceListener extends InstanceListener {
    public DoorInstanceListener() {
        super(DoorBlock.class);
    }

    @Override
    public void onWrenched(World world, PlayerEntity player, BlockPos pos, Direction face) {
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if (ModKeys.isPrimaryPressed(player)) {
            world.setBlockState(pos, state.func_235896_a_(BlockStateProperties.DOOR_HINGE));
            world.neighborChanged(pos, block, pos);
            return;
        }

        WrenchableUtilities.doHorizontalFacingBehavior(world, player, pos, face);
    }
}
