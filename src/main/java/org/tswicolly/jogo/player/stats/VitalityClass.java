package org.tswicolly.jogo.player.stats;

public class VitalityClass {
    private double vitality;

    public VitalityClass() {
        this.vitality = 1;
    }

    public double getVitality() {
        return vitality;
    }

    public void setVitality(double vitality) {
        this.vitality = vitality;
    }

    public void levelUpVitality(double vitality){
        this.vitality = vitality + this.vitality;
    }
}
