// WARNING: This file is auto-generated and any changes to it will be overwritten
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
        GreenfootImage textImage =  new  GreenfootImage("You Lost!", 128, Color.CYAN,  new  Color(0, 0, 0, 0));
        int width = textImage.getWidth();
        int height = textImage.getHeight();
        getBackground().drawImage(textImage, getWidth() / 2 - width / 2, getHeight() / 2 - height / 2);
    }
}
