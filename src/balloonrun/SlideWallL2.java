package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SlideWallL2 extends DynamicBody {

    private static final BodyImage image =
            new BodyImage("images/slave1down.png", 5f);
    
    public SlideWallL2(World world) {
        super(world);
        Shape shape = new BoxShape(0.5f, 2);
        setImage(image);
        SolidFixture platform = new SolidFixture(this, shape, Integer.MAX_VALUE);
        setFixedRotation(true);

    }
}
