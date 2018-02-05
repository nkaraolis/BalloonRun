package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class SpikeCollisionL2 implements CollisionListener {

    private Character jango;

    public SpikeCollisionL2(Character jango) {
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
                jango.setPosition(new Vec2(-18, -9));
            } else if (jango.getPosition().x >= 60 && jango.getPosition().x <= 160) {
                jango.setPosition(new Vec2(64, -4));
                jango.HealthLoss();
            }
        }
    }
}