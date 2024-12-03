import greenfoot.*;  

public class Coconut extends Actor {
    private double verticalSpeed = 0; 
    private double gravity = 0.3; 

    public Coconut() {
        setImage("coconut.png");
    }

    public void act() {
        verticalSpeed += gravity;

        setLocation(getX(), (int) (getY() + verticalSpeed));

        if (getY() >= getWorld().getHeight()) {
            getWorld().removeObject(this);
        }
        
        removeObject();
        if (isGameLost()) {
            transitionToGameOver();
            Greenfoot.playSound("Missing Cap.wav"); 
        }
    }
    
    public void removeObject()
    {
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            World world = getWorld();
            world.removeObject(player);
            Greenfoot.playSound("coconut.mp3"); 
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
        World level3 = getWorld();
        level3.stopped();
        World gameLostWorld =  new GameLostWorld();
        Greenfoot.setWorld(gameLostWorld);
    }
}
