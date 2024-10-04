  
/**
 * All code in Game.java, Asteroid.java and Board.java
 * have been developed by both James Khalil and Joshua Tolentino.
 * We have both equal code participation despite of only James pushing the changes.
 * 
 */
package textApplication;

import java.util.Scanner;

/**
 * Runs all of the methods created in
 * the other two classes and interacts
 * with the user
 * @author James Khalil and Joshua Tolentino
 *
 */
public class Game {
	
	/**
	 * Starts the game
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.play();
		
	}
	
	/**
	 * Handles all the methods required to
	 * play the game and end the game
	 */
	public void play(){
		Scanner input = new Scanner(System.in);
		String setup[][] = {
				{".",".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".",".","."},
		};
		Board board = new Board(setup,4,4);
		board.setCharacter();
		board.printBoard();
		boolean bDead = false;
		while (bDead == false) {
			System.out.println("");
			System.out.println("Which way would you like the ship to go?");
			System.out.println("A for left");
			System.out.println("D for right");
			System.out.println("W for up");
			System.out.println("S for down");
			System.out.println("Enter none of them to go nowhere");
			
			String direction = input.nextLine();
			if (direction.equalsIgnoreCase("W")) board.moveUp();
			else if (direction.equalsIgnoreCase("S")) board.moveDown();
			else if (direction.equalsIgnoreCase("A")) board.moveLeft();
			else if (direction.equalsIgnoreCase("D")) board.moveRight();
			
			board.moveAsteroid();
			
			int random = (int) (Math.random() * 2);
			if(random == 0) {
				board.createAsteroid();
			}
			
			bDead = board.hitAsteroid();
			board.printBoard();
		}System.out.println("");
		System.out.println("GAME OVER");
	}
}