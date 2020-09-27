package org.launchcode.marketplacemetrics.models;

public enum InventoryCategory {

    BOUGHT("Bought"),
    SOLD("Sold");

    private final String displayName;

    InventoryCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
