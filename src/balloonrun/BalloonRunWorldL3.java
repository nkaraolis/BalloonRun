package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.Color;

public class BalloonRunWorldL3 extends GameLevel {

    private SlidePlatformL3 Slide1L3;
    private SlidePlatformL3 Slide2L3;
    private Boulder boulder1;
    private Crusher base1;
    private Crusher base2;
    private Crusher base3;
    private Crusher base4;
    private Crusher base5;
    private Crusher base6;
    private Boulder boulder2;

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
            ground2.setPosition(new Vec2(105, -11.5f));
            ground2.setFillColor(Color.BLACK);

            Body ground3 = new Ground(this);
            ground3.setPosition(new Vec2(196, 9));
            ground3.setFillColor(Color.BLACK);
        }


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
            platform1.setPosition(new Vec2(5, -8f));
            platform1.setAngleDegrees(90);

            Body platform2 = new BoxPlatform(this);
            platform2.setPosition(new Vec2(1.5f, -6f));

            Body platform3 = new PlatformL3(this);
            platform3.setPosition(new Vec2(40, -3));

            Body platform4 = new PlatformL3(this);
            platform4.setPosition(new Vec2(51, 2));

            Body platform5 = new BoxPlatform(this);
            platform5.setPosition(new Vec2(64, 5));

            Body platform6 = new PlatformL3(this);
            platform6.setPosition(new Vec2(72, -2));

            Body platform7 = new BoxPlatform(this);
            platform7.setPosition(new Vec2(88, -3.5f));

            Body platform8 = new BoxPlatform(this);
            platform8.setPosition(new Vec2(94, -3.5f));

            Body platform9 = new BoxPlatform(this);
            platform9.setPosition(new Vec2(100, -3.5f));

            Body platform10 = new BoxPlatform(this);
            platform10.setPosition(new Vec2(106, -3.5f));

            Body platform11 = new BoxPlatform(this);
            platform11.setPosition(new Vec2(112, -3.5f));

            Body platform12 = new PlatformL3(this);
            platform12.setPosition(new Vec2(127, -6));

            Body platform13 = new FrictionPlatform(this);
            platform13.setPosition(new Vec2(118, -1));
            platform13.setFillColor(Color.CYAN);

            Body platform14 = new FrictionPlatform(this);
            platform14.setPosition(new Vec2(110, 5));
            platform14.setFillColor(Color.CYAN);

            Body platform15 = new FrictionPlatform(this);
            platform15.setPosition(new Vec2(127, 9));
            platform15.setFillColor(Color.CYAN);

            Body platform16 = new FrictionPlatform(this);
            platform16.setPosition(new Vec2(139, 9));
            platform16.setFillColor(Color.CYAN);

            Body platform17 = new FrictionPlatform(this);
            platform17.setPosition(new Vec2(145, 9));
            platform17.setFillColor(Color.CYAN);

            Body platform18 = new FrictionPlatform(this);
            platform18.setPosition(new Vec2(151, 9));
            platform18.setFillColor(Color.CYAN);

            Body platform19 = new FrictionPlatform(this);
            platform19.setPosition(new Vec2(157, 9));
            platform19.setFillColor(Color.CYAN);

            Body platform20 = new BoxPlatform(this);
            platform20.setPosition(new Vec2(139, 17));

            Body platform21 = new BoxPlatform(this);
            platform21.setPosition(new Vec2(145, 17));

            Body platform22 = new BoxPlatform(this);
            platform22.setPosition(new Vec2(151, 17));

            Body platform23 = new BoxPlatform(this);
            platform23.setPosition(new Vec2(157, 17));

            Body platform24 = new BoxPlatform(this);
            platform24.setPosition(new Vec2(163, 17));

            Body platform25 = new FrictionPlatform(this);
            platform25.setPosition(new Vec2(163, 9));
            platform25.setFillColor(Color.CYAN);

            Body platform26 = new FrictionPlatform(this);
            platform26.setPosition(new Vec2(133, 9));
            platform26.setFillColor(Color.CYAN);

            Body platform27 = new BoxPlatform(this);
            platform27.setPosition(new Vec2(190, 14));

            Body platform28 = new BoxPlatform(this);
            platform28.setPosition(new Vec2(193.5f, 11.5f));
            platform28.setAngleDegrees(90);

            Body platform29 = new PlatformL3(this);
            platform29.setPosition(new Vec2(205, 18));

            Body platform30 = new FrictionPlatform(this);
            platform30.setPosition(new Vec2(221, 22));
            platform30.setFillColor(Color.cyan);

            Body platform31 = new FrictionPlatform(this);
            platform31.setPosition(new Vec2(205, 27));
            platform31.setFillColor(Color.cyan);

            Body platform32 = new BoxPlatform(this);
            platform32.setPosition(new Vec2(221, 30));
        }


        {
            /**
             * Boulders
             */
            boulder1 = new Boulder(this);
            boulder1.setPosition(new Vec2(3, -9));
            boulder1.setGravityScale(100);
            boulder1.addCollisionListener(new BoulderCollision(getCharacter()));

            boulder2 = new Boulder(this);
            boulder2.setPosition(new Vec2(190, 11));
            boulder2.setGravityScale(100);
            boulder2.addCollisionListener(new BoulderCollision(getCharacter()));
        }


        {
            /**
             * Sliding platforms
             */
            Slide1L3 = new SlidePlatformL3(this);
            Slide1L3.setPosition(new Vec2(15, -2));
            Slide1L3.setGravityScale(0);

            Slide2L3 = new SlidePlatformL3(this);
            Slide2L3.setPosition(new Vec2(51f, -7));
            Slide2L3.setGravityScale(0);
        }


        {
            /**
             * Spike traps
             */
            for (int n = 0; n < 26; n++) {
                final Body spikeset1 = new Spike(this);
                spikeset1.setPosition(new Vec2(12 + n - 2, -10.5f));
                spikeset1.setFillColor(Color.LIGHT_GRAY);
                spikeset1.addCollisionListener(new SpikeCollisionL2(getCharacter()));
            }

            for (int n = 0; n < 5; n++) {
                final Body spikeset2 = new Spike(this);
                spikeset2.setPosition(new Vec2(88 + n - 2, -2.5f));
                spikeset2.setFillColor(Color.LIGHT_GRAY);
                spikeset2.addCollisionListener(new SpikeCollision(getCharacter()));
            }

            for (int n = 0; n < 5; n++) {
                final Body spikeset3 = new Spike(this);
                spikeset3.setPosition(new Vec2(94 + n - 2, -2.5f));
                spikeset3.setFillColor(Color.LIGHT_GRAY);
                spikeset3.addCollisionListener(new SpikeCollisionL3(getCharacter()));
            }

            for (int n = 0; n < 5; n++) {
                final Body spikeset4 = new Spike(this);
                spikeset4.setPosition(new Vec2(100 + n - 2, -2.5f));
                spikeset4.setFillColor(Color.LIGHT_GRAY);
                spikeset4.addCollisionListener(new SpikeCollisionL3(getCharacter()));
            }

            for (int n = 0; n < 5; n++) {
                final Body spikeset5 = new Spike(this);
                spikeset5.setPosition(new Vec2(106 + n - 2, -2.5f));
                spikeset5.setFillColor(Color.LIGHT_GRAY);
                spikeset5.addCollisionListener(new SpikeCollisionL3(getCharacter()));
            }

            for (int n = 0; n < 5; n++) {
                final Body spikeset6 = new Spike(this);
                spikeset6.setPosition(new Vec2(112 + n - 2, -2.5f));
                spikeset6.setFillColor(Color.LIGHT_GRAY);
                spikeset6.addCollisionListener(new SpikeCollisionL3(getCharacter()));
            }

            for (int n = 0; n < 30; n++) {
                final Body spikeset7 = new Spike(this);
                spikeset7.setPosition(new Vec2(197 + n - 2, 10));
                spikeset7.setFillColor(Color.LIGHT_GRAY);
                spikeset7.addCollisionListener(new SpikeCollisionL3(getCharacter()));
            }
        }


        {
            /**
             * Crushers
             */
            base1 = new Crusher(this);
            base1.setPosition(new Vec2(88, -5));
            base1.setGravityScale(0);
            base1.addCollisionListener(new SpikeCollisionL3(getCharacter()));

            base2 = new Crusher(this);
            base2.setPosition(new Vec2(100, -5));
            base2.setGravityScale(0);
            base2.addCollisionListener(new SpikeCollisionL3(getCharacter()));

            base3 = new Crusher(this);
            base3.setPosition(new Vec2(106, -5));
            base3.setGravityScale(0);
            base3.addCollisionListener(new SpikeCollisionL3(getCharacter()));

            base4 = new Crusher(this);
            base4.setPosition(new Vec2(112, -5));
            base4.setGravityScale(0);
            base4.addCollisionListener(new SpikeCollisionL3(getCharacter()));

            base5 = new Crusher(this);
            base5.setPosition(new Vec2(145, 15.5f));
            base5.setGravityScale(0);
            base5.addCollisionListener(new SpikeCollisionL3(getCharacter()));

            base6 = new Crusher(this);
            base6.setPosition(new Vec2(157, 15.5f));
            base6.setGravityScale(0);
            base6.addCollisionListener(new SpikeCollisionL3(getCharacter()));
        }


        {
            /**
             * One score coins
             */
            StaticBody onecoin1 = new OneCoin(this);
            onecoin1.setPosition(new Vec2(64f, 7f));
            onecoin1.addCollisionListener(new PickupOneScore(getCharacter()));

            StaticBody onecoin2 = new OneCoin(this);
            onecoin2.setPosition(new Vec2(94f, -9f));
            onecoin2.addCollisionListener(new PickupOneScore(getCharacter()));
        }


        {
            /**
             * Five score coins
             */
            StaticBody fivecoin1 = new FiveCoin(this);
            fivecoin1.setPosition(new Vec2(37f, -10f));
            fivecoin1.addCollisionListener(new PickupFiveScore(getCharacter()));

            StaticBody fivecoin2 = new FiveCoin(this);
            fivecoin2.setPosition(new Vec2(163, 11f));
            fivecoin2.addCollisionListener(new PickupFiveScore(getCharacter()));

            StaticBody fivecoin3 = new FiveCoin(this);
            fivecoin3.setPosition(new Vec2(205, 29));
            fivecoin3.addCollisionListener(new PickupFiveScore(getCharacter()));
        }


        {
            /**
             * Health bonuses
             */
            Body healthup1 = new HealthUp(this);
            healthup1.setPosition(new Vec2(168, 10));
            healthup1.addCollisionListener(new PickUpHealth(getCharacter()));
        }

    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-18, -9);
    }

    @Override
    public Vec2 checkpointPosition() {
        return new Vec2(221, 31.5f);
    }

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
