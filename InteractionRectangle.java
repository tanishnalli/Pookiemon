import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InteractionRectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InteractionRectangle extends Wall {
    public Actor getIntersectingObject(Class<?> Class) {
        return getOneIntersectingObject(Class);
    }
}