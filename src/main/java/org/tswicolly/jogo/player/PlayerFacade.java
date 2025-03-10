package org.tswicolly.jogo.player;

import org.tswicolly.jogo.controllers.balance.BalanceController;
import org.tswicolly.jogo.controllers.inventory.InventoryController;
import org.tswicolly.jogo.itens.NoWeapon;
import org.tswicolly.jogo.itens.tipos.ItemBase;
import org.tswicolly.jogo.player.action.atack.Atack;
import org.tswicolly.jogo.player.stats.Stats;
import org.tswicolly.jogo.player.xp.Xp;

public abstract class PlayerFacade {
    private String name;
    private int type = 1;
    private int level;
    private Stats stats = new Stats();
    private ItemBase equipedItem;
    private Atack atack = new Atack();
    private double life;
    private double lifeMax;
    private BalanceController balance = new BalanceController();
    private Xp xp; // Gerencia a lógica de experiência
    private InventoryController inventory;

    public PlayerFacade(String name) {
        this.name = name;
        this.level = 1;
        this.life = stats.getVitality() * 100;
        this.lifeMax = stats.getVitality() * 100;
        this.inventory = new InventoryController(getType());
        this.xp = new Xp();
        // Inicialmente, equipa o NoWeapon
        equipedItem = new NoWeapon();
    }

    public double atack() {
        return atack.atack(getEquipedItem(), stats.getStrength());
    }

    public int getLevel() {
        return level;
    }

    public ItemBase getEquipedItem() {
        return equipedItem;
    }

    /**
     * Troca o item equipado pelo novo item, caso este esteja no inventário.
     * Se o item atualmente equipado for um NoWeapon, ele é simplesmente substituído;
     * caso contrário, é realizada uma troca: o item atualmente equipado é colocado no slot do novo item.
     *
     * @param newItem o item a ser equipado.
     */
    public void changeEquippedItem(ItemBase newItem) {
        // Procura o índice do novo item no inventário
        int index = inventory.findItemIndex(newItem);
        if (index == -1) {
            System.out.println("Item não está no inventário. Não é possível equipar.");
            return;
        }

        // Se o item atualmente equipado for NoWeapon, simplesmente substitui
        if (equipedItem instanceof NoWeapon) {
            // Remove o novo item do inventário (substituindo-o por um EmptySlot)
            inventory.setItemAt(index, new NoWeapon()); // ou new EmptySlot(), dependendo da lógica desejada
            equipedItem = newItem;
            System.out.println(newItem.getName() + " foi equipado.");
        } else {
            // Realiza a troca: o item atualmente equipado vai para o slot onde estava o novo item
            ItemBase temp = equipedItem;
            equipedItem = newItem;
            inventory.setItemAt(index, temp);
            System.out.println(newItem.getName() + " foi equipado, e " + temp.getName() + " foi para o inventário.");
        }
    }

    public int getType() {
        return type;
    }

    public double getLife() {
        return life;
    }

    public void addLife(double life) {
        this.life = Math.min(this.life + life, lifeMax);
    }

    public void setLife(double life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void levelUp() {
        this.level++;
    }

    public void mostrar() {
        System.out.println("Level: " + getLevel());
        System.out.println("Força: " + stats.getStrength());
        System.out.println("Resistência: " + stats.getResistence());
        System.out.println("Vitalidade: " + stats.getVitality());
        if (getEquipedItem() != null) {
            System.out.println("Item Equipado: " + getEquipedItem().getName()
                    + " com " + getEquipedItem().getPower() + " de poder");
        } else {
            System.out.println("Nenhum item equipado.");
        }
    }

    public void addBalance(int coin, int coinType) {
        balance.addCoin(coin, coinType);
    }

    public void showBalance() {
        balance.showBalance();
    }

    public InventoryController getInventory() {
        return inventory;
    }

    /**
     * Adiciona um item ao inventário do jogador.
     *
     * @param item o item a ser adicionado.
     * @return true se o item foi adicionado com sucesso; false caso contrário.
     */
    public boolean addInventoryItem(ItemBase item) {
        boolean added = inventory.addItem(item);
        if (added) {
            System.out.println(item.getName() + " adicionado ao inventário.");
        }
        return added;
    }

    /**
     * Remove um item do inventário do jogador.
     *
     * @param item o item a ser removido.
     * @return true se o item foi removido com sucesso; false caso contrário.
     */
    public boolean removeInventoryItem(ItemBase item) {
        boolean removed = inventory.removeItem(item);
        if (removed) {
            System.out.println(item.getName() + " removido do inventário.");
        }
        return removed;
    }

    /**
     * Adiciona pontos de experiência ao jogador e atualiza o nível de acordo com os pontos ganhos.
     *
     * @param exp pontos de experiência ganhos.
     */
    public void addXp(int exp) {
        int levelsGained = xp.addXp(exp, level);
        for (int i = 0; i < levelsGained; i++) {
            levelUp();
        }
        System.out.println("Level: " + this.level);
        System.out.println("Xp total: " + xp.getXp());
        System.out.println("Xp para próximo level: " + xp.getXpToLevelUp());
    }

    /**
     * Método auxiliar para adicionar XP de mobs.
     *
     * @param xpEarned XP ganho do mob.
     */
    public void addXpMob(int xpEarned) {
        addXp(xpEarned);
    }
}
