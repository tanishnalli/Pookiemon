import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RivalHouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends World {
    Player player = new Player(43, 51);
    CollisionRectangle screen = new CollisionRectangle();
    int transparencyChange = 4;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    public House() {   
        super(600, 429, 1);
        //PewterCity.music.stop();
        //PalletTown.music.stop();
        //music.play();
        setBackground("House.png");
        addObject(player, getWidth()/2 - 93,  getHeight() - 80);
        addCollisionRectangle(getWidth()/2, 0, getWidth(), 120);
        addCollisionRectangle(86, 70, 172, 24);
        addCollisionRectangle(getWidth()/2 - 46, getHeight()/5 - 15, 28, 25);
        addCollisionRectangle(getWidth() - 36, getHeight()/5 - 10, 78, 30);
        addCollisionRectangle(23, getHeight()/2 + 150, 40, 50);
        addCollisionRectangle(getWidth() - 22, getHeight()/2 + 150, 40, 50);
        addCollisionRectangle(getWidth(), getHeight()/2, 1, getHeight());
        addCollisionRectangle(0, getHeight()/2, 1, getHeight());
        addCollisionRectangle(getWidth()/2, getHeight(), getWidth(), 1);
        addCollisionRectangle(getWidth()/2 + 23, getHeight()/2 + 5, 65, 58);
        addCollisionRectangle(85, getHeight() - 6, 140, 12);
        addCollisionRectangle(getWidth() - 178, getHeight() - 6, 320, 12);
        Door door = new Door();
        door.getImage().scale(30, 1);
        door.getImage().setTransparency(0); 
        addObject(door, getWidth()/2 - 93, getHeight() - 5);
        addObject(screen, getWidth()/2, getHeight()/2);
        screen.getImage().setTransparency(255);
        screen.getImage().scale(getWidth(), getHeight());
    }
    
    public void addCollisionRectangle(int x, int y, int width, int height) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width, height);
        collisionRectangle.getImage().setTransparency(0); 
        addObject(collisionRectangle, x, y);
    }

    public void act() {
        if (screen.getImage().getTransparency() > 10) {
            screen.getImage().setTransparency(screen.getImage().getTransparency() - transparencyChange);
        } else {
            this.removeObject(screen);
        }
    }
}
