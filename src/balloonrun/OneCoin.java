package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class OneCoin extends StaticBody {

    private static final BodyImage image =
            new BodyImage("images/OneCoin.png", 2f);
    private static final Shape shape = new CircleShape(0.6f);

    public OneCoin(World world) {
        super(world, shape);
        setImage(image);
    }
}
