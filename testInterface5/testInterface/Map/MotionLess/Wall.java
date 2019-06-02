package testInterface.Map.MotionLess;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall {
Image wall;
	
	public Wall(){
		try {
			wall = ImageIO.read(new File("src/Image/wall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Image getWall() {
		return wall;
	}

	public void setWall(Image wall) {
		this.wall = wall;
	}
}
