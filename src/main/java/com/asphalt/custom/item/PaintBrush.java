package com.asphalt.custom.item;

import com.asphalt.AsphaltMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.world.World;

import java.util.List;

import static com.asphalt.AsphaltMod.ASPHALT_BLOCK;

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
            context.getPlayer().sendMessage(Text.literal(String.valueOf(direction)));
            context.getPlayer().sendMessage(Text.literal(String.valueOf(dyeColor)));
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
