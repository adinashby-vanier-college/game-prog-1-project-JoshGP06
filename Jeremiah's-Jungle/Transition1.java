// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Transition1 extends World
{
    private int counter = 0;

    /**
     * Constructor for objects of class Transition1.
     */
    public Transition1()
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
            transitionToLevel2();
        }
    }

    /**
     * 
     */
    public void transitionToLevel2()
    {
        Greenfoot.setWorld( new  Level2());
    }
}
