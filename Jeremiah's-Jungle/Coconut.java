import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Coconut extends Actor {
    private double verticalSpeed = 0; // Current vertical speed of the coconut
    private double gravity = 0.3; // Gravity constant to accelerate the fall

    public Coconut() {
        // Set the image for the coconut
        setImage("coconut.png");
    }

    public void act() {
        // Apply gravity to the vertical speed
        verticalSpeed += gravity;

        // Update the position of the coconut based on its speed
        setLocation(getX(), (int) (getY() + verticalSpeed));

        // Remove the coconut if it reaches the bottom of the screen
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
            Greenfoot.playSound("fire.mp3"); 
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
