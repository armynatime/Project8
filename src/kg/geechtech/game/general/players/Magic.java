package kg.geechtech.game.general.players;

import kg.geechtech.game.general.RPG_Game;
import kg.geektech.game.general.players.Boss;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Magic extends Hero {
    private int num;

    public Magic(int health, int damage,int num) {
        super(health, damage, SuperAbility.MAGIC_POWER);
        this.num = num;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {
        for (int i = 0; i < hero.length; i++) {
            if (hero[i].getHealth() > 0 && this != hero[i]) {
                hero[i].setDamage(hero[i].getDamage() + num);
                System.out.println(this.getClass().getSimpleName() + " magic power " + this.num);
            }
        }
    }
}