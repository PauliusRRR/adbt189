package milestone1;

import city.cs.engine.SoundClip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.io.IOException;

/** The Game class */
public class Game {

    /** Initialising the world itself along with all the attributes */
    private GameLevel level;

    /** Initialising the game view of the world */
    private GameView view;

    /** Initialising Player movement */
    private PlayerMovement movement;

    /** Initialising SoundClip for audio */
    private SoundClip gameMusic;

    /** Initialising the game */
    public Game() {
        //level is initialised to level1
        level = new Level1(this);
        //Resolution for window
        view = new GameView(level, 800, 600);
        view.setZoom(16);
        //importing user's movement
        movement = new PlayerMovement(level.getPlayer());
        view.addKeyListener(movement);
        //Mouse cursor has to be on the application for the in-game movement to work
        view.addMouseListener(new GiveFocus(view));

        //Creates the view
        final JFrame frame = new JFrame("test");
        frame.add(view);
        //Application will close if user exits via pressing X (top right)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        //No resizable frame window allowed
        frame.setResizable(false);
        frame.pack();
        //Visibility set to True, makes the frame visible
        frame.setVisible(true);
        //SoundClip setup for different music each level
        try {
            gameMusic = new SoundClip("resources/music/quick.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        //start the simulation in the new level
        level.start();
    }

    public void goToNextLevel() {

        if (level instanceof Level1) {
            //stop the current level
            level.stop();
            //stop current level music
            gameMusic.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            //Specific zoom set to fit the screen
            view.setZoom(16);
            //change the controller to control the
            //student in the new world
            movement.updatePlayer(level.getPlayer());
            //SoundClip setup for different music each level
            try {
                gameMusic = new SoundClip("resources/music/quick2.wav");   // Open an audio input stream
                gameMusic.loop();  // Music set to a loop until level is completed

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            //start the simulation in the new level
            level.start();

        } else if (level instanceof Level2) {
            //stop the current level
            level.stop();
            //stop current level music
            gameMusic.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            //change the view to look into new level
            view.setWorld(level);
            //Specific zoom set to fit the screen
            view.setZoom(16);
            //change the controller to control the
            //student in the new world
            movement.updatePlayer(level.getPlayer());
            //SoundClip setup for different music each level
            try {
                gameMusic = new SoundClip("resources/music/quick3.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            //start the simulation in the new level
            level.start();

        } else if (level instanceof Level3) {
            System.out.println("FIN");
            System.exit(0);

        }
    }

        public static void main(String[] args) {

            new Game();

        }
    }
