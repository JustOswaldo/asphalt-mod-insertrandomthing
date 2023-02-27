package com.asphalt;

import com.asphalt.custom.block.AsphaltBlock;
import com.asphalt.custom.item.PaintBrush;
import com.asphalt.custom.item.PaintScraper;
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
import net.minecraft.sound.SoundEvent;
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

    //PAINT BRUSHES
    public static final PaintBrush PAINT_BRUSH = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush"), new PaintBrush(DyeColor.WHITE, new FabricItemSettings().maxCount(1)));
    public static final PaintScraper PAINT_SCRAPER = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_scraper"), new PaintScraper(new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_BLACK = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_black"), new PaintBrush(DyeColor.BLACK, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_BLUE = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_blue"), new PaintBrush(DyeColor.BLUE, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_BROWN = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_brown"), new PaintBrush(DyeColor.BROWN, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_LIGHT_BLUE = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_light_blue"), new PaintBrush(DyeColor.LIGHT_BLUE, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_CYAN = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_cyan"), new PaintBrush(DyeColor.CYAN, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_GRAY = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_gray"), new PaintBrush(DyeColor.GRAY, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_LIGHT_GRAY = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_light_gray"), new PaintBrush(DyeColor.LIGHT_GRAY, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_GREEN = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_green"), new PaintBrush(DyeColor.GREEN, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_LIME = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_lime"), new PaintBrush(DyeColor.LIME, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_MAGENTA = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_magenta"), new PaintBrush(DyeColor.MAGENTA, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_ORANGE = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_orange"), new PaintBrush(DyeColor.ORANGE, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_PINK = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_pink"), new PaintBrush(DyeColor.PINK, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_PURPLE = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_purple"), new PaintBrush(DyeColor.PURPLE, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_RED = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_red"), new PaintBrush(DyeColor.RED, new FabricItemSettings().maxCount(1)));
    public static final PaintBrush PAINT_BRUSH_YELLOW = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush_yellow"), new PaintBrush(DyeColor.YELLOW, new FabricItemSettings().maxCount(1)));
    //PAINT BRUSHES END
    public static final AsphaltBlock ASPHALT_BLOCK = Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "asphalt_block"), AsphaltBlock.ASPHALT_BLOCK);
    public static final Block SLIGHTLY_CRACKED_BLOCK = Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "slightly_cracked_asphalt_block"), new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()));
    public static final Block CRACKED_ASPHALT_BLOCK = Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "cracked_asphalt_block"), new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()));
    public static final Item asphaltBlockItem = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "asphalt_block"), new BlockItem(AsphaltBlock.ASPHALT_BLOCK, new FabricItemSettings()));
    public static final Item SlightCrackedAsphaltBlockItem = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "slightly_cracked_asphalt_block"), new BlockItem(SLIGHTLY_CRACKED_BLOCK, new FabricItemSettings()));
    public static final Item CrackedAsphaltBlockItem = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cracked_asphalt_block"), new BlockItem(CRACKED_ASPHALT_BLOCK, new FabricItemSettings()));
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(NAMESPACE, "general")).icon(() -> new ItemStack(asphaltBlockItem)).build();
    //sound effects
    public static final Identifier BRUSH_STROKE_SOUND = new Identifier("asphalt_ow:brush_stroke");
    public static SoundEvent BRUSH_STROKE_SOUND_EVENT = SoundEvent.of(BRUSH_STROKE_SOUND);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");
        Registry.register(Registries.SOUND_EVENT, AsphaltMod.BRUSH_STROKE_SOUND, BRUSH_STROKE_SOUND_EVENT);

        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            //Paint Brush
            content.add(PAINT_BRUSH);
            content.add(PAINT_BRUSH_LIGHT_GRAY);
            content.add(PAINT_BRUSH_GRAY);
            content.add(PAINT_BRUSH_BLACK);
            content.add(PAINT_BRUSH_BROWN);
            content.add(PAINT_BRUSH_RED);
            content.add(PAINT_BRUSH_ORANGE);
            content.add(PAINT_BRUSH_YELLOW);
            content.add(PAINT_BRUSH_LIME);
            content.add(PAINT_BRUSH_GREEN);
            content.add(PAINT_BRUSH_CYAN);
            content.add(PAINT_BRUSH_LIGHT_BLUE);
            content.add(PAINT_BRUSH_BLUE);
            content.add(PAINT_BRUSH_PURPLE);
            content.add(PAINT_BRUSH_MAGENTA);
            content.add(PAINT_BRUSH_PINK);
            //Paint Brush END
            content.add(PAINT_SCRAPER);
            content.add(asphaltBlockItem);
            content.add(SlightCrackedAsphaltBlockItem);
            content.add(CrackedAsphaltBlockItem);
        });
    }
}