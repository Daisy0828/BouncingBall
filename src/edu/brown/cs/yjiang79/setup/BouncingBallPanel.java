package edu.brown.cs.yjiang79.setup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import edu.brown.cs.yjiang79.setup.BouncingBallMain;

public class BouncingBallPanel extends JPanel {
	
	final static int INTERVAL = 100; 
	final static int BALL_NUM = 5; 
	
	private final ArrayList<Ball> ballList;
	private final Timer timer;           


	public BouncingBallPanel() {
		this.ballList = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			final int x = BouncingBallMain.DEFAULT_WIDTH / 2;
			final int y = BouncingBallMain.DEFAULT_HEIGHT / 2;
			
			final Random random = new Random();
			
			final int directionX = (int) (random.nextInt(100)) > 50 ? 1 : -1;
			final int directionY = (int) (random.nextInt(100)) > 50 ? 1 : -1;
			final int velocityX = (int) (random.nextInt(20)) * directionX;
			final int velocityY = (20 - velocityX) * directionY;
			
			this.ballList.add(new Ball(x, y, velocityX, velocityY));
		}
		
	    this.timer = new Timer(INTERVAL, new TimerAction());
	    this.timer.start();
	}
 
	
	public void pause() {
	    this.timer.stop();
	}
	
	public void resume() {
	    this.timer.start();
	}

	public void paintComponent(Graphics g) {
	    super.paintComponent(g); 

	    for(Ball ball : this.ballList) {
	    	g.setColor(ball.getColor());
	    	g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
		    
	    }
	    		          
	}
 
	class TimerAction implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	for(Ball ball : ballList) {
		    	ball.move(getWidth(), getHeight());
		    }  
		    repaint();     
	    }
	}
}

