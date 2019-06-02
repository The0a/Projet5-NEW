package testInterface.Map.Motion;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {
Image enemy;
	
	
	public Enemy(){
		try {
			enemy = ImageIO.read(new File("src/Image/enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	public Image getEnemy() {
		return enemy;
	}


	public void setEnemy(Image enemy) {
		this.enemy = enemy;
	}
}

