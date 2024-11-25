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
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground =  new  Ground();
        addObject(ground, 867, 794);
        LLongBlock lLongBlock =  new  LLongBlock();
        addObject(lLongBlock, 450, 541);
        Player jeremiah =  new  Player();
        addObject(jeremiah, 281, 411);
        LBlock lBlock4 =  new  LBlock();
        addObject(lBlock4, 34, 460);
        LBlock lBlock5 =  new  LBlock();
        addObject(lBlock5, 107, 460);
        LBlock lBlock6 =  new  LBlock();
        addObject(lBlock6, 34, 387);
        LBlock lBlock7 =  new  LBlock();
        addObject(lBlock7, 0, 313);
        RBlock rBlock =  new  RBlock();
        addObject(rBlock, 1462, 703);
        RBlock rBlock2 =  new  RBlock();
        addObject(rBlock2, 1464, 625);
        removeObject(rBlock2);
        RBlock rBlock3 =  new  RBlock();
        addObject(rBlock3, 1387, 705);
        RBlock rBlock4 =  new  RBlock();
        addObject(rBlock4, 1464, 630);
        RBlock rBlock5 =  new  RBlock();
        addObject(rBlock5, 1500, 557);
    }
}
