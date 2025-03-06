package org.tswicolly.jogo.player.stats;

public class ResistenceClass {
    private double resistence;

    public ResistenceClass() {
        this.resistence = 1;
    }

    public double getResistence() {
        return resistence;
    }

    public void setResistence(double resistence) {
        this.resistence = resistence;
    }

    public void levelUpResistence(double resistence){
        this.resistence = resistence + this.resistence;
    }
}
