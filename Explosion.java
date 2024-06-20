import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyGust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends BattleObjects {
    static String[] images = new String[7];
    int imageCounter = 0;
    int image = 0;
    
    public void act() {
        setImages();
        imageCounter++;
        if (imageCounter % 3 == 0) {
            setImage(images[image++]);
            if (image == 6) {
                getWorld().removeObject(this);
            }
        }
    }
    
    public void setImages() {
        images[0] = "Battle/BattleExplosion/0.png";
        images[1] = "Battle/BattleExplosion/1.png";
        images[2] = "Battle/BattleExplosion/2.png";
        images[3] = "Battle/BattleExplosion/3.png";
        images[4] = "Battle/BattleExplosion/4.png";
        images[5] = "Battle/BattleExplosion/5.png";
        images[6] = "Battle/BattleExplosion/6.png";
    }
}