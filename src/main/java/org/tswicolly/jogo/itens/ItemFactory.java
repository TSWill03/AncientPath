package org.tswicolly.jogo.itens;

import org.tswicolly.jogo.itens.tipos.ItemBase;
import org.tswicolly.jogo.itens.tipos.mobs.GoblinDagger;
import org.tswicolly.jogo.itens.tipos.weapons.sword.BasicSword;

public class ItemFactory {
    public static ItemBase createItem(String name) {
        name = name.replace(" ", "");
        name = name.toLowerCase();
        switch (name) {
            case "basicsword":
                return new BasicSword();
            case "goblindagger":
                return new GoblinDagger();
            case "hand":
                return new NoWeapon();
            default:
                return null;
        }

    }
}
