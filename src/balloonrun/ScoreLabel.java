package balloonrun;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A label containing the score, updated whenever the score changes.
 */
public class ScoreLabel extends JLabel implements ChangeListener {

    private Character jango;

    public ScoreLabel(Character jango) {
        this.jango = jango;
        setLabelText();
    }

    /**
     * Changes the player's score when a change event occurs
     *
     * @param e
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        setLabelText();
    }

    /**
     * Sets the label text to be the player's current score
     *
     */
    private void setLabelText() {
        setText("Score: " + jango.GetCount());
    }
}
