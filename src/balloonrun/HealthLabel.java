package balloonrun;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A label containing the score, updated whenever the score changes.
 */
public class HealthLabel extends JLabel implements ChangeListener {
    private Character jango;
    
    public HealthLabel(Character jango) {
        this.jango = jango;
        setLabelText();
    }
    
 /**
  * Notifies if a variable has changed and updates text accordingly
  * @param e 
  */   
    @Override
    public void stateChanged(ChangeEvent e) {
        setLabelText();
    }

    /**
     * Sets the text to be the player's current health
     */
    private void setLabelText() {
        setText("Health: " + jango.GetHealth());
    }
}
