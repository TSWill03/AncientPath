package org.tswicolly.jogo.controllers.inventory;

import org.tswicolly.jogo.inventory.Inventory;
import org.tswicolly.jogo.itens.tipos.ItemBase;

public class InventoryController {
    ItemBase item;
    Inventory inventory;
    public InventoryController(int tipe) {
        if (tipe == 1) {
            inventory = new Inventory(100, 30);
        }
        else {
            inventory = new Inventory(20000, 10);
        }
    }
    public void addItem(ItemBase item) {
        if (inventory.getCurrentItems() < inventory.getMaxItems()) {
            inventory.addItem(item);
        } else {
            System.out.println("Inventário cheio");
        }
    }

    public void showInventory() {
        inventory.showInventory();
    }
}
