package testInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import testInterface.DBCo;
import javax.imageio.ImageIO;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JPanel;

import sun.launcher.resources.launcher;

class Panneau extends JPanel implements KeyListener {


	private static final long serialVersionUID = 1L;
	private int largeur = 25;
	private int longueur = 25;
	private int tailleImg = 32;
	private Image RockFordUp, RockFordDown, RockFordRight, RockFordLeft, ground, wall, rock, diamond, exit,dirt;
	private Image Rockford;
	private int xRockford = 32;
	private int yRockford = 32;
	private Image ennemies;
	private int xEnnemies = 96;
	private int yEnnemies = 96;
	private ImagePerso[][] tabImg = new ImagePerso[longueur][largeur];
	private char[][] map = new char[longueur][largeur];
	private int countDiamond = 0;

	Panneau() throws FileNotFoundException {
		setSize(this.largeur * this.tailleImg, this.longueur * this.tailleImg);
		try {
			RockFordUp = ImageIO.read(new File("src/Image/RockFordUp.png"));
			RockFordDown = ImageIO.read(new File("src/Image/RockFordDown.png"));
			RockFordRight = ImageIO.read(new File("src/Image/RockFordRight.png"));
			RockFordLeft = ImageIO.read(new File("src/Image/RockFordLeft.png"));
			wall = ImageIO.read(new File("src/Image/wall.png"));
			rock = ImageIO.read(new File("src/Image/rock.png"));
			ground = ImageIO.read(new File("src/Image/ground.png"));
			diamond = ImageIO.read(new File("src/Image/Diamond.png"));
			exit = ImageIO.read(new File("src/Image/logout.png"));
			ennemies = ImageIO.read(new File("src/Image/Ennemies.png"));
			dirt = ImageIO.read(new File("src/Image/groundfinal.png"));
			Rockford = RockFordRight;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		setPreferredSize(new Dimension(100, 100));
		setForeground(Color.GREEN);
		this.map = readMap();
		displayMap(this.map);

	}

	public int[] pixelToIndex(int xPixel, int yPixel) {
		int[] coord = new int[2];
		coord[0] = xPixel / 32;
		coord[1] = yPixel / 32;
		return coord;
	}

	public int[] indexToPixel(int xIndex, int yIndex) {
		int[] coord = new int[2];
		coord[0] = xIndex * 32;
		coord[1] = yIndex * 32;
		return coord;
	}

	public void move(String typeMove) {
		int[] coord = new int[2];
		if (typeMove == "up") {
			int newY = this.yRockford - this.tailleImg;
			coord = this.pixelToIndex(this.xRockford, newY);
			if (newY > 0 && tabImg[coord[0]][coord[1]].getImage() != this.rock) {
				Rockford = RockFordUp;
				this.yRockford = newY;
			}
		} else if (typeMove == "down") {
			int newY = this.yRockford + this.tailleImg;
			coord = this.pixelToIndex(this.xRockford, newY);
			if (newY < this.longueur * this.tailleImg - this.tailleImg
					&& tabImg[coord[0]][coord[1]].getImage() != this.rock) {
				Rockford = RockFordDown;
				this.yRockford = newY;
			}
		} else if (typeMove == "left") {
			int newX = this.xRockford - this.tailleImg;
			coord = this.pixelToIndex(newX, this.yRockford);
			if (newX > 0 && tabImg[coord[0]][coord[1]].getImage() != this.rock) {
				Rockford = RockFordLeft;
				this.xRockford = newX;
			}
		} else if (typeMove == "right") {
			int newX = this.xRockford + this.tailleImg;
			coord = this.pixelToIndex(newX, this.yRockford);
			if (newX < this.largeur * this.tailleImg - this.tailleImg
					&& tabImg[coord[0]][coord[1]].getImage() != this.rock) {
				Rockford = RockFordRight;
				this.xRockford = newX;
			}
		}
		removeSymbol();
		enableExit(coord[0], coord[1], typeMove);

	}

	public void moveEnnemies() {
		int[] coord = new int[2];
		Random x = new Random();
		Random y = new Random();

		int n = x.nextInt(tailleImg);
		int z = y.nextInt(tailleImg);
		int newX = this.xEnnemies + n;
		int newY = this.yEnnemies + z;
		coord = this.pixelToIndex(this.xEnnemies, newX);
		coord = this.pixelToIndex(this.yEnnemies, newY);
		if (newX > 0 && tabImg[coord[0]][coord[1]].getImage() != this.wall)
			if (newY < 0 && tabImg[coord[0]][coord[1]].getImage() != this.wall)
				this.yEnnemies = newY;
		this.xEnnemies = newX;
	}

	public void enableExit(int x, int y, String typeMove) {
		if (map[x][y] == 'e') {
			int[] coord = indexToPixel(x, y);
			this.xRockford = coord[0];
			this.yRockford = coord[1];

			switch (typeMove) {
			case "up":
				Rockford = RockFordUp;
				break;
			case "down":
				Rockford = RockFordDown;
				break;
			case "right":
				Rockford = RockFordRight;
				break;
			case "left":
				Rockford = RockFordLeft;
				break;

			}
		}
	}

	public char[][] readMap() /*throws FileNotFoundException*/ {

		String MapFinal = "Launcher.map1";
		Scanner scnr = new Scanner(MapFinal);

		String str = "";
		char[] charArray;
		char[][] map1 = new char[longueur][largeur];
		int n = 0;

		while (scnr.hasNextLine()) {
			str = scnr.nextLine();
			charArray = str.toCharArray();
			map1[n] = charArray;
			n++;
		}

		scnr.close();

		return map;

	}

	public void removeSymbol() {
		int[] coord = this.pixelToIndex(this.xRockford, this.yRockford);
		if (this.map[coord[0]][coord[1]]=='b')
			{
			this.map[coord[0]][coord[1]] = 't';	
			}
		if (this.map[coord[0]][coord[1]] == 'd') {
			countDiamond++;
			this.map[coord[0]][coord[1]] = 't';
		}
		if (countDiamond == 10) {
			this.map[18][24] = 'e';

		}
		displayMap(this.map);
	}

	public void displayMap(char[][] map) {

		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {

				char elem = map[i][j];
				// tabImg[i][j].setX(j * 32);
				// tabImg[i][j].setY(i * 32);
				switch (elem) {

				case 'a': {
					tabImg[i][j] = new ImagePerso(wall, j * this.tailleImg, i * this.tailleImg);
					// tabImg[i][j].setImage(wall);
					break;
				}
				case 'b': {
					tabImg[i][j] = new ImagePerso(dirt, j * this.tailleImg, i * this.tailleImg);
					// tabImg[i][j].setImage(ground);
					break;
				}
				case 'r': {
					tabImg[i][j] = new ImagePerso(rock, j * this.tailleImg, i * this.tailleImg);
					// tabImg[i][j].setImage(ground);
					break;
				}
				case 'd': {
					tabImg[i][j] = new ImagePerso(diamond, j * this.tailleImg, i * this.tailleImg);
					// tabImg[i][j].setImage(ground);
					break;
				}
				case 'e': {
					tabImg[i][j] = new ImagePerso(exit, j * this.tailleImg, i * this.tailleImg);
					// tabImg[i][j].setImage(ground);
					break;
				}
				case 't': {
					tabImg[i][j] = new ImagePerso(ground, j * this.tailleImg, i * this.tailleImg);
					// tabImg[i][j].setImage(ground);
					break;
				}
				}
			}

		}

	}

	public void paint(Graphics g) {
//		super.paintComponent(g);

//		System.out.println("decors");
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {

				g.drawImage(tabImg[i][j].getImage(), i * this.tailleImg, j * this.tailleImg, this.tailleImg,
						this.tailleImg, this);
			}
		}

		g.drawImage(Rockford, this.xRockford, this.yRockford, this.tailleImg, this.tailleImg, this);
		moveEnnemies();
		g.drawImage(ennemies, this.xEnnemies, this.yEnnemies, this.tailleImg, this.tailleImg, this);
	}

	@Override
	public void keyPressed(KeyEvent arg7) {
		int code = arg7.getKeyCode();

		switch (code) {
		case KeyEvent.VK_UP:
//			map.getRockford().moveUp();
			move("up");
			break;
		case KeyEvent.VK_RIGHT:

			move("right");
			break;
		case KeyEvent.VK_LEFT:

			move("left");
			break;

		case KeyEvent.VK_DOWN:

			move("down");
			break;

		}
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
