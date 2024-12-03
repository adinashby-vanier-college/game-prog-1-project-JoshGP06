import greenfoot.*;

public class Player extends Actor
{
    private int dashCooldown = 0;  // Dash cooldown counter
    private final int DASH_COOLDOWN_TIME = 120;  // 2 seconds = 120 frames
    private int dashDistance = 80;  // Distance the player dashes
    private boolean isDashing = false;  // To track if the player is in the middle of a dash
    
    
    private int speed = 6;         // Horizontal movement speed
    private int jumpSpeed = -15;   // Jumping speed 
    private int gravity = 1;       // Gravity to pull the player down
    private int verticalSpeed = -10; // Vertical speed for jumping and gravity
    private boolean onGround = true; // Check if the player is on the ground
    
    public void act()
    {
        moveLeftRight();      
        applyGravity();      
        jump();               
        checkCollisions();    
        take();
        if (dashCooldown > 0) {
            dashCooldown--;  
        }
        
        if (Greenfoot.isKeyDown("shift") && dashCooldown == 0) {
            dash();
            dashCooldown = DASH_COOLDOWN_TIME; 
        }
        if (isGameWon1()) {
            transitionToTransition1();
            Greenfoot.playSound("Win sound.wav");
        }
        if (isGameWon2()) {
            transitionToTransition2();
            Greenfoot.playSound("Win sound.wav"); 
        }
        if (isGameWon3()) {
            transitionToGameWonWorld();
            Greenfoot.playSound("Win sound.wav"); 
        }
    }
    
    public boolean isGameWon1()
    {
        World world = getWorld();
        return world.getObjects(Crown.class).isEmpty();
    }
    
    public void transitionToTransition1()
    {
        World level1 = getWorld();
        if (level1 instanceof Level1) {
            level1.stopped();
            World transition1 = new Transition1();
            Greenfoot.setWorld(transition1);  
        }
    }
    
    public boolean isGameWon2()
    {
        World level2 = getWorld();
        return level2.getObjects(Crown.class).isEmpty();
    }
    
    public void transitionToTransition2()
    {
        World level2 = getWorld();
        if (level2 instanceof Level2) {
            level2.stopped(); 
            World transition2 = new Transition2();
            Greenfoot.setWorld(transition2);  
        }
    }
    
    public boolean isGameWon3()
    {
        World level3 = getWorld();
        return level3.getObjects(Crown.class).isEmpty();
    }
    
    public void transitionToGameWonWorld()
    {
        World level3 = getWorld();
        if (level3 instanceof Level3) {
            level3.stopped(); 
            World gameWonWorld = new GameWonWorld();
            Greenfoot.setWorld(gameWonWorld); 
        }
    }
    
    public void take()
    {
        Actor crown = getOneIntersectingObject(Crown.class);
        if (crown != null) {
            World world = getWorld();
            world.removeObject(crown);
        }
    }
    
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

    private void moveLeft()
    {
        int newX = getX() - speed;
        if (!isLBlockBlocked(newX, getY()))  
        {
            setLocation(newX, getY());  
        }
        else if (!isLLongBlockBlocked(newX, getY()))  
        {
            setLocation(newX, getY());  
        }
    }

    private void moveRight()
    {
        int newX = getX() + speed;
        if (!isRBlockBlocked(newX, getY()))  
        {
            setLocation(newX, getY());  
        }
        else if (!isRLongBlockBlocked(newX, getY()))  
        {
            setLocation(newX, getY());  
        }
    }

    private void applyGravity()
    {
        if (!onGround)  
        {
            verticalSpeed += gravity;
        }
        setLocation(getX(), getY() + verticalSpeed); 
    }

    private void jump()
    {
        if (Greenfoot.isKeyDown("space") && onGround == true)   
        {
            verticalSpeed = jumpSpeed;  
            onGround = false;  
            Greenfoot.playSound("jump.wav"); 
        }
    }
    
    private void dash() {
        if (!isDashing) {
            isDashing = true;
            int direction = (Greenfoot.isKeyDown("a")) ? -1 : (Greenfoot.isKeyDown("d")) ? 1 : 0;
            if (direction != 0) {
                setLocation(getX() + direction * dashDistance, getY());
            }
            Greenfoot.playSound("dash.wav");
            isDashing = false;
        }
    }

    private boolean isLBlockBlocked(int newX, int newY)
    {
        Actor lBlock = getOneObjectAtOffset(newX - getX() - 75/2, newY - getY(), LBlock.class);
        return lBlock != null;  
    }
    private boolean isRBlockBlocked(int newX, int newY)
    {
        Actor rBlock = getOneObjectAtOffset(newX - getX() + 75/2, newY - getY(), RBlock.class);
        return rBlock != null; 
    }
    private boolean isLLongBlockBlocked(int newX, int newY)
    {
        Actor lLongBlock = getOneObjectAtOffset(newX - getX() - 75/2, newY - getY(), LLongBlock.class);
        return lLongBlock != null;  
    }
    private boolean isRLongBlockBlocked(int newX, int newY)
    {
        Actor rLongBlock = getOneObjectAtOffset(newX - getX() + 75/2, newY - getY(), RLongBlock.class);
        return rLongBlock != null;  
    }
    private boolean isGroundBlocked(int newX, int newY)
    {
        Actor ground = getOneObjectAtOffset(newX - getX(), newY - getY()-15, Ground.class);
        return ground != null;  
    }
    private boolean isBigBlockBlocked(int newX, int newY)
    {
        Actor bigBlock = getOneObjectAtOffset(newX - getX(), newY - getY()-15, BigBlock.class);
        return bigBlock != null;  
    }
        
    private void checkCollisions()
    {
        boolean wasOnGround = onGround;  
    
        if (isLBlockBlocked(getX(), getY() + 75 / 2))  
        {
            while (isLBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1); 
            }
            onGround = true;  
            verticalSpeed = 0; 
        }
        else if (isLLongBlockBlocked(getX(), getY() + 75 / 2)) 
        {
            while (isLLongBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  
            }
            onGround = true;  
            verticalSpeed = 0;  
        }
        else if (isGroundBlocked(getX(), getY() + 75 / 2))  
        {
            while (isGroundBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  
            }
            onGround = true;  
            verticalSpeed = 0;  
        }
        else if (isRBlockBlocked(getX(), getY() + 75 / 2))  
        {
            while (isRBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  
            }
            onGround = true;  
            verticalSpeed = 0; 
        }
        else if (isRLongBlockBlocked(getX(), getY() + 75 / 2))  
        {
            while (isRLongBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  
            }
            onGround = true;  
            verticalSpeed = 0;  
        }
        else if (isBigBlockBlocked(getX(), getY() + 75 / 2))  
        {
            while (isBigBlockBlocked(getX(), getY() + 75 / 2)) {
                setLocation(getX(), getY() - 1);  
            }
            onGround = true;  
            verticalSpeed = 0;  
        }
        else
        {
            onGround = false;  
        }
        
    
        if (isLBlockBlocked(getX(), getY() - 75 / 2))  
        {
            verticalSpeed = 0;  
        }
        else if (isLLongBlockBlocked(getX(), getY() - 75 / 2))  
        {
            verticalSpeed = 0;  
        }
        else if (isGroundBlocked(getX(), getY() - 75 / 2))  
        {
            verticalSpeed = 0;  
        }
        else if (isRBlockBlocked(getX(), getY() - 75 / 2))  
        {
            verticalSpeed = 0;  
        }
        else if (isRLongBlockBlocked(getX(), getY() - 75 / 2))  
        {
            verticalSpeed = 0;  
        }
    
        if (wasOnGround && !onGround) {
            verticalSpeed = 0;  
        }
    }
}
