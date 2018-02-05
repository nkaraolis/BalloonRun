package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.Color;

public class BalloonRunWorldL1 extends GameLevel {

    private SlidePlatform Slide1;
    private SlidePlatform Slide2;
    private SlideWall SlideWall1;
    private SlideWall SlideWall2;

    /**
     * Add the bodies to the world.
     * @param game 
     */
    @Override
    public void populate(BalloonRun game) {
        super.populate(game);

        {
            /**
             * Ground
             */
            Body ground1 = new Ground(this);
            ground1.setPosition(new Vec2(10, -11.5f));
            ground1.setFillColor(Color.BLACK);

            Body ground2 = new Ground(this);
            ground2.setPosition(new Vec2(90, -11.5f));
            ground2.setFillColor(Color.BLACK);
        }


        {
            /**
             * Safety walls
             */
            Body backwall = new Wall(this);
            backwall.setPosition(new Vec2(-19.5f, -4));
            backwall.setFillColor(Color.BLACK);

            Body endwall = new Wall(this);
            endwall.setPosition(new Vec2(119.5f, -4));
            endwall.setFillColor(Color.BLACK);
        }


        {
            /**
             * Static platforms
             */
            Body platform1 = new Platform(this);
            platform1.setPosition(new Vec2(20, -4));

            Body platform2 = new Platform(this);
            platform2.setPosition(new Vec2(35, -4));

            Body platform3 = new Platform(this);
            platform3.setPosition(new Vec2(45, 0));

            Body platform4 = new Platform(this);
            platform4.setPosition(new Vec2(65, -4));

            Body platform5 = new Platform(this);
            platform5.setPosition(new Vec2(75, -7));

            Body platform6 = new Platform(this);
            platform6.setPosition(new Vec2(90, 3));

            Body platform7 = new Platform(this);
            platform7.setPosition(new Vec2(104, 5));

            Body finalPlatform = new BoxPlatform(this);
            finalPlatform.setPosition(new Vec2(123f, 0));
        }


        {
            /**
             * Sliding walls
             */
            SlideWall1 = new SlideWall(this);
            SlideWall1.setPosition(new Vec2(27, 2));
            SlideWall1.setGravityScale(0);

            SlideWall2 = new SlideWall(this);
            SlideWall2.setPosition(new Vec2(97, 10));
            SlideWall2.setGravityScale(0);
        }


        {
            /**
             * Sliding platforms
             */
            Slide1 = new SlidePlatform(this);
            Slide1.setPosition(new Vec2(7, -7));
            Slide1.setGravityScale(0);

            Slide2 = new SlidePlatform(this);
            Slide2.setPosition(new Vec2(79, -1));
            Slide2.setGravityScale(0);
        }


        {
            /**
             * Bouncy platforms
             */
            StaticBody bouncyPlatform1 = new BouncyPlatform(this, 5f);
            bouncyPlatform1.setPosition(new Vec2(-3, -9));
            bouncyPlatform1.setFillColor(Color.RED);
        }


        {
            /**
             * Spike traps
             */
            for (int n = 0; n < 18; n++) {
                final Body spikeset1 = new Spike(this);
                spikeset1.setPosition(new Vec2(2 + n - 2, -10.5f));
                spikeset1.setFillColor(Color.GRAY);
                spikeset1.addCollisionListener(new SpikeCollision(getCharacter()));
            }

            for (int n = 0; n < 12; n++) {
                final Body spikeset2 = new Spike(this);
                spikeset2.setPosition(new Vec2(25 + n - 2, -10.5f));
                spikeset2.setFillColor(Color.GRAY);
                spikeset2.addCollisionListener(new SpikeCollision(getCharacter()));
            }

            for (int n = 0; n < 10; n++) {
                final Body spikeset3 = new Spike(this);
                spikeset3.setPosition(new Vec2(86 + n - 2, -10.5f));
                spikeset3.setFillColor(Color.GRAY);
                spikeset3.addCollisionListener(new SpikeCollision(getCharacter()));
            }

            for (int n = 0; n < 10; n++) {
                final Body spikeset4 = new Spike(this);
                spikeset4.setPosition(new Vec2(105 + n - 2, -10.5f));
                spikeset4.setFillColor(Color.GRAY);
                spikeset4.addCollisionListener(new SpikeCollision(getCharacter()));
            }

            for (int n = 0; n < 10; n++) {
                final Body spikeset5 = new Spike(this);
                spikeset5.setPosition(new Vec2(118.5f, -5f + n - 2));
                spikeset5.setFillColor(Color.GRAY);
                spikeset5.addCollisionListener(new SpikeCollision(getCharacter()));
                spikeset5.setAngleDegrees(90);
            }
        }


        {
            /**
             * One score coins
             */
            StaticBody onecoin1 = new OneCoin(this);
            onecoin1.setPosition(new Vec2(19.5f, -2.5f));
            onecoin1.addCollisionListener(new PickupOneScore(getCharacter()));
        }


        {
            /**
             * Five score coins
             */
            StaticBody fivecoin1 = new FiveCoin(this);
            fivecoin1.setPosition(new Vec2(3.5f, -3.7f));
            fivecoin1.addCollisionListener(new PickupFiveScore(getCharacter()));

            StaticBody fivecoin2 = new FiveCoin(this);
            fivecoin2.setPosition(new Vec2(118, -9.5f));
            fivecoin2.addCollisionListener(new PickupFiveScore(getCharacter()));
        }


        {
            /**
             * Health bonuses
             */
            Body healthup1 = new HealthUp(this);
            healthup1.setPosition(new Vec2(-18, -9));
            healthup1.addCollisionListener(new PickUpHealth(getCharacter()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-8, -9);
    }

    @Override
    public Vec2 checkpointPosition() {
        return new Vec2(123, 1.5f);
    }

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
}
