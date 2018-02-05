package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Walker implements StepListener {

    private DynamicBody body;
    private float speed;

    Walker(DynamicBody body, float speed) {
        this.body = body;
        this.speed = speed;
    }
/**
 * Sets the body to be onto the player
 * @param body 
 */
    public void setBody(DynamicBody body) {
        this.body = body;
    }

/**
 * Sets the linear velocity  of the player to be the speed specified
 * @param e 
 */    
    @Override
    public void preStep(StepEvent e) {
        Vec2 v = body.getLinearVelocity();
        body.setLinearVelocity(new Vec2(speed, v.y));
    }

    @Override
    public void postStep(StepEvent e) {
    }
}