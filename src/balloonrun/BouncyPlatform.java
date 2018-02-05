package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.Color;

public class BouncyPlatform extends StaticBody {

    private static final float platWidth = 2f;
    private static final float platHeight = 0.5f;
    private static final float baseWidth = 0.5f;
    private static final int baseHeight = 1;

    public BouncyPlatform(World world, float height) {
        super(world);
        float platWidth2 = platWidth;
        float platHeight2 = platHeight;
        float baseWidth2 = baseWidth;
        float baseHeight2 = baseHeight;

        Shape platShape = new BoxShape(platWidth2, platHeight2,
                new Vec2(0, 0));
        SolidFixture platform = new SolidFixture(this, platShape);
        platform.setRestitution(1);
        

        Shape baseShape = new BoxShape(baseWidth2, baseHeight2,
                new Vec2(0, -baseHeight2));

        SolidFixture base = new SolidFixture(this, baseShape, 1);
    

    }
}
