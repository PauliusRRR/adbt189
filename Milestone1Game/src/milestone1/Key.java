package milestone1;

import city.cs.engine.*;
/** Creating a dynamic body key model and giving it texture */
public class Key extends DynamicBody {
    //Set up shape of the key body
    private static final Shape keyShape = new PolygonShape(
            -1.72f,-1.59f, 0.35f,2.09f, 1.47f,1.83f, 1.57f,0.53f, -0.5f,-2.14f);
    //Set up image for the key body
    private static final BodyImage image =
            new BodyImage("resources/entity/Key.png", 5f);

    //adding the image on the key body
    public Key(World world) {
        super(world, keyShape);
        addImage(image);
    }
}