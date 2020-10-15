package edu.brown.cs.yjiang79.setup;

import javax.swing.*;

public class BouncingBallMain extends JApplet {
	
	final static int DEFAULT_WIDTH = 375;
	final static int DEFAULT_HEIGHT = 300;
	
	
	public BouncingBallMain() {
		add(new BouncingBallContent());
	}
 
	public static void main(String[] args) {
		final JFrame demo = new JFrame("Bouncing Ball");
		demo.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
		demo.setContentPane(new BouncingBallContent());
     
		demo.setVisible(true); 
	}
}