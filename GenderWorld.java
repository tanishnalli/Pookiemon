import greenfoot.*;

public class GenderWorld extends World {
    static GreenfootSound music = new GreenfootSound("WorldTownTrash.mp3");
    public GenderWorld() {    
        super(600, 400, 1); 
        //music.play();
        //IntroWorld.music.stop();
        GreenfootImage background = getBackground();
        background.setColor(Color.WHITE);
        background.fill();
        addObjects();
        addText("Choose Your Gender", getWidth() / 2, 50, 24, Color.BLACK);
        addText("Boy", 150, 300, 24, Color.BLACK);
        addText("Girl", 450, 300, 24, Color.BLACK);
        
    }
    
    public void addObjects() {    
        addObject(new GenderMenu("Boy.png"), 150, 185);
        addObject(new GenderMenu("Girl.png"), 450, 185);
    }
    
    public void addText(String text, int x, int y, int fontSize, Color color) {
        
        GreenfootImage textImage = new GreenfootImage(text, fontSize, color, new Color(0, 0, 0, 0));
        getBackground().drawImage(textImage, x - textImage.getWidth() / 2, y - textImage.getHeight() / 2);
    }
}
