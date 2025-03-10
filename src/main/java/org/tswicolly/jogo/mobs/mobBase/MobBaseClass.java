package org.tswicolly.jogo.mobs.mobBase;

import org.tswicolly.jogo.itens.NoWeapon;
import org.tswicolly.jogo.itens.tipos.ItemBase;


public abstract class MobBaseClass {
    private String name;
    private double life;
    private double power;
    private double defense;
    private double level;
    private int xp;
    private int coin;
    /**
     * 1 = copper
     * 2 = silver
     * 3 = gold
     * 4 = platinum
     */
    private int coinType;
    private ItemBase drop;


    ItemBase EquipedItem;
    MobAtack atack = new MobAtack();


    public MobBaseClass(String name, double life, double power, double defense, double level, int xp, int coin, int coinType)  {
        this.name = name;
        this.life = life;
        this.power = power;
        this.defense = defense;
        this.level = level;
        this.xp = xp;
        this.coin = coin;
        this.coinType = coinType;
        EquipedItem = new NoWeapon();
    }
    public MobBaseClass(String name, double life, double power, double defense, double level, int xp, int coin, int coinType, ItemBase EquipedItem) {
        this.name = name;
        this.life = life;
        this.power = power;
        this.defense = defense;
        this.level = level;
        this.xp = xp;
        this.coin = coin;
        this.coinType = coinType;
        this.EquipedItem = EquipedItem;
    }

    public double atack(ItemBase EquipedItem){
        return atack.atack(EquipedItem, getPower());
    }

    public ItemBase getEquipedItem() {
        return EquipedItem;
    }


    public String getName() {
        return name;
    }

    public double getLife() {
        return life;
    }

    public double getPower() {
        return power;
    }

    public double getDefense() {
        return defense;
    }

    public double getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getCoin() {
        return coin;
    }
    public int getCoinType() {
        return coinType;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public ItemBase getDrop() {
        return drop;
    }
}
