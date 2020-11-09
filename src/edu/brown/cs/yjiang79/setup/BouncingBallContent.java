package edu.brown.cs.yjiang79.setup;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


class BouncingBallContent extends JPanel {
	
	private final BouncingBallPanel bouncingBallPanel; 
	private final ControlPanel controlPanel;
	
 
	public BouncingBallContent(JFrame demo) {
		bouncingBallPanel = new BouncingBallPanel();
		controlPanel = new ControlPanel(demo);
		
		controlPanel.setBouncingBallPanel(bouncingBallPanel);
	     
	    setLayout(new BorderLayout());
	    add(controlPanel, BorderLayout.PAGE_START);
	    add(bouncingBallPanel, BorderLayout.CENTER);
	}
 
 
}

