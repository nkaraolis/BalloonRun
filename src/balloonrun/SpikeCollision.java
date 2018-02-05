package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SpikeCollision implements CollisionListener {

    private Character jango;

    public SpikeCollision(Character jango) {
        this.jango = jango;
    }

    /**
     * Reduces player's health and resets it to a starting position based on current X value
     * 
     * @param e 
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == jango) {
            if (jango.getPosition().x <= 55) {
                jango.HealthLoss();
                jango.setPosition(new Vec2(-8, -9));
            } else if (jango.getPosition().x >= 60 && jango.getPosition().x <= 160) {
                jango.setPosition(new Vec2(63, -9));
                jango.HealthLoss();
            }
        }
    }
}