package com.asphalt;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsphaltMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("asphalt-or-oswald-who-knows");
    public static final String NAMESPACE = "asphalt-mod-insertrandomthing";
    public static final Item CUSTOM_ITEM = new Item(new FabricItemSettings());
    public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(NAMESPACE, "general"))
            .icon(() -> new ItemStack(CUSTOM_ITEM))
            .build();

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "asphalt_block"), EXAMPLE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "paint_brush"), CUSTOM_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(CUSTOM_ITEM);
            content.add(CUSTOM_ITEM);
        });
    }
}