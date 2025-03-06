package org.tswicolly.jogo.mobs.mobBase;

import org.tswicolly.jogo.itens.tipos.ItemBase;

import java.util.Random;

public class MobAtack {

    double damage;
    Random random = new Random();
    int critical = random.nextInt(0,100);

    public double atack(ItemBase atackItem, double strenght){
        System.out.println("Atacando com "+ atackItem.getName());
        damage = atackItem.getPower() + strenght;

        if(critical == 70){
            damage = damage * 5;
            System.out.println("Deu "+ damage +" de Dano\nCritico de 5x");

        }
        if(critical >= 70){
            damage = damage * 2;
            System.out.println("Deu "+ damage +" de Dano\nCritico de 2x");

        }
        if(critical < 70){
            System.out.println("Deu "+ damage +" de Dano");

        }

        return damage;
    }
}
