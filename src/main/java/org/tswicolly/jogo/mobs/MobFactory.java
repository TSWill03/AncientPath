package org.tswicolly.jogo.mobs;

import org.tswicolly.jogo.mobs.mobBase.MobBaseClass;
import org.tswicolly.jogo.mobs.normal.goblin.Goblin;

public class MobFactory {
    public static MobBaseClass createMob(String name) {
        name = name.replace(" ", "");
        name = name.toLowerCase();
        switch (name) {
            case "goblin":
                return new Goblin();
        }
        return null;
    }
}
