package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Spike extends StaticBody {

    private static final Shape spike = new PolygonShape(0f, 0.5f, 0.5f, -0.5f, -0.5f, -0.5f);

    public Spike(World world) {
        super(world, spike);
    
    }
}
