package kg.geechtech.game.general.players;

import kg.geektech.game.general.players.GameEntity;

import java.util.PrimitiveIterator;

public abstract class Hero extends GameEntity implements HavingSuperAbility{

    private SuperAbility superAbility;

    public Hero(int health, int damage, SuperAbility superAbility) {
        super(health, damage);
        this.superAbility = superAbility;

    }

}
