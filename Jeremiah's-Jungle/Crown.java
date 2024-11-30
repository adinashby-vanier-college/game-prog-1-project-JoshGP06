import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Crown extends Actor
{
    private int gravity = 1;       // Gravity to pull the player down
    private int verticalSpeed = -10; // Vertical speed for jumping and gravity
    private boolean onGround = true; // Check if the player is on the ground
    
    /**
     * Act - do whatever the Crown wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isBossLost())
        {
            applyGravity();
        }
    }
    
    public boolean isBossLost()
    {
        World level3 = getWorld();
        if (level3.getObjects(Boss.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private void applyGravity()
    {
        if (!onGround)  // If the player is not on the ground, apply gravity
        {
            verticalSpeed += gravity;
        }
        setLocation(getX(), getY() + verticalSpeed);  // Update the vertical position based on speed
    }
}
