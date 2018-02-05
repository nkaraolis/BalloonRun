package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Crusher extends DynamicBody {
    private static final BodyImage image =
            new BodyImage("images/Crushbase.png", 1f);
    
    public Crusher(World world) {
        super(world);
        Shape baseshape = new BoxShape(3f, 0.5f);
        SolidFixture platform = new SolidFixture(this, baseshape, Integer.MAX_VALUE);
        setImage(image);


    }
}
