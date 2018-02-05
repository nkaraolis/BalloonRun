package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Platform extends StaticBody {

        private static final BodyImage image =
            new BodyImage("images/Coruscant_speeder.png", 3f);
        
    public Platform(World world) {
        super(world);
        Shape shape = new BoxShape(2.8f, 0.4f);
        setImage(image);
        SolidFixture platform = new SolidFixture(this, shape, Integer.MAX_VALUE);

    }
}
