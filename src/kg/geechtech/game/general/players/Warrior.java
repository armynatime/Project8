package kg.geechtech.game.general.players;

import kg.geechtech.game.general.RPG_Game;
import kg.geektech.game.general.players.Boss;

import java.util.Random;

public class Warrior extends Hero {


    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {
        if (boss.getHealth() > 0) {

            int rand = RPG_Game.random.nextInt(4) + 2;
            boss.setHealth(boss.getHealth() - this.getDamage() * rand);
            System.out.println("Warrior critical damage hits boss "
                    + this.getDamage() * rand);
        }
    }
}
