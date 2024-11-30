import greenfoot.*;  // Import the Greenfoot classes

public class BossDefeated extends Actor
{
    private int shakeIntensity = 2;  // Intensity of shaking (larger numbers for stronger shakes)
    private int shakeDuration = 5;   // Duration of shake (number of frames it shakes)
    private int shakeTimer = 0;      // Timer to control shake duration

    private int originalX; // Original X position (so we don't move globally)
    private int originalY; // Original Y position (so we don't move globally)

    /**
     * Act - do whatever the BossDefeated wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Set the original position when the actor is first added to the world
        if (originalX == 0 && originalY == 0) {
            originalX = getX();
            originalY = getY();
        }

        // Handle shake effect
        if (shakeTimer == 0) {
            shakeTimer = shakeDuration;  // Start the shake duration
        }

        if (shakeTimer > 0) {
            shakeTimer--;
            shakeEffect(); // Apply the shake effect
        }
    }

    // Shake effect to add more anger to the motion
    public void shakeEffect()
    {
        // Apply a small random offset to simulate the shake effect visually
        int shakeOffset = Greenfoot.getRandomNumber(shakeIntensity * 2) - shakeIntensity;  // Random shake in both directions
        setLocation(originalX + shakeOffset, originalY); // Move the actor within a small range, keeping its original position intact
    }
}
