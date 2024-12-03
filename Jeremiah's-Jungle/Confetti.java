import greenfoot.*;  
import java.awt.Color;  

public class Confetti extends Actor
{
    private int speedX;  
    private int speedY;  
    private GreenfootImage confettiImage;  
    private int lifetime = 50;  

    public Confetti()
    {
        confettiImage = new GreenfootImage("confetti.png");  
        setImage(confettiImage);

        speedX = Greenfoot.getRandomNumber(6) - 3;  
        speedY = Greenfoot.getRandomNumber(6) + 2;  
    }

    public void act()
    {
        move();

        lifetime--;
        if (lifetime <= 0) {
            getWorld().removeObject(this);
        }
    }

    private void move()
    {
        setLocation(getX() + speedX, getY() + speedY);
    }
}