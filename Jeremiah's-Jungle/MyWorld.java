// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {
        super(1500, 800, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground =  new Ground();
        addObject(ground, 867, 794);
        LBlock block =  new LBlock();
        addObject(block, 1463, 702);
        LBlock block2 =  new LBlock();
        addObject(block2, 1390, 703);
        LBlock block3 =  new LBlock();
        addObject(block3, 1462, 629);
        LongBlock longBlock =  new LongBlock();
        addObject(longBlock, 485, 541);
        Player jeremiah =  new Player();
        addObject(jeremiah, 281, 411);
        LongBlock longBlock2 =  new LongBlock();
        LBlock lBlock4 =  new LBlock();
        addObject(lBlock4, 34, 460);
        LBlock lBlock5 =  new LBlock();
        addObject(lBlock5, 107, 462);
        LBlock lBlock6 =  new LBlock();
        addObject(lBlock6, 11, 387);
        LBlock lBlock7 =  new LBlock();
        addObject(lBlock7, 2, 317);
    }
}
