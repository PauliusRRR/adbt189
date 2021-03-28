package milestone1;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
/** Creation of the User view and background */
public class GameView extends UserView {
    private Image background;
    public GameView(World w, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("resources/background/BG.png").getImage();
    }
    //background application for resolution
    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, -100, -120, this);
    }




}