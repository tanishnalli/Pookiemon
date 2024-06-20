import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Route1 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route1 extends World {
    public static final int WIDE = 602;
    public static final int HIGH = 400;
    public static final int MAX_WIDE = 602;
    public static final int MAX_HIGH = 997;
    Player player = new Player(29, 34);
    int transparencyChange = 4;
    Scroller scroller = null;
    static CollisionRectangle screen = new CollisionRectangle();
    
    static boolean[] itemTaken = {false,}, npcDone = {};
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    static GreenfootImage bg = new GreenfootImage("Route1.png");
    
    public Route1(int x, int y) {
        super(WIDE, HIGH, 1, false);
        //PalletTown.music.stop();
        //PewterCity.music.stop();
        //music.play();
        scroller = new Scroller(this, bg, MAX_WIDE, MAX_HIGH);
        addObject(player, x, y);
        screen.getImage().setTransparency(255);
        screen.getImage().scale(MAX_WIDE, MAX_HIGH);
        addCollisionRectangle(MAX_WIDE/4 - 4, MAX_HIGH - 50, 300, 80);
        addCollisionRectangle(3 * MAX_WIDE/4 + 25, MAX_HIGH - 50, 240, 80);
        addCollisionRectangle(25, MAX_HIGH/2, 50, MAX_HIGH);
        addCollisionRectangle(MAX_WIDE - 25, MAX_HIGH/2, 50, MAX_HIGH);
        addCollisionRectangle(MAX_WIDE/4 - 11, 25, 220, 50);
        addCollisionRectangle(3 * MAX_WIDE/4 + 8, 25, 220, 50);
        addCollisionRectangle(MAX_WIDE/4 + 73, 180, 50, 185);
        addCollisionRectangle(MAX_WIDE/2 + 23, MAX_HIGH/2 - 120, 150, 50);
        addCollisionRectangle(150, MAX_HIGH/2 + 132, 298, 50);
        addCollisionRectangle(75, MAX_HIGH/2 - 120, 50, 50);
        addCollisionRectangle(3 * MAX_WIDE/4, MAX_HIGH - 205, 400, 8);
        addCollisionRectangle(MAX_WIDE/6, MAX_HIGH - 205, 100, 8);
        addCollisionRectangle(6 * MAX_WIDE/7, 2 * MAX_HIGH/3 + 3, 125, 8);
        addCollisionRectangle(MAX_WIDE/4 + 22, 141, 450, 8);
        addCollisionRectangle(MAX_WIDE/5, 266, 150, 8);
        addCollisionRectangle(MAX_WIDE/4 + 25, MAX_HIGH/3 + 60, 150, 8);
        addCollisionRectangle(MAX_WIDE/8, MAX_HIGH/2 + 20, 50, 8);
        addCollisionRectangle(MAX_WIDE/4 + 23, MAX_HIGH/2 + 20, 90, 8);
        addCollisionRectangle(2 * MAX_WIDE/3 + 50, MAX_HIGH/2 + 20, 350, 8);
        PalletTownToRoute1 enterence1 = new PalletTownToRoute1();
        enterence1.getImage().scale(50, 5);
        enterence1.getImage().setTransparency(0);
        addObject(enterence1, MAX_WIDE/2 + 25, MAX_HIGH - 5);
        Route1ToPewterCity enterence2 = new Route1ToPewterCity();
        enterence2.getImage().scale(100, 5);
        enterence2.getImage().setTransparency(0);
        addObject(enterence2, MAX_WIDE/2, 5);
        addBush(MAX_WIDE/2 + 102, MAX_HIGH/5 + 12, 300, 125);
        addBush(MAX_WIDE/2 + 177, MAX_HIGH/3 + 52, 150, 125);
        addBush(MAX_WIDE/2 + 25, MAX_HIGH - 62, 50, 125);
        addBush(MAX_WIDE/4 + 37, MAX_HIGH - 172, 175, 50);
        addBush(MAX_WIDE/4 - 12, MAX_HIGH - 122, 175, 50);
        addBush(3 * MAX_WIDE/4 - 12, MAX_HIGH - 122, 125, 50);
        addBush(3 * MAX_WIDE/4 + 37, MAX_HIGH - 172, 125, 50);
        addBush(MAX_WIDE/2 + 77, MAX_HIGH/2 + 167, 150, 125);
        addObject(screen, MAX_WIDE/2, MAX_HIGH/2);
    }
    
    public void act() {
        Player.beforeY = scroller.getScrolledY() + HIGH/2;
        if (Player.beforeY >= MAX_HIGH - HIGH/2) {
            Player.beforeY = scroller.getScrolledY() + player.getY();
        } else if (Player.beforeY <= HIGH/2) {
            Player.beforeY = player.getY();
        }
        if (screen.getImage().getTransparency() > 10) {
            screen.getImage().setTransparency(screen.getImage().getTransparency() - transparencyChange);
        } else {
            screen.getImage().setTransparency(0);
            this.removeObject(screen);
        }
        scroll();
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
    
    public void addBush(int x, int y, int width, int height) {
        TallGrass bush = new TallGrass();
        bush.getImage().scale(width, height);
        bush.getImage().setTransparency(0);
        addObject(bush, x, y);
    }
}