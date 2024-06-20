import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBaseCave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBase extends BattleObjects {
    public PlayerBase(int location) {
        if (location == 0) {
            setImage("Battle/BasePlayerForest.png");
        } else if (location == 1) {
            setImage("Battle/BasePlayerCave.png");
        }
    }
}