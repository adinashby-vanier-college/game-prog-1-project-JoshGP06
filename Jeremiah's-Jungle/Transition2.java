import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Transition2 extends World
{
    private int counter = 0;

    public Transition2()
    {
        super(1500, 800, 1);
    }

    public void act()
    {
        counter = counter + 1;
        if (counter == 125) {
            transitionToLevel3();
        }
    }

    public void transitionToLevel3()
    {
        World level3 = new Level3();
        Greenfoot.setWorld(level3);  
        level3.started();
    }
}
