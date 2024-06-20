import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PokeBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PokeBall extends Actor
{
    /**
     * Act - do whatever the PokeBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage("Pokeball.png");
        if(getWorld().getClass() == Lab.class) {
            getImage().scale(30, 30);
        }
    }
}
