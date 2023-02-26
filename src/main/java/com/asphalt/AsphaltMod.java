package com.asphalt;

import com.asphalt.custom.item.PaintBrush;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsphaltMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("asphalt-or-oswald-who-knows");
    public static final String NAMESPACE = "asphalt_ow";
    //    public static final Item CUSTOM_ITEM = new Item(new FabricItemSettings());

    public static final PaintBrush PAINT_BRUSH = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush"), new PaintBrush(DyeColor.WHITE, new FabricItemSettings()));
    public static final PaintBrush PAINT_BRUSH_BLACK = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_black"), new PaintBrush(DyeColor.BLACK, new FabricItemSettings()));
    public static final Block ASPHALT_BLOCK = Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "asphalt_block"), new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()));
    public static final Block SLIGHTLY_CRACKED_BLOCK = Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "slightly_cracked_asphalt_block"), new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()));
    public static final Block CRACKED_ASPHALT_BLOCK = Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "cracked_asphalt_block"), new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()));
    public static final Item asphaltBlockItem = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "asphalt_block"), new BlockItem(ASPHALT_BLOCK, new FabricItemSettings()));
    public static final Item SlightCrackedAsphaltBlockItem = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "slightly_cracked_asphalt_block"), new BlockItem(SLIGHTLY_CRACKED_BLOCK, new FabricItemSettings()));
    public static final Item CrackedAsphaltBlockItem = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cracked_asphalt_block"), new BlockItem(CRACKED_ASPHALT_BLOCK, new FabricItemSettings()));
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(NAMESPACE, "general")).icon(() -> new ItemStack(asphaltBlockItem)).build();

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(PAINT_BRUSH);
            content.add(PAINT_BRUSH_BLACK);
            content.add(asphaltBlockItem);
            content.add(SlightCrackedAsphaltBlockItem);
            content.add(CrackedAsphaltBlockItem);
        });
    }
}