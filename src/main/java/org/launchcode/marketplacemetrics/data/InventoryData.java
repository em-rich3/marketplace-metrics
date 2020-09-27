package org.launchcode.marketplacemetrics.data;

import org.launchcode.marketplacemetrics.models.Inventory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InventoryData {

    private static final Map<Integer, Inventory> inventoryMap = new HashMap<>();

    public static void add(Inventory inventory) {
        inventoryMap.put(inventory.getId(), inventory);
    }

    public static Inventory getById(int id) {
        return inventoryMap.get(id);
    }

    public static Collection<Inventory> getAll() {
        return inventoryMap.values();
    }

    public static void remove(int id) {
        inventoryMap.remove(id);
    }
}
