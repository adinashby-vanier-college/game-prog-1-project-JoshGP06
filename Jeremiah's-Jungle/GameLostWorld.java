import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GameLostWorld extends World
{

    /**
     * Losing text
     */
    public GameLostWorld()
    {
        super(1500, 800, 1);
        GreenfootImage gameOverText =  new  GreenfootImage("GAME OVER", 128, Color.CYAN,  new  Color(0, 0, 0, 0));
        int width = gameOverText.getWidth();
        int height = gameOverText.getHeight();
        getBackground().drawImage(gameOverText, getWidth() / 2 - width / 2, getHeight() / 2 - height / 2);
        GreenfootImage youDiedText =  new  GreenfootImage("THERE'S A NEW KING IN THE JUNGLE!", 48, Color.WHITE,  new  Color(0, 0, 0, 0));
        getBackground().drawImage(youDiedText, getWidth() / 2 - youDiedText.getWidth() / 2, getHeight() / 2 + 100);
        prepare();
    }

    
    private void prepare()
    {
        BossWin bossWin =  new  BossWin();
        addObject(bossWin, 1264, 395);
        DefeatedJeremiah defeatedJeremiah =  new  DefeatedJeremiah();
        addObject(defeatedJeremiah, 159, 416);
        bossWin.setLocation(1224, 453);
        bossWin.setLocation(1184, 473);
        bossWin.setLocation(1264, 404);
        defeatedJeremiah.setLocation(217, 592);
        defeatedJeremiah.setLocation(261, 561);
        defeatedJeremiah.setLocation(278, 551);
        defeatedJeremiah.setLocation(295, 562);
        defeatedJeremiah.setLocation(273, 562);
        defeatedJeremiah.setLocation(156, 552);
        defeatedJeremiah.setLocation(206, 564);
        defeatedJeremiah.setLocation(173, 618);
        defeatedJeremiah.setLocation(84, 558);
    }
}
