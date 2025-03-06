package org.tswicolly.jogo.inventory;

import org.tswicolly.jogo.itens.tipos.ItemBase;

public class Inventory {
    private double maxWeight;
    private int currentWeight;
    private int maxItems;
    private int currentItems;
    ItemBase[] items;

    public Inventory(double maxWeight, int maxItems) {
        this.maxWeight = maxWeight;
        this.maxItems = maxItems;
        this.currentWeight = 0;
        this.currentItems = 0;
        createInventory();
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        if(maxWeight < 0) {
            throw new IllegalArgumentException("Max weight must be greater than 0");
        }
        else {
            this.maxWeight = maxWeight;
        }
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public int getCurrentItems() {
        int currentItemsController = 0;
        for (ItemBase i: items) {
            if (!i.getName().equals("Empty Slot")) {
                currentItemsController++;
            }
        }
        currentItems = currentItemsController;
        return currentItems;
    }

    private void createInventory() {
        items = new ItemBase[maxItems];
        for(int i = 0; i < maxItems; i++) {
            items[i] = new EmptySlot();
        }
    }

    public void reloadWeight() {
        currentWeight = 0;
        for(int i = 0; i < maxItems; i++) {
            currentWeight += items[i].getWeight();
        }
    }

    public void addItem(ItemBase item) {
        int identifierCurrentItem = 0;
        for (ItemBase i: items) {
            if (i.getName().equals("Empty Slot")) {
                items[identifierCurrentItem] = item;
                reloadWeight();
            }
            else {
                identifierCurrentItem++;
            }
        }
    }

    public void showInventory() {
        for (ItemBase i: items) {
            System.out.println(i.getName());
        }
    }
}
