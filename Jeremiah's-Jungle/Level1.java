// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Level1 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     */
    public Level1()
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
        addObject(jeremiah, 100, 700);
        LBlock lBlock4 =  new  LBlock();
        addObject(lBlock4, 34, 465);
        LBlock lBlock5 =  new  LBlock();
        addObject(lBlock5, 107, 465);
        LBlock lBlock6 =  new  LBlock();
        addObject(lBlock6, 34, 393);
        LBlock lBlock7 =  new  LBlock();
        addObject(lBlock7, 0, 320);
        RBlock rBlock1 =  new  RBlock();
        addObject(rBlock1, 1462, 715);
        RBlock rBlock2 =  new  RBlock();
        addObject(rBlock2, 1464, 640);
        RBlock rBlock3 =  new  RBlock();
        addObject(rBlock3, 1387, 715);
        RBlock rBlock4 =  new  RBlock();
        addObject(rBlock4, 1500, 565);
        RLongBlock rLongBlock =  new  RLongBlock();
        addObject(rLongBlock, 1015, 252);
    }
}
