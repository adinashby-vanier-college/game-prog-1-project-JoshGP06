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
        if(isBossLost() == true)
        {
            applyGravity();
        }
        checkCollisions();
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
    
    private boolean isBigBlockBlocked(int newX, int newY)
    {
        Actor bigBlock = getOneObjectAtOffset(newX - getX(), newY - getY()-15, BigBlock.class);
        return bigBlock != null;  // If there is a block, return true
    }
    
    private void checkCollisions()
    {
        if (isBigBlockBlocked(getX(), getY() + 75 / 2))  // Check if there's an LBlock directly below
        {
            // Adjust player's vertical position so they land on top of the block
            while (isBigBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  // Move up by 1 pixel to find the top of the block
            }
            onGround = true;  // The player is on the ground
            verticalSpeed = 0;  // Stop downward movement (gravity)
        }
        else
        {
            onGround = false;  // Player is in the air
        }
    }
}
