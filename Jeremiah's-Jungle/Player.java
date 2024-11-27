import greenfoot.*;

public class Player extends Actor
{
    private int speed = 6;         // Horizontal movement speed
    private int jumpSpeed = -15;   // Jumping speed (negative to move upwards)
    private int gravity = 1;       // Gravity to pull the player down
    private int verticalSpeed = -10; // Vertical speed for jumping and gravity
    private boolean onGround = true; // Check if the player is on the ground
    
    public void act()
    {
        moveLeftRight();      // Handle horizontal movement
        applyGravity();       // Apply gravity (fall if in the air)
        jump();               // Handle jumping
        checkCollisions();    // Check for collisions (ground, ceiling, etc.)
        take();
        if (isGameWon()) {
            transitionToTransition1();
            Greenfoot.playSound("Win sound.wav"); 
        }
    }
    
    public boolean isGameWon()
    {
        World world = getWorld();
        if (world.getObjects(Crown.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void transitionToTransition1()
    {
        World level1 = getWorld();
        //level1.stopped();
        World transition1 =  new  Transition1();
        //gameWonWorld.started();
        Greenfoot.setWorld(transition1);
    }
    
    public void take()
    {
        Actor crown = getOneIntersectingObject(Crown.class);
        if (crown != null) {
            World world = getWorld();
            world.removeObject(crown);
            //Greenfoot.playSound("eating.wav");
        }
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
        else if (!isLLongBlockBlocked(newX, getY()))  // Check if the new position is blocked
        {
            setLocation(newX, getY());  // Move left if no collision
        }
    }

    // Check if the player can move right without colliding with a block
    private void moveRight()
    {
        int newX = getX() + speed;
        if (!isRBlockBlocked(newX, getY()))  // Check if the new position is blocked
        {
            setLocation(newX, getY());  // Move right if no collision
        }
        else if (!isRLongBlockBlocked(newX, getY()))  // Check if the new position is blocked
        {
            setLocation(newX, getY());  // Move left if no collision
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
        if (Greenfoot.isKeyDown("space") && onGround == true)  // Only jump if on the ground
        {
            verticalSpeed = jumpSpeed;  // Apply jump speed (move upwards)
            onGround = false;  // Player is in the air after jumping
            Greenfoot.playSound("jump.wav"); 
        }
    }

    // Check if the player is colliding with any Block at a specific position
    private boolean isLBlockBlocked(int newX, int newY)
    {
        Actor lBlock = getOneObjectAtOffset(newX - getX() - 75/2, newY - getY(), LBlock.class);
        return lBlock != null;  // If there is a block, return true
    }
    private boolean isRBlockBlocked(int newX, int newY)
    {
        Actor rBlock = getOneObjectAtOffset(newX - getX() + 75/2, newY - getY(), RBlock.class);
        return rBlock != null;  // If there is a block, return true
    }
    private boolean isLLongBlockBlocked(int newX, int newY)
    {
        Actor lLongBlock = getOneObjectAtOffset(newX - getX() - 75/2, newY - getY(), LLongBlock.class);
        return lLongBlock != null;  // If there is a block, return true
    }
    private boolean isRLongBlockBlocked(int newX, int newY)
    {
        Actor rLongBlock = getOneObjectAtOffset(newX - getX() + 75/2, newY - getY(), RLongBlock.class);
        return rLongBlock != null;  // If there is a block, return true
    }
    private boolean isGroundBlocked(int newX, int newY)
    {
        Actor ground = getOneObjectAtOffset(newX - getX(), newY - getY()-15, Ground.class);
        return ground != null;  // If there is a block, return true
    }
        
    // Check if the player is colliding with the ground or ceiling
    private void checkCollisions()
    {
        boolean wasOnGround = onGround;  // Save the previous onGround state
    
        // Check if the player is colliding with an LBlock below (for landing)
        if (isLBlockBlocked(getX(), getY() + 75 / 2))  // Check if there's an LBlock directly below
        {
            // Adjust player's vertical position so they land on top of the block
            while (isLBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  // Move up by 1 pixel to find the top of the block
            }
            onGround = true;  // The player is on the ground
            verticalSpeed = 0;  // Stop downward movement (gravity)
        }
        else if (isLLongBlockBlocked(getX(), getY() + 75 / 2))  // Check if there's an LLongBlock directly below
        {
            // Adjust player's vertical position so they land on top of the block
            while (isLLongBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  // Move up by 1 pixel to find the top of the block
            }
            onGround = true;  // The player is on the ground
            verticalSpeed = 0;  // Stop downward movement (gravity)
        }
        else if (isGroundBlocked(getX(), getY() + 75 / 2))  // Check if there's an LLongBlock directly below
        {
            // Adjust player's vertical position so they land on top of the block
            while (isGroundBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  // Move up by 1 pixel to find the top of the block
            }
            onGround = true;  // The player is on the ground
            verticalSpeed = 0;  // Stop downward movement (gravity)
        }
        else if (isRBlockBlocked(getX(), getY() + 75 / 2))  // Check if there's an LBlock directly below
        {
            // Adjust player's vertical position so they land on top of the block
            while (isRBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  // Move up by 1 pixel to find the top of the block
            }
            onGround = true;  // The player is on the ground
            verticalSpeed = 0;  // Stop downward movement (gravity)
        }
        else if (isRLongBlockBlocked(getX(), getY() + 75 / 2))  // Check if there's an LLongBlock directly below
        {
            // Adjust player's vertical position so they land on top of the block
            while (isRLongBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  // Move up by 1 pixel to find the top of the block
            }
            onGround = true;  // The player is on the ground
            verticalSpeed = 0;  // Stop downward movement (gravity)
        }
        else
        {
            onGround = false;  // Player is in the air
        }
        
    
        // Check if the player is colliding with a ceiling (if jumping)
        if (isLBlockBlocked(getX(), getY() - 75 / 2))  // Check if there's an LBlock directly above
        {
            verticalSpeed = 0;  // Stop upward movement if hitting the ceiling
        }
        else if (isLLongBlockBlocked(getX(), getY() - 75 / 2))  // Check if there's an LLongBlock directly above
        {
            verticalSpeed = 0;  // Stop upward movement if hitting the ceiling
        }
        else if (isGroundBlocked(getX(), getY() - 75 / 2))  // Check if there's an LBlock directly above
        {
            verticalSpeed = 0;  // Stop upward movement if hitting the ceiling
        }
        else if (isRBlockBlocked(getX(), getY() - 75 / 2))  // Check if there's an LBlock directly above
        {
            verticalSpeed = 0;  // Stop upward movement if hitting the ceiling
        }
        else if (isRLongBlockBlocked(getX(), getY() - 75 / 2))  // Check if there's an LLongBlock directly above
        {
            verticalSpeed = 0;  // Stop upward movement if hitting the ceiling
        }
    
        // If the player was on the ground and just left the ground, reset the vertical speed
        if (wasOnGround && !onGround) {
            verticalSpeed = 0;  // Reset vertical speed when leaving the ground
        }
    }
}
