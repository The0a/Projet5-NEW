package testInterface.Map.MotionLess;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
	Image ground;
	
	public Ground(){
		try {
			ground = ImageIO.read(new File("src/Image/ground.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Image getGround() {
		return ground;
	}

	public void setGround(Image ground) {
		this.ground = ground;
	}
}
