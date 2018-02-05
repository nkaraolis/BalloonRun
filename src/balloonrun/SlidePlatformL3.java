package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SlidePlatformL3 extends DynamicBody {
    
    private static final BodyImage image =
            new BodyImage("images/SolarSailer.png", 3f);
    
       
    public SlidePlatformL3(World world){
        super(world);
        Shape shape = new BoxShape(3, 1f);
        SolidFixture platform = new SolidFixture(this, shape, Integer.MAX_VALUE);
        setImage(image);
        
    }
}
