import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlWorld extends World
{
    GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    /**
     * Constructor for objects of class ControlWorld.
     * 
     */
    public ControlWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //music.play();
        makeImage();
    }
    public void act(){
        if(Greenfoot.isKeyDown("B")){
            music.stop();
            Greenfoot.setWorld(new StartScreen());
        }
    }
    
    public void makeImage(){
        GreenfootImage controlsImage = new GreenfootImage("controls.png");
        controlsImage.scale(getWidth(), getHeight()); 
        setBackground(controlsImage);
    }
}
