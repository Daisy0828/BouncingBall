package edu.brown.cs.yjiang79.setup;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ControlPanel extends JPanel{
	
	private JButton resumeButton;        
    private JButton pauseButton;
    private BouncingBallPanel bouncingBallPanel;
    
    public ControlPanel() {
    	this.resumeButton = new JButton("Resume");
    	this.pauseButton  = new JButton("Pause");
    	
    	resumeButton.addActionListener(new ResumeAction());
	    pauseButton.addActionListener(new PauseAction());
	    
	    this.setLayout(new GridLayout(2,1));
	    this.add(resumeButton);
	    this.add(pauseButton);
    	
    }
    
    public void setBouncingBallPanel(BouncingBallPanel bouncingBallPanel) {
    	this.bouncingBallPanel = bouncingBallPanel;
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
