import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBag extends World {
    int tab = 0;
    CollisionRectangle bagImage = new CollisionRectangle();
    CollisionRectangle speech = new CollisionRectangle();
    BagTabs batTag = new BagTabs();
    boolean isPressed = false;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    public PlayerBag() {    
        super(617, 412, 1);
        
        setBackground("BagTab/BagScreen.png");
        bagImage.setImage("BagTab/ItemsBag.png");
        batTag.setImage("BagTab/ItemsTab.png");
        speech.setImage("SpeechBubble.png");
        addObject(bagImage, getWidth()/6, 13 * getHeight()/30);
        addObject(batTag, 43 * getWidth()/240, 59 * getHeight()/600);
        addObject(speech, 340 * getWidth()/600, 507 * getHeight()/600);
        bagImage.getImage().scale(168, 168);
        speech.getImage().scale(510, 85);
        showText("←, →, ↑ & ↓ to navigate    B to exit", 340 * getWidth()/600, 507 * getHeight()/600);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("B")) {
            //Greenfoot.setWorld(new Battle(0, 0, 0, 0, 0));
        }
        if (!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")) {
            isPressed = false;
        }
        if (!isPressed) {
            setTab();
        }
        if (tab == 0) {
            bagImage.setImage("BagTab/ItemsBag.png");
            batTag.setImage("BagTab/ItemsTab.png");            
        } else if (tab == 1) {
            bagImage.setImage("BagTab/KeyItemsBag.png");
            batTag.setImage("BagTab/KeyItemsTab.png");
        } else if (tab == 2) {
            bagImage.setImage("BagTab/PokeballsBag.png");
            batTag.setImage("BagTab/PokeballsTab.png");
        }
        bagImage.getImage().scale(168, 168);
        speech.getImage().scale(510, 85);
        showText("←, →, ↑ & ↓ to navigate    B to exit", 340 * getWidth()/600, 507 * getHeight()/600);
    }
    
    public void setTab() {
        if (tab == 0 && Greenfoot.isKeyDown("right")) {
            isPressed = true;
            tab = 1;
        } else if (tab == 1 && Greenfoot.isKeyDown("left")) {
            isPressed = true;
            tab = 0;
        } else if (tab == 1 && Greenfoot.isKeyDown("right")) {
            isPressed = true;
            tab = 2;
        } else if (tab == 2 && Greenfoot.isKeyDown("left")) {
            isPressed = true;
            tab = 1;
        }
    }
}