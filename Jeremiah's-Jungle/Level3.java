import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Level3 extends World
{
    private GreenfootSound music;

    public Level3()
    {
        super(1500, 800, 1);
        music =  new  GreenfootSound("level3.WAV");
        prepare();
    }

    public void started()
    {
        music.playLoop();
    }
    public void stopped()
    {
        music.stop();
    }

    private void prepare()
    {
        BigBlock bigBlock =  new  BigBlock();
        addObject(bigBlock, 1250, 750);
        BigBlock bigBlock2 =  new  BigBlock();
        addObject(bigBlock2, 750, 750);
        BigBlock bigBlock3 =  new  BigBlock();
        addObject(bigBlock3, 250, 750);
        Player player = new Player();
        addObject(player,233,550);
        Fire fire = new Fire();
        addObject(fire,1315,729);
        Fire fire2 = new Fire();
        addObject(fire2,929,727);
        Fire fire3 = new Fire();
        addObject(fire3,542,725);
        Fire fire4 = new Fire();
        addObject(fire4,160,727);
        Crown crown = new Crown();
        addObject(crown,1400,100);
        Boss boss = new Boss();
        addObject(boss,1331,450);
    }
}
