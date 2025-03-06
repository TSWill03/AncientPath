package org.tswicolly.jogo.player.action.atack;

import org.tswicolly.jogo.itens.tipos.ItemBase;
import java.util.Random;


public class Atack {


    double damage;
    Random random = new Random();
    int critical;


    public double atack(ItemBase atackItem, double strenght){
        System.out.println("Atacando com "+ atackItem.getName());
        damage = atackItem.getPower() + strenght;
        critical = random.nextInt(0,100);

        System.out.println("Chance de critico: "+ critical);
        if(critical >= 90){
            damage = damage * 5;
            System.out.println("Deu "+ damage +" de Dano\nCritico de 5x");

        }
        if(critical >= 70 && critical < 90){
            damage = damage * 2;
            System.out.println("Deu "+ damage +" de Dano\nCritico de 2x");

        }
        if(critical < 70){
            System.out.println("Deu "+ damage +" de Dano");

        }
        return damage;
    }
}
