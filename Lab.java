import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lab extends World {
    Scroller scroller = null;
    public static final int WIDE = 610;
    public static final int HIGH = 400;
    public final int MAX_WIDE = 610;
    public final int MAX_HIGH = 621;
    Professor professor = new Professor();
    public boolean talkedToProfessor = false;
    Player player = new Player(43, 51);
    CollisionRectangle screen = new CollisionRectangle();
    
    int transparencyChange = 4;
    InteractionRectangle interaction = new InteractionRectangle();
    StarterBulbasaurSelection chooseBulbasaur = new StarterBulbasaurSelection();
    StarterBulbasaur bulbasaur = new StarterBulbasaur();
    StarterSquirtleSelection chooseSquirtle = new StarterSquirtleSelection();
    StarterSquirtle squirtle = new StarterSquirtle();
    StarterCharmanderSelection chooseCharmander = new StarterCharmanderSelection();
    StarterCharmander charmander = new StarterCharmander();
    public static int dialogue = 0;
    public int charmanderDialogue = 0;
    public int bulbasaurDialogue = 0;
    public int squirtleDialogue = 0;
    public boolean aDown;
    public boolean bDown;
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    PokeBall charmanderBall = new PokeBall();
    PokeBall squirtleBall = new PokeBall();
    PokeBall bulbasaurBall = new PokeBall();
    static boolean chosenStarter = false;
    static GreenfootImage bg = new GreenfootImage("Lab.png");
    
    public Lab() {
        super(WIDE, HIGH, 1, false);
        //PalletTown.music.stop();
        //music.play();
        dialogue = 0;
        scroller = new Scroller(this, bg, 610, 621);
        addCollisionRectangle(130, MAX_HIGH - 8, 270, 16);
        addCollisionRectangle(MAX_WIDE - 130, MAX_HIGH - 8, 270, 16);
        addCollisionRectangle(23, MAX_HIGH - 60, 40, 50);
        addCollisionRectangle(MAX_WIDE - 23, MAX_HIGH - 60, 40, 50);
        addCollisionRectangle(-8, MAX_HIGH/2, 16, MAX_HIGH);
        addCollisionRectangle(MAX_WIDE + 8, MAX_HIGH/2, 16, MAX_HIGH);
        addCollisionRectangle(MAX_WIDE/2, 35, MAX_WIDE, 70);
        addCollisionRectangle(MAX_WIDE/4 - 35, MAX_HIGH/2 + 80, 230, 70);
        addCollisionRectangle(3 * MAX_WIDE/4 + 35, MAX_HIGH/2 + 80, 230, 70);
        addCollisionRectangle(MAX_WIDE - 95, 50, 190, 100);
        addCollisionRectangle(139, 50, 278, 100);
        addCollisionRectangle(93, 215, 90, 100);
        addCollisionRectangle(MAX_WIDE - 165, 220, 140, 40);
        addCollisionRectangle(22, 175, 42, 75);
        NameSelection name = new NameSelection(Player.gender);
        addObject(player, MAX_WIDE/2, MAX_HIGH - 75);
        Door door = new Door();
        door.getImage().scale(30, 1);
        door.getImage().setTransparency(0); 
        addObject(door, MAX_WIDE/2, MAX_HIGH - 5);
        if(PalletTown.talkedToPalletProfessor == true) {
            addObject(professor, MAX_WIDE/2, 170);
            addCollisionRectangle(MAX_WIDE/2, 170, 40, 35);
        }
        GreenfootImage interactionImage = interaction.getImage();
        interactionImage.scale(8, 8);
        interactionImage.setTransparency(0); 
        addObject(interaction, MAX_WIDE/2, 200);
        addCollisionRectangle(MAX_WIDE/2, 170, 40, 35);
        makeImage();
        addObject(charmanderBall, MAX_WIDE/2 + 185, 222);
        addObject(chooseCharmander, MAX_WIDE/2 + 185, 242);
        addObject(squirtleBall, MAX_WIDE/2 + 140, 222);
        addObject(chooseSquirtle, MAX_WIDE/2 + 140, 242);
        addObject(bulbasaurBall, MAX_WIDE/2 + 95, 222);
        addObject(chooseBulbasaur, MAX_WIDE/2 + 95, 242);
        addObject(screen, MAX_WIDE/2, MAX_HIGH/2);
        screen.getImage().setTransparency(255);
        screen.getImage().scale(MAX_WIDE, MAX_HIGH);
    }
    
    public void addCollisionRectangle(int x, int y, int width, int height) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.getImage().scale(width, height);
        collisionRectangle.getImage().setTransparency(0); 
        addObject(collisionRectangle, x, y);
    }
    
    public void act() {
        if (chosenStarter) {
            if (Player.playerPokemonNames[0] == "Bulbasaur") {
                removeObject(bulbasaurBall);
            } else if (Player.playerPokemonNames[0] == "Squirtle") {
                removeObject(squirtleBall);
            } else if (Player.playerPokemonNames[0] == "Charmander") {
                removeObject(charmanderBall);
            }
        }
        Actor actorTouchingInteraction = interaction.getIntersectingObject(Player.class);
        if(PalletTown.firstTime == true && PalletTown.talkedToPalletProfessor == true) {
            if(Greenfoot.isKeyDown("A") && !aDown && actorTouchingInteraction != null && actorTouchingInteraction == player) {
                if(dialogue <= 7 && dialogue > 0) {
                    player.speed = 0;
                }
                dialogue++;
                aDown = true;
            } else if(!Greenfoot.isKeyDown("A")){
                aDown = false;
            }
            
            if(dialogue > 7){
                removeObjects(getObjects(SpeechBubble.class));
                player.speed = 3;
                talkedToProfessor = true;
                PalletTown.firstTime = true;
            }
            
            if (Greenfoot.isKeyDown("A") && !aDown && player.isTouching(chooseBulbasaur) && PalletTown.firstTime == true && talkedToProfessor == true && bulbasaurDialogue < 2) {
                addObject(bulbasaur, MAX_WIDE - 75, 325);
                bulbasaurDialogue++;
                player.speed = 0;
                aDown = true;
            } else if (Greenfoot.isKeyDown("A") && !aDown && player.isTouching(chooseCharmander) && PalletTown.firstTime == true && talkedToProfessor == true && charmanderDialogue < 2) {
                addObject(charmander, MAX_WIDE - 75, 325);
                charmanderDialogue++;
                player.speed = 0;
                aDown = true;
            } else if (Greenfoot.isKeyDown("A") && !aDown && player.isTouching(chooseSquirtle) && PalletTown.firstTime == true && talkedToProfessor == true && squirtleDialogue < 2) {
                addObject(squirtle, MAX_WIDE - 75, 325);
                squirtleDialogue++;
                player.speed = 0;
                aDown = true;
            } else if(!Greenfoot.isKeyDown("A")){
                aDown = false;
            }
            makeImage();
            if(bulbasaurDialogue == 1) {
                player.speed = 0;
                if(Greenfoot.isKeyDown("B") && player.isTouching(chooseBulbasaur) && PalletTown.firstTime == true && talkedToProfessor == true) {
                    bDown = true;
                    removeDialogueObjects();
                    bulbasaurDialogue = 0;
                    player.speed = 3;
                }
            }
            if(charmanderDialogue == 1) {
                player.speed = 0;
                if(Greenfoot.isKeyDown("B") && player.isTouching(chooseCharmander) && PalletTown.firstTime == true && talkedToProfessor == true) {
                    bDown = true;
                    removeDialogueObjects();
                    charmanderDialogue = 0;
                    player.speed = 3;
                }
            }
            if(squirtleDialogue == 1) {
                player.speed = 0;
                if(Greenfoot.isKeyDown("B") && player.isTouching(chooseSquirtle) && PalletTown.firstTime == true && talkedToProfessor == true) {
                    bDown = true;
                    removeDialogueObjects();
                    squirtleDialogue = 0;
                    player.speed = 3;
                }
            }
            if (!Greenfoot.isKeyDown("B")){
                bDown = false;
            }
            if (bulbasaurDialogue >= 2) {
                Player.playerPokemonNames[0] = "Bulbasaur";
                Player.playerItems[0] = new PookieBall();
                Player.playerItems[1] = new Potion();
                Player.howManyItems[0] = 5;
                Player.howManyItems[1] = 2;
                Player.playerPokemonLevels[0] = 10;
                Player.money += 500;
                chosenStarter = true;
                removeDialogueObjects();
                player.speed = 3;
                PalletTown.firstTime = false;
            }
            if (charmanderDialogue >= 2) {
                Player.playerPokemonNames[0] = "Charmander";
                Player.playerItems[0] = new PookieBall();
                Player.playerItems[1] = new Potion();
                Player.howManyItems[0] = 5;
                Player.howManyItems[1] = 2;
                Player.playerPokemonLevels[0] = 10;
                Player.money += 500;
                chosenStarter = true;
                removeDialogueObjects();
                player.speed = 3;
                PalletTown.firstTime = false;
            }
            if(squirtleDialogue >= 2) {
                Player.playerPokemonNames[0] = "Squirtle";
                Player.playerItems[0] = new PookieBall();
                Player.playerItems[1] = new Potion();
                Player.howManyItems[0] = 5;
                Player.howManyItems[1] = 2;
                Player.playerPokemonLevels[0] = 10;
                Player.money += 500;
                chosenStarter = true;
                removeDialogueObjects();
                player.speed = 3;
                PalletTown.firstTime = false;
            }
        }
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
    
    public void makeImage(){
        removeObjects(getObjects(Text.class));
        if(dialogue == 1) {
            SpeechBubble speechBubble = new SpeechBubble();
            addObject(speechBubble, getWidth()/2, 350);
            addObject(new Text("Oak: Oh, that's right, I told you"), getWidth()/2 - 52, 335);
            addObject(new Text("to come! Just wait!"), getWidth()/2 - 100, 360);
        } else if (dialogue == 2) {
            addObject(new Text("There are three Pookiémon here."), getWidth()/2 - 46, 335);
        } else if(dialogue == 3) {
            addObject(new Text("Haha!"), getWidth()/2 - 153, 335);
        } else if(dialogue == 4) {
            addObject(new Text("The Pookiémon are held inside"), getWidth()/2 - 50, 335);
            addObject(new Text("these Pookié BALLS"), getWidth()/2 - 99, 360);
        } else if(dialogue == 5) {
            addObject(new Text("When I was young, I was a serious"), getWidth()/2 - 38, 335);
            addObject(new Text("Pookiémon TRAINER."), getWidth()/2 - 92, 360);
        } else if(dialogue == 6) {
            addObject(new Text("But now, in my old age, I have"), getWidth()/2 - 53, 335);
            addObject(new Text("only these three left."), getWidth()/2 - 93, 360);
        } else if(dialogue == 7) {
            addObject(new Text("You can have one."), getWidth()/2 - 103, 335);
            addObject(new Text("Go on, choose!"), getWidth()/2 - 117, 360);
        }
        if(charmanderDialogue == 1) {
            SpeechBubble speechBubble = new SpeechBubble();
            addObject(speechBubble, getWidth()/2 - 75, 350);
            addObject(new Text("You want FIRE POOKIÉMON CHARMANDER?"), getWidth()/2 - 79, 335);
            addObject(new Text("A to Confirm, B to Choose Other"), getWidth()/2 - 125, 360);
        }
        if(squirtleDialogue == 1) {
            SpeechBubble speechBubble = new SpeechBubble();
            addObject(speechBubble, getWidth()/2 - 75, 350);
            addObject(new Text("You want WATER POOKIÉMON SQUIRTLE?"), getWidth()/2 - 79, 335);
            addObject(new Text("A to Confirm, B to Choose Other"), getWidth()/2 - 125, 360);
        }
        if(bulbasaurDialogue == 1) {
            SpeechBubble speechBubble = new SpeechBubble();
            addObject(speechBubble, getWidth()/2 - 75, 350);
            addObject(new Text("You want GRASS POOKIÉMON BULBASAUR?"), getWidth()/2 - 79, 335);
            addObject(new Text("A to Confirm, B to Choose Other"), getWidth()/2 - 125, 360);
        }
    }

    private void removeDialogueObjects() {
        removeObjects(getObjects(SpeechBubble.class));
        removeObjects(getObjects(StarterBulbasaur.class));
        removeObjects(getObjects(StarterCharmander.class));
        removeObjects(getObjects(StarterSquirtle.class));
        removeObjects(getObjects(Text.class));
    }
}
