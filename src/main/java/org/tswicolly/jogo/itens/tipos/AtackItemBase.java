package org.tswicolly.jogo.itens.tipos;

public class AtackItemBase extends ItemBase{


    private final int tipe = 1;
    private int range;

    public AtackItemBase(String name, double weight, int power) {
        super(name, power);
        this.weight = weight;
    }
    public AtackItemBase(String name, double weight, int power, int range) {
        super(name, power);
        this.weight = weight;
        this.range = range;
    }
}
