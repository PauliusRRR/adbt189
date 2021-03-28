package milestone1;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;
/** Level 2 Setup */
public class Level2 extends GameLevel{

    public Level2(Game game) {

        super(game);

        getPlayer().setPosition(new Vec2(-3f, -10));
        getKey().setPosition(new Vec2(9f, 10f));


        getPlayer().addCollisionListener(new KeyMission(getPlayer()));

        //Ground Platforms with a colour fill
        Shape shape = new BoxShape(14, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-14f, -18.5f));
        StaticBody ground2 = new StaticBody(this, shape);
        ground2.setPosition(new Vec2(13f, -18.5f));
        //colour
        ground.setFillColor(Color.DARK_GRAY);
        ground2.setFillColor(Color.DARK_GRAY);

        //High Platforms with a colour Fill
        Shape platform1Shape = new BoxShape(3.5f, 0.3f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-18, 2f));
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(9, -6f));
        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(-2, -10.5f));
        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(18, -1f));
        StaticBody platform5 = new StaticBody(this, platform1Shape);
        platform5.setPosition(new Vec2(-4, -1f));


        //colour
        platform1.setFillColor(Color.DARK_GRAY);
        platform2.setFillColor(Color.DARK_GRAY);
        platform3.setFillColor(Color.DARK_GRAY);
        platform4.setFillColor(Color.DARK_GRAY);
        platform5.setFillColor(Color.DARK_GRAY);

    }
    @Override
    public boolean isComplete() {
        if (getPlayer().getKeyCount() == 0)
            return true;
        else
            return false;
    }




}
