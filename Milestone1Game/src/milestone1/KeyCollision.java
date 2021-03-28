package milestone1;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/** Adding a collision listener to the Key model and level completion */
public class KeyCollision implements CollisionListener {

    private GameLevel level;
    private Game game;

    public KeyCollision(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Key
                && level.isComplete()) {
            game.goToNextLevel();
        }
    }
}
