package org.tswicolly.jogo.mobs.normal.goblin;

import org.tswicolly.jogo.itens.tipos.ItemBase;
import org.tswicolly.jogo.mobs.mobBase.MobBaseClass;

public class Goblin extends MobBaseClass {
    ItemBase drop = new ItemBase("GoblinDagger", 3) {
        @Override
        public double getWeight() {
            return 1;
        }
    };
    public Goblin() {
        super("Goblin", 100, 10, 5, 1, 1010, 10,1, new GoblinDagger());
    }

}
