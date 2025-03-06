package org.tswicolly.jogo.player;


import org.tswicolly.jogo.controllers.balance.BalanceController;
import org.tswicolly.jogo.controllers.inventory.InventoryController;
import org.tswicolly.jogo.inventory.Inventory;
import org.tswicolly.jogo.itens.tipos.ItemBase;
import org.tswicolly.jogo.player.action.atack.Atack;
import org.tswicolly.jogo.player.stats.ResistenceClass;
import org.tswicolly.jogo.player.stats.StrengthClass;
import org.tswicolly.jogo.player.stats.VitalityClass;

public class Player {

    private String name;
    private int tipe = 1;
    private int level;
    private StrengthClass strength;
    private ResistenceClass resistence;
    private VitalityClass vitality;
    ItemBase EquipedItem;
    Atack atack = new Atack();
    double life;
    double lifeMax;
    BalanceController balance = new BalanceController();
    int xp = 0;
    int xpToLevelUp = 100;
    int xpToNextLevelMultiplier = 2;
    InventoryController inventory;


    public Player(String name) {
        this.name = name;
        this.level = 1;
        strength = new StrengthClass();
        resistence = new ResistenceClass();
        vitality = new VitalityClass();
        life = vitality.getVitality() * 100;
        lifeMax = vitality.getVitality() * 100;
        inventory = new InventoryController(tipe);
    }

    public int getLevel() {
        return level;
    }

    public Double getStrength() {
        return strength.getStrenght();
    }
    public Double getResistence() {
        return resistence.getResistence();
    }
    public Double getVitality() {
        return vitality.getVitality();
    }
    public double atack(){
        return atack.atack(getEquipedItem(), getStrength());
    }

    public ItemBase getEquipedItem() {
        return EquipedItem;
    }

    public void EquipItem(ItemBase item){
        this.EquipedItem = item;
    }
    public int getTipe() {
        return tipe;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }


    public void mostrar(){
        System.out.println("Level: " + getLevel());
        System.out.println("Força: " + getStrength());
        System.out.println("Resistencia: " + getResistence());
        System.out.println("Vitalidade: " + getVitality());
        System.out.println("Item Equipado: " + getEquipedItem().getName() + " com " + getEquipedItem().getPower() + " de poder");
    }

    public String getName() {
        return name;
    }

    public void levelUp(){
        this.level = level + 1;
    }

    public void addXp(int xp){
        this.xp += xp;
        while (this.xp >= xpToLevelUp){
            this.xp -= xpToLevelUp;
            levelUp();
            xpToLevelUp = xpToLevelUp * (level * xpToNextLevelMultiplier);
        }
        System.out.println("Level: " + this.level);
        System.out.println("Xp total: " + this.xp);
        System.out.println("Xp para proximo level: " + xpToLevelUp);
    }

    public void addBalance(int coin, int coinType){
        balance.addCoin(coin, coinType);
    }

    public void addLife(double life){
        this.life = Math.min(this.life + life, lifeMax);
    }

    public void showBalance(){
        balance.showBalance();
    }
    public InventoryController getInventory() {
        return inventory;
    }
}
