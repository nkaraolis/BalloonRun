package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows player to collect things.
 */
public class PickupOneScore implements CollisionListener {

    private Character jango;

    public PickupOneScore(Character jango) {
        this.jango = jango;
    }

    /**
     * Picking up a five score coin and increasing the player's score by one 
     * @param e 
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == jango) {
            jango.addOneScore();
            e.getReceivingBody().destroy();
            //System.out.println("Called");
        }
    }
}
