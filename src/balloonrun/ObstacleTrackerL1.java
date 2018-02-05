package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class ObstacleTrackerL1 implements StepListener {


 
    private SlidePlatform slide1;
    private SlidePlatform slide2;
    private SlideWall wall1;
    private SlideWall wall2;


    public ObstacleTrackerL1(SlidePlatform slide1, SlidePlatform slide2, SlideWall wall1, SlideWall wall2) {

        this.slide1 = slide1;
        this.slide2 = slide2;
        this.wall1 = wall1;
        this.wall2 = wall2;

    }

    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        /**Sets the movement for sliding Platform 1
         *  
         */
        if (slide1.getPosition().x == 7) {
            slide1.setLinearVelocity(new Vec2(3, 0));
        } else if (slide1.getPosition().x >= 9) {
            slide1.setLinearVelocity(new Vec2(-3, 0));
        }

        /**Sets the movement for sliding Platform 2
         * 
         */
        if (slide2.getPosition().x == 79) {
            slide2.setLinearVelocity(new Vec2(3, 0));

        } else if (slide2.getPosition().x >= 82) {
            slide2.setLinearVelocity(new Vec2(-3, 0));
        }

       /**Sets the movement for sliding wall 1
        * 
        */
        if (wall1.getPosition().y <= 2) {
            wall1.setLinearVelocity(new Vec2(0, 3));

        } else if (wall1.getPosition().y >= 6) {
            wall1.setLinearVelocity(new Vec2(0, -3));

        }
        /**Sets the movement for sliding Wall 2
         * 
         */
        if (wall2.getPosition().y <= 10) {
            wall2.setLinearVelocity(new Vec2(0, 3));

        } else if (wall2.getPosition().y >= 14) {
            wall2.setLinearVelocity(new Vec2(0, -3));

        }
    }
}
