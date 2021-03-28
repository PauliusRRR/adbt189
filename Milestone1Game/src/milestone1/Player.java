package milestone1;

import city.cs.engine.*;
/** Initialising Player to a Polygon shape, adding textures to the player model */
public class Player extends Walker {
        private static final Shape playerShape = new PolygonShape(
                -1.98f,-1.93f,
                -2.38f,0.4f,
                -2.18f,1.38f,
                -0.31f,1.38f,
                -0.27f,0.1f,
                -0.79f,-1.92f);


        private static final BodyImage image =
                new BodyImage("resources/player/Idle.png", 4f);

        private int KeyCount;

    public Player(World world) {
        super(world, playerShape);
        addImage(image);

        KeyCount = 0;
    }

    public void OneKey(){
        KeyCount++;
        System.out.println(KeyCount + " Key will do just fine!");

    }

    public int getKeyCount() {
        return KeyCount;
    }


}
