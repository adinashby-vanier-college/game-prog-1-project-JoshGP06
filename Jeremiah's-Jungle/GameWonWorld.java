import greenfoot.*; 

/**
 * Winning screen for the game.
 */
public class GameWonWorld extends World
{
    private int confettiTimer = 0;
    private GreenfootSound music;
    private int maxConfetti = 25;  
    private int currentConfettiCount = 0;
    private GreenfootSound confettiSound;  
    /**
     * Constructor for objects of class GameWonWorld.
     */
    public GameWonWorld()
    {
        super(1500, 800, 1);
        
        music = new GreenfootSound("FinalWin.wav");
        music.playLoop(); 

        GreenfootImage background = new GreenfootImage("winScreen.png");
        
        background.scale(getWidth(), getHeight());
        
        setBackground(background);
        
        confettiSound = new GreenfootSound("confettiPop.mp3");

        GreenfootImage youWinText = new GreenfootImage("YOU WIN!", 128, Color.YELLOW, new Color(0, 0, 0, 0));
        int width = youWinText.getWidth();
        int height = youWinText.getHeight();
        getBackground().drawImage(youWinText, getWidth() / 2 - width / 2, getHeight() / 2 - height / 2);
        addConfetti();

        GreenfootImage congratulationsText = new GreenfootImage("CONGRATULATIONS!", 48, Color.GREEN, new Color(0, 0, 0, 0));
        getBackground().drawImage(congratulationsText, getWidth() / 2 - congratulationsText.getWidth() / 2, getHeight() / 2 + 100);
        

        prepare();
    }
        public void act()
    {
        addConfetti();
    }
     private void addConfetti()
    {
        if (confettiTimer % 30 == 0 && currentConfettiCount < maxConfetti) {  
            int x = Greenfoot.getRandomNumber(getWidth()); 
            int y = 0;  
            Confetti confetti = new Confetti();
            addObject(confetti, x, y);
            currentConfettiCount++; 
            confettiSound.play(); 
        }
        confettiTimer++;

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
        VictoriousJeremiah victoriousJeremiah = new VictoriousJeremiah();
        addObject(victoriousJeremiah,1215,404);
        victoriousJeremiah.setLocation(1204,410);
        WinCrown winCrown = new WinCrown();
        addObject(winCrown,1173,216);
        BossDefeated bossDefeated = new BossDefeated();
        addObject(bossDefeated,248,382);
    }
}
