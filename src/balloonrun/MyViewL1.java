package balloonrun;

import city.cs.engine.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MyViewL1 extends UserView {

    private BalloonRun game;

    public MyViewL1(BalloonRun game, World world, int width, int height) {
        super(world, width, height);
        this.game = game;
    }

    /**
     * Changes the background depending on the level
     * @param g 
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        ImageIcon icon;
        icon = new ImageIcon("images/Coruscant.jpg");

        ImageIcon icon2;
        icon2 = new ImageIcon("images/Kamino.jpg");

        ImageIcon icon3;
        icon3 = new ImageIcon("images/geonosis.jpg");

        if (game.getLevel() == 1) {
            g.drawImage(icon.getImage(), 0, 0, this);
        } else if (game.getLevel() == 2) {
            g.drawImage(icon2.getImage(), 0, 0, this);
        } else if (game.getLevel() == 3) {
            g.drawImage(icon3.getImage(), 0, 0, this);
        }
    }
}
