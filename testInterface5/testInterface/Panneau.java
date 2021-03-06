package testInterface;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.Scanner;

import javax.swing.JPanel;


import testInterface.Map.ImportMap.DAOFichier;
import testInterface.Map.ImagePerso;
import testInterface.Map.Rockford;
import testInterface.Map.Motion.Boulder;
import testInterface.Map.MotionLess.Diamond;
import testInterface.Map.MotionLess.Dirt;
import testInterface.Map.MotionLess.Exit;
import testInterface.Map.MotionLess.Ground;
import testInterface.Map.MotionLess.Wall;

public class Panneau extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rockford rockford;
	private int largeur = 25;
	private int longueur = 25;
//	private int tailleImg = 32;
//	public static Image ground, wall, rock, diamond, exit,dirt;
	//private Image Rockford;
//	private int xRockford = 32;
//	private int yRockford = 32;
//	private Image ennemies;
//	private int xEnnemies = 96;
//	private int yEnnemies = 96;
	
	Boulder boulder = new Boulder();
	Ground ground = new Ground();
	Wall wall = new Wall();
	Dirt dirt = new Dirt();
	Diamond diamond = new Diamond();
	Exit exit = new Exit();
	private ImagePerso[][] tabImg = new ImagePerso[longueur][largeur];
	private int countDiamond = 0;
	char[][] map;

	Panneau() throws FileNotFoundException {
		setSize(this.largeur * ImagePerso.getTailleImg(), this.longueur * ImagePerso.getTailleImg());
//		try {
			
//			wall = ImageIO.read(new File("src/Image/wall.png"));
//			rock = ImageIO.read(new File("src/Image/rock.png"));
//			ground = ImageIO.read(new File("src/Image/ground.png"));
//			diamond = ImageIO.read(new File("src/Image/Diamond.png"));
//			exit = ImageIO.read(new File("src/Image/logout.png"));
//			ennemies = ImageIO.read(new File("src/Image/Ennemies.png"));
//			dirt = ImageIO.read(new File("src/Image/groundfinal.png"));
			
			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		setPreferredSize(new Dimension(100, 100));
		init();
		DAOFichier readBase = new DAOFichier();
		map = readBase.readFile();
//		map = readFile();
		fillTabImg(map);

	}
	
	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}
	
	private void init() {
		this.rockford = new Rockford(this);
	}
	
//	public static Image getGround() {
//		return ground;
//	}
//
//	public static Image getWall() {
//		return wall;
//	}

//	public static Image getRock() {
//		return rock;
//	}

//	public static Image getDiamond() {
//		return diamond;
//	}
//
//	public static Image getExit() {
//		return exit;
//	}

//	public static Image getDirt() {
//		return dirt;
//	}

	public ImagePerso getImagePerso(int i,int j) {
		return tabImg[i][j];
	}

	public int getLargeur() {
		return largeur;
	}

	public int getLongueur() {
		return longueur;
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


//	public void moveEnnemies() {
//		int[] coord = new int[2];
//		Random x = new Random();
//		Random y = new Random();
//
//		int n = x.nextInt(tailleImg);
//		int z = y.nextInt(tailleImg);
//		int newX = this.xEnnemies + n;
//		int newY = this.yEnnemies + z;
//		coord = this.pixelToIndex(this.xEnnemies, newX);
//		coord = this.pixelToIndex(this.yEnnemies, newY);
//		if (newX > 0 && tabImg[coord[0]][coord[1]].getImage() != this.wall)
//			if (newY < 0 && tabImg[coord[0]][coord[1]].getImage() != this.wall)
//				this.yEnnemies = newY;
//		this.xEnnemies = newX;
//	}

//	public void enableExit(int x, int y, String typeMove) {
//		if (map[x][y] == 'e') {
//			int[] coord = indexToPixel(x, y);
//			this.xRockford = coord[0];
//			this.yRockford = coord[1];
//
//			switch (typeMove) {
//			case "up":
//				Rockford = RockFordUp;
//				break;
//			case "down":
//				Rockford = RockFordDown;
//				break;
//			case "right":
//				Rockford = RockFordRight;
//				break;
//			case "left":
//				Rockford = RockFordLeft;
//				break;
//
//			}
//		}
//	}

//	public char[][] readFile() throws FileNotFoundException {
//		String FileName = "src/Image/text.txt";
////		Scanner scnr = new Scanner(new FileReader(FileName));
////
////		String str = "";
////		char[] charArray;
//		char[][] map = new char[longueur][largeur];
////		int n = 0;
//
//		FileReader text = new FileReader(FileName);
//		int x = 0;
//		for (int i = 0; i < 25; i++) {
//			for (int j = 0; j < 25; j++) {
//				Scanner scnr = new Scanner(text);
//				String mapTemp = scnr.nextLine();
//				map[i][j] = mapTemp.charAt(x);
//				scnr.close();
//				x++;
//			}
//		}

		
//		DAOFichier readBase = new DAOFichier();
//		char[][] map = readBase.readFile();
//		
////		System.out.println(map);
//		return map;
//
//	}

	public void removeSymbol() {
		int xIndex = this.rockford.getImgPerso().getXIndex();
		int yIndex = this.rockford.getImgPerso().getYIndex();
		
		if (this.getImagePerso(xIndex,yIndex).getElement() =='d')
			{
				this.getImagePerso(xIndex,yIndex).setElement('g') ;	
				System.out.println(this.getImagePerso(xIndex,yIndex).getElement());
			}
		else if (this.getImagePerso(xIndex,yIndex).getElement() =='D')
		{
			this.getImagePerso(xIndex,yIndex).setElement('g') ;	
			countDiamond++;
			System.out.println(this.getImagePerso(xIndex,yIndex).getElement());
		}
		if (countDiamond == 10) {
			this.tabImg[18][24] = new ImagePerso(exit.getExit(), 24 * ImagePerso.getTailleImg(), 18 * ImagePerso.getTailleImg(), 'e');
		}

		}

	public void fillTabImg(char[][] map) {

		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {

				char elem = map[i][j];
				// tabImg[i][j].setX(j * 32);
				// tabImg[i][j].setY(i * 32);
				switch (elem) {

				case 'w': {
					tabImg[i][j] = new ImagePerso(wall.getWall(), j * ImagePerso.getTailleImg(), i * ImagePerso.getTailleImg(), elem);
					// tabImg[i][j].setImage(wall);
					break;
				}
				case 'd': {
					tabImg[i][j] = new ImagePerso(dirt.getDirt(), j * ImagePerso.getTailleImg(), i * ImagePerso.getTailleImg(), elem);
					// tabImg[i][j].setImage(ground);
					break;
				}
				case 'r': {
					tabImg[i][j] = new ImagePerso(boulder.getBoulder(), j * ImagePerso.getTailleImg(), i * ImagePerso.getTailleImg(), elem);
					// tabImg[i][j].setImage(ground);
					break;
				}
				case 'D': {
					tabImg[i][j] = new ImagePerso(diamond.getDiamond(), j * ImagePerso.getTailleImg(), i * ImagePerso.getTailleImg(), elem);
					// tabImg[i][j].setImage(ground);
					break;
				}
				case 'e': {
					tabImg[i][j] = new ImagePerso(exit.getExit(), j * ImagePerso.getTailleImg(), i * ImagePerso.getTailleImg(), elem);
					// tabImg[i][j].setImage(ground);
					break;
				}
				case 'g': {
					tabImg[i][j] = new ImagePerso(ground.getGround(), j * ImagePerso.getTailleImg(), i * ImagePerso.getTailleImg(), elem);
					// tabImg[i][j].setImage(ground);
					break;
				}
				}
			}

		}

	}

	public void paint(Graphics g) {
//		super.paintComponent(g);

//		
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {

				g.drawImage(tabImg[i][j].getImage(), i * ImagePerso.getTailleImg(), j * ImagePerso.getTailleImg(), ImagePerso.getTailleImg(),
						ImagePerso.getTailleImg(), this);
			}
		}
		
		g.drawImage(this.rockford.getImgPerso().getImage(), this.rockford.getImgPerso().getXPixel(), this.rockford.getImgPerso().getYPixel(), ImagePerso.getTailleImg(), ImagePerso.getTailleImg(), this);
//		moveEnnemies();
		//g.drawImage(ennemies, this.xEnnemies, this.yEnnemies, this.tailleImg, this.tailleImg, this);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int code = event.getKeyCode();
		ImagePerso imgPersoRockford;
		switch (code) {
		case KeyEvent.VK_UP:
//			map.getRockford().moveUp();
			this.rockford.move("up");
			imgPersoRockford = this.rockford.getImgPerso();
			imgPersoRockford.setImage(Rockford.getRockFordUp());
			break;
		case KeyEvent.VK_RIGHT:

			this.rockford.move("right");
			imgPersoRockford = this.rockford.getImgPerso();
			imgPersoRockford.setImage(Rockford.getRockFordRight());
			break;
		case KeyEvent.VK_LEFT:
			this.rockford.move("left");
			imgPersoRockford = this.rockford.getImgPerso();
			imgPersoRockford.setImage(Rockford.getRockFordLeft());
			break;

		case KeyEvent.VK_DOWN:
			this.rockford.move("down");
			imgPersoRockford = this.rockford.getImgPerso();
			imgPersoRockford.setImage(Rockford.getRockFordDown());
			break;

		}
		this.removeSymbol();
		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {


	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
