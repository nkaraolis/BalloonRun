package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {

    private Character jango;
    /**
     * Below are level 1 variables
     */
    private SlidePlatform Slide1;
    private SlidePlatform Slide2;
    private SlideWall SlideWall1;
    private SlideWall SlideWall2;
    /**
     * Below are level 2 variables
     */
    private SlidePlatformL2 Slide1L2;
    private SlidePlatformL2 Slide2L2;
    private SlideWallL2 SlideWall1L2;
    private SlideWallL2 SlideWall2L2;
    /**
     * Below are level 3 variables
     */
    private Boulder boulder1;
    private SlidePlatformL3 Slide1L3;
    private SlidePlatformL3 Slide2L3;
    private Crusher base1;
    private Crusher base2;
    private Crusher base3;
    private Crusher base4;
    private Crusher base5;
    private Crusher base6;
    private Boulder boulder2;

    /**
     * Returns the main character. Used in TrackerL1, TrackerL2 and TrackerL3.
     *
     * @return
     */
    public Character getCharacter() {
        return jango;
    }

    /**
     * Returns a dynamic body. Used in TrackerL1, TrackerL2 and TrackerL3.
     *
     * @return
     */
    public Body getActor() {
        return jango;
    }

    /**
     * Populate the world of this level. Additional level classes should use
     * this method to add different bodies.
     */
    public void populate(BalloonRun game) {
        jango = new Character(this);
        jango.setPosition(startPosition());
        Checkpoint checkpoint = new Checkpoint(this);
        checkpoint.setPosition(checkpointPosition());
        checkpoint.addCollisionListener(new FinishLevel(game));
    }

    /**
     * The starting position of the player.
     */
    public abstract Vec2 startPosition();

    /**
     * The position of the final checkpoint.
     */
    public abstract Vec2 checkpointPosition();

    /**
     * Below are level 1 return statements
     */
    /**
     * Returns Sliding platform 1. Used for StepListener (ObstacleTrackerL1)
     *
     * @return
     */
    public SlidePlatform getSlide1() {
        return Slide1;
    }

    /**
     * Returns Sliding platform 2. Used for StepListener (ObstacleTrackerL1)
     *
     * @return
     */
    public SlidePlatform getSlide2() {
        return Slide2;
    }

    /**
     * Returns Sliding wall 1. Used for StepListener (ObstacleTrackerL1)
     *
     * @return
     */
    public SlideWall getSlideWall1() {
        return SlideWall1;
    }

    /**
     * Returns Sliding wall 1. Used for StepListener (ObstacleTrackerL1)
     *
     * @return
     */
    public SlideWall getSlideWall2() {
        return SlideWall2;
    }

    /**
     * Below are level 2 return statements
     */
    /**
     * Returns Sliding platform 1. Used for StepListener (ObstacleTrackerL2)
     *
     * @return
     */
    public SlidePlatformL2 getSlide1L2() {
        return Slide1L2;
    }

    /**
     * Returns Sliding platform 2. Used for StepListener (ObstacleTrackerL2)
     *
     * @return
     */
    public SlidePlatformL2 getSlide2L2() {
        return Slide2L2;
    }

    /**
     * Returns Sliding wall 1. Used for StepListener (ObstacleTrackerL2)
     *
     * @return
     */
    public SlideWallL2 getSlideWall1L2() {
        return SlideWall1L2;
    }

    /**
     * Returns Sliding wall 2. Used for StepListener (ObstacleTrackerL2)
     *
     * @return
     */
    public SlideWallL2 getSlideWall2L2() {
        return SlideWall2L2;
    }

    /**
     * Below are level 3 return statements
     */
    /**
     * Returns Sliding platform 1. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public SlidePlatformL3 getSlide1L3() {
        return Slide1L3;
    }

    /**
     * Returns boulder 1. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public Boulder getBoulder1() {
        return boulder1;
    }

    /**
     * Returns sliding platform 2. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public SlidePlatformL3 getSlide2L3() {
        return Slide2L3;
    }

    /**
     * Returns crusher base 1. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public Crusher getCrushBase1() {
        return base1;
    }

    /**
     * Returns crusher base 2. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public Crusher getCrushBase2() {
        return base2;
    }

    /**
     * Returns crusher base 3. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public Crusher getCrushBase3() {
        return base3;
    }

    /**
     * Returns crusher base 4. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public Crusher getCrushBase4() {
        return base4;
    }

    /**
     * Returns crusher base 5. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public Crusher getCrushBase5() {
        return base5;
    }

    /**
     * Returns crusher base 6. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public Crusher getCrushBase6() {
        return base6;
    }

    /**
     * Returns boulder 2. Used for StepListener (ObstacleTrackerL3)
     *
     * @return
     */
    public Boulder getBoulder2() {
        return boulder2;
    }
}
