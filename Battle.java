import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Battle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battle extends World {
    static int location = 0;
    static int enemyPokemon = 0;
    static int playerPokemon = 0;
    static int enemy = 0;
    OverlayText overlayText = new OverlayText();
    BattleOverlay battleOverlay = new BattleOverlay();
    EnemyBase enemyBase;
    PlayerBase playerBase;
    EnterArrow enterArrow = new EnterArrow();
    int aCounter = 0;
    boolean allowedA = false;
    int allowedACounter = 0;
    int changeACounterBy = 1;
    boolean safe = false;
    boolean ran;
    boolean canUseMove = false;
    boolean myTurn = true;
    Pokemon enemyPokemonKind = new Pokemon();
    String enemyPokemonName = "";
    Pokemon playerPokemonKind = new Pokemon();
    String playerPokemonName = "";
    boolean canUseItem = false;
    int ball;
    boolean canShowEnemyText = false;
    Bar enemyBar;
    Bar playerBar;
    boolean usedItem = false;
    boolean usedMove = false;
    boolean catching = false;
    boolean exploded = false;
    static int enemyLevel;
    static int enemyHP;
    boolean isFirstTime = true;
    int catchingCounter = 0;
    boolean caught = false;
    static GreenfootSound battleSound = new GreenfootSound("WorldWildBattle.mp3");
    boolean playerFainted = false;
    boolean switched = false;
    boolean usedPookieBall = false;
    boolean usedUltraBall = false;
    boolean enemyFainted = false;
    boolean aDown = false;
    
    public Battle(int loc, int ePok, int pPok) {    
        super(600, 500, 1);
        //Route1.music.stop();
        //battleSound.play();
        
        if (location == 0) {
            enemyLevel = Greenfoot.getRandomNumber(3) + 5;
        } else {
            enemyLevel = 18;
        }
        
        location = loc;
        enemyPokemon = ePok;
        playerPokemon = pPok;
        
        enemyBase = new EnemyBase(location);
        playerBase = new PlayerBase(location);
        
        addObject(enemyBase, 3 * getWidth()/4, getHeight()/3);
        addObject(playerBase, getWidth()/3, getHeight() - (battleOverlay.getImage().getHeight() + playerBase.getImage().getHeight()/2));
        overlayText.getImage().scale(456, 100);
        addObject(battleOverlay, getWidth()/2, getHeight() - battleOverlay.getImage().getHeight()/2);
        addObject(overlayText, 227, getHeight() - battleOverlay.getImage().getHeight()/2);
        addObject(enterArrow, 3 * getWidth()/4 - 25, getHeight() - battleOverlay.getImage().getHeight()/4);
        
        if (location == 0) {
            setBackground("BackBattleWildForest.png");
        } else if (location == 1) {
            setBackground("BackBattleWildCave.png");
        }
        if (enemyPokemon == 0) {
            enemyPokemonName = "Articuno";
            enemyPokemonKind = new Articuno(enemyLevel, true);
            Articuno.hp = Articuno.maxhp;
            addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
            enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
            showText("lvl " + Articuno.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
        } else if (enemyPokemon == 1) {
            enemyPokemonName = "Mew";
            enemyPokemonKind = new Mew(enemyLevel, true);
            Mew.hp = Mew.maxhp;
            addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
            enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
            showText("lvl " + Mew.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
        } else if (enemyPokemon == 2) {
            enemyPokemonName = "Mewtwo";
            enemyPokemonKind = new Mewtwo(enemyLevel, true);
            Mewtwo.hp = Mewtwo.maxhp;
            addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
            enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
            showText("lvl " + Mewtwo.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
        } else if (enemyPokemon == 3) {
            enemyPokemonName = "Moltres";
            enemyPokemonKind = new Moltres(enemyLevel, true);
            Moltres.hp = Moltres.maxhp;
            addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
            enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
            showText("lvl " + Moltres.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
        } else if (enemyPokemon == 4) {
            enemyPokemonName = "Zapdos";
            enemyPokemonKind = new Zapdos(enemyLevel, true);
            Zapdos.hp = Zapdos.maxhp;
            addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
            enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
            showText("lvl " + Zapdos.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
        } else if (enemyPokemon == 5) {
            enemyPokemonName = "Geodude";
            enemyPokemonKind = new Geodude(enemyLevel, true);
            Geodude.hp = Geodude.maxhp;
            addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
            enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
            showText("lvl " + Geodude.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
        } else if (enemyPokemon == 6) {
            enemyPokemonName = "Kabutops";
            enemyPokemonKind = new Kabutops(enemyLevel, true);
            Kabutops.hp = Kabutops.maxhp;
            addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
            enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
            showText("lvl " + Kabutops.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
        } else if (enemyPokemon == 7) {
            enemyPokemonName = "Onix";
            enemyPokemonKind = new Onix(enemyLevel, true);
            Onix.hp = Onix.maxhp;
            addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
            enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
            showText("lvl " + Onix.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
        }
        if (playerPokemon == 0) {
            playerPokemonName = "Bulbasaur";
            playerPokemonKind = new Bulbasaur();
            addObject(playerPokemonKind, getWidth()/3, getHeight() - (battleOverlay.getImage().getHeight() + playerBase.getImage().getHeight() * 3/5) - 1);
            playerPokemonKind.getImage().scale(playerPokemonKind.getImage().getWidth()/2, playerPokemonKind.getImage().getHeight()/2);
        } else if (playerPokemon == 1) {
            playerPokemonName = "Squirtle";
            playerPokemonKind = new Squirtle();
            addObject(playerPokemonKind, getWidth()/3, getHeight() - (battleOverlay.getImage().getHeight() + playerBase.getImage().getHeight() * 3/5) - 6);
            playerPokemonKind.getImage().scale(playerPokemonKind.getImage().getWidth()/2, playerPokemonKind.getImage().getHeight()/2);
        } else if (playerPokemon == 2) {
            playerPokemonName = "Charmander";
            playerPokemonKind = new Charmander();
            addObject(playerPokemonKind, getWidth()/3, getHeight() - (battleOverlay.getImage().getHeight() + playerBase.getImage().getHeight() * 3/5) - 17);
            playerPokemonKind.getImage().scale(playerPokemonKind.getImage().getWidth()/2, playerPokemonKind.getImage().getHeight()/2);
        } else if (playerPokemon == 3) {
            playerPokemonName = "Articuno";
            playerPokemonKind = new Articuno(Player.playerPokemonLevels[0], false);
            addObject(playerPokemonKind, getWidth()/3, getHeight() - (battleOverlay.getImage().getHeight() + playerBase.getImage().getHeight() * 3/5) - 13);
            playerPokemonKind.getImage().scale(playerPokemonKind.getImage().getWidth()/2, playerPokemonKind.getImage().getHeight()/2);
        } else if (playerPokemon == 4) {
            playerPokemonName = "Mew";
            playerPokemonKind = new Mew(Player.playerPokemonLevels[0], false);
            addObject(playerPokemonKind, getWidth()/3, getHeight() - (battleOverlay.getImage().getHeight() + playerBase.getImage().getHeight() * 3/5) - 38);
            playerPokemonKind.getImage().scale(playerPokemonKind.getImage().getWidth()/2, playerPokemonKind.getImage().getHeight()/2);
        } else if (playerPokemon == 5) {
            playerPokemonName = "Mewtwo";
            playerPokemonKind = new Mewtwo(Player.playerPokemonLevels[0], false);
            addObject(playerPokemonKind, getWidth()/3, getHeight() - (battleOverlay.getImage().getHeight() + playerBase.getImage().getHeight() * 3/5) - 38);
            playerPokemonKind.getImage().scale(playerPokemonKind.getImage().getWidth()/2, playerPokemonKind.getImage().getHeight()/2);
        } else if (playerPokemon == 6) {
            playerPokemonName = "Moltres";
            playerPokemonKind = new Moltres(Player.playerPokemonLevels[0], false);
            addObject(playerPokemonKind, getWidth()/3, getHeight() - (battleOverlay.getImage().getHeight() + playerBase.getImage().getHeight() * 3/5) - 34);
            playerPokemonKind.getImage().scale(playerPokemonKind.getImage().getWidth()/2, playerPokemonKind.getImage().getHeight()/2);
        } else if (playerPokemon == 7) {
            playerPokemonName = "Zapdos";
            playerPokemonKind = new Zapdos(Player.playerPokemonLevels[0], false);
            addObject(playerPokemonKind, getWidth()/3, getHeight() - (battleOverlay.getImage().getHeight() + playerBase.getImage().getHeight() * 3/5) - 16);
            playerPokemonKind.getImage().scale(playerPokemonKind.getImage().getWidth()/2, playerPokemonKind.getImage().getHeight()/2);
        }
        
        addObject(new EnemyBoard(enemyPokemonKind), (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/2, getHeight()/5);
        addObject(new PlayerBoard(enemyPokemonKind), getWidth() - (new PlayerBoard(enemyPokemonKind)).getImage().getWidth()/2, 3 * getHeight()/5);
        enemyBar = new Bar(false);
        playerBar = new Bar(true);
        enemyBar.getImage().scale(100 * getEnemyHP()/(15 + enemyLevel * 2), 6);
        addObject(enemyBar, (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/2, getHeight()/5 + 6);
        playerBar.getImage().scale(100 * Player.playerPokemonHP[0]/Player.playerPokemonMaxHP[0], 6);
        addObject(playerBar, getWidth() - (new PlayerBoard(playerPokemonKind)).getImage().getWidth()/2 - 50 + playerBar.getImage().getWidth()/2, 3 * getHeight()/5);
        showText(Player.playerPokemonHP[0] + "/" + Player.playerPokemonMaxHP[0], getWidth() - (new PlayerBoard(enemyPokemonKind)).getImage().getWidth()/2, 3 * getHeight()/5 + 20);
        showText(playerPokemonName, getWidth() - (new PlayerBoard(enemyPokemonKind)).getImage().getWidth()/2, 3 * getHeight()/5 - 20);
        showText("lvl " + Player.playerPokemonLevels[0], getWidth() - (new PlayerBoard(enemyPokemonKind)).getImage().getWidth()/7, 3 * getHeight()/5);
        showText(enemyPokemonName, (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
    }
    
    public void act() {
        if (!Greenfoot.isKeyDown("A")) {
            aDown = false;
        }
        if (Player.playerPokemonHP[0] <= 0) {
            Player.playerPokemonHP[0] = 0;
            playerFainted = true;
        }
        if (playerFainted && Greenfoot.isKeyDown("A")) {
            Player.playerPokemonMaxHP[0] = 15 + Player.playerPokemonLevels[0] * 2;
            Player.playerPokemonHP[0] = Player.playerPokemonMaxHP[0];
            Greenfoot.setWorld(new PookiemonCenter(true));
        }
        if (enemyFainted && Greenfoot.isKeyDown("A") && !aDown) {
            win();
        }
        if (caught && Greenfoot.isKeyDown("A")) {
            win();
        }
        showText(Player.playerPokemonHP[0] + "/" + Player.playerPokemonMaxHP[0], getWidth() - (new PlayerBoard(enemyPokemonKind)).getImage().getWidth()/2, 3 * getHeight()/5 + 20);
        showText(playerPokemonName, getWidth() - (new PlayerBoard(enemyPokemonKind)).getImage().getWidth()/2, 3 * getHeight()/5 - 20);
        showText("lvl " + Player.playerPokemonLevels[0], getWidth() - (new PlayerBoard(enemyPokemonKind)).getImage().getWidth()/7, 3 * getHeight()/5);
        removeObjects(getObjects(CollisionRectangle.class));
        ball = Pookiemons.onMe;
        allowedACounter+=changeACounterBy;
        if (getObjects(Moves.class).size() > 0) {
            addMoves();
        }
        if (catching) {
            catchPokemon();
        } else {
            if (canShowEnemyText && myTurn && Greenfoot.isKeyDown("A") && getObjects(Attacks.class).size() == 0) {
                removeObjects(getObjects(OverlayText.class));
                removeObjects(getObjects(EnterArrow.class));
                removeObjects(getObjects(Buttons.class));
                showText(" ", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                if (usedItem) {
                    addItems();
                } else if (usedMove) {
                    addMoves();
                }
                canShowEnemyText = false;
                usedItem = false;
                usedMove = false;
            }
            if (myTurn) {
                myTurnBattle();
            } else if (!enemyFainted) {
                opponentTurnBattle();
            }
            if (getObjects(Moves.class).size() == 4 && (getObjects(Items.class).size() == 0 || getObjects(Null.class).size() == 0)) {
                addMoves();
            }
            enemyBar.setLocation((new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/2 - 50 + enemyBar.getImage().getWidth()/2, getHeight()/5 + 6);
            playerBar.setLocation(getWidth() - (new PlayerBoard(playerPokemonKind)).getImage().getWidth()/2 - 50 + playerBar.getImage().getWidth()/2, 3 * getHeight()/5);
            if (isFirstTime) {
                enemyBar.getImage().scale(100, 6);
                if (enemyPokemon == 0) {
                    Articuno.hp = 15 + Articuno.level * 2;
                } else if (enemyPokemon == 1) {
                    Mew.hp = 15 + Mew.level * 2;
                } else if (enemyPokemon == 2) {
                    Mewtwo.hp = 15 + Mewtwo.level * 2;
                } else if (enemyPokemon == 3) {
                    Moltres.hp = 15 + Moltres.level * 2;
                } else if (enemyPokemon == 4) {
                    Zapdos.hp = 15 + Zapdos.level * 2;
                } else if (enemyPokemon == 5) {
                    Geodude.hp = 15 + Geodude.level * 2;
                } else if (enemyPokemon == 6) {
                    Kabutops.hp = 15 + Kabutops.level * 2;
                } else if (enemyPokemon == 7) {
                    Onix.hp = 15 + Onix.level * 2;
                }
            }
        }
    }
    
    public void myTurnBattle() {
        if (getObjects(Items.class).size() > 0) {
            if (Buttons.onMe == 0 && getObjectsAt(getWidth()/2 + getWidth()/15, getHeight() - getHeight()/7, PookieBall.class).size() > 0) {
                showText("You have \n" + Player.howManyItems[0], battleOverlay.getImage().getWidth() - 72, getHeight() - battleOverlay.getImage().getHeight()/2);
            } else if (Buttons.onMe == 1 && getObjectsAt(getWidth()/5 - 5, getHeight() - getHeight()/7, Potion.class).size() > 0) {
                showText("You have \n" + Player.howManyItems[1], battleOverlay.getImage().getWidth() - 72, getHeight() - battleOverlay.getImage().getHeight()/2);
            } else if (Buttons.onMe == 2 && getObjectsAt(getWidth()/5 - 5, getHeight() - getHeight()/20, SuperPotion.class).size() > 0) {
                showText("You have \n" + Player.howManyItems[2], battleOverlay.getImage().getWidth() - 72, getHeight() - battleOverlay.getImage().getHeight()/2);
            } else if (Buttons.onMe == 3 && getObjectsAt(getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20, UltraBall.class).size() > 0) {
                showText("You have \n" + Player.howManyItems[3], battleOverlay.getImage().getWidth() - 72, getHeight() - battleOverlay.getImage().getHeight()/2);
            } else {
                showText("", battleOverlay.getImage().getWidth() - 72, getHeight() - battleOverlay.getImage().getHeight()/2);
            }
        } else {
            showText("", battleOverlay.getImage().getWidth() - 72, getHeight() - battleOverlay.getImage().getHeight()/2);
        }
        if (Greenfoot.isKeyDown("B") && getObjects(Buttons.class).size() > 0) {
            removeObjects(getObjects(Buttons.class));
            addObject(new Fight(), getWidth()/5 - 5, getHeight() - getHeight()/7);
            addObject(new Bag(), getWidth()/2 + getWidth()/15, getHeight() - getHeight()/7);
            addObject(new Pookiemon(), getWidth()/5 - 5, getHeight() - getHeight()/20);
            addObject(new Run(), getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
            switched = false;
        }
        if (Greenfoot.isKeyDown("A") && allowedA) {
            aCounter++;
            allowedA = false;
        }
        if (allowedACounter % 50 == 0) {
            allowedA = true;
            allowedACounter = 0;
        }
        if (!Greenfoot.isKeyDown("A")) {
            safe = true;
        }
        if (aCounter == 0) {
            if (location == 1) {
                showText("Brock sent out " + enemyPokemonName + "!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
            } else if (location == 0) {
                showText("A wild " + enemyPokemonName + " appeared!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
            }
        } else if (aCounter == 1) {
            showText(Player.playerPokemonNames[0] + ", go!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
        } else if (aCounter == 2) {
            showText(" ", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
            removeObject(overlayText);
            removeObject(enterArrow);
            removeObjects(getObjects(Buttons.class));
            addObject(new Fight(), getWidth()/5 - 5, getHeight() - getHeight()/7);
            addObject(new Bag(), getWidth()/2 + getWidth()/15, getHeight() - getHeight()/7);
            addObject(new Pookiemon(), getWidth()/5 - 5, getHeight() - getHeight()/20);
            addObject(new Run(), getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
            switched = false;
            isFirstTime = false;
        } else if (aCounter == -1) {
            if (Greenfoot.isKeyDown("A") && safe && ran) {
                safe = false;
                allowedA = false;
                battleSound.stop();
                Greenfoot.setWorld(new Route1(Player.beforeX, Player.beforeY));
            } else if (Greenfoot.isKeyDown("A") && safe && !ran) {
                safe = false;
                aCounter = 2;
                changeACounterBy = 1;
                myTurn = false;
            }
        } else {
            if (Greenfoot.isKeyDown("A") && Buttons.onMe == 3 && getObjects(Run.class).size() > 0 && !canUseMove && getObjects(Moves.class).size() == 0 && getObjects(Run.class).size() > 0) {
                /*
                removeObjects(getObjects(Buttons.class));
                addObject(overlayText, 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                if (Math.random() <= 0.8) {
                    showText("You managed to run safely.", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                    aCounter = -1;
                    changeACounterBy = 0;
                    ran = true;
                } else {
                    showText("You didn't manage to run...", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                    aCounter = -1;
                    changeACounterBy = 0;
                    ran = false;
                }
                addObject(enterArrow, 3 * getWidth()/4 - 25, getHeight() - battleOverlay.getImage().getHeight()/4);
                */
            } else if (Greenfoot.isKeyDown("A") && Buttons.onMe == 1 && !canUseMove && getObjects(Moves.class).size() == 0 && getObjects(Fight.class).size() > 0) {
                addMoves();
            } else if (Greenfoot.isKeyDown("A") && Buttons.onMe == 0 && !canUseMove && getObjects(Moves.class).size() == 0 && getObjects(Bag.class).size() > 0) {
                removeObjects(getObjects(Buttons.class));
                addItems();
            } else if ((Greenfoot.isKeyDown("A") && Buttons.onMe == 2 && !canUseMove && getObjects(Moves.class).size() == 0 && getObjects(Pookiemon.class).size() > 0) || getObjects(Pookiemons.class).size() > 0) {
                //removeObjects(getObjects(Buttons.class));
                //switchPokemon();
            } else if (canUseMove && Greenfoot.isKeyDown("A")) {
                if (playerPokemon == 0) {
                    if (Buttons.onMe == 0) {
                        PlayerRazorLeaf razorLeaf = new PlayerRazorLeaf();
                        addObject(razorLeaf, getWidth()/2, getHeight()/2);
                        myTurn = false;
                        usedMove = true;
                        doDamage();
                    }
                    if (Buttons.onMe == 1) {
                        PlayerTackle tackle = new PlayerTackle();
                        addObject(tackle, getWidth()/2, getHeight()/2);
                        myTurn = false;
                        usedMove = true;
                        doDamage();
                    }
                    if (Buttons.onMe == 2) {
                        if (Bulbasaur.attacks[2] == Null3.class) {
                            Null3 null3 = new Null3();
                            addObject(null3, getWidth()/5 - 5, getHeight() - getHeight()/20);
                        } else {
                            PlayerRockTomb rockTomb = new PlayerRockTomb();
                            addObject(rockTomb, getWidth()/2, getHeight()/2);
                            myTurn = false;
                            usedMove = true;
                            doDamage();
                        }
                    }
                    if (Buttons.onMe == 3) {
                        if (Bulbasaur.attacks[3] == Null4.class) {
                            Null4 null4 = new Null4();
                            addObject(null4, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
                        } else {
                            PlayerGust gust = new PlayerGust();
                            addObject(gust, getWidth()/2, getHeight()/2);
                            myTurn = false;
                            usedMove = true;
                            doDamage();
                        }
                    }
                } else if (playerPokemon == 1) {
                    if (Buttons.onMe == 0) {
                        PlayerWaterGun waterGun = new PlayerWaterGun();
                        addObject(waterGun, getWidth()/2, getHeight()/2);
                        myTurn = false;
                        usedMove = true;
                        doDamage();
                    }
                    if (Buttons.onMe == 1) {
                        PlayerTackle tackle = new PlayerTackle();
                        addObject(tackle, getWidth()/2, getHeight()/2);
                        myTurn = false;
                        usedMove = true;
                        doDamage();
                    }
                    if (Buttons.onMe == 2) {
                        if (Squirtle.attacks[2] == Null3.class) {
                            Null3 null3 = new Null3();
                            addObject(null3, getWidth()/5 - 5, getHeight() - getHeight()/20);
                        } else {
                            PlayerRockTomb rockTomb = new PlayerRockTomb();
                            addObject(rockTomb, getWidth()/2, getHeight()/2);
                            myTurn = false;
                            usedMove = true;
                            doDamage();
                        }
                    }
                    if (Buttons.onMe == 3) {
                        if (Squirtle.attacks[3] == Null4.class) {
                            Null4 null4 = new Null4();
                            addObject(null4, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
                        } else {
                            PlayerLowSweep lowSweep = new PlayerLowSweep();
                            addObject(lowSweep, getWidth()/2, getHeight()/2);
                            myTurn = false;
                            usedMove = true;
                            doDamage();
                        }
                    }
                } else if (playerPokemon == 2) {
                    if (Buttons.onMe == 0) {
                        PlayerEmber ember = new PlayerEmber();
                        addObject(ember, getWidth()/2, getHeight()/2);
                        myTurn = false;
                        usedMove = true;
                        doDamage();
                    }
                    if (Buttons.onMe == 1) {
                        PlayerTackle tackle = new PlayerTackle();
                        addObject(tackle, getWidth()/2, getHeight()/2);
                        myTurn = false;
                        usedMove = true;
                        doDamage();
                    }
                    if (Buttons.onMe == 2) {
                        if (Charmander.attacks[2] == Null3.class) {
                            Null3 null3 = new Null3();
                            addObject(null3, getWidth()/5 - 5, getHeight() - getHeight()/20);
                        } else {
                            PlayerFlamethrower playerFlamethrower = new PlayerFlamethrower();
                            addObject(playerFlamethrower, getWidth()/2, getHeight()/2);
                            myTurn = false;
                            usedMove = true;
                            doDamage();
                        }
                    }
                    if (Buttons.onMe == 3) {
                        if (Charmander.attacks[3] == Null4.class) {
                            Null4 null4 = new Null4();
                            addObject(null4, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
                        } else {
                            PlayerGust gust = new PlayerGust();
                            addObject(gust, getWidth()/2, getHeight()/2);
                            myTurn = false;
                            usedMove = true;
                            doDamage();
                        }
                    }
                }
                canUseMove = false;
            } else if (canUseItem && (getObjects(Items.class).size() > 0 || getObjects(Null.class).size() > 0) && getObjects(Moves.class).size() == 0 && Greenfoot.isKeyDown("A")) {
                if (Buttons.onMe == 0 && getObjects(Items.class).size() > 0 && getObjectsAt(getWidth()/2 + getWidth()/15, getHeight() - getHeight()/7, PookieBall.class).size() > 0) {
                    PlayerPookieBall pookieBall = new PlayerPookieBall();
                    addObject(pookieBall, getWidth()/2, getHeight()/2);
                    Player.howManyItems[0]--;
                    catching = true;
                } else if (Buttons.onMe == 1 && getObjects(Items.class).size() > 0 && getObjectsAt(getWidth()/5 - 5, getHeight() - getHeight()/7, Potion.class).size() > 0) {
                    PlayerPotion potion = new PlayerPotion();
                    addObject(potion, getWidth()/2, getHeight()/2);
                    Player.howManyItems[1]--;
                    Player.playerPokemonHP[0]+=25;
                    if (Player.playerPokemonHP[0] > Player.playerPokemonMaxHP[0]) {
                        Player.playerPokemonHP[0] = Player.playerPokemonMaxHP[0];
                    }
                    myTurn = false;
                    usedItem = true;
                } else if (Buttons.onMe == 2 && getObjects(Items.class).size() > 0 && getObjectsAt(getWidth()/5 - 5, getHeight() - getHeight()/20, SuperPotion.class).size() > 0) {
                    PlayerSuperPotion superPotion = new PlayerSuperPotion();
                    addObject(superPotion, getWidth()/2, getHeight()/2);
                    Player.howManyItems[2]--;
                    Player.playerPokemonHP[0] = Player.playerPokemonMaxHP[0];
                    myTurn = false;
                    usedItem = true;
                } else if (Buttons.onMe == 3 && getObjects(Items.class).size() > 0 && getObjectsAt(getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20, UltraBall.class).size() > 0) {
                    PlayerUltraBall ultraBall = new PlayerUltraBall();
                    addObject(ultraBall, getWidth()/2, getHeight()/2);
                    Player.howManyItems[3]--;
                    catching = true;
                }
            }
        }
        if (getObjects(Moves.class).size() > 0 && !Greenfoot.isKeyDown("A") && getObjects(Attacks.class).size() == 0) {
            canUseMove = true;
        } else {
            canUseMove = false;
        }
        if (getObjects(Items.class).size() > 0 && !Greenfoot.isKeyDown("A") && (Player.howManyItems[0] > 0 || Player.howManyItems[1] > 0 || Player.howManyItems[2] > 0 || Player.howManyItems[3] > 0)) {
            canUseItem = true;
        } else {
            canUseItem = false;
        }
    }
    
    public void addMoves() {
        removeObjects(getObjects(Buttons.class));
        if (playerPokemon == 0) {
            RazorLeaf razorLeaf = new RazorLeaf();
            Tackle tackle = new Tackle();
            if (Bulbasaur.attacks[2] == Null3.class) {
                Null3 null3 = new Null3();
                addObject(null3, getWidth()/5 - 5, getHeight() - getHeight()/20);
            } else {
                RockTomb rockTomb = new RockTomb();
                addObject(rockTomb, getWidth()/5 - 5, getHeight() - getHeight()/20);
            }
            if (Bulbasaur.attacks[3] == Null4.class) {
                Null4 null4 = new Null4();
                addObject(null4, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
            } else {
                Gust gust = new Gust();
                gust.getImage().scale(222, 44);
                addObject(gust, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
            }
            addObject(razorLeaf, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/7);
            addObject(tackle, getWidth()/5 - 5, getHeight() - getHeight()/7);
        } else if (playerPokemon == 1) {
            WaterGun waterGun = new WaterGun();
            Tackle tackle = new Tackle();
            if (Squirtle.attacks[2] == Null3.class) {
                Null3 null3 = new Null3();
                addObject(null3, getWidth()/5 - 5, getHeight() - getHeight()/20);
            } else {
                RockTomb rockTomb = new RockTomb();
                addObject(rockTomb, getWidth()/5 - 5, getHeight() - getHeight()/20);
            }
            if (Squirtle.attacks[3] == Null4.class) {
                Null4 null4 = new Null4();
                addObject(null4, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
            } else {
                LowSweep lowSweep = new LowSweep();
                lowSweep.getImage().scale(222, 44);
                addObject(lowSweep, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
            }
            addObject(waterGun, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/7);
            addObject(tackle, getWidth()/5 - 5, getHeight() - getHeight()/7);
        } else if (playerPokemon == 2) {
            Ember ember = new Ember();
            Tackle tackle = new Tackle();
            if (Charmander.attacks[2] == Null3.class) {
                Null3 null3 = new Null3();
                addObject(null3, getWidth()/5 - 5, getHeight() - getHeight()/20);
            } else {
                Flamethrower flamethrower = new Flamethrower();
                flamethrower.getImage().scale(222, 44);
                addObject(flamethrower, getWidth()/5 - 5, getHeight() - getHeight()/20);
            }
            if (Charmander.attacks[3] == Null4.class) {
                Null4 null4 = new Null4();
                addObject(null4, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
            } else {
                Gust gust = new Gust();
                gust.getImage().scale(222, 44);
                addObject(gust, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
            }
            addObject(ember, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/7);
            addObject(tackle, getWidth()/5 - 5, getHeight() - getHeight()/7);
        }
    }
    
    public void opponentTurnBattle() {
        canShowEnemyText = true;
        removeObjects(getObjects(Buttons.class));
        removeObjects(getObjects(OverlayText.class));
        removeObjects(getObjects(EnterArrow.class));
        addObject(overlayText, 227, getHeight() - battleOverlay.getImage().getHeight()/2);
        addObject(enterArrow, 3 * getWidth()/4 - 25, getHeight() - battleOverlay.getImage().getHeight()/4);
        if (getObjects(Attacks.class).size() == 0) {
            int moveNum = Greenfoot.getRandomNumber(4);
            if (enemyPokemon == 0) {
                if (moveNum == 0) {
                    EnemyWaterGun waterGun = new EnemyWaterGun();
                    addObject(waterGun, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Water Gun!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 1) {
                    EnemyTackle tackle = new EnemyTackle();
                    addObject(tackle, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Tackle!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 2) {
                    EnemyRockTomb rockTomb = new EnemyRockTomb();
                    addObject(rockTomb, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Rock Tomb!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 3) {
                    EnemyGust gust = new EnemyGust();
                    addObject(gust, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Gust!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                }
                Player.playerPokemonHP[0]-=Articuno.damage;
            } else if (enemyPokemon == 1) {
                if (moveNum == 0) {
                    EnemyWaterGun waterGun = new EnemyWaterGun();
                    addObject(waterGun, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Water Gun!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 1) {
                    EnemyTackle tackle = new EnemyTackle();
                    addObject(tackle, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Tackle!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 2) {
                    EnemyFlamethrower flamethrower = new EnemyFlamethrower();
                    addObject(flamethrower, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Flamethrower!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 3) {
                    EnemyGust gust = new EnemyGust();
                    addObject(gust, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Gust!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                }
                Player.playerPokemonHP[0]-=Mew.damage;
            } else if (enemyPokemon == 2) {
                if (moveNum == 0) {
                    EnemyWaterGun waterGun = new EnemyWaterGun();
                    addObject(waterGun, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Water Gun!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 1) {
                    EnemyTackle tackle = new EnemyTackle();
                    addObject(tackle, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Tackle!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 2) {
                    EnemyFlamethrower flamethrower = new EnemyFlamethrower();
                    addObject(flamethrower, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Flamethrower!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 3) {
                    EnemyGust gust = new EnemyGust();
                    addObject(gust, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Gust!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                }
                Player.playerPokemonHP[0]-=Mewtwo.damage;
            } else if (enemyPokemon == 3) {
                if (moveNum == 0) {
                    EnemyEmber ember = new EnemyEmber();
                    addObject(ember, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Ember!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 1) {
                    EnemyTackle tackle = new EnemyTackle();
                    addObject(tackle, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Tackle!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 2) {
                    EnemyFlamethrower flamethrower = new EnemyFlamethrower();
                    addObject(flamethrower, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Flamethrower!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 3) {
                    EnemyGust gust = new EnemyGust();
                    addObject(gust, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Gust!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                }
                Player.playerPokemonHP[0]-=Moltres.damage;
            } else if (enemyPokemon == 4) {
                if (moveNum == 0) {
                    EnemyRazorLeaf razorLeaf = new EnemyRazorLeaf();
                    addObject(razorLeaf, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Razor Leaf!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 1) {
                    EnemyTackle tackle = new EnemyTackle();
                    addObject(tackle, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Tackle!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 2) {
                    EnemyRockTomb rockTomb = new EnemyRockTomb();
                    addObject(rockTomb, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Rock Tomb!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 3) {
                    EnemyGust gust = new EnemyGust();
                    addObject(gust, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Gust!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                }
                Player.playerPokemonHP[0]-=Zapdos.damage;
            } else if (enemyPokemon == 5) {
                if (moveNum == 0) {
                    EnemyWaterGun waterGun = new EnemyWaterGun();
                    addObject(waterGun, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Water Gun!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 1) {
                    EnemyTackle tackle = new EnemyTackle();
                    addObject(tackle, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Tackle!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 2) {
                    EnemyRockTomb rockTomb = new EnemyRockTomb();
                    addObject(rockTomb, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Rock Tomb!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 3) {
                    EnemyLowSweep lowSweep = new EnemyLowSweep();
                    addObject(lowSweep, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Low Sweep!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                }
                Player.playerPokemonHP[0]-=Geodude.damage;
            } else if (enemyPokemon == 6) {
                if (moveNum == 0) {
                    EnemyWaterGun waterGun = new EnemyWaterGun();
                    addObject(waterGun, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Water Gun!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 1) {
                    EnemyTackle tackle = new EnemyTackle();
                    addObject(tackle, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Tackle!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 2) {
                    EnemyRockTomb rockTomb = new EnemyRockTomb();
                    addObject(rockTomb, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Rock Tomb!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 3) {
                    EnemyLowSweep lowSweep = new EnemyLowSweep();
                    addObject(lowSweep, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Low Sweep!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                }
                Player.playerPokemonHP[0]-=Kabutops.damage;
            } else if (enemyPokemon == 7) {
                if (moveNum == 0) {
                    EnemyWaterGun waterGun = new EnemyWaterGun();
                    addObject(waterGun, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Water Gun!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 1) {
                    EnemyTackle tackle = new EnemyTackle();
                    addObject(tackle, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Tackle!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 2) {
                    EnemyRockTomb rockTomb = new EnemyRockTomb();
                    addObject(rockTomb, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Rock Tomb!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                } else if (moveNum == 3) {
                    EnemyLowSweep lowSweep = new EnemyLowSweep();
                    addObject(lowSweep, getWidth()/2, getHeight()/2);
                    showText(enemyPokemonName + " used Low Sweep!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                }
                Player.playerPokemonHP[0]-=Onix.damage;
            }
            if (Player.playerPokemonHP[0] <= 0) {
                playerFainted();
            } else {
                playerBar.getImage().scale((int)(100 * ((Player.playerPokemonHP[0] * 1.0)/Player.playerPokemonMaxHP[0])), playerBar.getImage().getHeight());
            }
            myTurn = true;
        }
    }
    
    public void addItems() {
        if (Player.howManyItems[0] > 0) {
            addObject(new PookieBall(), getWidth()/2 + getWidth()/15, getHeight() - getHeight()/7);
        } else {
            Null1 null1 = new Null1();
            addObject(null1, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/7);
        }
        if (Player.howManyItems[1] > 0) {
            addObject(new Potion(), getWidth()/5 - 5, getHeight() - getHeight()/7);
        } else {
            Null2 null2 = new Null2();
            addObject(null2, getWidth()/5 - 5, getHeight() - getHeight()/7);
        }
        if (Player.howManyItems[2] > 0) {
            addObject(new SuperPotion(), getWidth()/5 - 5, getHeight() - getHeight()/20);
        } else {
            Null3 null3 = new Null3();
            addObject(null3, getWidth()/5 - 5, getHeight() - getHeight()/20);
        }
        if (Player.howManyItems[3] > 0) {
            addObject(new UltraBall(), getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
        } else {
            Null4 null4 = new Null4();
            addObject(null4, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/20);
        }
    }
    
    public void playerFainted() {
        removeObject(playerPokemonKind);
        removeObjects(getObjects(Buttons.class));
        removeObjects(getObjects(OverlayText.class));
        removeObjects(getObjects(EnterArrow.class));
        addObject(overlayText, 227, getHeight() - battleOverlay.getImage().getHeight()/2);
        addObject(enterArrow, 3 * getWidth()/4 - 25, getHeight() - battleOverlay.getImage().getHeight()/4);
        showText("Your " + playerPokemonName + " Fainted!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
        playerFainted = true;
    }
    
    public void doDamage() {
        if (enemyPokemon == 0) {
            Articuno.hp-=Player.playerPokemonDamage[0];
            if (Articuno.hp <= 0) {
                enemyFainted();
            } else {
                if ((int)(100 * ((Articuno.hp * 1.0)/Articuno.maxhp)) == 0) {
                    removeObject(enemyBar);
                } else {
                    enemyBar.getImage().scale((int)(100 * ((Articuno.hp * 1.0)/Articuno.maxhp)), enemyBar.getImage().getHeight());
                }
            }
        } else if (enemyPokemon == 1) {
            Mew.hp-=Player.playerPokemonDamage[0];
            if (Mew.hp <= 0) {
                enemyFainted();
            } else {
                if ((int)(100 * ((Mew.hp * 1.0)/Mew.maxhp)) == 0) {
                    removeObject(enemyBar);
                } else {
                    enemyBar.getImage().scale((int)(100 * ((Mew.hp * 1.0)/Mew.maxhp)), enemyBar.getImage().getHeight());
                }
            }
        } else if (enemyPokemon == 2) {
            Mewtwo.hp-=Player.playerPokemonDamage[0];
            if (Mewtwo.hp <= 0) {
                enemyFainted();
            } else {
                if ((int)(100 * ((Mewtwo.hp * 1.0)/Mewtwo.maxhp)) == 0) {
                    removeObject(enemyBar);
                } else {
                    enemyBar.getImage().scale((int)(100 * ((Mewtwo.hp * 1.0)/Mewtwo.maxhp)), enemyBar.getImage().getHeight());
                }
            }
        } else if (enemyPokemon == 3) {
            Moltres.hp-=Player.playerPokemonDamage[0];
            if (Moltres.hp <= 0) {
                enemyFainted();
            } else {
                if ((int)(100 * ((Moltres.hp * 1.0)/Moltres.maxhp)) == 0) {
                    removeObject(enemyBar);
                } else {
                    enemyBar.getImage().scale((int)(100 * ((Moltres.hp * 1.0)/Moltres.maxhp)), enemyBar.getImage().getHeight());
                }
            }
        } else if (enemyPokemon == 4) {
            Zapdos.hp-=Player.playerPokemonDamage[0];
            if (Zapdos.hp <= 0) {
                enemyFainted();
            } else {
                if ((int)(100 * ((Zapdos.hp * 1.0)/Zapdos.maxhp)) == 0) {
                    removeObject(enemyBar);
                } else {
                    enemyBar.getImage().scale((int)(100 * ((Zapdos.hp * 1.0)/Zapdos.maxhp)), enemyBar.getImage().getHeight());
                }
            }
        } else if (enemyPokemon == 5) {
            Geodude.hp-=Player.playerPokemonDamage[0];
            if (Geodude.hp <= 0) {
                enemyFainted();
            } else {
                if ((int)(100 * ((Geodude.hp * 1.0)/Geodude.maxhp)) == 0) {
                    removeObject(enemyBar);
                } else {
                    enemyBar.getImage().scale((int)(100 * ((Geodude.hp * 1.0)/Geodude.maxhp)), enemyBar.getImage().getHeight());
                }
            }
        } else if (enemyPokemon == 6) {
            Kabutops.hp-=Player.playerPokemonDamage[0];
            if (Kabutops.hp <= 0) {
                enemyFainted();
            } else {
                if ((int)(100 * ((Kabutops.hp * 1.0)/Kabutops.maxhp)) == 0) {
                    removeObject(enemyBar);
                } else {
                    enemyBar.getImage().scale((int)(100 * ((Kabutops.hp * 1.0)/Kabutops.maxhp)), enemyBar.getImage().getHeight());
                }
            }
        } else if (enemyPokemon == 7) {
            Onix.hp-=Player.playerPokemonDamage[0];
            if (Onix.hp <= 0) {
                enemyFainted();
            } else {
                if ((int)(100 * ((Onix.hp * 1.0)/Onix.maxhp)) == 0) {
                    removeObject(enemyBar);
                } else {
                    enemyBar.getImage().scale((int)(100 * ((Onix.hp * 1.0)/Onix.maxhp)), enemyBar.getImage().getHeight());
                }
            }
        }
    }
    
    public void win() {
        if (Player.previousWorld == Route1.class) {
            Player.money+=100;
            if (Player.playerPokemonLevels[0] != 100) {
                Player.playerPokemonLevels[0]++;
                Player.playerPokemonHP[0]+=2;
            }
            if (Player.playerPokemonLevels[1] != 0 && Player.playerPokemonLevels[1] != 100) {
                Player.playerPokemonLevels[1]++;
                Player.playerPokemonHP[1]+=2;
            }
            if (Player.playerPokemonLevels[2] != 0 && Player.playerPokemonLevels[2] != 100) {
                Player.playerPokemonLevels[2]++;
                Player.playerPokemonHP[2]+=2;
            }
            Greenfoot.setWorld(new Route1(Player.beforeX, Player.beforeY));
            battleSound.stop();
        } else if (Player.previousWorld == Gym.class) {
            if (enemyPokemonName == "Geodude") {
                Player.money+=100;
                Greenfoot.setWorld(new Battle(1, 6, playerPokemon));
            } else if (enemyPokemonName == "Kabutops") {
                Player.money+=100;
                Greenfoot.setWorld(new Battle(1, 7, playerPokemon));
            } else if (enemyPokemonName == "Onix") {
                Player.money+=100;
                Player.beatBrock = true;
                Player.speed = 3;
                Greenfoot.setWorld(new Gym());
            }
        }
    }
    
    public void addPookiemonPic(String path) {
        CollisionRectangle collisionRectangle = new CollisionRectangle();
        collisionRectangle.setImage(path);
        collisionRectangle.getImage().scale(65, 65);
        addObject(collisionRectangle, getWidth() - battleOverlay.getImage().getHeight() * 3/4, getHeight() - battleOverlay.getImage().getHeight()/2);
    }
    
    public static int getEnemyHP() {
        if (enemyPokemon == 0) {
            return Articuno.hp;
        } else if (enemyPokemon == 1) {
            return Mew.hp;
        } else if (enemyPokemon == 2) {
            return Mewtwo.hp;
        } else if (enemyPokemon == 3) {
            return Moltres.hp;
        } else if (enemyPokemon == 4) {
            return Zapdos.hp;
        } else if (enemyPokemon == 5) {
            return Geodude.hp;
        } else if (enemyPokemon == 6) {
            return Kabutops.hp;
        } else if (enemyPokemon == 7) {
            return Onix.hp;
        }
        return 0;
    }
    
    public static int getEnemyLevel() {
        if (enemyPokemon == 0) {
            return Articuno.level;
        } else if (enemyPokemon == 1) {
            return Mew.level;
        } else if (enemyPokemon == 2) {
            return Mewtwo.level;
        } else if (enemyPokemon == 3) {
            return Moltres.level;
        } else if (enemyPokemon == 4) {
            return Zapdos.level;
        } else if (enemyPokemon == 5) {
            return Geodude.level;
        } else if (enemyPokemon == 6) {
            return Kabutops.level;
        } else if (enemyPokemon == 7) {
            return Onix.level;
        }
        return 0;
    }
    
    public void catchPokemon() {
        if (getObjects(PlayerPookieBall.class).size() == 0) {
            usedPookieBall = true;
        } else if (getObjects(PlayerUltraBall.class).size() == 0) {
            usedUltraBall = true;
        }
        if (getObjects(PlayerPookieBall.class).size() == 0 && getObjects(PlayerUltraBall.class).size() == 0) {
            removeObjects(getObjects(Buttons.class));
            removeObjects(getObjects(OverlayText.class));
            removeObjects(getObjects(EnterArrow.class));
            addObject(overlayText, 227, getHeight() - battleOverlay.getImage().getHeight()/2);
            addObject(enterArrow, 3 * getWidth()/4 - 25, getHeight() - battleOverlay.getImage().getHeight()/4);
            showText("You threw a Ball!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
            removeObject(enemyPokemonKind);
            removeObjects(getObjects(BlockedEntry.class));
            BlockedEntry ball = new BlockedEntry();
            if (usedPookieBall) {
                ball.setImage("Pokeball.png");
            } else if (usedUltraBall) {
                ball.setImage("Ultraball.png");
            }
            ball.getImage().scale(50, 50);
            addObject(ball, 3 * getWidth()/4 + 6, getHeight()/4);
            catchingCounter++;
            if (catchingCounter % 100 == 0) {
                catchingCounter = 0;
                if (usedPookieBall && Greenfoot.getRandomNumber(10) >= 5) {
                    
                } else if (usedUltraBall && Greenfoot.getRandomNumber(10) >= 9) {
                    
                }
                if (Greenfoot.getRandomNumber(2) == 1) {
                    showText("Congrats! You caught " + enemyPokemonName + "!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
                    if (Player.playerPokemonNames[1] == "") {
                        Player.playerPokemonNames[1] = enemyPokemonName;
                        Player.playerPokemonLevels[1] = getEnemyLevel();
                    } else if (Player.playerPokemonNames[2] == "") {
                        Player.playerPokemonNames[2] = enemyPokemonName;
                        Player.playerPokemonLevels[2] = getEnemyLevel();
                    } else {
                        Player.playerPokemonBox.add(enemyPokemonName);
                    }
                    catching = false;
                    caught = true;
                } else {
                    removeObjects(getObjects(BlockedEntry.class));
                    if (enemyPokemon == 0) {
                        enemyPokemonName = "Articuno";
                        enemyPokemonKind = new Articuno(enemyLevel, true);
                        addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
                        enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
                        showText("lvl " + Articuno.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
                    } else if (enemyPokemon == 1) {
                        enemyPokemonName = "Mew";
                        enemyPokemonKind = new Mew(enemyLevel, true);
                        addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
                        enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
                        showText("lvl " + Mew.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
                    } else if (enemyPokemon == 2) {
                        enemyPokemonName = "Mewtwo";
                        enemyPokemonKind = new Mewtwo(enemyLevel, true);
                        addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
                        enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
                        showText("lvl " + Mewtwo.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
                    } else if (enemyPokemon == 3) {
                        enemyPokemonName = "Moltres";
                        enemyPokemonKind = new Moltres(enemyLevel, true);
                        addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
                        enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
                        showText("lvl " + Moltres.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
                    } else if (enemyPokemon == 4) {
                        enemyPokemonName = "Zapdos";
                        enemyPokemonKind = new Zapdos(enemyLevel, true);
                        addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
                        enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
                        showText("lvl " + Zapdos.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
                    } else if (enemyPokemon == 5) {
                        enemyPokemonName = "Geodude";
                        enemyPokemonKind = new Geodude(enemyLevel, true);
                        addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
                        enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
                        showText("lvl " + Geodude.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
                    } else if (enemyPokemon == 6) {
                        enemyPokemonName = "Kabutops";
                        enemyPokemonKind = new Kabutops(enemyLevel, true);
                        addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
                        enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
                        showText("lvl " + Kabutops.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
                    } else if (enemyPokemon == 7) {
                        enemyPokemonName = "Onix";
                        enemyPokemonKind = new Onix(enemyLevel, true);
                        addObject(enemyPokemonKind, 3 * getWidth()/4 + 6, getHeight()/6);
                        enemyPokemonKind.getImage().scale(enemyPokemonKind.getImage().getWidth()/2, enemyPokemonKind.getImage().getHeight()/2);
                        showText("lvl " + Onix.level, 3 * (new EnemyBoard(enemyPokemonKind)).getImage().getWidth()/4, getHeight()/6);
                    }
                    catching = false;
                    myTurn = false;
                    usedItem = true;
                }
            }
        }
    }
    
    public void switchPokemon() {
        if (Player.playerPokemonNames[1] == "Articuno") {
            ArticunoButton button = new ArticunoButton(false);
            addObject(button, getWidth()/5 - 5, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 1) {
                addPookiemonPic("Pookiemon/Enemy/Articuno.png");
            }
            switchOrders(1);
        } else if (Player.playerPokemonNames[1] == "Mew") {
            MewButton button = new MewButton(false);
            addObject(button, getWidth()/5 - 5, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 1) {
                addPookiemonPic("Pookiemon/Enemy/Mew.png");
            }
            switchOrders(1);
        } else if (Player.playerPokemonNames[1] == "Mewtwo") {
            MewtwoButton button = new MewtwoButton(false);
            addObject(button, getWidth()/5 - 5, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 1) {
                addPookiemonPic("Pookiemon/Enemy/Mewtwo.png");
            }
            switchOrders(1);
        } else if (Player.playerPokemonNames[1] == "Moltres") {
            MoltresButton button = new MoltresButton(false);
            addObject(button, getWidth()/5 - 5, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 1) {
                addPookiemonPic("Pookiemon/Enemy/Moltres.png");
            }
            switchOrders(1);
        } else if (Player.playerPokemonNames[1] == "Zapdos") {
            ZapdosButton button = new ZapdosButton(false);
            addObject(button, getWidth()/5 - 5, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 1) {
                addPookiemonPic("Pookiemon/Enemy/Zapdos.png");
            }
            switchOrders(1);
        } else if (Player.playerPokemonNames[1] == "Bulbasaur") {
            BulbasaurButton button = new BulbasaurButton(false);
            addObject(button, getWidth()/5 - 5, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 1) {
                addPookiemonPic("Pookiemon/Enemy/Bulbasaur.png");
            }
            switchOrders(1);
        } else if (Player.playerPokemonNames[1] == "Squirtle") {
            SquirtleButton button = new SquirtleButton(false);
            addObject(button, getWidth()/5 - 5, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 1) {
                addPookiemonPic("Pookiemon/Enemy/Squirtle.png");
            }
            switchOrders(1);
        } else if (Player.playerPokemonNames[1] == "Charmander") {
            CharmanderButton button = new CharmanderButton(false);
            addObject(button, getWidth()/5 - 5, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 1) {
                addPookiemonPic("Pookiemon/Enemy/Charmander.png");
            }
            switchOrders(1);
        } else {
            NullButton button = new NullButton(false);
            addObject(button, getWidth()/5 - 5, getHeight() - getHeight()/10);
        }
        if (Player.playerPokemonNames[2] == "Articuno") {
            ArticunoButton button = new ArticunoButton(true);
            addObject(button, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 0) {
                addPookiemonPic("Pookiemon/Enemy/Articuno.png");
            }
            switchOrders(2);
        } else if (Player.playerPokemonNames[2] == "Mew") {
            MewButton button = new MewButton(true);
            addObject(button, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 0) {
                addPookiemonPic("Pookiemon/Enemy/Mew.png");
            }
            switchOrders(2);
        } else if (Player.playerPokemonNames[2] == "Mewtwo") {
            MewtwoButton button = new MewtwoButton(true);
            addObject(button, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 0) {
                addPookiemonPic("Pookiemon/Enemy/Mewtwo.png");
            }
            switchOrders(2);
        } else if (Player.playerPokemonNames[2] == "Moltres") {
            MoltresButton button = new MoltresButton(true);
            addObject(button, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 0) {
                addPookiemonPic("Pookiemon/Enemy/Moltres.png");
            }
            switchOrders(2);
        } else if (Player.playerPokemonNames[2] == "Zapdos") {
            ZapdosButton button = new ZapdosButton(true);
            addObject(button, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 0) {
                addPookiemonPic("Pookiemon/Enemy/Zapdos.png");
            }
            switchOrders(2);
        } else if (Player.playerPokemonNames[2] == "Bulbasaur") {
            BulbasaurButton button = new BulbasaurButton(true);
            addObject(button, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 0) {
                addPookiemonPic("Pookiemon/Enemy/Bulbasaur.png");
            }
            switchOrders(2);
        } else if (Player.playerPokemonNames[2] == "Squirtle") {
            SquirtleButton button = new SquirtleButton(true);
            addObject(button, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 0) {
                addPookiemonPic("Pookiemon/Enemy/Squirtle.png");
            }
            switchOrders(2);
        } else if (Player.playerPokemonNames[2] == "Charmander") {
            CharmanderButton button = new CharmanderButton(true);
            addObject(button, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/10);
            if (Pookiemons.onMe == 0) {
                addPookiemonPic("Pookiemon/Enemy/Charmander.png");
            }
            switchOrders(2);
        } else {
            NullButton button = new NullButton(true);
            addObject(button, getWidth()/2 + getWidth()/15, getHeight() - getHeight()/10);
        }
    }
    
    public void enemyFainted() {
        removeObject(enemyPokemonKind);
        removeObjects(getObjects(Buttons.class));
        removeObjects(getObjects(OverlayText.class));
        removeObjects(getObjects(EnterArrow.class));
        addObject(overlayText, 227, getHeight() - battleOverlay.getImage().getHeight()/2);
        addObject(enterArrow, 3 * getWidth()/4 - 25, getHeight() - battleOverlay.getImage().getHeight()/4);
        showText("The opposing " + enemyPokemonName + " Fainted!", 227, getHeight() - battleOverlay.getImage().getHeight()/2);
        enemyFainted = true;
        aDown = true;
    }
    
    public void switchOrders(int playerOrEnemy) {
        if (Greenfoot.isKeyDown("A") && !switched) {
            String name = Player.playerPokemonNames[playerOrEnemy];
            int level = Player.playerPokemonLevels[playerOrEnemy];
            int maxhp = Player.playerPokemonMaxHP[playerOrEnemy];
            int hp = Player.playerPokemonHP[playerOrEnemy];
            int damage = Player.playerPokemonDamage[playerOrEnemy];
            Player.playerPokemonNames[playerOrEnemy] = Player.playerPokemonNames[0];
            Player.playerPokemonLevels[playerOrEnemy] = Player.playerPokemonLevels[0];
            Player.playerPokemonMaxHP[playerOrEnemy] = Player.playerPokemonMaxHP[0];
            Player.playerPokemonHP[playerOrEnemy] = Player.playerPokemonHP[0];
            Player.playerPokemonDamage[playerOrEnemy] = Player.playerPokemonDamage[0];
            Player.playerPokemonNames[0] = name;
            Player.playerPokemonLevels[0] = level;
            Player.playerPokemonMaxHP[0] = maxhp;
            Player.playerPokemonHP[0] = hp;
            Player.playerPokemonDamage[0] = damage;
            switched = true;
        }
    }
}