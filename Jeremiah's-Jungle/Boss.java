import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Boss extends Actor
{
    private boolean isJumping = false; 
    private boolean shouldStopJumping = false; 
    private int startX, startY; 
    private int targetX, targetY; 
    private int totalFrames = 90; 
    private int currentFrame = 0; 
    private int jumpPhase = 0; 
    private int waitTimer = 0; 
    private boolean isRemoved = false;
    private int start = 0;
    
    public void act()
    {   
        start++;
        if(start >= 90){
            if (!isRemoved) {
                if (!shouldStopJumping) {
                    checkCollisionWithFrog();
                    if (isJumping) {
                            performJump(); 
                        } else {
                            initiateJump(); 
                        }
                    } else {
                    if (jumpPhase > 4 && currentFrame >= totalFrames) {
                        waitTimer++; 
                        setImage("textBoss.png");
                        setLocation(1200,350);
                        
                        if (waitTimer >= 180) { 
                            getWorld().removeObject(this); 
                            isRemoved = true; 
                        }
                    }
                }
            }
        }
    }
    
    private void initiateJump() {
        startX = getX();
        startY = getY();

        if (jumpPhase == 0) {
            targetX = 200;
            targetY = 450; 
        } 
        else if (jumpPhase == 1) {
            targetX = 750;
            targetY = 450; 
        }
        else if (jumpPhase == 2) {
            targetX = 1331; 
            targetY = 450; 
        }
        else if (jumpPhase == 3) {
            targetX = 200; 
            targetY = 450; 
        }
        else if (jumpPhase == 4) {
            targetX = 1331; 
            targetY = 450; 
        }
        
        isJumping = true; 
        currentFrame = 0; 
    }

    private void performJump() {
        double t = (double) currentFrame / totalFrames;

        int x = (int) (startX + t * (targetX - startX));

        int peakHeight = 300; 
        int y = (int) (startY + t * (targetY - startY) - peakHeight * (1 - 4 * (t - 0.5) * (t - 0.5)));

        setLocation(x, y);

        currentFrame++;

        if (currentFrame >= totalFrames) {
            isJumping = false; 
            jumpPhase++; 

            if (jumpPhase > 4) {
                shouldStopJumping = true; 
            }
        } 
    }

    private void checkCollisionWithFrog() {
        Player frog = (Player) getOneIntersectingObject(Player.class);

        if (frog != null) {
            getWorld().removeObject(frog);

            World level3 = getWorld();
            level3.stopped();
            World gameLostWorld =  new GameLostWorld();
            Greenfoot.setWorld(gameLostWorld);
            Greenfoot.playSound("Missing Cap.wav"); 
        }
    }
    
}