import greenfoot.*;

public class GenderMenu extends Actor {
    private String imageName;
    private boolean genderSelected = false;
    GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    public GenderMenu(String imageName) {
        
        this.imageName = imageName;
        setImage(imageName);
    }

    public void act() {
        if(genderSelected) {
             music.stop();
             Greenfoot.setWorld(new PlayerHouseLevelTwo());
        }
        if (Greenfoot.mouseClicked(this) && !genderSelected) {
            if (imageName.equals("Boy.png")) {
                Player.gender = "boy";
                Greenfoot.setWorld(new NameSelection("boy"));
            } else if (imageName.equals("Girl.png")) {
                Player.gender = "girl";
                Greenfoot.setWorld(new NameSelection("girl"));
            }
            java.util.List<Player> players = getWorld().getObjects(Player.class);
            if (!players.isEmpty()) {
                Player player = players.get(0);
                player.updateImages(Player.gender);
            }
            genderSelected = true;
        }
    }
}