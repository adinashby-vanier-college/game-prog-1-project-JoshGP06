import greenfoot.*;

public class Player extends Actor
{
    private int speed = 5;         // Horizontal movement speed
    private int jumpSpeed = -12;   // Jumping speed (negative to move upwards)
    private int gravity = 1;       // Gravity to pull the player down
    private int verticalSpeed = 0; // Vertical speed for jumping and gravity
    private boolean onGround = false; // Check if the player is on the ground

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
        if (!isBlockBlocked(newX, getY()))  // Check if the new position is blocked
        {
            setLocation(newX, getY());  // Move left if no collision
        }
    }

    // Check if the player can move right without colliding with a block
    private void moveRight()
    {
        int newX = getX() + speed;
        if (!isBlockBlocked(newX, getY()))  // Check if the new position is blocked
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
        if (Greenfoot.isKeyDown("space") && onGround)  // Only jump if on the ground
        {
            verticalSpeed = jumpSpeed;  // Apply jump speed (move upwards)
            onGround = false;  // Player is in the air after jumping
        }
    }

    // Check if the player is colliding with any BarrierBlock at a specific position
    private boolean isBlockBlocked(int newX, int newY)
    {
        Actor block = getOneObjectAtOffset(newX - getX() -25, newY - getY(), Block.class);
        return block != null;  // If there is a block, return true
    }

    // Check if the player is colliding with the ground or ceiling
    private void checkCollisions()
    {
        // Check for collision with the ground (or a block below the player)
        if (isBlockBlocked(getX(), getY() + 25))  // Check if there's a block directly below
        {
            onGround = true;  // The player is on the ground
            verticalSpeed = 0;  // Stop downward movement (gravity)
        }
        else
        {
            onGround = false;  // Player is in the air
        }

        // Check if the player is colliding with a ceiling (if jumping)
        if (isBlockBlocked(getX(), getY() - 25))  // Check if there's a block directly above
        {
            verticalSpeed = 0;  // Stop upward movement if hitting the ceiling
        }
    }
}
