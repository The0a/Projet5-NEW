package testInterface.Map;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import testInterface.Panneau;
//import testInterface.Map.Motion.Boulder;

public class Rockford {
	private Panneau p;
	private ImagePerso imgPerso;
	private static Image RockFordUp, RockFordDown, RockFordRight, RockFordLeft;

	public static Image getRockFordUp() {
		return RockFordUp;
	}

	public static Image getRockFordDown() {
		return RockFordDown;
	}

	public static Image getRockFordRight() {
		return RockFordRight;
	}

	public static Image getRockFordLeft() {
		return RockFordLeft;
	}

	public Rockford(Panneau p) {

		try {
			RockFordUp = ImageIO.read(new File("src/Image/normal.gif"));
			RockFordDown = ImageIO.read(new File("src/Image/RockFordDown.png"));
			RockFordRight = ImageIO.read(new File("src/Image/RockFordRight.png"));
			RockFordLeft = ImageIO.read(new File("src/Image/RockFordLeft.png"));
			this.imgPerso = new ImagePerso(RockFordRight);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.p = p;
	}

	public void move(String typeMove) {
		
		if (typeMove == "up") {
			int newYPixel = this.imgPerso.getYPixel() - ImagePerso.getTailleImg();
			int newYIndex = ImagePerso.pixelToIndex(newYPixel);
			if (this.p.getImagePerso(this.imgPerso.getXIndex(), newYIndex).getElement() != 'w' 
					&& this.p.getImagePerso(this.imgPerso.getXIndex(), newYIndex).getElement() != 'r') {
				System.out.println("hello up");
				//this.imgPerso.setImage(RockFordUp);
				this.imgPerso.setYPixel(newYPixel);
				
			}
		} else if (typeMove == "down") {
			int newYPixel = this.imgPerso.getYPixel() + ImagePerso.getTailleImg();
			int newYIndex = ImagePerso.pixelToIndex(newYPixel);
			if (this.p.getImagePerso(this.imgPerso.getXIndex(), newYIndex).getElement() != 'w'
					&& this.p.getImagePerso(this.imgPerso.getXIndex(), newYIndex).getElement() != 'r') {
				System.out.println("hello down");
				//this.imgPerso.setImage(RockFordDown);
				this.imgPerso.setYPixel(newYPixel);
			}
		} else if (typeMove == "left") {
			int newXPixel = this.imgPerso.getXPixel() - ImagePerso.getTailleImg();
			int newXIndex = ImagePerso.pixelToIndex(newXPixel);
			if (this.p.getImagePerso(newXIndex,this.imgPerso.getXIndex()).getElement() != 'w' 
					&& this.p.getImagePerso(newXIndex, this.imgPerso.getYIndex()).getElement() != 'r') {
				System.out.println("hello left");
				//this.imgPerso.setImage(RockFordLeft);
				this.imgPerso.setXPixel(newXPixel);
			}
		} else if (typeMove == "right") {
			int newXPixel = this.imgPerso.getXPixel() + ImagePerso.getTailleImg();
			int newXIndex = ImagePerso.pixelToIndex(newXPixel);
			if (this.p.getImagePerso(newXIndex,this.imgPerso.getXIndex()).getElement() != 'w' 
					&& this.p.getImagePerso(newXIndex, this.imgPerso.getYIndex()).getElement() != 'r') {
				System.out.println("hello right");
				//this.imgPerso.setImage(RockFordRight);
				this.imgPerso.setXPixel(newXPixel);
			}
		}
}

	public ImagePerso getImgPerso() {
		return imgPerso;
	}

	public void setImgPerso(ImagePerso imgPerso) {
		this.imgPerso = imgPerso;
	}
}