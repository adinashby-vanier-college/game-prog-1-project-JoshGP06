import greenfoot.*; 

public class Lazer extends Actor
{
    private int timer = 0;  
    private boolean visible = true;  
    
    public void act() 
    {
        removeObject();
        if (isGameLost()) {
            transitionToGameOver();
            Greenfoot.playSound("Missing Cap.wav"); 
        }
        timer++;  
        timer();
    }
    
    public void timer()
    {
        if (timer % 100 == 0) {
            if (visible) {
                setImage("invisible.png");  
                visible = false;
            } else {
                setImage("lazer.png");  
                visible = true;
            }
        }
    }

    public void removeObject()
    {
        if (visible) {  
            Actor player = getOneIntersectingObject(Player.class);
            if (player != null) {
                World world = getWorld();
                world.removeObject(player);
                Greenfoot.playSound("lazer.mp3"); 
            }
        }
    }
    
    public boolean isGameLost()
    {
        World world = getWorld();
        if (world.getObjects(Player.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void transitionToGameOver()
    {
            World level2 = getWorld();
            World gameLostWorld =  new GameLostWorld();
            Greenfoot.setWorld(gameLostWorld);
                 if(level2 instanceof Level2){
            level2.stopped(); 
        }
    }
}
