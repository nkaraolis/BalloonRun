package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SlidePlatform extends DynamicBody {
    
    private static final BodyImage image =
            new BodyImage("images/Coruscant_speeder.png", 3f);
    
       
    public SlidePlatform(World world){
        super(world);
        Shape shape = new BoxShape(3, 0.5f);
        SolidFixture platform = new SolidFixture(this, shape, Integer.MAX_VALUE);
        setImage(image);
        
    }
}
