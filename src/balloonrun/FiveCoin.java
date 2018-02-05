package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class FiveCoin extends StaticBody {
    
            private static final BodyImage image =
            new BodyImage("images/FiveCoin.png", 2f);
    private static final Shape shape = new CircleShape(0.3f);
    
    public FiveCoin(World world){
        super(world, shape);
        setImage(image);
    }
}
