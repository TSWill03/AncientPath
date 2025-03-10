package org.tswicolly.jogo.controllers.inventory;

import org.tswicolly.jogo.inventory.Inventory;
import org.tswicolly.jogo.itens.tipos.ItemBase;

public class InventoryController {
    Inventory inventory;

    public InventoryController(int type) {
        if (type == 1) {
            inventory = new Inventory(100, 30);
        } else {
            inventory = new Inventory(20000, 10);
        }
    }

    public boolean addItem(ItemBase item) {
        return inventory.addItem(item);
    }

    public boolean removeItem(ItemBase item) {
        return inventory.removeItem(item);
    }

    public boolean contains(ItemBase item) {
        return inventory.contains(item);
    }

    public void showInventory() {
        inventory.showInventory();
    }
    public int findItemIndex(ItemBase item) {
        return inventory.findItemIndex(item);
    }

    public ItemBase getItemAt(int index) {
        return inventory.getItemAt(index);
    }

    public void setItemAt(int index, ItemBase item) {
        inventory.setItemAt(index, item);
    }

}
