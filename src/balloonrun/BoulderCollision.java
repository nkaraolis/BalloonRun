package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class BoulderCollision implements CollisionListener {

    private Character jango;

    public BoulderCollision(Character jango) {
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
            } else if (jango.getPosition().x >= 164) {
                jango.setPosition(new Vec2(164, 11));
                jango.HealthLoss();
            }
        
    }
}
    }
