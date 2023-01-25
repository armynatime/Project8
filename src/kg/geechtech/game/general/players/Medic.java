package kg.geechtech.game.general.players;

import kg.geektech.game.general.players.Boss;

public class Medic extends Hero {

    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {
        for (int i = 0; i < hero.length; i++) {
            if (hero[i].getHealth() > 0 && hero[i].getHealth() < 100 && this != hero[i]) {
                hero[i].setHealth(hero[i].getHealth() + this.healPoints);
                System.out.println(this.getClass().getSimpleName() + " " + "health point " + this.healPoints + " "+
                        hero[i].getClass().getSimpleName());



            }

        }

    }
}
