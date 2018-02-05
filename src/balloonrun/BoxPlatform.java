package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BoxPlatform extends StaticBody {

        
        
    public BoxPlatform(World world) {
        super(world);
        Shape shape = new BoxShape(3f, 0.5f);
        SolidFixture platform = new SolidFixture(this, shape, Integer.MAX_VALUE);
    
        
    }
}