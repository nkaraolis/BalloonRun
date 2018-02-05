package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Wall extends StaticBody {

    public Wall(World world) {
        super(world);
        Shape shape = new BoxShape(0.5f, 7);
        SolidFixture platform = new SolidFixture(this, shape);

    }
}
