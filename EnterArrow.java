import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnterArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnterArrow extends BattleObjects {
    int counter = 0;
    
    public EnterArrow() {
        setImage("Battle/TextTriangle0.png");
    }
    
    public void act() {
        counter++;
        if (counter % 20 == 0) {
            setImage("Battle/TextTriangle0.png");
        } else if (counter % 10 == 0 && counter % 20 != 0) {
            setImage("Battle/TextTriangle1.png");
        }
    }
}