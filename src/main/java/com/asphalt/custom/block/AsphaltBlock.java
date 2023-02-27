package com.asphalt.custom.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;

public class AsphaltBlock extends Block {
    public static final BooleanProperty VERTICAL_B = BooleanProperty.of("vertical_b");
    public static final IntProperty COLOUR_B = IntProperty.of("asphalt_state", 0,15);
    public static final BooleanProperty HORIZONTAL_B = BooleanProperty.of("horizontal_b");
    public static final EnumProperty<asphalt_direction> ASPHALT_DIRECTION = EnumProperty.of("asphalt_direction", asphalt_direction.class);
    // The block instance. You can place it anywhere. Make the class is initialized.
    public static final AsphaltBlock ASPHALT_BLOCK = new AsphaltBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());


    public AsphaltBlock(FabricBlockSettings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(HORIZONTAL_B, false));
        setDefaultState(getDefaultState().with(COLOUR_B, 0));
        setDefaultState(getDefaultState().with(VERTICAL_B, false));

    }
    public IntProperty getAsphaltColour(){
        return COLOUR_B;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_B);
        builder.add(COLOUR_B);
        builder.add(VERTICAL_B);
    }

}
