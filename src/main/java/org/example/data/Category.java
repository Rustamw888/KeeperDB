package org.example.data;

import java.util.Arrays;

public enum Category {

    SHOP("Магазины"), FUEL("АЗС"), BAR("Бары");

    Category(String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }

    private static Category findCategory(String description) {
        return Arrays.stream(values())
                .filter(category -> category.getDescription().equals(description))
                .findFirst()
                .orElseThrow();
    }
}
