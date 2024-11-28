import greenfoot.*;

public class LoadingScreen extends World
{
    private int timer = 0;  // Timer to track time until transition

    public LoadingScreen()
    {    
        super(1500, 800, 1);  // Set the size of the world (width, height, cell size)
        showLoadingScreen();
    }

    public void act()
    {
        timer++;  // Increment the timer on each act

        // Transition to Level 1 after 5 seconds (300 frames)
        if (timer >= 300) {
            transitionToLevel1();
        }
    }

    // Display a loading message on the screen
    private void showLoadingScreen()
    {
        showText("Loading... Please wait", getWidth() / 2, getHeight() / 2);  // Show loading text
    }

    // Transition to Level 1
    private void transitionToLevel1()
    {
        World level1 = new Level1();  // Replace with your actual Level 1 class
        Greenfoot.setWorld(level1);  // Set the world to Level 1
    }
}
