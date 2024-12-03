import greenfoot.*;

public class StartWorld extends World
{
    private int timer = 0;  
    private int gameState = 0;  

    private GreenfootImage titleImage;  
    private startButton startButton;    
    private GreenfootSound backgroundMusic; 
    private boolean musicStarted = false;  

    public StartWorld()
    {    
        super(1500, 800, 1);  

        GreenfootImage background = new GreenfootImage("loadingScreen.jpg");  
        background.scale(getWidth(), getHeight());  
        setBackground(background);  

        titleImage = new GreenfootImage("Title.png");  
        getBackground().drawImage(titleImage, getWidth() / 2 - titleImage.getWidth() / 2, getHeight() / 2 - titleImage.getHeight() / 2 - 150); // Center the title

        startButton = new startButton();
        addObject(startButton, getWidth() / 2, getHeight() / 2 + 100);  
        backgroundMusic = new GreenfootSound("Loading Music.wav");
        prepare();
    }

    public void act()
    {
        if (!musicStarted) {
            backgroundMusic.playLoop();  
            musicStarted = true;  
        }
        if (gameState == 0) {
            if (Greenfoot.mouseClicked(startButton)) {
                startGame();  
            }
        }
        else if (gameState == 1) {
            
            removeObject(startButton);  

            showLoadingText();

            if (timer >= 300) {
                transitionToLevel1();
            }
            timer++;  
        }
    }

    public void startGame() {
        gameState = 1;  
        timer = 0;  
    }

    private void showLoadingText() {
        showText("Loading... Please wait", getWidth() / 2, getHeight() / 2);  
    }

    private void transitionToLevel1() {
        World level1 = new Level1();  
        Greenfoot.setWorld(level1);  
        level1.started();
        backgroundMusic.stop(); 
    }
    
    private void prepare()
    {
        Info info = new Info();
        addObject(info,717,713);
        info.setLocation(782,683);
        info.setLocation(760,689);
        info.setLocation(753,688);
        info.setLocation(754,685);
        info.setLocation(747,701);
        info.setLocation(739,707);
        info.setLocation(757,690);
        info.setLocation(748,705);
        info.setLocation(742,691);
        info.setLocation(755,704);
    }
}
