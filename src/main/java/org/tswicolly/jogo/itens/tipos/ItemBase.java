package org.tswicolly.jogo.itens.tipos;

public abstract class ItemBase {
    String name;
    double weight;
    double power;

    public ItemBase(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public double getWeight() {
        return (int) weight;
    }
}
