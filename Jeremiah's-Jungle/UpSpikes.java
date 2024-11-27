import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class UpSpikes extends Actor
{

    /**
     * Act - do whatever the UpSpikes wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        removeObject();
    }

    /**
     * 
     */
    public void removeObject()
    {
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            World world = getWorld();
            world.removeObject(player);
        }
    }
}
