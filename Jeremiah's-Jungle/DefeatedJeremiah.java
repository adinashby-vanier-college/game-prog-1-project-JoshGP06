// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class DefeatedJeremiah extends Actor
{
    private int rotationSpeed = 5;
    private int maxRotation = 15;
    private int minRotation = -15;
    private int currentRotation = 0;

    /**
     * 
     */
    public DefeatedJeremiah()
    {
        GreenfootImage img =  new GreenfootImage("LostJeremiah.png");
        setImage(img);
    }

    /**
     * Act - do whatever the DefeatedJeremiah wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        stressRotation();
    }

    /**
     * Makes Jeremiah shake in defeat in the losing screen.
     */
    public void stressRotation()
    {
        if (currentRotation >= maxRotation || currentRotation <= minRotation) {
            rotationSpeed =  - rotationSpeed;
        }
        currentRotation = currentRotation + rotationSpeed;
        setRotation(currentRotation);
    }
}
