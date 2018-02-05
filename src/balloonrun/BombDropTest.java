package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BombDropTest extends MouseAdapter {

    private WorldView view;
    private Shape ballShape;
    private BodyImage ballImage;

    public BombDropTest(WorldView view) {
        this.view = view;
        float radius = 0.5f;
        ballShape = new CircleShape(radius);
        ballImage = new BodyImage("images/bomb.jpg", 2*radius);
    }

    /**
     * Create a bowling ball at the current mouse position.
     * @param e event object containing the mouse position
     */
    public void mousePressed(MouseEvent e) {
       // DynamicBody ball = new DynamicBody(view.getWorld(), ballShape);
        //ball.setPosition(view.viewToWorld(e.getPoint()));
        //ball.setImage(ballImage);
    }
}
