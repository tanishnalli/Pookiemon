import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StarterBulbasaur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StarterBulbasaurSelection extends Wall
{
    /**
     * Act - do whatever the StarterBulbasaur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StarterBulbasaurSelection() {
        GreenfootImage image = getImage();
        image.scale(8, 8);
        image.setTransparency(0);
        setImage(image);
    }
}
