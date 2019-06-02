
package testInterface.Map;

import java.awt.Image;

import testInterface.Map.Motion.Boulder;
import testInterface.Map.MotionLess.Diamond;
import testInterface.Map.MotionLess.Dirt;
import testInterface.Map.MotionLess.Exit;
import testInterface.Map.MotionLess.Ground;
import testInterface.Map.MotionLess.Wall;


public class ImagePerso {
	private static int tailleImg = 32; 
	//static field enables to have the same image size whichever ImagePerso instance you are considering
	private Image image; 
	private int xPixel=0;
	private int yPixel=0;
	private int xIndex=0;
	private int yIndex=0;
	private char element=0; //still element of the background
	
	Boulder boulder = new Boulder();
	Ground ground = new Ground();
	Wall wall = new Wall();
	Dirt dirt = new Dirt();
	Diamond diamond = new Diamond();
	Exit exit = new Exit();


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
			setImage(wall.getWall());
			break;
		}
		case 'd': {
			setImage(dirt.getDirt());
			break;
		}
		case 'r': {
			setImage(boulder.getBoulder());
			break;
		}
		case 'D': {
			setImage(diamond.getDiamond());
			break;
		}
		case 'e': {
			setImage(exit.getExit());
			break;
		}
		case 'g': {
			setImage(ground.getGround());
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
