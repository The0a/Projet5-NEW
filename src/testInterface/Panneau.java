package testInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Panneau extends JPanel implements KeyListener {

	int largeur = 25;
	int longueur = 25;
	private Image RockFordUp, RockFordDown, RockFordRight, RockFordLeft, ground, wall, rock;
	private Image Rockford;
	private int xRockford = 32;
	private int yRockford = 32;
	private ImagePerso[][] tabImg = new ImagePerso[longueur][largeur];

	Panneau() throws FileNotFoundException {
		setSize(25*32, 25*32);
		try {
			RockFordUp = ImageIO.read(new File("src/Image/RockFordUp.png"));
			RockFordDown = ImageIO.read(new File("src/Image/RockFordDown.png"));
			RockFordRight = ImageIO.read(new File("src/Image/RockFordRight.png"));
			RockFordLeft = ImageIO.read(new File("src/Image/RockFordLeft.png"));
			wall = ImageIO.read(new File("src/Image/wall.png"));
			rock = ImageIO.read(new File("src/Image/rock.png"));
			ground = ImageIO.read(new File("src/Image/ground.png"));
			Rockford= RockFordRight;

		} catch (IOException e) {
			e.printStackTrace();
		}
//		setPreferredSize(new Dimension(100, 100));
		setForeground(Color.GREEN);
		readFile();
	}

	public void moveUp() {

		this.yRockford = this.yRockford - 32;
		Rockford = RockFordUp;

	}

	public void moveRight() {
		Rockford = RockFordRight;
		this.xRockford = this.xRockford + 32;

	}

	public void moveLeft() {
		Rockford = RockFordLeft;
		this.xRockford = this.xRockford - 32;

	}

	public void moveDown() {
		Rockford = RockFordDown;
		this.yRockford = this.yRockford + 32;

	}

	public void readFile() throws FileNotFoundException {
		String FileName = "src/Image/text.txt";

		File text = new File(FileName);
		int k = 0;
		Scanner scnr = new Scanner(text);
		String lineStr = scnr.nextLine();
		scnr.close();

		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {

				char elem = lineStr.charAt(k);
//				tabImg[i][j].setX(j * 32);
//				tabImg[i][j].setY(i * 32);
				System.out.println(i + "," + j);
				switch (elem) {

				case 'a': {
					tabImg[i][j] = new ImagePerso(wall, j*32, i*32);
//							tabImg[i][j].setImage(wall);
					break;
				}
				case 'b': {
					tabImg[i][j] = new ImagePerso(ground, j*32, i*32);
//					tabImg[i][j].setImage(ground);
					break;
				}

				}
				k += 1;
			}
		}
	}

	public void paint(Graphics g) {
//		super.paintComponent(g);

		System.out.println("decors");
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {

				g.drawImage(tabImg[i][j].getImage(), i * 32, j * 32, 32, 32, this);
			}
		}
		System.out.println("rockford");
		g.drawImage(Rockford, this.xRockford, this.yRockford, 32, 32, this);
	}

	@Override
	public void keyPressed(KeyEvent arg7) {
		int code = arg7.getKeyCode();

		switch (code) {
		case KeyEvent.VK_UP:
//			map.getRockford().moveUp();
			moveUp();
			break;
		case KeyEvent.VK_RIGHT:

			moveRight();
			break;
		case KeyEvent.VK_LEFT:

			moveLeft();
			break;

		case KeyEvent.VK_DOWN:

			moveDown();
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
