package pong;

import java.awt.Color;

import sedgewick.StdDraw;

public class Canvas extends Game{
	private Color color;
	
	public Canvas(Color color){
		this.color = color;
	}
	
	public void draw(){
		StdDraw.setPenColor(this.color);
		StdDraw.filledRectangle(0.5, 0.5, 1, 1);
		StdDraw.setPenColor(Color.white);
		StdDraw.rectangle(0.5, 0.5, 0.5, 0.5);
		StdDraw.text(0.5, 1.025, "Pong^2 by Visaal");
		StdDraw.text(0.75, 1.025, "Rally score: " + rally);

		//"Pong.io by Visaal"

	}
	

}
