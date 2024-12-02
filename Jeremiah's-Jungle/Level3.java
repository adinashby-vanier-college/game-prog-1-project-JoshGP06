import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Level3 extends World
{
    private GreenfootSound music;
    private int coconutSpawnTimer = 0; // Timer to control coconut spawning

    public Level3()
    {
        super(1500, 800, 1);
        music =  new  GreenfootSound("level3.WAV");
        prepare();
        act();
    }
    
    public void act() {
        spawnCoconuts(); // Handle coconut spawning
    }

    public void started()
    {
        music.playLoop();
    }
    public void stopped()
    {
        music.stop();
    }
    
    private void spawnCoconuts() {
        // Increment the spawn timer
        coconutSpawnTimer++;

        // Spawn a coconut every 100 frames (adjust for frequency)
        if (coconutSpawnTimer >= 30) {
            // Reset the timer
            coconutSpawnTimer = 0;

            // Generate a random x position at the top of the screen
            int randomX = Greenfoot.getRandomNumber(getWidth());

            // Add a new coconut at the random position
            addObject(new Coconut(), randomX, 0);
        }
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
