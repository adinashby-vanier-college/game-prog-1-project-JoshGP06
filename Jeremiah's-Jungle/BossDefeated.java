import greenfoot.*;  

public class BossDefeated extends Actor
{
    private int shakeIntensity = 2;  
    private int shakeDuration = 5;   
    private int shakeTimer = 0;      

    private int originalX; 
    private int originalY; 

    /**
     * Act - do whatever the BossDefeated wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (originalX == 0 && originalY == 0) {
            originalX = getX();
            originalY = getY();
        }

        if (shakeTimer == 0) {
            shakeTimer = shakeDuration; 
        }

        if (shakeTimer > 0) {
            shakeTimer--;
            shakeEffect(); 
        }
    }

    public void shakeEffect()
    {
        int shakeOffset = Greenfoot.getRandomNumber(shakeIntensity * 2) - shakeIntensity;  
        setLocation(originalX + shakeOffset, originalY);
    }
}
