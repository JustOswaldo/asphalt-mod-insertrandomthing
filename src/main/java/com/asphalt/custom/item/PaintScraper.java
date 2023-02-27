package com.asphalt.custom.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

import net.minecraft.world.World;

import java.util.List;

import static com.asphalt.AsphaltMod.ASPHALT_BLOCK;
import static com.asphalt.custom.block.AsphaltBlock.HORIZONTAL_B;
import static com.asphalt.custom.block.AsphaltBlock.VERTICAL_B;

public class PaintScraper extends Item {

    public PaintScraper(FabricItemSettings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var world = context.getWorld();
        var blockState = world.getBlockState(context.getBlockPos());
        if (blockState.getBlock() == ASPHALT_BLOCK){

            world.setBlockState(context.getBlockPos(),blockState.with(VERTICAL_B, false).with(HORIZONTAL_B, false));
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // default white text
        tooltip.add(Text.translatable("item.asphalt_ow.tool_tip.paint_scraper"));

    }

}
