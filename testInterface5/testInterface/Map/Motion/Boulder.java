package testInterface.Map.Motion;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Boulder {
	
	Image boulder;
	
	
	public Boulder(){
		try {
			boulder = ImageIO.read(new File("src/Image/rock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
	
	public Image getBoulder() {
		return boulder;
	}
	
	public void setBoulder(Image boulder) {
		this.boulder = boulder;
	}
	
	public void boulderRight(char map[][], int i, int j) {
		map[i][j+1] = map[i][j];
		map[i][j] = 'g';
	}
	
	public void boulderLeft(char map[][], int i, int j) {
		map[i][j-1] = map[i][j];
		map[i][j] = 'g';
	}
	
	public void boulderFall(char map[][], int i, int j) {
		map[i][j+1] = map[i][j];
		map[i][j] = 'g';
	}
	
}
