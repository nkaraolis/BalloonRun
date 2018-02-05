package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows player to collect things.
 */
public class PickUpHealth implements CollisionListener {

    private Character jango;

    public PickUpHealth(Character jango) {
        this.jango = jango;
    }

    /**
     * Collision event with the player to add health
     * @param e 
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == jango) {
            jango.HealthGain();           
            e.getReceivingBody().destroy();
        }
    }
}
