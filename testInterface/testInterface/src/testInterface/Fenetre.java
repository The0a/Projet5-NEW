package testInterface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class Fenetre extends JFrame  {
	
	
	Panneau pan = new Panneau();
	
	
	Fenetre()throws FileNotFoundException {
		
		this.setTitle("My First Fenetre in Java");

		setSize(26*32, 27*32);
//		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(pan);
		
	
		this.setFocusable(true);
		this.addKeyListener(pan);
		
		
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				requestFocus();
			}
		});

		
		
//		pack();

		setVisible(true);
//		createSpire(lecteur);
	}
}