//package edu.brown.cs.yjiang79.setup;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Random;
//
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
//import edu.brown.cs.yjiang79.setup.BouncingBallMain;
//
//public class BouncingBallPanel extends JPanel {
//	
//	final static int INTERVAL = 50; 
//	private int ballNum = 5; 
//	private float velocity = 1;
//	private final ArrayList<Integer> velocityList;
//	private int currentVolocityIndex;
//	private final ArrayList<Ball> ballList;
//	private final Timer timer; 
//
//
//	public BouncingBallPanel() {
//		ballList = new ArrayList<>();
//		velocityList = new ArrayList<Integer>();
//        for (int i=1; i<21; i++) {
//        	velocityList.add(i);
//        }
//        Collections.shuffle(velocityList);
//        currentVolocityIndex = 0;
//		for(int i = 0; i < ballNum; i++) {
//			ballList.add(generateBall());
//		}
//		
//	    timer = new Timer(INTERVAL, new TimerAction());
//	    timer.start();
//	    addMouseListener(new BouncingBallMouseListener());
//	}
// 
//	private Ball generateBall() {
//		final int x = BouncingBallMain.DEFAULT_WIDTH / 2;
//		final int y = BouncingBallMain.DEFAULT_HEIGHT / 2;
//		
//		final Random random = new Random();		
//		final int directionX = (int) (random.nextInt(100)) > 50 ? 1 : -1;
//		final int directionY = (int) (random.nextInt(100)) > 50 ? 1 : -1;
//		
//		final int velocityX = velocityList.indexOf(currentVolocityIndex) * directionX;
//		final int velocityY = (21 - velocityX) * directionY;
//		currentVolocityIndex =  (currentVolocityIndex + 1) % 20;
//		Ball ball = new Ball(x, y, velocityX, velocityY);
//		ball.changeVelocity(velocity);
//		
//		return ball;
//	}
//	
//	public void pause() {
//	    timer.stop();
//	}
//	
//	public void resume() {
//	    timer.start();
//	}
//	
//	public void setBallNum(int ballNum) {
//		while(ballNum < this.ballNum) {
//			ballList.remove(0);
//			this.ballNum --;
//		}
//		while(ballNum > this.ballNum) {
//			ballList.add(generateBall());
//			this.ballNum ++;
//		}
//	}
//	
//	public void setVelocity(float velocity) {
//		for(final Ball ball : ballList) {
//			this.velocity = velocity; 
//			ball.changeVelocity(velocity);
//		}
//	}
//
//	public void paintComponent(Graphics g) {
//	    super.paintComponent(g); 
//
//	    for(Ball ball : ballList) {
//	    	g.setColor(ball.getColor());
//	    	g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());	    
//	    }
//	    		          
//	}
// 
//	class TimerAction implements ActionListener {
//	    public void actionPerformed(ActionEvent e) {
//	    	for(Ball ball : ballList) {
//		    	ball.move(getWidth(), getHeight());
//		    }  
//		    repaint();     
//	    }
//	}
//	
//	class BouncingBallMouseListener implements MouseListener {
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			if(e.isMetaDown()) {
//				final int currBallNum = ballNum - 1;
//				if(currBallNum > 0 && currBallNum < 100) {
//					setBallNum(currBallNum);
//				}
//			} else {
//				final int currBallNum = ballNum + 1;
//				if(currBallNum > 0 && currBallNum < 100) {
//					setBallNum(currBallNum);
//				}
//			}
//		}
//
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//
//	}
//}


package edu.brown.cs.yjiang79.setup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import edu.brown.cs.yjiang79.setup.BouncingBallMain;

public class BouncingBallPanel extends JPanel {
	
	final static int INTERVAL = 50; 
	private int ballNum = 5; 
	private float velocity = 1;
	private final ArrayList<Integer> velocityList;
	private int currentVolocityIndex;
	private final ArrayList<Ball> ballList;
//	private final Timer timer; 
	private Color ballColor;
	private int ballX;
	private int ballY;
	private int diameter;
	
	private boolean isPaused;


	public BouncingBallPanel() {
		ballList = new ArrayList<>();
		velocityList = new ArrayList<Integer>();
		isPaused = false;
        for (int i=1; i<21; i++) {
        	velocityList.add(i);
        }
        Collections.shuffle(velocityList);
        currentVolocityIndex = 0;
		for(int i = 0; i < ballNum; i++) {
			
			ballList.add(generateBall());
		}
		
//	    timer = new Timer(INTERVAL, new TimerAction());
//	    timer.start();
	    addMouseListener(new BouncingBallMouseListener());

	    
	}
 
	private Ball generateBall() {
		final int x = BouncingBallMain.DEFAULT_WIDTH / 2;
		final int y = BouncingBallMain.DEFAULT_HEIGHT / 2;
		
		final Random random = new Random();		
		final int directionX = (int) (random.nextInt(100)) > 50 ? 1 : -1;
		final int directionY = (int) (random.nextInt(100)) > 50 ? 1 : -1;
		
		final int velocityX = velocityList.indexOf(currentVolocityIndex) * directionX;
		final int velocityY = (21 - velocityX) * directionY;
		currentVolocityIndex =  (currentVolocityIndex + 1) % 20;
		Ball ball = new Ball(x, y, velocityX, velocityY);
		ball.changeVelocity(velocity);
		
		Thread ballThread = new Thread() {
	    	public synchronized void run() {
	            while (true) {
	            	if(!isPaused) {
	            		ball.move(getWidth(), getHeight());
		    		    ballColor = ball.getColor();
		    		    ballX = ball.getX();
		    		    ballY = ball.getY();
		    		    diameter = ball.getDiameter();
		    		    repaint(); 
		    		    
	            	}
	            	try {
	                    Thread.sleep(INTERVAL);  
	                 } catch (InterruptedException ex) { }
	    		    
	            }
	          }
	    }; 
	    ballThread.start();
	    
		return ball;
	}
	
	public void pause() {
//	    timer.stop();
		isPaused = true;
	}
	
	public void resume() {
//	    timer.start();
		isPaused = false;
	}
	
	public void setBallNum(int ballNum) {
		while(ballNum < this.ballNum) {
			ballList.remove(0);
			this.ballNum --;
		}
		while(ballNum > this.ballNum) {
			ballList.add(generateBall());
			this.ballNum ++;
		}
	}
	
	public void setVelocity(float velocity) {
		for(final Ball ball : ballList) {
			this.velocity = velocity; 
			ball.changeVelocity(velocity);
		}
	}

	public void paintComponent(Graphics g) {
	    super.paintComponent(g); 
	    for (final Ball ball : ballList) {
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
	
	class BouncingBallMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.isMetaDown()) {
				final int currBallNum = ballNum - 1;
				if(currBallNum > 0 && currBallNum < 100) {
					setBallNum(currBallNum);
				}
			} else {
				final int currBallNum = ballNum + 1;
				if(currBallNum > 0 && currBallNum < 100) {
					setBallNum(currBallNum);
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
}


