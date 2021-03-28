package milestone1;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;
import java.awt.*;

/** Level 1 Setup */
public class Level1  extends GameLevel {

    public Level1(Game game) {

        super(game);

        getPlayer().setPosition(new Vec2(-3f, -10));
        getKey().setPosition(new Vec2(-19f, 8f));
        getPlayer().addCollisionListener(new KeyMission(getPlayer()));

        //Ground Platforms with a colour fill
        Shape shape = new BoxShape(14, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-14f, -18.5f));
        StaticBody ground2 = new StaticBody(this, shape);
        ground2.setPosition(new Vec2(13f, -18.5f));
        //colour
        ground.setFillColor(Color.CYAN);
        ground2.setFillColor(Color.CYAN);

        //High Platforms with a colour Fill
        Shape platform1Shape = new BoxShape(3.5f, 0.3f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-18, 2f));
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(9, -6f));
        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(-2, -1f));
        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(18, -10.5f));
        //colour
        platform1.setFillColor(Color.CYAN);
        platform2.setFillColor(Color.CYAN);
        platform3.setFillColor(Color.CYAN);
        platform4.setFillColor(Color.CYAN);



    }
    @Override
    public boolean isComplete() {
        if (getPlayer().getKeyCount() == 0)
            return true;
        else
            return false;
    }
}
