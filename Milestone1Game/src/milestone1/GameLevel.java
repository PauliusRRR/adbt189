package milestone1;

import city.cs.engine.World;
/** Game level class extension to world*/
public abstract class GameLevel extends World {
    private Player player;
    private Key key;

    //generating the player, key and collision listener
    public GameLevel(Game game) {

        player = new Player(this);
        key = new Key(this);
        KeyCollision collision = new KeyCollision(this, game);
        player.addCollisionListener(collision);
    }

    public Player getPlayer() {
        return player;
    }

    public Key getKey() {
        return key;
    }
    public abstract boolean isComplete();
}
