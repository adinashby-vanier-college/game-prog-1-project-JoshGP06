import greenfoot.*;

public class StartWorld extends World
{
    private int timer = 0;  // Timer to track time until transition to Level 1
    private int gameState = 0;  // Game state tracker (0: showing title, 1: showing loading text, 2: transitioning to level)

    private GreenfootImage titleImage;  // To display the game title
    private startButton startButton;    // The start button
    private GreenfootSound backgroundMusic; // To hold the music
    private boolean musicStarted = false;  // Flag to check if music has started

    // Constructor to set up the world
    public StartWorld()
    {    
        super(1500, 800, 1);  // Set the size of the world (width, height, cell size)

        // Set the background image (this is done only once)
        GreenfootImage background = new GreenfootImage("loadingScreen.jpg");  // Load the background image
        background.scale(getWidth(), getHeight());  // Scale the background to fit the world size
        setBackground(background);  // Set the scaled background image

        // Load and display the game title
        titleImage = new GreenfootImage("Title.png");  
        getBackground().drawImage(titleImage, getWidth() / 2 - titleImage.getWidth() / 2, getHeight() / 2 - titleImage.getHeight() / 2 - 150); // Center the title

        // Create and add the Start button
        startButton = new startButton();
        addObject(startButton, getWidth() / 2, getHeight() / 2 + 100);  // Position the button below the title
        backgroundMusic = new GreenfootSound("Loading Music.wav");
        prepare();
    }

    // Act method to handle actions and transitions
    public void act()
    {
        if (!musicStarted) {
            backgroundMusic.playLoop();  // Start the music loop
            musicStarted = true;  // Set the flag so the music only starts once
        }
        if (gameState == 0) {
            // Show the title and start button
            // No transition, just waiting for the button click
            if (Greenfoot.mouseClicked(startButton)) {
                startGame();  // Start the game when the start button is clicked
            }
        }
        else if (gameState == 1) {
            // Remove the start button (but keep the background intact)
            removeObject(startButton);  // Remove the start button actor from the world

            // Show the loading text in the center of the screen
            showLoadingText();

            // Transition to Level 1 after 5 seconds (300 frames)
            if (timer >= 300) {
                transitionToLevel1();
            }
            timer++;  // Increment the timer
        }
    }

    // Called when the start button is clicked
    public void startGame() {
        gameState = 1;  // Change the state to show loading screen
        timer = 0;  // Reset the timer
    }

    // Display the loading text
    private void showLoadingText() {
        showText("Loading... Please wait", getWidth() / 2, getHeight() / 2);  // Show loading text at the center
    }

    // Transition to Level 1
    private void transitionToLevel1() {
        World level1 = new Level1();  // Replace with your actual Level 1 class
        Greenfoot.setWorld(level1);  // Set the world to Level 1
        level1.started();
        backgroundMusic.stop(); 
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
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
