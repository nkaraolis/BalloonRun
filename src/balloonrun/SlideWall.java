package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SlideWall extends DynamicBody {

    private static final BodyImage image =
            new BodyImage("images/Coruscant_speeder_down.png", 5f);
    
    public SlideWall(World world) {
        super(world);
        Shape shape = new BoxShape(0.5f, 2);
        setImage(image);
        SolidFixture platform = new SolidFixture(this, shape, Integer.MAX_VALUE);
        setFixedRotation(true);

    }
}
