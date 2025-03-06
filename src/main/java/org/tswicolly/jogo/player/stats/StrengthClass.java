package org.tswicolly.jogo.player.stats;

public class StrengthClass {
    private double strenght;

    public StrengthClass() {
        this.strenght = 1;
    }

    public double getStrenght() {
        return strenght;
    }

    public void setStrenght(double strenght) {
        this.strenght = strenght;
    }

    public void levelUpStrenght(double strenght){
        this.strenght = strenght + this.strenght;
    }
}
