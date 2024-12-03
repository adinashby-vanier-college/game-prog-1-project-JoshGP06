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
        World level2 = new Level2();
        Greenfoot.setWorld(level2);  
        level2.started();
    }
}
