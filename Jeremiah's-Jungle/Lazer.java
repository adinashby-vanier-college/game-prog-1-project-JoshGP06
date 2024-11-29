import greenfoot.*;  // Import the Greenfoot library

public class Lazer extends Actor
{
    private int timer = 0;  // Timer to track the time elapsed
    private boolean visible = true;  // To track visibility of the laser
    
    public void act() 
    {
        removeObject();
        if (isGameLost()) {
            transitionToGameOver();
            Greenfoot.playSound("Missing Cap.wav"); 
        }
        timer++;  // Increment the timer every act step
        timer();
    }
    
    public void timer()
    {
        // Every 120 acts (which is equivalent to about 2 seconds if the world is running at 60fps)
        if (timer % 100 == 0) {
            if (visible) {
                setImage("invisible.png");  // Change image to an invisible one (or you can remove it)
                visible = false;
            } else {
                setImage("lazer.png");  // Set image back to visible (make sure to have a laser image)
                visible = true;
            }
        }
    }

    public void removeObject()
    {
        if (visible) {  // Only check for intersection when the laser is visible
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
            //level1.stopped();
            World gameLostWorld =  new GameLostWorld();
            //gameOverWorld.started();
            Greenfoot.setWorld(gameLostWorld);
                 if(level2 instanceof Level2){
            level2.stopped(); 
        }
    }
}
