import greenfoot.*;

public class Player extends Actor
{
    private int speed = 5;         // Horizontal movement speed
    private int jumpSpeed = 40;   // Jumping speed (negative to move upwards)
    private int gravity = 1;       // Gravity to pull the player down
    private int verticalSpeed = -10; // Vertical speed for jumping and gravity
    private boolean onGround = true; // Check if the player is on the ground

    public void act()
    {
        moveLeftRight();      // Handle horizontal movement
        applyGravity();       // Apply gravity (fall if in the air)
        jump();               // Handle jumping
        checkCollisions();    // Check for collisions (ground, ceiling, etc.)
    }

    // Handle left-right movement
    private void moveLeftRight()
    {
        if (Greenfoot.isKeyDown("a"))
        {
            moveLeft();
        }
        else if (Greenfoot.isKeyDown("d"))
        {
            moveRight();
        }
    }

    // Check if the player can move left without colliding with a block
    private void moveLeft()
    {
        int newX = getX() - speed;
        if (!isLBlockBlocked(newX, getY()))  // Check if the new position is blocked
        {
            setLocation(newX, getY());  // Move left if no collision
        }
    }

    // Check if the player can move right without colliding with a block
    private void moveRight()
    {
        int newX = getX() + speed;
        if (!isLBlockBlocked(newX, getY()))  // Check if the new position is blocked
        {
            setLocation(newX, getY());  // Move right if no collision
        }
    }

    // Apply gravity: if not on the ground, pull the player down
    private void applyGravity()
    {
        if (!onGround)  // If the player is not on the ground, apply gravity
        {
            verticalSpeed += gravity;
        }
        setLocation(getX(), getY() + verticalSpeed);  // Update the vertical position based on speed
    }

    // Handle jumping: if on the ground, apply an upward speed
    private void jump()
    {
        if (Greenfoot.isKeyDown("w") && onGround == true)  // Only jump if on the ground
        {
            setLocation(getX(), getY() -5);
            verticalSpeed = -15;  // Apply jump speed (move upwards)
            onGround = false;  // Player is in the air after jumping
        }
    }

    // Check if the player is colliding with any BarrierBlock at a specific position
    private boolean isLBlockBlocked(int newX, int newY)
    {
        Actor lBlock = getOneObjectAtOffset(newX - getX() -25, newY - getY(), LBlock.class);
        return lBlock != null;  // If there is a block, return true
    }

    // Check if the player is colliding with the ground or ceiling
    private void checkCollisions()
    {
        // Check for collision with the ground (or a block below the player)
        if (isLBlockBlocked(getX(), getY() + 75/2))  // Check if there's a block directly below
        {
            onGround = true;  // The player is on the ground
            verticalSpeed = 0;  // Stop downward movement (gravity)
        }
        else
        {
            onGround = false;  // Player is in the air
        }

        // Check if the player is colliding with a ceiling (if jumping)
        if (isLBlockBlocked(getX(), getY() - 25))  // Check if there's a block directly above
        {
            verticalSpeed = 0;  // Stop upward movement if hitting the ceiling
        }
    }
}
