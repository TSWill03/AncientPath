package org.tswicolly.jogo.inventory;

import org.tswicolly.jogo.itens.tipos.ItemBase;

public class Inventory {
    private double maxWeight;
    private int maxItems;
    private ItemBase[] items;

    public Inventory(double maxWeight, int maxItems) {
        if(maxWeight < 0) {
            throw new IllegalArgumentException("Max weight must be greater than 0");
        }
        if(maxItems <= 0) {
            throw new IllegalArgumentException("Max items must be greater than 0");
        }
        this.maxWeight = maxWeight;
        this.maxItems = maxItems;
        initializeInventory();
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        if(maxWeight < 0) {
            throw new IllegalArgumentException("Max weight must be greater than 0");
        }
        this.maxWeight = maxWeight;
    }

    /**
     * Calcula o peso total atual somando o peso de cada item.
     */
    public int getCurrentWeight() {
        int totalWeight = 0;
        for (ItemBase item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public int getMaxItems() {
        return maxItems;
    }

    /**
     * Calcula quantos itens não são "Empty Slot" no inventário.
     */
    public int getCurrentItems() {
        int count = 0;
        for (ItemBase item : items) {
            if (!item.getName().equals("Empty Slot")) {
                count++;
            }
        }
        return count;
    }

    /**
     * Inicializa o inventário preenchendo os slots com EmptySlot.
     */
    private void initializeInventory() {
        items = new ItemBase[maxItems];
        for (int i = 0; i < maxItems; i++) {
            items[i] = new EmptySlot();
        }
    }

    /**
     * Tenta adicionar um item ao inventário.
     * Verifica se o peso total não ultrapassa o peso máximo e se há slots vazios.
     *
     * @param item o item a ser adicionado
     * @return true se o item foi adicionado com sucesso; false caso contrário.
     */
    public boolean addItem(ItemBase item) {
        if (getCurrentWeight() + item.getWeight() > maxWeight) {
            System.out.println("Não é possível adicionar o item: excede o peso máximo.");
            return false;
        }
        for (int i = 0; i < maxItems; i++) {
            if (items[i].getName().equals("Empty Slot")) {
                items[i] = item;
                return true;
            }
        }
        System.out.println("Não é possível adicionar o item: inventário cheio.");
        return false;
    }

    /**
     * Verifica se o inventário contém o item.
     * @param item o item a ser procurado
     * @return true se o item estiver presente; false caso contrário.
     */
    public boolean contains(ItemBase item) {
        for (ItemBase it : items) {
            // Aqui podemos comparar pelo nome ou pela referência
            if (!it.getName().equals("Empty Slot") && it.getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove o item do inventário substituindo-o por um EmptySlot.
     * @param item o item a ser removido
     * @return true se o item foi removido; false se não foi encontrado.
     */
    public boolean removeItem(ItemBase item) {
        for (int i = 0; i < maxItems; i++) {
            if (!items[i].getName().equals("Empty Slot") && items[i].getName().equals(item.getName())) {
                items[i] = new EmptySlot();
                return true;
            }
        }
        System.out.println("Item não encontrado no inventário.");
        return false;
    }

    /**
     * Exibe o conteúdo do inventário.
     */
    public void showInventory() {
        for (int i = 0; i < maxItems; i++) {
            System.out.println("Slot " + i + ": " + items[i].getName());
        }
    }
    /**
     * Retorna o índice do item no inventário.
     * Se não for encontrado, retorna -1.
     */
    public int findItemIndex(ItemBase item) {
        for (int i = 0; i < maxItems; i++) {
            // Comparação pode ser feita pelo nome (ou outra lógica de igualdade)
            if (!items[i].getName().equals("Empty Slot") && items[i].getName().equals(item.getName())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retorna o item no slot indicado.
     */
    public ItemBase getItemAt(int index) {
        if (index >= 0 && index < maxItems) {
            return items[index];
        }
        return null;
    }

    /**
     * Define o item no slot indicado.
     */
    public void setItemAt(int index, ItemBase item) {
        if (index >= 0 && index < maxItems) {
            items[index] = item;
        }
    }

}
