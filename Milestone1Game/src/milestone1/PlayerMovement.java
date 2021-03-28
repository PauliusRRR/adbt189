package milestone1;

import city.cs.engine.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/** Player Movement Development */
public class PlayerMovement implements KeyListener {

    private static final float WALKING_SPEED = 5;

    private static final float JUMP_speed = 12;

    private Player player;

    public PlayerMovement(Player p)
    {
        player = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    //player movement assignment
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            player.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            player.startWalking(WALKING_SPEED);
        }
        if (code == KeyEvent.VK_SPACE) {
            player.jump(JUMP_speed);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            player.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            player.stopWalking();
        }

    }
    public void updatePlayer(Player player) {this.player = player;}
}