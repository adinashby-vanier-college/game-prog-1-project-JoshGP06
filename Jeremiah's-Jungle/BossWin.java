// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class BossWin extends Actor
{
    private int bounceSpeed = 2;
    private int direction = 1;
    private int alpha = 255;
    private boolean fadingOut = true;
    private int rotationSpeed = 2;
    private int rotationAngle = 0;
    private int maxRotation = 15;
    private int minRotation = -15;

    /**
     * 
     */
    public BossWin()
    {
        GreenfootImage img =  new GreenfootImage("LaughingBoss.png");
        setImage(img);
    }

    /**
     * Act - do whatever the BossWin wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animateMovement();
        animateGlow();
        rotateEffect();
    }

    /**
     * Makes the boss jump in victory in the GAME OVER screen
     */
    public void animateMovement()
    {
        if (direction == 1) {
            setLocation(getX(), getY() - bounceSpeed);
            if (getY() <= 350) {
                direction = -1;
            }
        }
        else {
            setLocation(getX(), getY() + bounceSpeed);
            if (getY() >= 450) {
                direction = 1;
            }
        }
    }

    /**
     * Adds a glowing effect to the boss to add to his aura
     */
    public void animateGlow()
    {
        if (fadingOut) {
            alpha = alpha - 5;
            if (alpha <= 100) {
                fadingOut = false;
            }
        }
        else {
            alpha = alpha + 5;
            if (alpha >= 255) {
                fadingOut = true;
            }
        }
        GreenfootImage img = getImage();
        img.setTransparency(alpha);
    }

    /**
     * Rotates boss to give him a laughing effect
     */
    private void rotateEffect()
    {
        if (rotationAngle >= maxRotation || rotationAngle <= minRotation) {
            rotationSpeed =  - rotationSpeed;
        }
        rotationAngle = rotationAngle + rotationSpeed;
        setRotation(rotationAngle);
    }
}
