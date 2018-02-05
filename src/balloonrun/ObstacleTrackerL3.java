package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Used to make different objects move in Level 3
 */
public class ObstacleTrackerL3 implements StepListener {

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

    public ObstacleTrackerL3(Boulder boulder1, SlidePlatformL3 Slide1L3, SlidePlatformL3 Slide2L3, Crusher base1, Crusher base2, Crusher base3, Crusher base4, Crusher base5, Crusher base6, Boulder boulder2) {

        this.boulder1 = boulder1;
        this.Slide1L3 = Slide1L3;
        this.Slide2L3 = Slide2L3;
        this.base1 = base1;
        this.base2 = base2;
        this.base3 = base3;
        this.base4 = base4;
        this.base5 = base5;
        this.base6 = base6;
        this.boulder2 = boulder2;
        
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        /**
         * Calculations for boulder 1
         *
         */
        boulder1.setLinearVelocity(new Vec2(-4, 0));
        boulder1.setAngularVelocity(5);
        if (boulder1.getPosition().x <= -7) {
            boulder1.setPosition(new Vec2(4, -9));
        }

        /**
         * Calculations for sliding Platform 1
         *
         */
        if (Slide1L3.getPosition().x <= 12) {
            Slide1L3.setLinearVelocity(new Vec2(3, 0));
        } else if (Slide1L3.getPosition().x >= 15) {
            Slide1L3.setLinearVelocity(new Vec2(-3, 0));
        }

        /**
         * Calculations for sliding Platform 2
         *
         */
        if (Slide2L3.getPosition().x <= 51f) {
            Slide2L3.setLinearVelocity(new Vec2(3, 0));

        } else if (Slide2L3.getPosition().x >= 55f) {
            Slide2L3.setLinearVelocity(new Vec2(-3, 0));
        }

        /**
         * Calculations for crush base 1
         *
         */
        if (base1.getPosition().y >= -5) {
            base1.setLinearVelocity(new Vec2(0, -5));
        } else if (base1.getPosition().y <= -10) {
            base1.setLinearVelocity(new Vec2(0, 5));
        }

        /**
         * Calculations for crush base 2
         *
         */
        if (base2.getPosition().y >= -5) {
            base2.setLinearVelocity(new Vec2(0, -2));
        } else if (base2.getPosition().y <= -10) {
            base2.setLinearVelocity(new Vec2(0, 2));
        }

        /**
         * Calculations for crush base 3
         *
         */
        if (base3.getPosition().y >= -5) {
            base3.setLinearVelocity(new Vec2(0, -2));
        } else if (base3.getPosition().y <= -10) {
            base3.setLinearVelocity(new Vec2(0, 2));
        }

        /**
         * Calculations for crush base 4
         *
         */
        if (base4.getPosition().y >= -5) {
            base4.setLinearVelocity(new Vec2(0, -2));
        } else if (base4.getPosition().y <= -10) {
            base4.setLinearVelocity(new Vec2(0, 2));
        }

        /**
         * Calculations for crush base 5
         *
         */
        if (base5.getPosition().y >= 15.5f) {
            base5.setLinearVelocity(new Vec2(0, -6));
        } else if (base5.getPosition().y <= 10.5f) {
            base5.setLinearVelocity(new Vec2(0, 6));
        }

        /**
         * Calculations for crush base 6
         *
         */
        if (base6.getPosition().y >= 15.5f) {
            base6.setLinearVelocity(new Vec2(0, -6));
        } else if (base6.getPosition().y <= 10.5f) {
            base6.setLinearVelocity(new Vec2(0, 6));
        }

        /**
         * Calculations for boulder 2
         *
         */
        boulder2.setLinearVelocity(new Vec2(-15, 0));
        boulder2.setAngularVelocity(5);
        if (boulder2.getPosition().x <= 180) {
            boulder2.setPosition(new Vec2(190, 10.5f));
        }

    }
}
