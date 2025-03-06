package org.tswicolly.jogo.controllers.battle;

import org.tswicolly.jogo.mobs.mobBase.MobBaseClass;
import org.tswicolly.jogo.player.Player;

import java.util.Scanner;

public class BattleController {
    Player player;
    MobBaseClass mob;
    Scanner scanner = new Scanner(System.in);

    public BattleController(Player player, MobBaseClass mob) {
        this.player = player;
        this.mob = mob;
    }

    public void battle(){
        System.out.println("Player: "+ player.getName());
        System.out.println("Mob: "+ mob.getName() + "\n");


        while (player.getLife() > 0 && mob.getLife() > 0) {
            System.out.println("1 - Mostrar Vidas");
            System.out.println("2 - Player Atack");
            System.out.println("3 - Mob Atack");

            int optionBattleController = scanner.nextInt();
            System.out.println("\n");
            if (optionBattleController == 1) {
                System.out.println("Player: " + player.getLife());
                System.out.println("Mob: " + mob.getLife());
            }

            if (optionBattleController == 2) {
                mob.setLife(mob.getLife() - atackPlayer());
                if (mob.getLife() <= 0) {
                    System.out.println("Player Ganhou");
                    System.out.println("Ganhou " + mob.getXp() + " de xp");
                    System.out.print("Ganhou " + mob.getCoin() + " de ");
                    if (mob.getCoinTipe() == 1) {
                        System.out.println("Cobre");
                    }
                    if (mob.getCoinTipe() == 2) {
                        System.out.println("Prata");
                    }
                    if (mob.getCoinTipe() == 3) {
                        System.out.println("Ouro");
                    }
                    if (mob.getCoinTipe() == 4) {
                        System.out.println("Platina");
                    }
                    //Mob Drop

                    System.out.println("Dropou: " + mob.getEquipedItem().getName());
                    System.out.println("Deseja pegar o item?");
                    System.out.println("y-n");

                    String option = scanner.next();
                    if (option.equals("y")) {
                        player.getInventory().addItem(mob.getDrop());
                    }

                    player.addXp(mob.getXp());
                    player.addBalance(mob.getCoin(), mob.getCoinTipe());
                    System.out.println("\nPlayer ficou com " + player.getLife() + " de vida");
                }
            }
            if (optionBattleController == 3) {
                player.setLife(player.getLife() - atackMob());
                if (player.getLife() < 0) {
                    System.out.println("Player Perdeu");

                }
            }
        }
    }

    public double atackPlayer(){
        return player.atack();
    }

    public double atackMob(){
        return mob.atack(mob.getEquipedItem());
    }
}
