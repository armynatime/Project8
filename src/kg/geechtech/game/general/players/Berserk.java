package kg.geechtech.game.general.players;

import kg.geektech.game.general.players.Boss;

public class Berserk extends Hero {


    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {
        for (int i = 0; i < hero.length; i++) {
            if (boss.getHealth() > 0 && this == hero[i]) {
                hero[i].setHealth(hero[i].getDamage() / 2 + (boss.getDamage() - 5));
                System.out.println(this.getClass().getSimpleName() + "Use revert [" + hero[i].getDamage() + "]");
            }
        }


    }
}
