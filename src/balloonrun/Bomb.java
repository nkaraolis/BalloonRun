package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Bomb extends DynamicBody {
    private static final float radius = 0.5f;
    private static final Shape bomb = new CircleShape(radius);
    
    private static final BodyImage bombImage = new BodyImage("images/bomb.jpg", 2*radius);
    
    public Bomb(World world) {
        super(world, bomb);
        setImage(bombImage);
    }
}
