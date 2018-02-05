package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class CrushSpike extends DynamicBody {

    private static final Shape spike = new PolygonShape(0f, 0.5f, 0.5f, -0.5f, -0.5f, -0.5f);

    public CrushSpike(World world) {
        super(world, spike);
        SolidFixture crushspike = new SolidFixture(this, spike, Integer.MAX_VALUE);
    
    }
}
