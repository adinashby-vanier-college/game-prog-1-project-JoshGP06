// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Transition2 extends World
{
    private int counter = 0;

    /**
     * Constructor for objects of class Transition2.
     */
    public Transition2()
    {
        super(1500, 800, 1);
    }

    /**
     * 
     */
    public void act()
    {
        counter = counter + 1;
        if (counter == 125) {
            transitionToLevel3();
        }
    }

    /**
     * 
     */
    public void transitionToLevel3()
    {
        Greenfoot.setWorld( new  Level3());
    }
}
