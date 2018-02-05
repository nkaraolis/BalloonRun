package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Boulder extends DynamicBody {

    private static final float radius = 2f;
    private static final Shape shape = new CircleShape(radius);
    private static final BodyImage image = new BodyImage("images/boulder.png", 2 * radius);

    public Boulder(World world) {
        super(world, shape);
        SolidFixture boulder = new SolidFixture(this, shape);
        setImage(image);
        
    }
}
