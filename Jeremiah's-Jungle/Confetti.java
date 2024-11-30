import greenfoot.*;  // Import the Greenfoot classes
import java.awt.Color;  // For setting text colors

// Confetti class - Represents a single piece of confetti
public class Confetti extends Actor
{
    private int speedX;  // Speed of movement in the X direction
    private int speedY;  // Speed of movement in the Y direction
    private GreenfootImage confettiImage;  // Confetti image with many pieces
    private int lifetime = 50;  // Confetti lifetime (in frames)

    public Confetti()
    {
        confettiImage = new GreenfootImage("confetti.png");  // Ensure you have this image in your project
        setImage(confettiImage);

        // Randomize the speed and direction of the confetti
        speedX = Greenfoot.getRandomNumber(6) - 3;  // Random X speed between -3 and 3
        speedY = Greenfoot.getRandomNumber(6) + 2;  // Random Y speed between 2 and 7 (to make it fall down)
    }

    public void act()
    {
        // Move the confetti based on the speed
        move();

        // Reduce lifetime and remove confetti if it exceeds its lifetime
        lifetime--;
        if (lifetime <= 0) {
            getWorld().removeObject(this);
        }
    }

    // Method to move the confetti
    private void move()
    {
        // Move the confetti by the speed values
        setLocation(getX() + speedX, getY() + speedY);
    }
}