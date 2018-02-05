package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class FinishLevel implements CollisionListener {

   private BalloonRun game;
   

    public FinishLevel(BalloonRun game) {
        this.game = game;
    }

    /**
     * Collision with checkpoint to finish a level
     * @param e 
     */
    @Override
    public void collide(CollisionEvent e) {
        Character actor = game.getActor();
        if (e.getOtherBody() == actor) {          
            game.goNextLevel();
        }     
    }
}