package testInterface.Map.MotionLess;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diamond {
Image diamond;
	
	
	public Diamond(){
		try {
			diamond = ImageIO.read(new File("src/Image/Diamond.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	public Image getDiamond() {
		return diamond;
	}


	public void setDiamond(Image diamond) {
		this.diamond = diamond;
	}

}
