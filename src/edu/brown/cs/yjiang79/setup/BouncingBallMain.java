package edu.brown.cs.yjiang79.setup;

import javax.swing.JApplet;
import javax.swing.JFrame;


@SuppressWarnings("deprecation")
public class BouncingBallMain extends JApplet {
	
	final static int DEFAULT_WIDTH = 375*2;
	final static int DEFAULT_HEIGHT = 300*2;
		
 
	public static void main(String[] args) {
		final JFrame demo = new JFrame("Bouncing Ball");
		demo.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
		demo.setContentPane(new BouncingBallContent(demo));
     
		demo.setVisible(true); 
	}
}