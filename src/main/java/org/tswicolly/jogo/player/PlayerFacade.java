package org.tswicolly.jogo.player;

import org.tswicolly.jogo.controllers.balance.BalanceController;
import org.tswicolly.jogo.controllers.inventory.InventoryController;
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
    private Xp xp; // Responsável por gerenciar a lógica de experiência
    private InventoryController inventory;

    public PlayerFacade(String name) {
        this.name = name;
        this.level = 1;
        this.life = stats.getVitality() * 100;
        this.lifeMax = stats.getVitality() * 100;
        this.inventory = new InventoryController(type);
        this.xp = new Xp(); // Valor inicial de xpToLevelUp é definido internamente
    }

    public int getLevel() {
        return level;
    }

    public double atack() {
        return atack.atack(getEquipedItem(), stats.getStrength());
    }

    public ItemBase getEquipedItem() {
        return equipedItem;
    }

    public void equipItem(ItemBase item) {
        this.equipedItem = item;
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
     * Adiciona pontos de experiência ao jogador e atualiza o nível de acordo com os pontos ganhos.
     *
     * @param exp pontos de experiência ganhos.
     */
    public void addXp(int exp) {
        // Calcula quantos níveis foram ganhos com o XP adicionado.
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
