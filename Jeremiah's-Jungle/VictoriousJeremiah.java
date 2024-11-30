import greenfoot.Actor;

public class VictoriousJeremiah extends Actor
{
    private int rotationSpeed = 2;
    private int rotationAngle = 0;
    private int maxRotation = 15;
    private int minRotation = -15;

    public VictoriousJeremiah()
    {
    
    }

    public void act()
    {
        // Perform the slight rotating effect to simulate laughing
        rotateEffect();
    }

    // Slight rotation effect to simulate laughing
  private void rotateEffect()
    {
        if (rotationAngle >= maxRotation || rotationAngle <= minRotation) {
            rotationSpeed =  - rotationSpeed;
        }
        rotationAngle = rotationAngle + rotationSpeed;
        setRotation(rotationAngle);
    }
}
