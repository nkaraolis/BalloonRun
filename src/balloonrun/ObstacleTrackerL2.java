package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class ObstacleTrackerL2 implements StepListener {

 

    private SlidePlatformL2 Slide1L2;
    private SlidePlatformL2 Slide2L2;
    private SlideWallL2 SlideWall1L2;
    private SlideWallL2 SlideWall2L2;
  

    public ObstacleTrackerL2(SlidePlatformL2 Slide1L2,  SlidePlatformL2 Slide2L2, SlideWallL2 SlideWall1L2, SlideWallL2 SlideWall2L2) {

        this.Slide1L2 = Slide1L2;
        this.Slide2L2 = Slide2L2;
        this.SlideWall1L2 = SlideWall1L2;
        this.SlideWall2L2 = SlideWall2L2;

    }
@Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {


        /**Sets the movement for sliding Platform 1
         *  
         */
        if (Slide1L2.getPosition().x == 21) {
            Slide1L2.setLinearVelocity(new Vec2(3, 0));
        } else if (Slide1L2.getPosition().x >= 24) {
            Slide1L2.setLinearVelocity(new Vec2(-3, 0));
        }

        /**Sets the movement for sliding Platform 2
         * 
         */
        if (Slide2L2.getPosition().x == 85.5f) {
            Slide2L2.setLinearVelocity(new Vec2(3, 0));

        } else if (Slide2L2.getPosition().x >= 88.5f) {
            Slide2L2.setLinearVelocity(new Vec2(-3, 0));
        }

       /**Sets the movement for sliding wall 1
        * 
        */
        if (SlideWall1L2.getPosition().y <= 1) {
            SlideWall1L2.setLinearVelocity(new Vec2(0, 3));

        } else if (SlideWall1L2.getPosition().y >= 4) {
            SlideWall1L2.setLinearVelocity(new Vec2(0, -3));

        }      
        /**Sets the movement for sliding Wall 2
         * 
         */
        
        
        if (SlideWall2L2.getPosition().y <= 9) {
            SlideWall2L2.setLinearVelocity(new Vec2(0, 3));

        } else if (SlideWall2L2.getPosition().y >= 12) {
            SlideWall2L2.setLinearVelocity(new Vec2(0, -3));

        }
    }
}
