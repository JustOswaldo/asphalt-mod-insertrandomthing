package com.asphalt.custom.block;

import net.minecraft.util.StringIdentifiable;

public enum asphalt_direction implements StringIdentifiable{
    NORMAL("normal"),
    VERTICAL("vertical"),
    HORIZONTAL("horizontal"),
    CROSSED("crossed");

    asphalt_direction(String name) {
        this.name = name;
    }
    private final String name;

    @Override
    public String asString() {
        return this.name;
    }
}
