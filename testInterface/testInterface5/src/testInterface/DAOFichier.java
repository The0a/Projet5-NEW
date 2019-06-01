//package testInterface;
//
//
//import java.awt.Image;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class DAOFichier {
//	private String FileName = "src/Image/text.txt";
//	private String message = "";
//	char[][] line = new char[4][4];
//	ImagePerso[][] tabImg = new ImagePerso[4][4];
//
//	public String getFileName() {
//		return FileName;
//	}
//
//	public void setFileName(String fileName) {
//		FileName = fileName;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public DAOFichier(Panneau decors) throws FileNotFoundException {
//		super();
//		readFile(decors);
//	}
//
//	public void readFile(Panneau decors) throws FileNotFoundException {
//		File text = new File(FileName);
//		int x = 0;
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				Scanner scnr = new Scanner(text);
//				line[i][j] = scnr.nextLine().charAt(x);
//				scnr.close();
//
//				switch (line[i][j]) {
//
//				case 'a': {
//					tabImg[i][j] = decors.getWall();
//					decors.setxDecors(decors.getxDecors());
//					decors.setyDecors(decors.getyDecors());
//					decors.repaint();
//					break;
//				}
//				case 'b': {
//					decors.setxDecors(decors.getxDecors());
//					decors.setyDecors(decors.getyDecors());
//					tabImg[i][j] = decors.getRock();
//					decors.repaint();
//
//					break;
//				}
//
//				}
//
//				decors.setxDecors(decors.getxDecors()+50);
//				message = message + line[i][j];
//				x += 1;
//			}
//			decors.setyDecors(decors.getyDecors()+50);
//			message = message + "\n";
//
//		}
//	}
//}
