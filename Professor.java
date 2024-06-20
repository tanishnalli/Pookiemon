import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Professor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Professor extends Actor
{
    /**
     * Act - do whatever the Professor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean firstTime = true;
    public void act()
    {
        setImage("ProfessorDown.png");
        if(getWorld().getClass() == Lab.class) {
            getImage().scale(46, 43);
        }
    }
}
