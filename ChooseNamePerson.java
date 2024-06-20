import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChooseNamePerson here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChooseNamePerson extends Actor {
    public ChooseNamePerson(String gender) {
        GreenfootImage player = new GreenfootImage("Boy.png");;
        if ((gender.toLowerCase()).equals("girl")) {
            player = new GreenfootImage("Girl.png");
        }
        setImage(player);
    }
}