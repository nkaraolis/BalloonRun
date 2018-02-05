package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public  class Checkpoint extends StaticBody  {
    
     private static final BodyImage image = new BodyImage("images/Checkpoint.png", 4);
     
     
     
    public Checkpoint(World world){
        super(world);       
        Shape shape = new BoxShape(0.5f, 1.5f);
        setImage(image);
        Fixture checkpoint = new SolidFixture(this, shape);
       
    }
    
    
}
