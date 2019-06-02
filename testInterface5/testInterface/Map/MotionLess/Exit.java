package testInterface.Map.MotionLess;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Exit {
Image exit;
	
	
	public Exit(){
		try {
			exit = ImageIO.read(new File("src/Image/exit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	public Image getExit() {
		return exit;
	}


	public void setExit(Image exit) {
		this.exit = exit;
	}
}

