package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private static final float WALKING_SPEED = 7;
    private static final float JUMPING_SPEED = 11;

    private DynamicBody body;
    private World world;
    private MyViewL1 view;
    private Walker walkLeft;
    private Walker walkRight;

    private Bomb bombShape;

    private BodyImage bombImage;

    private static final BodyImage RightImage
            = new BodyImage("images/jangoright.png", 7f);

    private static final BodyImage LeftImage
            = new BodyImage("images/jangoleft.png", 7f);

    // one of walkLeft, walkRight or null
    private Walker currentWalker;

    public Controller(DynamicBody body, MyViewL1 view) {
        this.body = body;
        this.world = body.getWorld();
        this.walkLeft = new Walker(body, -WALKING_SPEED);
        this.walkRight = new Walker(body, WALKING_SPEED);
        this.currentWalker = null;

        this.view = view;
    }

    /**
     * Key pressed commands used to control the player
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE) { // SPACE = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.setLinearVelocity(new Vec2(v.x, JUMPING_SPEED));
            }
        } else if (code == KeyEvent.VK_LEFT) {
            // LEFT ARROW = walk left
            setWalker(walkLeft);
            body.setImage(LeftImage);
        } else if (code == KeyEvent.VK_RIGHT) {
            // RIGHT ARROW = walk right
            setWalker(walkRight);
            body.setImage(RightImage);
        }

        /*  if (e.getKeyChar() == 'x' ) {
         body.getImage();
         DynamicBody bombShape = new Bomb(view.getWorld());
         bombShape.setImage(bombImage);
            
         if(body.getImage() == RightImage) {
         bombShape.setPosition(new Vec2(body.getPosition().x + 1f, body.getPosition().y));
         bombShape.setLinearVelocity(new Vec2(30, 0)); 
         } else if (body.getImage() == LeftImage) {
                
            
         bombShape.setPosition(new Vec2(body.getPosition().x - 1f, body.getPosition().y - 0.1f));
         bombShape.setLinearVelocity(new Vec2(-30, 0)); 
         }
         } */
    }

    /**
     * Removes any previous key listeners to make the character move as expected
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            clearWalker(walkLeft);
        } else if (code == KeyEvent.VK_RIGHT) {
            clearWalker(walkRight);
        }
    }

    /**
     * Sets the controller onto the player
     * @param body 
     */
    public void setBody(DynamicBody body) {
        if (currentWalker != null) {
            world.removeStepListener(currentWalker);
            currentWalker = null;
        }
        this.body = body;
        this.world = body.getWorld();
        walkLeft.setBody(body);
        walkRight.setBody(body);
    }

    /**
     * Set the walker, unless already walking
     */
    private void setWalker(Walker w) {
        if (currentWalker == null) {
            currentWalker = w;
            world.addStepListener(currentWalker);
        }
    }

    /**
     * Clear the walker, if this is the one in effect.
     */
    private void clearWalker(Walker w) {
        if (currentWalker == w) {
            world.removeStepListener(currentWalker);
            currentWalker = null;
        }
    }

}
