import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PookiemonGym here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PookiemonCenter extends World {
    public static final int WIDE = 600;
    public static final int HIGH = 399;
    Player player = new Player(43, 51);
    CollisionRectangle screen = new CollisionRectangle();
    int transparencyChange = 4;
    CenterNPC npc = new CenterNPC();
    static InteractionRectangle interaction = new InteractionRectangle();
    public boolean aDown;
    public static int dialogue = 0;
    OverlayText overlayText;
    EnterArrow enterArrow;
    BattleOverlay battleOverlay;
    boolean allowed = false;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    boolean playerHealed;
    
    public PookiemonCenter(boolean healed) {
        super(WIDE, HIGH, 1);
        //Battle.battleSound.stop();
        //PewterCity.music.stop();
        //music.play();
        setBackground("Center.png");
        if (healed) {
            addObject(player, WIDE/2, HIGH/2 - 20);
        } else {
            addObject(player, WIDE/2, HIGH - 70);
        }
        screen.getImage().setTransparency(255);
        screen.getImage().scale(WIDE, HIGH);
        addCollisionRectangle(0, HIGH/2, 1, HIGH);
        addCollisionRectangle(WIDE, HIGH/2, 1, HIGH);
        addCollisionRectangle(WIDE/2, HIGH - 15, WIDE, 40);
        addCollisionRectangle(WIDE/2, 80, 274, 120);
        addCollisionRectangle(WIDE/2, 40, WIDE, 40);
        addCollisionRectangle(WIDE/2 - 40, 60, 420, 40);
        addCollisionRectangle(30, 250, 100, 60);
        addCollisionRectangle(WIDE - 120, 270, 60, 40);
        Door door = new Door();
        door.getImage().scale(30, 1);
        door.getImage().setTransparency(0);
        addObject(door, getWidth()/2, 18 * getHeight()/20);
        interaction.getImage().scale(100, 10);
        interaction.getImage().setTransparency(0);
        addObject(interaction, getWidth()/2, getHeight()/3 + 25);
        npc.getImage().scale(50, 50);
        addObject(npc, WIDE/2, 85);
        addObject(screen, WIDE/2, HIGH/2);
    }
    
    public void act() {
        if (screen.getImage().getTransparency() > 10) {
            screen.getImage().setTransparency(screen.getImage().getTransparency() - transparencyChange);
        } else {
            this.removeObject(screen);
        }
        if (getObjects(CollisionRectangle.class).size() == 8) {
            heal();
        }
    }
    
    public void heal() {
        Actor actorTouchingInteraction = interaction.getIntersectingObject(Player.class);
        if (playerHealed || (Greenfoot.isKeyDown("A") && !aDown && actorTouchingInteraction != null && actorTouchingInteraction == player)) {
            battleOverlay = new BattleOverlay();
            overlayText = new OverlayText();
            enterArrow = new EnterArrow();
            removeObjects(getObjects(BattleOverlay.class));
            removeObjects(getObjects(OverlayText.class));
            removeObjects(getObjects(EnterArrow.class));
            overlayText.getImage().scale(getWidth(), 100);
            addObject(overlayText, getWidth()/2, getHeight() - battleOverlay.getImage().getHeight()/2);
            addObject(enterArrow, getWidth() - 35, getHeight() - battleOverlay.getImage().getHeight()/4);
            showText("I will fully heal your Pookiémon for you!", getWidth()/2, getHeight() - overlayText.getImage().getHeight()/2);
            player.speed = 0;
            dialogue++;
            aDown = true;
            playerHealed = false;
            player.playerPokemonHP[0] = player.playerPokemonMaxHP[0];
            player.playerPokemonHP[1] = player.playerPokemonMaxHP[1];
            player.playerPokemonHP[2] = player.playerPokemonMaxHP[2];
            if(dialogue == 2) {
                showText(". . . . .", getWidth()/2, getHeight() - overlayText.getImage().getHeight()/2);
            }
            if(dialogue == 3) {
                showText("Okay, I have completely healed them!", getWidth()/2, getHeight() - overlayText.getImage().getHeight()/2);
            }
        }
        if(!Greenfoot.isKeyDown("A")){
            aDown = false;
        } else {
            aDown = true;
        }
        if(dialogue > 3) {
            player.speed = 3;
            removeObjects(getObjects(BattleOverlay.class));
            removeObjects(getObjects(OverlayText.class));
            removeObjects(getObjects(EnterArrow.class));
            showText("", getWidth()/2, getHeight() - overlayText.getImage().getHeight()/2);
            dialogue = 0;
            allowed = false;
        }
    }
    
    public void addCollisionRectangle(int x, int y, int width, int height) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width, height);
        collisionRectangle.getImage().setTransparency(0);
        addObject(collisionRectangle, x, y);
    }
}