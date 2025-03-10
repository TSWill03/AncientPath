package org.tswicolly.jogo.test;


import org.tswicolly.jogo.controllers.battle.BattleController;
import org.tswicolly.jogo.itens.tipos.AtackItemBase;
import org.tswicolly.jogo.mobs.normal.goblin.Goblin;
import org.tswicolly.jogo.player.Player;


public class TestAtack {
    public void testAtack() {

        AtackItemBase basicSword = new AtackItemBase("BasicSword", 1, 400);
        Player player = new Player("Wicolly");
        player.equipItem(basicSword);

        Goblin goblin = new Goblin();

        BattleController battle = new BattleController(player, goblin);

        battle.battle();
        System.out.println("Batalha terminada");
        player.showBalance();

    }
}
