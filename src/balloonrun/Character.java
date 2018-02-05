package balloonrun;

import city.cs.engine.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jbox2d.common.Vec2;

public class Character extends DynamicBody {

    private static final Shape shape = new PolygonShape(
            0.149f, 0.975f, 0.68f, 0.193f, 0.6f, -1.2f,
            -0.45f, -1.2f, -0.725f, 0.163f, -0.14f, 0.972f);
    private int count;
    private int health = 100;
    private static final BodyImage image
            = new BodyImage("images/jangoright.png", 7f);

    public Character(World world) {
        super(world);

        SolidFixture fixture = new SolidFixture(this, shape, 5);
        fixture.setFriction(10);
        fixture.setDensity(50);
        setImage(image);
        setFixedRotation(true);
        count = 0;
        this.listeners = new LinkedList<ChangeListener>();

    }

    /**
     * Returns the player's current score
     *
     * @return
     */
    public int GetCount() {
        return count;

    }

    /**
     * Set a new score (used when next level is loaded to load previous score)
     *
     * @param newScore
     */
    public void setCount(int newScore) {
        this.count = newScore;
    }

    /**
     * Returns the player's current health
     *
     * @return
     */
    public int GetHealth() {
        return health;
    }

    /**
     * Resets health to full
     */
    public void setHealth() {
        health = 100;
    }

    /**
     * Adds one to the player's score
     *
     */
    public void addOneScore() {
        count++;
        changed();
    }

    /**
     * Adds five to the player's score
     *
     */
    public void addFiveScore() {
        count = count + 5;
        changed();
    }

    /**
     * Deducts 25 health from the player's health
     * Also checks if player has lost all health
     */
    public void HealthLoss() {
        health = health - 25;
        changed();
        if (health == 0) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }

    /**
     * Sets the player's health to be 100
     *
     */
    public void HealthGain() {
        health = 100;
        System.out.println("Health gained!");
        System.out.println("Health = " + health);
        changed();
    }
    private List<ChangeListener> listeners;

    /**
     * Adds the change listeners needed to be able to show a variable has
     * changed
     *
     * @param l
     */
    public void addChangeListener(ChangeListener l) {
        listeners.add(l);

    }

    /**
     * Unregister a change listener. Does nothing if the listener is not
     * registered.
     *
     * @param listener the listener to remove
     */
    public void removeChangeListener(ChangeListener l) {
        listeners.remove(l);
    }

    /**
     * Notify all listeners that the model has changed. This method should be
     * called by any method of a child class that modifies the child data.
     */
    protected void changed() {
        ChangeEvent e = new ChangeEvent(this);
        for (ChangeListener l : listeners) {
            l.stateChanged(e);
        }
    }
}
