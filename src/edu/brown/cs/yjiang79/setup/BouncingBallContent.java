package edu.brown.cs.yjiang79.setup;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BouncingBallContent extends JPanel {
	
	private final BouncingBallPanel bouncingBallPanel; 
	private final JPanel buttonPanel;
	
 
	public BouncingBallContent() {
		this.bouncingBallPanel = new BouncingBallPanel();
	    this.buttonPanel = new JPanel();
	    
	    JButton resumeButton = new JButton("Resume");        
	    JButton pauseButton  = new JButton("Pause");
	    
	    resumeButton.addActionListener(new ResumeAction());
	    pauseButton.addActionListener(new PauseAction());
	    
	    buttonPanel.setLayout(new GridLayout(2,1));
	    buttonPanel.add(resumeButton);
	    buttonPanel.add(pauseButton);
	     
	    this.setLayout(new BorderLayout());
	    this.add(buttonPanel, BorderLayout.EAST);
	    this.add(bouncingBallPanel, BorderLayout.CENTER);
	}
 
 
	 class ResumeAction implements ActionListener {
	     public void actionPerformed(ActionEvent e) {
	    	 bouncingBallPanel.resume();
	     }
	 }
	 
	 
	 class PauseAction implements ActionListener {
	     public void actionPerformed(ActionEvent e) {
	    	 bouncingBallPanel.pause();
	     }
	 }
}

