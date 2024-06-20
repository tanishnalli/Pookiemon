import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World{
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    public StartScreen(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //music.play();
        makeStart();
        orangeRectangle();
        redRectangle();
        
        addText("©2024 SKIBIDI OHIO inc.", getWidth()/2, getHeight() - 15, 24, Color.WHITE);
    }
    
    public void makeStart(){
        StartButton startButton = new StartButton();
        addObject(startButton, getWidth()/2 - 30, getHeight() - 70);
        GreenfootImage backgroundImage = new GreenfootImage("start.png");
        backgroundImage.scale(getWidth(), getHeight()); 
        setBackground(backgroundImage);
        
        ControllButton controllButton = new ControllButton();
        addObject(controllButton, getWidth()/2 - 230, getHeight() - 15);
    }
    
    public void orangeRectangle() {
        int rectWidth = getWidth();
        int rectHeight = 30;
        int rectX = getWidth() / 2;
        int rectY = 0;
        GreenfootImage background = getBackground();
        background.setColor(new Color(248, 88, 0));
        background.fillRect(rectX - rectWidth / 2, rectY, rectWidth, rectHeight);
    }
    
    public void redRectangle() {
        int rectWidth = getWidth();
        int rectHeight = 30;
        int rectX = getWidth() / 2;
        int rectY = getHeight() - 30;
        
        GreenfootImage background = getBackground();
        background.setColor(new Color(87, 4, 4));
        background.fillRect(rectX - rectWidth / 2, rectY, rectWidth, rectHeight);
    }
    
    public void addText(String text, int x, int y, int fontSize, Color color) {
        GreenfootImage textImage = new GreenfootImage(text, fontSize, color, new Color(0, 0, 0, 0));
        getBackground().drawImage(textImage, x - textImage.getWidth() / 2, y - textImage.getHeight() / 2);
    }
}
