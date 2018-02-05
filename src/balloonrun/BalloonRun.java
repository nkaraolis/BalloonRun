package balloonrun;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class BalloonRun {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;
    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyViewL1 view;
    private final JFrame frame;
    private Controller controller;
    private Box linebox;
    /**
     * Level 1 tracker variables
     */
    private TrackerL1 trackerL1;
    private ObstacleTrackerL1 OTrackerL1;
    private Body L1B;
    private SlidePlatform L1SP1;
    private SlidePlatform L1SP2;
    private SlideWall L1SW1;
    private SlideWall L1SW2;
    private Character L1C;
    /**
     * Level 2 tracker variables
     */
    private TrackerL2 trackerL2;
    private ObstacleTrackerL2 OTrackerL2;
    private Body L2B;
    private SlidePlatformL2 L2SP1;
    private SlidePlatformL2 L2SP2;
    private SlideWallL2 L2SW1;
    private SlideWallL2 L2SW2;
    private Character L2C;
    /**
     * Level 3 Tracker variables
     */
    private TrackerL3 trackerL3;
    private ObstacleTrackerL3 OTrackerL3;
    private Body L3B;
    private Boulder L3B1;
    private SlidePlatformL3 L3SP1;
    private SlidePlatformL3 L3SP2;
    private CrushSpike L3S1;
    private Crusher L3CB1;
    private Crusher L3CB2;
    private Crusher L3CB3;
    private Crusher L3CB4;
    private Crusher L3CB5;
    private Crusher L3CB6;
    private Boulder L3B2;
    private Character L3C;
    /**
     * Level change variables
     */
    private int level = 1;
    private int levelScore;
    
    /**
     * Music class variable for playing music
     */
    private Audio music;
    

    public BalloonRun() {

        world = new BalloonRunWorldL1();
        world.populate(this);
        Character jango = world.getCharacter();

        view = new MyViewL1(this, world, 750, 500);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);
        //view.addMouseListener(new BombDropTest(view));

        // display the view in a frame
        frame = new JFrame("Balloon Run");
        
        int width = 750;
        int height = 500;
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - width)/2;
        int y = (dim.height - height)/2;
        
        frame.setBounds(x, y, width, height);
        
        frame.isAlwaysOnTop();
        
        linebox = new Box(BoxLayout.LINE_AXIS);
        frame.add(linebox, BorderLayout.NORTH);
        linebox.setSize(10, 500);

        
        ScoreLabel scoreLabel = new ScoreLabel(jango);
        linebox.add(scoreLabel);
        
        HealthLabel healthLabel = new HealthLabel(jango);
        linebox.add(healthLabel);
        jango.addChangeListener(scoreLabel);
        jango.addChangeListener(healthLabel);
       
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        
     //   frame.add(new ControlPanel(), BorderLayout.SOUTH);

        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        
        frame.requestFocus();
        
        //view.addMouseListener(new GiveFocus(frame));

        
        controller = new Controller(world.getCharacter(), view);
        frame.addKeyListener(controller);
        
     
        
        /**
         * Level 1 tracker variables
         * 
         */
        L1B = world.getActor();
        L1SP1 = world.getSlide1();
        L1SP2 = world.getSlide2();
        L1SW1 = world.getSlideWall1();
        L1SW2 = world.getSlideWall2();
        L1C = world.getCharacter();

        /**
         * Tracker for level 1
         */
        trackerL1 = new TrackerL1(view, L1B, L1C);
        OTrackerL1 = new ObstacleTrackerL1(L1SP1, L1SP2, L1SW1, L1SW2);

        world.addStepListener(trackerL1);
        world.addStepListener(OTrackerL1);

        



        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 750, 750);
    
        music = new Audio();
        music.music();

        // start!
        world.start();
    }

    public Character getActor() {
        return world.getCharacter();
    }
    
    public int getLevel() {
        return level;
    }

    public void goNextLevel() {
        world.setPaused(true);
        level++;


        if (level == 2) {
            levelScore = world.getCharacter().GetCount();
            world.removeStepListener(trackerL1);
            world.removeStepListener(OTrackerL1);
            frame.remove(linebox);

            // get a new world
            world = new BalloonRunWorldL2();

            // fill it with bodies
            world.populate(this);
            Character jango = world.getCharacter();

            System.out.println("Next level");
            //           System.out.println(jango.GetHealth());

            L2B = world.getActor();
            L2SP1 = world.getSlide1L2();
            L2SP2 = world.getSlide2L2();
            L2SW1 = world.getSlideWall1L2();
            L2SW2 = world.getSlideWall2L2();
            L2C = world.getCharacter();
            trackerL2 = new TrackerL2(view, L2B, L2C);
            OTrackerL2 = new ObstacleTrackerL2(L2SP1, L2SP2, L2SW1, L2SW2);
            world.addStepListener(trackerL2);
            world.addStepListener(OTrackerL2);

            // switch the keyboard control to the new actor
            controller.setBody(world.getCharacter());

            // show the new world in the view
            view.setWorld(world);

            linebox = new Box(BoxLayout.LINE_AXIS);
            frame.add(linebox, BorderLayout.NORTH);
            linebox.setSize(10, 500);

            jango.setCount(levelScore);
            jango.setHealth();

            ScoreLabel scoreLabel = new ScoreLabel(jango);
            scoreLabel.setText("Score: " + levelScore);
            linebox.add(scoreLabel);

            HealthLabel healthLabel = new HealthLabel(jango);
            healthLabel.setText("Health: " + jango.GetHealth());
            linebox.add(healthLabel);
            jango.addChangeListener(scoreLabel);
            jango.addChangeListener(healthLabel);

            world.start();

        } else if (level == 3) {
            levelScore = world.getCharacter().GetCount();
            world.removeStepListener(trackerL2);
            frame.remove(linebox);


            // get a new world
            world = new BalloonRunWorldL3();

            // fill it with bodies
            world.populate(this);
            Character jango = world.getCharacter();


            System.out.println("Next level");
            /**
             * Level 3 tracker variables
             */
            L3B = world.getActor();
            L3B1 = world.getBoulder1();
            L3SP1 = world.getSlide1L3();
            L3SP2 = world.getSlide2L3();
            L3CB1 = world.getCrushBase1();
            L3CB2 = world.getCrushBase2();
            L3CB3 = world.getCrushBase3();
            L3CB4 = world.getCrushBase4();
            L3CB5 = world.getCrushBase5();
            L3CB6 = world.getCrushBase6();
            L3B2 = world.getBoulder2();
            L3C = world.getCharacter();

            trackerL3 = new TrackerL3(view, L3B, L3C);
            OTrackerL3 = new ObstacleTrackerL3(L3B1, L3SP1, L3SP2, L3CB1, L3CB2, L3CB3, L3CB4, L3CB5, L3CB6, L3B2);
            world.addStepListener(trackerL3);
            world.addStepListener(OTrackerL3);



            // switch the keyboard control to the new actor
            controller.setBody(world.getCharacter());

            // show the new world in the view
            view.setWorld(world);

            linebox = new Box(BoxLayout.LINE_AXIS);
            frame.add(linebox, BorderLayout.NORTH);
            linebox.setSize(10, 500);

            jango.setCount(levelScore);
            jango.setHealth();

            ScoreLabel scoreLabel = new ScoreLabel(jango);
            scoreLabel.setText("Score: " + levelScore);
            linebox.add(scoreLabel);

            HealthLabel healthLabel = new HealthLabel(jango);
            healthLabel.setText("Health: " + jango.GetHealth());
            linebox.add(healthLabel);
            jango.addChangeListener(scoreLabel);
            jango.addChangeListener(healthLabel);

            world.start();


        } else if (level == 4) {
            System.exit(0);
        }
    }
/**
 * Main method to start the game and the splash screen
 * @param args
 * @throws InterruptedException 
 */
    public static void main(String[] args) throws InterruptedException {
        for (int i =0; i<=4; i++) {
            Thread.sleep(1000);
        }
        new BalloonRun();
    }
}