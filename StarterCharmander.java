import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StarterCharmander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StarterCharmander extends Actor
{
    /**
     * Act - do whatever the StarterCharmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public StarterCharmander() {
        GreenfootImage image = new GreenfootImage("StarterCharmander.png");
        image.scale(150, 150);
        setImage(image);
    }
}
