package edu.brown.cs.yjiang79.setup;

import java.awt.*;

public class Ball {
	
	final static int DEFAULT_DIAMETER = 20;
	final static Color[] COLORLIST = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.GRAY};
 
	private int x;           
	private int y;
	private int diameter;
	private int color;
	 
	private int velocityX;   
	private int velocityY;
	 
	private int limitX;  
	private int limitY;
 
	public Ball(int x, int y, int velocityX, int velocityY) {
	    this.x = x;
	    this.y = y;
	    this.diameter = DEFAULT_DIAMETER;
	    this.color = 0;
	    this.velocityX = velocityX;
	    this.velocityY = velocityY;
	}
 

 
	public void move(int panelWidth, int panelHeight) {
	    this.x += velocityX;
	    this.y += velocityY;  
	    
	    this.limitX  = panelWidth  - this.diameter;
	    this.limitY = panelHeight - this.diameter;
	     
	    if(this.x < 0) {                  
	        this.x = 0;            
	        this.velocityX = -this.velocityX; 
	        this.color = (this.color + 1) % 7;
	    } else if(this.x > this.limitX) { 
	        this.x = this.limitX;    
	        this.velocityX = -this.velocityX;  
	        this.color = (this.color + 1) % 7;
	    }
	     
	    if(this.y < 0) {                 
	        this.y = 0;
	        this.velocityY = -this.velocityY;
	        this.color = (this.color + 1) % 7;
	        
	    } else if(this.y > this.limitY) { 
	        this.y =  this.limitY;
	        this.velocityY = -this.velocityY;
	        this.color = (this.color + 1) % 7;
	    }
	}
 
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getDiameter() {
		return this.diameter;
	}
	 
	public Color getColor() {
		return this.COLORLIST[this.color];
	}

}