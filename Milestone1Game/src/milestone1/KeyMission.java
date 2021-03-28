package milestone1;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
    /** Adding a key mission - once another body touches the key it gets destroyed and counted */
public class KeyMission implements CollisionListener {
    //Initialising player and key mission
    private Player player;
    public KeyMission(Player p) {this.player = p;}
    //Once the player collides with the key it gets destroyed and counted as 1
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Key) {
            player.OneKey();
            e.getOtherBody().destroy();
        }
    }
}
