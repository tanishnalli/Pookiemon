import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PookiemonGym here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gym extends World {
    Scroller scroller = null;
    public static final int WIDE = 601;
    public static final int HIGH = 400;
    public final int MAX_WIDE = 601;
    public final int MAX_HIGH = 742;
    Player player = new Player(43, 51);
    CollisionRectangle screen = new CollisionRectangle();
    int transparencyChange = 4;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    CollisionRectangle brock = new CollisionRectangle();
    CollisionRectangle brockBase = new CollisionRectangle();
    static InteractionRectangle startBattle = new InteractionRectangle();
    static GreenfootImage bg = new GreenfootImage("Gym.png");
    
    public Gym() {
        super(WIDE, HIGH, 1, false); 
        //PewterCity.music.stop();
        //music.play();
        scroller = new Scroller(this, bg, MAX_WIDE, MAX_HIGH);
        addObject(player, MAX_WIDE/2, MAX_HIGH - 70);
        screen.getImage().setTransparency(255);
        screen.getImage().scale(MAX_WIDE, MAX_HIGH);
        addCollisionRectangle(WIDE/2 - 92, HIGH + 152, WIDE/14, 90);
        addCollisionRectangle(WIDE/2 + 94, HIGH + 152, WIDE/14, 90);
        
        addCollisionRectangle(42, HIGH + 152, 5, MAX_HIGH + 400);
        addCollisionRectangle(MAX_WIDE - 42, HIGH + 152, 5, MAX_HIGH + 400);
        
        addCollisionRectangle(-WIDE / 15, HIGH + 302, MAX_WIDE , 5);
        addCollisionRectangle(640, HIGH + 302, MAX_WIDE , 5);
        
        addCollisionRectangle(300, HIGH + 312, 100 , 5);
        
        addCollisionRectangle(WIDE/10 + 5,WIDE / 2 - 68, 50 , 5);
        addCollisionRectangle(WIDE - 65,232, 50 , 5);
        addCollisionRectangle(115,182, 45 , 5);
        addCollisionRectangle(WIDE - 115,182, 45 , 5);
        
        addCollisionRectangle(90,207, 5 , 50);
        addCollisionRectangle(WIDE - 90,207, 5 , 50);
        addCollisionRectangle(135,162, 5 , 45);
        addCollisionRectangle(WIDE - 135,162, 5 , 45);
        
        addCollisionRectangle(202, 135, WIDE, 5);
        
        brockBase.getImage().scale(90, 50);
        brockBase.getImage().setTransparency(0); 
        addObject(brockBase, MAX_WIDE/2, MAX_HIGH/3 + 11);
        
        brock.setImage("Brock.png");
        addObject(brock, MAX_WIDE/2, MAX_HIGH/3);
        
        startBattle.getImage().scale(90, 65);
        startBattle.getImage().setTransparency(0); 
        addObject(startBattle, MAX_WIDE/2, MAX_HIGH/3 + 11);
        
        Door door = new Door();
        door.getImage().scale(30, 1);
        door.getImage().setTransparency(0);
        addObject(door, WIDE/2, 19 * MAX_HIGH/20);
        addObject(screen, MAX_WIDE/2, MAX_HIGH/2);
    }
    
    public void act() {
        if (screen.getImage().getTransparency() > 10) {
            screen.getImage().setTransparency(screen.getImage().getTransparency() - transparencyChange);
        } else {
            this.removeObject(screen);
        }
        if (player != null) {
            scroll();
        }
    }
    
    public void scroll() {
        scroller.scroll(player.getX() - WIDE / 2, player.getY() - HIGH / 2);
    }
    
    public void addCollisionRectangle(int x, int y, int width, int height) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width, height);
        collisionRectangle.getImage().setTransparency(0); 
        addObject(collisionRectangle, x, y);
    }
}