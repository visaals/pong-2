package pong;

import java.awt.Color;

import sedgewick.StdDraw;

public class Ball extends Game {
	private double radius;
	private Color color;
	private double speed; // set to 0.05
	private double x; //x position
	private double y; //y position
	private boolean hit_right;
	private boolean hit_top;
	private Player p1;
	private Player p2;
	private double[] xarr = new double[100];
	private double[] yarr = new double[100];
	private int counter;

	public Ball(double x, double y, double radius, Player p1, Player p2) {
		this.x = x;
		this.y = y;
		
		this.radius = radius;
		this.color = Color.blue;
		this.speed = 0.0125;
		
		this.hit_right = false;
		this.hit_top = false;
		
		this.p1 = p1;
		this.p2 = p2;
		this.counter = 0;
	}

	public void draw() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(this.x, this.y, this.radius);
		// make it move in a random direction
		move();
		
//		for (int i = 0; i < 100; i ++){
//			StdDraw.filledCircle(xarr[i], yarr[i], this.radius/2);
//		}
	}
	

	public void move() {
		//checks if it hits the top or a player
		hit_top();
		hit_right(p1,p2);
		
		
		if (!this.hit_top) {
			moveUpYAxis();
		} else {
			moveDownYAxis();
		}
		if (!this.hit_right) {
			
			moveRight();
		} else {
			moveLeft();
		}
		
		if (this.x > 1 || this.x < 0){
			this.x = 0.5;
			this.y = 0.5;	
			rally = 0;
		}
		
		//store this.x and this.y in a 
		xarr[counter % 100] = this.x;
		yarr[counter % 100] = this.y;
		counter++;
		
		
	
	}
	
	
	
	
	public void moveRight() {
		this.x += this.speed;
	}

	public void moveLeft() {
		this.x -= this.speed;
	}

	public void moveUpYAxis() {
		this.y += this.x * this.x  / 32;
	}

	public void moveDownYAxis() {
		this.y -= this.x * this.x/ 32;
	}

	public void hit_top() {
		if (this.y >= 0.975) {
			this.hit_top = !this.hit_top;
		} else if (this.y <= 0.025) {
			this.hit_top = !this.hit_top;
		}
	}

	public void hit_right(Player p1, Player p2) {
		//gotta change this so it bounces if it hit's a player
		//get player. top boundary and bottom boundary
		double top = p1.getY() + 0.1;
		double bottom = p1.getY() - 0.1;
		
		double top2 = p2.getY() + 0.1;
		double bottom2 = p2.getY() - 0.1;
		
		if (this.x >= 0.925 && this.y < top && this.y > bottom) {
				this.x = 0.924;
				this.hit_right = !this.hit_right;
				rally++;

				System.out.println(rally);
			
		} else if (this.x <= 0.075 && this.y < top2 && this.y > bottom2 ) {
				this.x = 0.076;
				this.hit_right = !this.hit_right;
				rally++;

				System.out.println(rally);
		}

	}


	// auto generated getters and setters
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
