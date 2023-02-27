package com.asphalt.custom.item;

import com.asphalt.AsphaltMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.List;

import static com.asphalt.AsphaltMod.ASPHALT_BLOCK;
import static com.asphalt.custom.block.AsphaltBlock.*;
import static com.asphalt.custom.block.asphalt_direction.HORIZONTAL;
import static com.asphalt.custom.block.asphalt_direction.VERTICAL;
import static net.minecraft.command.argument.BlockStateArgumentType.blockState;

public class PaintBrush extends Item {
    public final DyeColor dyeColor;


    public PaintBrush(DyeColor dyeColor, FabricItemSettings settings) {
        super(settings);
        this.dyeColor = dyeColor;
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var world = context.getWorld();
        var direction = context.getPlayerFacing();
        var blockState = world.getBlockState(context.getBlockPos());
        if (blockState.getBlock() == ASPHALT_BLOCK) {
            if (!world.isClient) {
                world.playSound(
                        null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                        context.getBlockPos(), // The position of where the sound will come from
                        AsphaltMod.BRUSH_STROKE_SOUND_EVENT, // The sound that will play
                        SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                        1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                        1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                );
            }
            if (direction == Direction.NORTH){
                world.setBlockState(context.getBlockPos(),blockState.with(VERTICAL_B, true).with(COLOUR_B, dyeColor.getId()));

            }
            if (direction == Direction.SOUTH){
                world.setBlockState(context.getBlockPos(),blockState.with(VERTICAL_B, true).with(COLOUR_B, dyeColor.getId()));
            }
            if (direction == Direction.EAST){
                world.setBlockState(context.getBlockPos(),blockState.with(HORIZONTAL_B, true).with(COLOUR_B, dyeColor.getId()));
            }
            if (direction == Direction.WEST){
                world.setBlockState(context.getBlockPos(),blockState.with(HORIZONTAL_B, true).with(COLOUR_B, dyeColor.getId()));
            }
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // default white text
        tooltip.add(Text.translatable("item.asphalt_ow.tool_tip.paint_brush"));

    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }
}
