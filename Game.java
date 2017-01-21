package pong;

import java.awt.Color;
import java.awt.event.KeyEvent;

import sedgewick.StdDraw;

/**
 * TODO: Make an AI player Collision detection on the ball
 * 		 Revise how the game starts/resets after the ball is lost
 * 		 Keep score between the players
 * 		 Make the frame wider maybe, or at least have that option
 * 		 Make more fluid controls - like make it so you can hold down a button
 * 		 
 * 		 Make the art of the rectangles look cooler/change the color scheme
 * 
 * 		 Add a trail to the ball to see it's path, I think this would be cool
 * 			Make an rolling array and plot those points as well
 * 
 * 		 Make it so player score on both sides
 * @author Visaal
 *
 */
public class Game {
	static boolean game_over;
	public static int rally;
	
	
	
	public void play(Ball b, Player p1, Player p2, Canvas canvas, int rally) {
		char c = 'a';
		while (!game_over) {
			StdDraw.clear();
			// I need to figure out a way to process the char inputs faster
			c = nextKeyTyped();
			// draw canvas
			canvas.draw();

			// drawing ball
			b.draw();
			// drawing players
			p2.draw();
			p1.draw();

			System.out.println(c);

			// letting player quit game if they press q
			// System.out.println(game_over);
			if (c == 'q') {
				game_over = !game_over;
				StdDraw.clear();
				StdDraw.text(0.5, 0.5, "GAME OVER");
				StdDraw.show();
			}

			StdDraw.show(15);

		}
	}

	public char nextKeyTyped() {
		if (StdDraw.hasNextKeyTyped()) {
			return StdDraw.nextKeyTyped();
		} else {
			return '0';
		}
	}

	public static void main(String[] args) {
		// creating objects
		StdDraw.setCanvasSize(800, 800);
		Color beige = new Color(102, 101, 71);
		Color lightRed = new Color(251,46,1);
		Color green = new Color(111, 203, 159);
		
		//create new game object
		Game game = new Game();
		
		//create two players - up-arrow/down-arrow and w/s to move
		Player p1 = new Player(lightRed, 1 - 0.025, 0.5, 0, 2, 1);
		Player p2 = new Player(green, 0.025, 0.5, 0, 2, 0);
		
		//create ball (color, starting-x, starting-y, player, player)
		Ball b = new Ball(0.1, 0.1, 0.025, p1, p2);
		//create canvas
		Canvas canvas = new Canvas(beige);
	
		// starting game
		game_over = false;
		game.play(b, p1, p2, canvas, rally);
		
		// quit screen
		while (game_over) {
			if (StdDraw.hasNextKeyTyped() && StdDraw.nextKeyTyped() == 'q') {
				game_over = !game_over;
				game.play(b, p1, p2, canvas, rally);

			}
		}

	}

}
