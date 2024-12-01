import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Boss extends Actor
{
    private boolean isJumping = false; // Whether the boss is currently jumping
    private boolean shouldStopJumping = false; // Flag to stop jumping after the final jump
    private int startX, startY; // Starting position of the jump
    private int targetX, targetY; // Target block position
    private int totalFrames = 90; // Number of frames to complete the jump
    private int currentFrame = 0; // Current frame in the jump animation
    private int jumpPhase = 0; // 0 = Right to Left, 1 = Left to Middle, 2 = Middle to Right
    private int waitTimer = 0; // Timer for the 3-second wait
    private boolean isRemoved = false; // Flag to track if the boss has been removed from the world
    private int start = 0;
    
    public void act()
    {   
        start++;
        if(start >= 90){
            if (!isRemoved) {
                if (!shouldStopJumping) {
                    checkCollisionWithFrog();
                    if (isJumping) {
                            performJump(); // Handle the jump animation
                        } else {
                            initiateJump(); // Begin the jump
                        }
                    } else {
                        // After the last jump, start the timer for a 3-second wait
                    if (jumpPhase > 4 && currentFrame >= totalFrames) {
                        waitTimer++; // Increase the wait timer
                        setImage("textBoss.png");
                        setLocation(1200,350);
                        
                        // If the wait time exceeds 3 seconds (assuming each frame is 1/60 second)
                        if (waitTimer >= 180) { // 180 frames = 3 seconds at 60 FPS
                            getWorld().removeObject(this); // Safely remove the boss after the wait
                            isRemoved = true; // Set the removed flag to prevent further actions
                        }
                    }
                }
            }
        }
    }
    
    private void initiateJump() {
        // Define the starting position as the current position
        startX = getX();
        startY = getY();

        // Determine the target position based on the current jump phase
        if (jumpPhase == 0) {
            // Jump from right block to left block
            targetX = 200; // X-coordinate of the left block
            targetY = 450; // Y-coordinate of the left block
        } 
        else if (jumpPhase == 1) {
            // Jump from left block to middle block
            targetX = 750; // X-coordinate of the middle block
            targetY = 450; // Y-coordinate of the middle block
        }
        else if (jumpPhase == 2) {
            // Jump from middle block to right block
            targetX = 1331; // X-coordinate of the right block
            targetY = 450; // Y-coordinate of the right block
        }
        else if (jumpPhase == 3) {
            // Jump from right block to left block
            targetX = 200; // X-coordinate of the left block
            targetY = 450; // Y-coordinate of the left block
        }
        else if (jumpPhase == 4) {
            // Jump from left block to right block
            targetX = 1331; // X-coordinate of the right block
            targetY = 450; // Y-coordinate of the right block
        }
        
        isJumping = true; // Start the jump
        currentFrame = 0; // Reset the animation frame
    }

    private void performJump() {
        // Calculate the interpolation factor (progress) from 0 to 1
        double t = (double) currentFrame / totalFrames;

        // Calculate the horizontal position (linear interpolation)
        int x = (int) (startX + t * (targetX - startX));

        // Calculate the vertical position (parabolic arc)
        int peakHeight = 300; // Adjust for how high the jump should go
        int y = (int) (startY + t * (targetY - startY) - peakHeight * (1 - 4 * (t - 0.5) * (t - 0.5)));

        // Set the boss's position
        setLocation(x, y);

        // Increment the animation frame
        currentFrame++;

        // End the jump when all frames are completed
        if (currentFrame >= totalFrames) {
            isJumping = false; // Stop the jump
            jumpPhase++; // Move to the next phase of the jump

            // If the boss has completed the jump to the right block (Phase 2), stop the jump
            if (jumpPhase > 4) {
                shouldStopJumping = true; // Set the flag to stop jumping
            }
        } 
    }

    private void checkCollisionWithFrog() {
        // Check for an intersecting frog
        Player frog = (Player) getOneIntersectingObject(Player.class);

        if (frog != null) {
            // If a frog is found, remove it from the world
            getWorld().removeObject(frog);

            // Transition to the LosingScreen world
            World level3 = getWorld();
            level3.stopped();
            World gameLostWorld =  new GameLostWorld();
            Greenfoot.setWorld(gameLostWorld);
            Greenfoot.playSound("Missing Cap.wav"); 
        }
    }
    
}