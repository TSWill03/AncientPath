package org.tswicolly.jogo.player.stats;

public class Stats {
    private ResistenceClass resistence;
    private StrengthClass strength;
    private VitalityClass vitality;

    public Stats() {
        resistence = new ResistenceClass();
        strength = new StrengthClass();
        vitality = new VitalityClass();
    }

    public double getResistence() {
        return resistence.getResistence();
    }

    public double getStrength() {
        return strength.getStrenght();
    }

    public double getVitality() {
        return vitality.getVitality();
    }
}
