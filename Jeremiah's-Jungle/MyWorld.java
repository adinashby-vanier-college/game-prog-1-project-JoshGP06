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
        Ground ground =  new  Ground();
        addObject(ground, 867, 794);
        Block block =  new  Block();
        addObject(block, 1463, 702);
        Block block2 =  new  Block();
        addObject(block2, 1390, 703);
        Block block3 =  new  Block();
        addObject(block3, 1462, 629);
        LongBlock longBlock =  new  LongBlock();
        addObject(longBlock, 485, 541);
        Player jeremiah =  new  Player();
        addObject(jeremiah, 281, 411);
        Block block4 =  new  Block();
        addObject(block4, 37, 462);
        Block block5 =  new  Block();
        addObject(block5, 111, 462);
        Block block6 =  new  Block();
        addObject(block6, 38, 387);
        LongBlock longBlock2 =  new  LongBlock();
        addObject(longBlock2, 1014, 288);
    }
}
