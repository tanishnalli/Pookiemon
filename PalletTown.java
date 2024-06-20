import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PalletTown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PalletTown extends World {
    Scroller scroller = null;
    public static final int WIDE = 600;
    public static final int HIGH = 400;
    int transparencyChange = 4;
    public final int MAX_WIDE = 809;
    public final int MAX_HIGH = 676;
    Player player = new Player(31, 36);
    static Door myDoor = new Door();
    static Door rivalDoor = new Door();
    static Door labDoor = new Door();
    static Professor professor = new Professor();
    CollisionRectangle screen = new CollisionRectangle();
    InteractionRectangle interaction = new InteractionRectangle();
    static PalletTownToRoute1 entrance = new PalletTownToRoute1();
    public static boolean firstTime = true;
    public boolean aDown;
    public int dialogue = 0;
    static PalletTownToRoute1 enterence = new PalletTownToRoute1();
    CollisionRectangle entranceCollisionRectangle = new CollisionRectangle();
    static boolean[] itemTaken = {false,}, npcDone = {};
    public static boolean talkedToPalletProfessor = false;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    static GreenfootImage bg = new GreenfootImage("PalletTown.png");
    
    public PalletTown() {    
        super(WIDE, HIGH, 1, false);
        //Route1.music.stop();
        //PlayerHouseLevelOne.music.stop();
        //Lab.music.stop();
        //House.music.stop();
        //music.play();
        scroller = new Scroller(this, bg, MAX_WIDE, MAX_HIGH);
        if (Player.previousWorld == PlayerHouseLevelOne.class) {
            addObject(player, MAX_WIDE/4 + 17, MAX_HIGH/3 + 62);
        } else if (Player.previousWorld == House.class) {
            addObject(player, 2 * MAX_WIDE/3 - 17, MAX_HIGH/3 + 62);
        } else if (Player.previousWorld == Lab.class) {
            addObject(player, 2 * MAX_WIDE/3 + 17, MAX_HIGH/2 + 152);
        } else if (Player.previousWorld == Route1.class) {
            addObject(player, MAX_WIDE/2 + 35, 50);
        }
        addObject(player, getWidth()/4 + 68, getHeight()/2 + 86);
        addCollisionRectangle(200, 35, MAX_WIDE/2, 70);
        addCollisionRectangle(610, 35, MAX_WIDE/3, 70);
        addCollisionRectangle(MAX_WIDE/2, MAX_HIGH - 15, MAX_WIDE, 30);
        addCollisionRectangle(35, MAX_HIGH/2, 70, MAX_HIGH);
        addCollisionRectangle(MAX_WIDE - 35, MAX_HIGH/2, 70, MAX_HIGH);
        addCollisionRectangle(MAX_WIDE/4 + 50, MAX_HIGH/2 + 50, 160, 30);
        addCollisionRectangle(MAX_WIDE/4 - 17, MAX_HIGH/2 + 150, 25, 25);
        addCollisionRectangle(MAX_WIDE/4 + 100, MAX_HIGH - 50, 120, 95);
        addCollisionRectangle(MAX_WIDE/6 + 17, MAX_HIGH/2 - 90, 20, 40);
        addCollisionRectangle(MAX_WIDE/2 + 51, MAX_HIGH/2 - 90, 20, 40);
        addCollisionRectangle(MAX_WIDE/2 + 135, MAX_HIGH - 118, 200, 30);
        addCollisionRectangle(MAX_WIDE/4 + 52, MAX_HIGH/3 - 50, 160, 115);
        addCollisionRectangle(MAX_WIDE/4 - 15, MAX_HIGH/2 - 90, 25, 40);
        addCollisionRectangle(MAX_WIDE/3 + 17, MAX_HIGH/2 - 90, 96, 40);
        addCollisionRectangle(MAX_WIDE/4 + 355, MAX_HIGH/3 - 50, 160, 115);
        addCollisionRectangle(MAX_WIDE/4 + 288, MAX_HIGH/2 - 90, 25, 40);
        addCollisionRectangle(MAX_WIDE/3 + 320, MAX_HIGH/2 - 90, 96, 40);
        addCollisionRectangle(MAX_WIDE/4 + 355, MAX_HIGH/2 + 42, 234, 110);
        addCollisionRectangle(MAX_WIDE/4 + 286, MAX_HIGH/2 + 112, 96, 40);
        addCollisionRectangle(MAX_WIDE/4 + 423, MAX_HIGH/2 + 112, 96, 40);
        myDoor.getImage().scale(32, 6);
        myDoor.getImage().setTransparency(0); 
        addObject(myDoor, MAX_WIDE/4 + 17, MAX_HIGH/3 + 35);
        rivalDoor.getImage().scale(32, 6);
        rivalDoor.getImage().setTransparency(0); 
        addObject(rivalDoor, 2 * MAX_WIDE/3 - 17, MAX_HIGH/3 + 35);
        labDoor.getImage().scale(32, 6);
        labDoor.getImage().setTransparency(0); 
        addObject(labDoor, 2 * MAX_WIDE/3 + 17, 2 * MAX_HIGH/3 + 11);
        entrance.getImage().scale(50, 5);
        entrance.getImage().setTransparency(0); 
        addObject(entrance, MAX_WIDE/2 + 30, 1);
        GreenfootImage interactionImage = interaction.getImage();
        interactionImage.scale(8, 8);
        interactionImage.setTransparency(0); 
        addObject(interaction, MAX_WIDE/2 + 34, 42);
        makeImage();
        if(firstTime == true && talkedToPalletProfessor == false) {
            addObject(professor, MAX_WIDE/2 + 34, 20);
            entranceCollisionRectangle.getImage().scale(50, 21);
            entranceCollisionRectangle.getImage().setTransparency(0); 
            addObject(entranceCollisionRectangle, MAX_WIDE/2 + 34, 23);
        }
        if(talkedToPalletProfessor == true) {
            entranceCollisionRectangle.getImage().scale(50, 21);
            entranceCollisionRectangle.getImage().setTransparency(0); 
            addObject(entranceCollisionRectangle, MAX_WIDE/2 + 34, 23);
            removeObjects(getObjects(Professor.class));
        }
        if(firstTime == false) {
            removeObject(interaction);
            removeObject(entranceCollisionRectangle);
            removeObjects(getObjects(Professor.class));
        }
        addObject(screen, MAX_WIDE/2, MAX_HIGH/2);
        screen.getImage().setTransparency(255);
        screen.getImage().scale(MAX_WIDE, MAX_HIGH);
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
        if(firstTime == true && talkedToPalletProfessor == false) {
            Actor actorTouchingInteraction = interaction.getIntersectingObject(Player.class);
            if(Greenfoot.isKeyDown("A") && !aDown && actorTouchingInteraction != null && actorTouchingInteraction == player) {
                if(dialogue <= 5) {
                    player.speed = 0;
                }
                dialogue++;
                aDown = true;
            } else if(!Greenfoot.isKeyDown("A")){
                aDown = false;
            }
            if(dialogue == 4){
                removeObjects(getObjects(SpeechBubble.class));
                addObject(screen, MAX_WIDE/2, MAX_HIGH/2);
                screen.getImage().setTransparency(255);
                screen.getImage().scale(MAX_WIDE, MAX_HIGH);
                removeObjects(getObjects(Professor.class));
            }
            if(dialogue >= 5) {
                talkedToPalletProfessor = true;
                player.speed = 3;
            }
        }
        makeImage();
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
    
    public void makeImage(){
        removeObjects(getObjects(Text.class));
        if(dialogue == 1){
            SpeechBubble speechBubble = new SpeechBubble();
            addObject(speechBubble, getWidth()/2, 350);
            addObject(new Text("Oak: It's unsafe to go outside!"), getWidth()/2 - 58, 335);
            addObject(new Text("Wild Pookiémon live in tall grass!"), getWidth()/2 - 45, 360);
        }else if (dialogue == 2){
            addObject(new Text("You need your own Pookiémon for"), getWidth()/2 - 37, 335);
            addObject(new Text("your protection."), getWidth()/2 - 113, 360);
        } else if (dialogue == 3){
            addObject(new Text("I know!"), getWidth()/2 - 150, 335);
            addObject(new Text("Here, come meet me in the laboratory!"), getWidth()/2 - 26, 360);
        } 
    }
}