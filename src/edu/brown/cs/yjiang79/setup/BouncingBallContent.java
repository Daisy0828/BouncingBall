package edu.brown.cs.yjiang79.setup;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BouncingBallContent extends JPanel {
	
	private final BouncingBallPanel bouncingBallPanel; 
	private final ControlPanel controlPanel;
	
 
	public BouncingBallContent() {
		this.bouncingBallPanel = new BouncingBallPanel();
		this.controlPanel = new ControlPanel();
		
		this.controlPanel.setBouncingBallPanel(this.bouncingBallPanel);
	     
	    this.setLayout(new BorderLayout());
	    this.add(controlPanel, BorderLayout.EAST);
	    this.add(bouncingBallPanel, BorderLayout.CENTER);
	}
 
 
}

