package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class TrackerL2 implements StepListener {

    /**
     * The view
     */
    private MyViewL1 view;
    /**
     * The body
     */
    private Body body;

    private Character jango;

    public TrackerL2(MyViewL1 view, Body body, Character jango) {
        this.view = view;
        this.body = body;

        this.jango = jango;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    /**
     * Centres the view onto the player
     *
     * @param e
     */
    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(body.getPosition()));

        /**
         * Tracks the player position and will reset them to different starting
         * positions Based on the player's current position
         *
         */
        if (jango.getPosition().y <= -15 && jango.getPosition().x <= 55) {

            jango.setPosition(new Vec2(-18, -9));
            jango.HealthLoss();

        } else if (jango.getPosition().x >= 60 && jango.getPosition().y <= -15) {
            jango.setPosition(new Vec2(64, -4));
            jango.HealthLoss();
        }

    }
}
