import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor{
    public Text(String text){
        GreenfootImage speech = new GreenfootImage(text, 20, Color.GRAY, Color.WHITE);
        setImage(speech);
    }
}
