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
            Greenfoot.playSound("spikeImpact.wav"); 
             // Stop the music if the world is an instance of Level1 (or the world where the music is playing)
            if (world instanceof Level1) {
                ((Level1) world).stopMusic();  // Stop the music in Level1
        }
         World level2 = getWorld(); 
        if(level2 instanceof Level2){
        ((Level2) level2).stopMusic(); //Stop the music in Level2 
    }
    }
}
}

