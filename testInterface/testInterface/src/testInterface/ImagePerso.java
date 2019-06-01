package testInterface;

import java.awt.Image;

public class ImagePerso {
	private Image image; 
	private int x=0;
	private int y=0;
	
	public ImagePerso(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
