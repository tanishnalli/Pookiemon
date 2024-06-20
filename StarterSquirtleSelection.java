import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StarterSquirtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StarterSquirtleSelection extends Wall
{
    /**
     * Act - do whatever the StarterSquirtle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StarterSquirtleSelection() {
        GreenfootImage image = getImage();
        image.scale(8, 8);
        image.setTransparency(0);
        setImage(image);
    }
}
