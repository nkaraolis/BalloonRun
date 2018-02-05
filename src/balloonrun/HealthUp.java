package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class HealthUp extends StaticBody {
        
    private static final Shape shape = new CircleShape(0.4f);
    
        private static final BodyImage image =
            new BodyImage("images/Heart.png", 3f);
    
    public HealthUp(World world){
        super(world, shape);
        setImage(image);
    }
}
