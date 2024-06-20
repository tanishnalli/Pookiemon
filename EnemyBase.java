import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBaseCave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBase extends BattleObjects {
    public EnemyBase(int location) {
        if (location == 0) {
            setImage("Battle/BaseEnemyForest.png");
        } else if (location == 1) {
            setImage("Battle/BaseEnemyCave.png");
        }
    }
}