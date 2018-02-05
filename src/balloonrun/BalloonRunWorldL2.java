package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.Color;

public class BalloonRunWorldL2 extends GameLevel {

    private SlidePlatformL2 Slide1L2;
    private SlidePlatformL2 Slide2L2;
    private SlideWallL2 SlideWall1L2;
    private SlideWallL2 SlideWall2L2;

    /**
     * Add the bodies to the world.
     * @param game 
     */
    @Override
    public void populate(BalloonRun game) {
        super.populate(game);

        {
            /**
             * Safety walls
             */
            Body backwall = new Wall(this);
            backwall.setPosition(new Vec2(-19.5f, -4));
            backwall.setFillColor(Color.BLACK);
        }


        {
            /**
             * Static platforms
             */
            Body platform1 = new BoxPlatform(this);
            platform1.setPosition(new Vec2(-17, -11.5f));

            Body platform2 = new FrictionPlatform(this);
            platform2.setPosition(new Vec2(-5, -11.5f));
            platform2.setFillColor(Color.CYAN);

            Body platform3 = new FrictionPlatform(this);
            platform3.setPosition(new Vec2(5, -8));
            platform3.setFillColor(Color.CYAN);

            Body platform4 = new BoxPlatform(this);
            platform4.setPosition(new Vec2(35, -5));

            Body platform5 = new FrictionPlatform(this);
            platform5.setPosition(new Vec2(25, 0));
            platform5.setFillColor(Color.CYAN);

            Body platform6 = new FrictionPlatform(this);
            platform6.setPosition(new Vec2(18, 4));
            platform6.setFillColor(Color.CYAN);

            Body platform7 = new BoxPlatform(this);
            platform7.setPosition(new Vec2(10, 7));

            Body platform8 = new BoxPlatform(this);
            platform8.setPosition(new Vec2(0, 7));

            Body platform9 = new FrictionPlatform(this);
            platform9.setPosition(new Vec2(48, -5));
            platform9.setFillColor(Color.CYAN);

            Body platform10 = new BoxPlatform(this);
            platform10.setPosition(new Vec2(54, -5));

            Body platform11 = new BoxPlatform(this);
            platform11.setPosition(new Vec2(64, -5));

            Body platform12 = new FrictionPlatform(this);
            platform12.setPosition(new Vec2(74, -2));
            platform12.setFillColor(Color.CYAN);

            Body platform13 = new BoxPlatform(this);
            platform13.setPosition(new Vec2(105, 2));

            Body platform14 = new FrictionPlatform(this);
            platform14.setPosition(new Vec2(121, 3));
            platform14.setFillColor(Color.CYAN);

            Body platform15 = new BoxPlatform(this);
            platform15.setPosition(new Vec2(133, 7));

            Body platform16 = new FrictionPlatform(this);
            platform16.setPosition(new Vec2(142, 10));
            platform16.setFillColor(Color.CYAN);

            Body platform17 = new BoxPlatform(this);
            platform17.setPosition(new Vec2(149, 12));

            Body platform18 = new FrictionPlatform(this);
            platform18.setPosition(new Vec2(156, 14));
            platform18.setFillColor(Color.CYAN);

            Body platform19 = new FrictionPlatform(this);
            platform19.setPosition(new Vec2(140.5f, 18));
            platform19.setFillColor(Color.CYAN);

            Body platform20 = new BoxPlatform(this);
            platform20.setPosition(new Vec2(13, -14));

            Body platform21 = new BoxPlatform(this);
            platform21.setPosition(new Vec2(-16, 10));

            Body finalPlatform = new BoxPlatform(this);
            finalPlatform.setPosition(new Vec2(131f, 22));
        }


        {
            /**
             * Sliding walls
             */
            SlideWall1L2 = new SlideWallL2(this);
            SlideWall1L2.setPosition(new Vec2(40, 4));
            SlideWall1L2.setGravityScale(0);

            SlideWall2L2 = new SlideWallL2(this);
            SlideWall2L2.setPosition(new Vec2(112, 9));
            SlideWall2L2.setGravityScale(0);
        }


        {
            /**
             * Sliding platforms
             */
            Slide1L2 = new SlidePlatformL2(this);
            Slide1L2.setPosition(new Vec2(21, -7));
            Slide1L2.setGravityScale(0);

            Slide2L2 = new SlidePlatformL2(this);
            Slide2L2.setPosition(new Vec2(85.5f, 2));
            Slide2L2.setGravityScale(0);
        }


        {
            /**
             * Spike traps
             */
            for (int n = 0; n < 3; n++) {
                final Body spikeset1 = new Spike(this);
                spikeset1.setPosition(new Vec2(10 + n - 2, 8f));
                spikeset1.setFillColor(Color.LIGHT_GRAY);
                spikeset1.addCollisionListener(new SpikeCollisionL2(getCharacter()));
            }

            for (int n = 0; n < 5; n++) {
                final Body spikeset2 = new Spike(this);
                spikeset2.setPosition(new Vec2(54 + n - 2, -4f));
                spikeset2.setFillColor(Color.LIGHT_GRAY);
                spikeset2.addCollisionListener(new SpikeCollisionL2(getCharacter()));
            }

            for (int n = 0; n < 5; n++) {
                final Body spikeset3 = new Spike(this);
                spikeset3.setPosition(new Vec2(149 + n - 2, 13));
                spikeset3.setFillColor(Color.LIGHT_GRAY);
                spikeset3.addCollisionListener(new SpikeCollisionL2(getCharacter()));
            }

            for (int n = 0; n < 5; n++) {
                final Body spikeset4 = new Spike(this);
                spikeset4.setPosition(new Vec2(25 + n - 2, -1));
                spikeset4.setFillColor(Color.LIGHT_GRAY);
                spikeset4.addCollisionListener(new SpikeCollisionL2(getCharacter()));
                spikeset4.setAngleDegrees(180);
            }

            for (int n = 0; n < 5; n++) {
                final Body spikeset5 = new Spike(this);
                spikeset5.setPosition(new Vec2(13 + n - 2, -13));
                spikeset5.setFillColor(Color.LIGHT_GRAY);
                spikeset5.addCollisionListener(new SpikeCollisionL2(getCharacter()));
            }
        }


        {
            /**
             * One score coins
             */
            StaticBody onecoin1 = new OneCoin(this);
            onecoin1.setPosition(new Vec2(64f, -3f));
            onecoin1.addCollisionListener(new PickupOneScore(getCharacter()));

            StaticBody onecoin2 = new OneCoin(this);
            onecoin2.setPosition(new Vec2(133f, 9f));
            onecoin2.addCollisionListener(new PickupOneScore(getCharacter()));
        }


        {
            /**
             * Five score coins
             */
            StaticBody fivecoin1 = new FiveCoin(this);
            fivecoin1.setPosition(new Vec2(35f, -3f));
            fivecoin1.addCollisionListener(new PickupFiveScore(getCharacter()));

            StaticBody fivecoin2 = new FiveCoin(this);
            fivecoin2.setPosition(new Vec2(0, 9f));
            fivecoin2.addCollisionListener(new PickupFiveScore(getCharacter()));
        }


        {
            /**
             * Health bonuses
             */
            Body healthup1 = new HealthUp(this);
            healthup1.setPosition(new Vec2(-16, 11));
            healthup1.addCollisionListener(new PickUpHealth(getCharacter()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-18, -9);
    }

    @Override
    public Vec2 checkpointPosition() {
        return new Vec2(131, 23.5f);
    }

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
}
