package balloonrun;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Ground extends StaticBody {

     private static final Shape shape = new BoxShape(30, 0.5f);
      

         

public  Ground(World world) {
   super(world, shape); 
   
}
}
