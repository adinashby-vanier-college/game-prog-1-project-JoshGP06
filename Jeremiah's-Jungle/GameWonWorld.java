import greenfoot.*;  // Import the Greenfoot classes

/**
 * Winning screen for the game.
 */
public class GameWonWorld extends World
{
    private int confettiTimer = 0;
    private int maxConfetti = 25;  // Max number of confetti pieces on screen at once
    private int currentConfettiCount = 0;
    private GreenfootSound confettiSound;  // Sound to play when confetti spawns
    /**
     * Constructor for objects of class GameWonWorld.
     */
    public GameWonWorld()
    {
        // Set the background size and color
        super(1500, 800, 1);

        // Set the background image
        GreenfootImage background = new GreenfootImage("winScreen.png");
        
        // Scale the image to match the world size (1500 x 800 in this case)
        background.scale(getWidth(), getHeight());
        
        // Set the scaled image as the background
        setBackground(background);
        
        confettiSound = new GreenfootSound("confettiPop.mp3");

        // Create and display "YOU WIN!" text
        GreenfootImage youWinText = new GreenfootImage("YOU WIN!", 128, Color.YELLOW, new Color(0, 0, 0, 0));
        int width = youWinText.getWidth();
        int height = youWinText.getHeight();
        getBackground().drawImage(youWinText, getWidth() / 2 - width / 2, getHeight() / 2 - height / 2);
        addConfetti();

        // Create and display the subtitle "CONGRATULATIONS!" text
        GreenfootImage congratulationsText = new GreenfootImage("CONGRATULATIONS!", 48, Color.GREEN, new Color(0, 0, 0, 0));
        getBackground().drawImage(congratulationsText, getWidth() / 2 - congratulationsText.getWidth() / 2, getHeight() / 2 + 100);
        

        // Prepare additional elements if necessary
        prepare();
    }
        public void act()
    {
        // Continuously add confetti during the game won screen
        addConfetti();
    }
     private void addConfetti()
    {
        // Spawn confetti at random intervals, but ensure the total number of confetti on screen doesn't exceed the limit
        if (confettiTimer % 30 == 0 && currentConfettiCount < maxConfetti) {  // Every 20 frames and limit max confetti
            int x = Greenfoot.getRandomNumber(getWidth()); // Random X position
            int y = 0;  // Spawn at the top of the screen
            Confetti confetti = new Confetti();
            addObject(confetti, x, y);
            currentConfettiCount++;  // Increase the current confetti count
            confettiSound.play(); 
        }

        // Reset the timer and limit spawning after a certain amount of confetti
        confettiTimer++;

        // If confetti have been removed, adjust the current count
        if (currentConfettiCount > maxConfetti) {
            currentConfettiCount = maxConfetti;
        }
    }

    /**
     * Prepare the world for the start of the program.
     * In this case, no actors are needed, but you can add any other elements here.
     */
    private void prepare() 
    {
        // You can add more objects or effects here, but for now, we'll leave it empty.
        VictoriousJeremiah victoriousJeremiah = new VictoriousJeremiah();
        addObject(victoriousJeremiah,1215,404);
        victoriousJeremiah.setLocation(1204,410);
        WinCrown winCrown = new WinCrown();
        addObject(winCrown,1173,216);
        BossDefeated bossDefeated = new BossDefeated();
        addObject(bossDefeated,248,382);
    }
}
