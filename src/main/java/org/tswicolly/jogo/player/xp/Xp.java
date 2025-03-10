package org.tswicolly.jogo.player.xp;

public class Xp {
    private int xp = 0;
    private int levelsGained = 0;
    private int xpToNextLevelMultiplier = 2;
    private int xpToLevelUp = 100; // xp necessário para o próximo nível

    /**
     * Adiciona pontos de experiência e retorna quantos níveis foram ganhos.
     *
     * @param xpEarned                pontos de experiência ganhos.ltiplicador para o xp necessário para o próximo nível.
     * @param currentLevel            nível atual do jogador.
     * @return número de níveis ganhos.
     */
    public int addXp(int xpEarned, int currentLevel) {
        this.xp += xpEarned;
        int gainedLevels = 0;
        while (this.xp >= xpToLevelUp) {
            this.xp -= xpToLevelUp;
            gainedLevels++;
            // Atualiza o xp necessário para o próximo nível.
            xpToLevelUp *= (currentLevel * xpToNextLevelMultiplier);
            currentLevel++; // Atualiza o nível para refletir a nova necessidade, se aplicável.
        }
        levelsGained += gainedLevels;
        return gainedLevels;
    }

    public int getXp() {
        return xp;
    }

    public int getXpToLevelUp() {
        return xpToLevelUp;
    }

    public int getLevelsGained() {
        return levelsGained;
    }
}
