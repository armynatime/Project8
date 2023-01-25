package kg.geechtech.game.general;

import kg.geechtech.game.general.players.*;
import kg.geektech.game.general.players.Boss;

import java.util.Random;

public class RPG_Game {

    static int roundCounter = 0;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(700, 50);

        Warrior warrior = new Warrior(270, 25);
        Magic magic = new Magic(250, 25,7);
        Berserk berserk = new Berserk(230, 20);
        Medic doc = new Medic(230, 5, 15);
        Medic assistant = new Medic(290, 10, 5);

        Hero[] heroes = {warrior, magic, berserk, doc, assistant};

        printStatistic(boss, heroes);
        while (!isGameFinish(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        roundCounter++;
        bossHits(boss, heroes);
        heroesHits(boss, heroes);
        heroesApplyAbility(boss, heroes);
        printStatistic(boss, heroes);
    }

    private static void heroesApplyAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static void heroesHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            boss.setHealth(boss.getHealth() - heroes[i].getDamage());
        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
        }
    }

    private static boolean isGameFinish(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes Won!!!");
            return true;
        }
        boolean allHeroessDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroessDead = false;
                break;
            }
        }
        if (allHeroessDead) {
            System.out.println("Boss Won!!!");
        }
        return allHeroessDead;
    }

    private static void printStatistic(Boss boss, Hero[] heroes) {
        System.out.println("***********************************");
        System.out.println("ROUND " + roundCounter);
        System.out.println("Boss health: " + boss.getHealth() +
                " " + " Damage: [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " length: " + heroes[i].getHealth() +
                    " " + "Damage: [" + heroes[i].getDamage() + "]");
        }
        System.out.println();
    }
}
