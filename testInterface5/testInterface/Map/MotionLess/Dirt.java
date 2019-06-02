package testInterface.Map.MotionLess;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dirt {
Image dirt;
	
	
	public Dirt(){
		try {
			dirt = ImageIO.read(new File("src/Image/dirt.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	public Image getDirt() {
		return dirt;
	}


	public void setDirt(Image dirt) {
		this.dirt = dirt;
	}
}
