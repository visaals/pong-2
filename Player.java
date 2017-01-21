package pong;

import java.awt.Color;
import java.awt.event.KeyEvent;

import sedgewick.StdDraw;

public class Player extends Game {
	private Color color;
	public double x;
	private double y;
	private int up;
	private int down;
	private int player;

	// constructor
	public Player(Color color, double x, double y, int up, int down, int player) {
		super();
		this.color = color;
		this.x = x;
		this.y = y;
		this.up = up;
		this.down = down;
		this.player = player;
	}

	public void draw() {
		StdDraw.setPenColor(this.color);
		// draw a rectangle at the edge of the screen
		StdDraw.filledRectangle(this.x, this.y, 0.025, 0.1);
		move();
	}

	public void move() {
		//Restricts movement to canvas of height 1
		if(ArcadeKeys.isKeyPressed(this.player, this.up) && this.y <= 0.9){
			System.out.println("Move up");
			moveUp();
		}
		else if(ArcadeKeys.isKeyPressed(this.player, this.down) && this.y >= 0.125){
			System.out.println("Move down");

			moveDown();
		}
		

	}
	
	public void moveUp() {
		this.y += 0.05;
	}

	public void moveDown() {
		this.y -= 0.05;
	}

	
	
	
	
	
	
	// getters and setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
