// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Jeremiah extends Actor
{
    private int jumpHeight = 10;
    private int gravity = 1;
    private int verticalSpeed = 0;
    private boolean onGround = true;
    

    /**
     * Act - do whatever the Jeremiah wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
        jump();
        moveVertically();
    }

    /**
     * 
     */
    public void movement()
    {
        if (Greenfoot.isKeyDown("d")) {
            move(4);
        }
        if (Greenfoot.isKeyDown("a")) {
            move(-3);
        }
    }

    /**
     * 
     */
    public void jump()
    {
        if (Greenfoot.isKeyDown("space") && onGround) {
            verticalSpeed = 6;
            onGround = false;
        }
        if ( ! onGround) {
            verticalSpeed = gravity;
        }
    }

    /**
     * 
     */
    private void moveVertically()
    {
        setLocation(getX(), getY() + verticalSpeed);
    }
}
