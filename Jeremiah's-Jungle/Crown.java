import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Crown extends Actor
{
    private int gravity = 1;      
    private int verticalSpeed = -10; 
    private boolean onGround = true; 
    
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
        if (!onGround)  
        {
            verticalSpeed += gravity;
        }
        setLocation(getX(), getY() + verticalSpeed);  
    }
    
    private boolean isBigBlockBlocked(int newX, int newY)
    {
        Actor bigBlock = getOneObjectAtOffset(newX - getX(), newY - getY()-15, BigBlock.class);
        return bigBlock != null;  
    }
    private boolean isRLongBlockBlocked(int newX, int newY)
    {
        Actor rLongBlock = getOneObjectAtOffset(newX - getX() + 75/2, newY - getY(), RLongBlock.class);
        return rLongBlock != null;  
    }
    
    private void checkCollisions()
    {
        if (isBigBlockBlocked(getX(), getY() + 75 / 2))   
        {
            while (isBigBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  
            }
            onGround = true;  
            verticalSpeed = 0;  
        }
        else if (isRLongBlockBlocked(getX(), getY() + 75 / 2))
        {
            
            while (isRLongBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  
            }
            onGround = true;  
            verticalSpeed = 0;  
        }
        else
        {
            onGround = false;  
        }
    }
}
