// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Jeremiah extends Actor
{
    public int jumpHeight = 14;
    public int gravity = 1;
    public int verticalSpeed = 10;
    public boolean isJumping = false;

    /**
     * Act - do whatever the Jeremiah wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        applyGravity();
        checkForJump();
    }

    /**
     * 
     */
    public void move()
    {
        if (Greenfoot.isKeyDown("d")) {
            move(4);
        }
        if (Greenfoot.isKeyDown("a")) {
            move(-4);
        }
    }

    /**
     * 
     */
    public void checkForJump()
    {
        if (Greenfoot.isKeyDown("space") &&  ! isJumping) {
            verticalSpeed =  - jumpHeight;
            isJumping = true;
        }
    }

    /**
     * 
     */
    public void applyGravity()
    {
        verticalSpeed = gravity + verticalSpeed;
        setLocation(getX(), getY() + verticalSpeed);
        if (isTouching(Ground.class)) {
            setLocation(getX(), getY() - verticalSpeed);
            isJumping = false;
            verticalSpeed = 0;
        }
        if (isTouching(Block.class)) {
            setLocation(getX(), getY() - verticalSpeed);
            isJumping = false;
            verticalSpeed = 0;
        }
        if (isTouching(LongBlock.class)) {
            setLocation(getX(), getY() - verticalSpeed);
            isJumping = false;
            verticalSpeed = 0;
        }
        if (getY() >= getWorld().getHeight() - 1) {
            setLocation(getX(), getWorld().getHeight() - 1);
            isJumping = false;
            verticalSpeed = 0;
        }
    }
}
