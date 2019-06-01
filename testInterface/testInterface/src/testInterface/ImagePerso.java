package testInterface;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagePerso {
	private static int tailleImg = 32; 
	//static field enables to have the same image size whichever ImagePerso instance you are considering
	private Image image; 
	private int xPixel=0;
	private int yPixel=0;
	private int xIndex=0;
	private int yIndex=0;
	private char element=0; //still element of the background

	public ImagePerso(Image image, int x, int y,char element) {
		
		this.image = image;
		this.xPixel = x;
		this.yPixel = y;
		this.xIndex=pixelToIndex(this.xPixel);
		this.yIndex=pixelToIndex(this.yPixel);
		this.element=element;
	}
	
	public ImagePerso(Image image, int x, int y) {
		//call the complete constructor with 'E' as element for enemies
		this(image,x,y,'E');
	}
	
	public ImagePerso(Image image) {
		//call the complete constructor with 'R' as element for rockford
		this(image,tailleImg,tailleImg,'R');
	}

	public char getElement() {
		return element;
	}


	public void setElement(char element) {
		this.element = element;
		switch (element) {
		case 'w': {
			setImage(Panneau.getWall());
			break;
		}
		case 'd': {
			setImage(Panneau.getDirt());
			break;
		}
		case 'r': {
			setImage(Panneau.getRock());
			break;
		}
		case 'D': {
			setImage(Panneau.getDiamond());
			break;
		}
		case 'e': {
			setImage(Panneau.getExit());
			break;
		}
		case 'g': {
			setImage(Panneau.getGround());
			break;
		}
		}
	}

	public static int pixelToIndex(int xPixel) {
		return xPixel/tailleImg;
	}

	public static int indexToPixel(int xIndex) {

		return xIndex*tailleImg;
	}

	public Image getImage() {
		return image;
	}
	

	public void setImage(Image image) {
		this.image = image;
	}

	public static int getTailleImg() {
		return tailleImg;
	}

	public int getXPixel() {
		return xPixel;
	}
	
	public int getXIndex() {
		return xIndex;
	}

	public void setXPixel(int x) {
		this.xPixel = x;
		this.xIndex = pixelToIndex(x);
	}
	
	public void setXIndex(int x) {
		this.xIndex = x;
		this.xPixel = indexToPixel(x);
	}

	public int getYPixel() {
		return yPixel;
	}
	
	public int getYIndex() {
		return yIndex;
	}
	
	public void setYPixel(int y) {
		this.yPixel = y;
		this.yIndex = pixelToIndex(y);
	}
	
	public void setYIndex(int y) {
		this.yIndex = y;
		this.yPixel = indexToPixel(y);
	}

}
