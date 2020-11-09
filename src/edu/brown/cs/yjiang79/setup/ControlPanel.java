package edu.brown.cs.yjiang79.setup;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ControlPanel extends JPanel{
	
	private JButton resumeButton;        
    private JButton pauseButton;
    private JLabel ballNumLabel;
    private JTextField ballNumTextField;
    private JLabel velocityLabel;
    private JLabel velocityLabel1;
    private JTextField velocityTextField;
    private BouncingBallPanel bouncingBallPanel;
    private JFrame mainFrame;
    
    public ControlPanel(JFrame mainFrame) {
    	this.mainFrame = mainFrame;
    	resumeButton = new JButton("Resume");
    	pauseButton  = new JButton("Pause");
    	ballNumLabel = new JLabel();
    	ballNumLabel.setText("Number of balls");
    	velocityLabel = new JLabel();
    	velocityLabel.setText("Speed");
    	velocityLabel1 = new JLabel();
    	velocityLabel1.setText("X");
    	ballNumTextField = new JTextField(10);
    	velocityTextField = new JTextField(10);
    	  	
    	resumeButton.setMaximumSize(new Dimension(100, 30));
    	pauseButton.setMaximumSize(new Dimension(100, 30));
    	ballNumLabel.setMaximumSize(new Dimension(100, 30));
    	ballNumTextField.setMaximumSize(new Dimension(100, 30));
    	velocityLabel.setMaximumSize(new Dimension(100, 30));
    	velocityLabel1.setMaximumSize(new Dimension(100, 30));
    	velocityTextField.setMaximumSize(new Dimension(100, 30));
    	    	
    	resumeButton.addActionListener(new ResumeAction());
	    pauseButton.addActionListener(new PauseAction());
	    ballNumTextField.addActionListener(new BallNumAction());
	    velocityTextField.addActionListener(new VelocityAction());
	    
    	final JPanel line1 = new JPanel();
    	line1.add(resumeButton);
    	line1.add(pauseButton);
    	line1.add(ballNumLabel);
    	line1.add(ballNumTextField);
    	line1.add(velocityLabel);
    	line1.add(velocityTextField);
    	line1.add(velocityLabel1);
    	
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    add(line1);
	    
	    setOpaque(true);
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
	 
	 class BallNumAction implements ActionListener {
	     public void actionPerformed(ActionEvent e) {
	    	 final int ballNum = Integer.parseInt(ballNumTextField.getText());
	    	 if(ballNum > 0 && ballNum < 100) {
	    		 bouncingBallPanel.setBallNum(ballNum); 
	    	 } else {
	    		 JOptionPane.showMessageDialog(mainFrame,
	    				    "The num of balls should be positive and smaller than 100.",
	    				    "Ball Number Error",
	    				    JOptionPane.ERROR_MESSAGE);
	    	 }
	    	 
	     }
	 }
	 
	 class VelocityAction implements ActionListener {
	     public void actionPerformed(ActionEvent e) {
	    	 final float velocity = Float.parseFloat(velocityTextField.getText());
	    	 if(velocity > 0 && velocity < 3) {
	    		 bouncingBallPanel.setVelocity(velocity); 
	    	 } else {
	    		 JOptionPane.showMessageDialog(mainFrame,
	    				    "The speed arrange is 0-3x.",
	    				    "Speed Error",
	    				    JOptionPane.ERROR_MESSAGE);
	    	 }
	    	 
	     }
	 }
}
