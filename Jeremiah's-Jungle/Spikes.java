import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Spikes extends Actor
{

    /**
     * Act - do whatever the Spikes wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        removeObject();
        if (isGameLost()) {
            transitionToGameOver();
            Greenfoot.playSound("Missing Cap.wav"); 
        }
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
        }
    }
    
    public boolean isGameLost()
    {
        World world = getWorld();
        if (world.getObjects(Player.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void transitionToGameOver()
    {
        World level1 = getWorld();
        //level1.stopped();
        World gameLostWorld =  new GameLostWorld();
        //gameOverWorld.started();
        Greenfoot.setWorld(gameLostWorld);
        if(level1 instanceof Level1){
        ((Level1) level1).stopMusic(); 
    }
    World level2 = getWorld(); 
        if(level2 instanceof Level2){
        ((Level2) level2).stopMusic(); 
    }
    }
    

}
