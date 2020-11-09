package edu.brown.cs.yjiang79.setup;

import java.awt.Color;
import java.util.Random;

public class Ball {
	
	final static int DEFAULT_DIAMETER = 20;
 
	private int x;           
	private int y;
	private int diameter;
	private Color color;
	 
	private int velocityXOriginal;   
	private int velocityYOriginal;
	private int velocityX;   
	private int velocityY;
	 
	private int limitX;  
	private int limitY;
 
	public Ball(int x, int y, int velocityX, int velocityY) {
		final Random r=new Random();
	    this.x = x;
	    this.y = y;
	    diameter = DEFAULT_DIAMETER;
	    color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),127);
	    velocityXOriginal = velocityX;
	    velocityYOriginal = velocityY;
	    this.velocityX = velocityX;
	    this.velocityY = velocityY;
	}
 
	public void changeVelocity(float velocity) {
		velocityX = (int) (velocityXOriginal * velocity);
		velocityY = (int) (velocityYOriginal * velocity);
	}
 
	public void move(int panelWidth, int panelHeight) {
		final Random r=new Random();
	    x += velocityX;
	    y += velocityY;  
	    
	    limitX  = panelWidth  - diameter;
	    limitY = panelHeight - diameter;
	     
	    if(x < 0) {                  
	        x = 0;            
	        velocityX = -velocityX; 
	        color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),127);
	    } else if(x > limitX) { 
	        x = limitX;    
	        velocityX = -velocityX;  
	        color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),127);
	    }
	     
	    if(y < 0) {                 
	        y = 0;
	        velocityY = -velocityY;
	        color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),127);
	        
	    } else if(y > limitY) { 
	        y =  limitY;
	        velocityY = -velocityY;
	        color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),127);
	    }
	}
 
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getDiameter() {
		return diameter;
	}
	 
	public Color getColor() {
		return color;
	}

}