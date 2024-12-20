import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Level1 extends World
{
    private GreenfootSound music;
    /**
     * Constructor for objects of class MyWorld.
     */
    public Level1()
    {
        super(1500, 800, 1);
        music = new GreenfootSound("level1.mp3");
        prepare();
        started();  
        stopped();
    }
    
    public void started()
    {
        music.playLoop();
    }

    public void stopped()
    {
        music.stop();
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground =  new  Ground();
        addObject(ground, 867, 800);
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
        addObject(rBlock1, 1462, 721);
        RBlock rBlock2 =  new  RBlock();
        addObject(rBlock2, 1464, 646);
        RBlock rBlock3 =  new  RBlock();
        addObject(rBlock3, 1387, 721);
        RBlock rBlock4 =  new  RBlock();
        addObject(rBlock4, 1500, 571);
        RLongBlock rLongBlock =  new  RLongBlock();
        addObject(rLongBlock, 1015, 252);
        Spikes spikes =  new  Spikes();
        addObject(spikes, 276, 735);
        Spikes spikes2 =  new  Spikes();
        addObject(spikes2, 605, 735);
        Spikes spikes3 =  new  Spikes();
        addObject(spikes3, 950, 735);
        Spikes spikes4 =  new  Spikes();
        addObject(spikes4, 1049, 492);
        Spikes spikes5 =  new  Spikes();
        addObject(spikes5, 730, 492);
        Spikes spikes6 =  new  Spikes();
        addObject(spikes6, 393, 492);
        Spikes spikes7 =  new  Spikes();
        addObject(spikes7, 454, 202);
        Spikes spikes8 =  new  Spikes();
        addObject(spikes8, 748, 202);
        Spikes spikes9 =  new  Spikes();
        addObject(spikes9, 1066, 202);
        UpSpikes upSpikes =  new  UpSpikes();
        addObject(upSpikes, 895, 302);
        UpSpikes upSpikes2 =  new  UpSpikes();
        addObject(upSpikes2, 545, 302);
        UpSpikes upSpikes3 =  new  UpSpikes();
        addObject(upSpikes3, 764, 591);
        UpSpikes upSpikes4 =  new  UpSpikes();
        addObject(upSpikes4, 421, 591);
        Crown crown =  new  Crown();
        addObject(crown, 1414, 176);
    }
}
