package org.tswicolly.jogo.controllers.balance;

public class BalanceController {
    private int copper;
    private int silver;
    private int gold;
    private int platinum;
    public BalanceController() {

        this.copper = 0;
        this.silver = 0;
        this.gold = 0;
        this.platinum = 0;

    }

    public void addCoin(int coin, int coinType) {
        if (coinType == 1) {
            copper += coin;
        }
        if (coinType == 2) {
            silver += coin;
        }
        if (coinType == 3) {
            gold += coin;
        }
        if (coinType == 4) {
            platinum += coin;
        }
        verifyBalance();
    }

    public void verifyBalance(){
        boolean verify = false;
        while (!verify){
            while (copper >= 10){
                    copper -= 10;
                    silver += 1;
                }
            while (silver >= 10){
                silver -= 10;
                gold += 1;
            }
            while (gold >= 10){
                gold -= 10;
                platinum += 1;
            }
            verify = true;
        }
    }

    public int getCopper() {
        return copper;
    }

    public int getSilver() {
        return silver;
    }

    public int getGold() {
        return gold;
    }

    public int getPlatinum() {
        return platinum;
    }
    public void showBalance(){
        System.out.println("Cobre: "+ getCopper());
        System.out.println("Prata: "+ getSilver());
        System.out.println("Ouro:  "+ getGold());
        System.out.println("Platina: "+ getPlatinum());
    }
}
