package textApplication;

import java.util.concurrent.TimeUnit;

/**
 * Creates the board and handles all the methods
 * need for each action, such as moving your character,
 * detecting if you've been hit, and moving the asteroids
 * @author James Khalil and Joshua Tolentino
 *
 */
public class Board {
	//Instance variables
	private String setup[][];
	int rPosition;
	int cPosition;
	static int MAXASTEROIDS = 4;
	int asteroidCounter = 0;
	Asteroid asteroidArray[] = new Asteroid[MAXASTEROIDS];
	
	/**
	 * Constructor class
	 * @param setup for the board
	 * @param rPosition is the row position of the character
	 * @param cPosition is the column position of the character
	 */
	public Board(String setup[][],int rPosition,int cPosition) {
		this.setSetup(setup);
		this.rPosition = rPosition;
		this.cPosition = cPosition;
	}

	/**
	 * Setter method
	 * @param setup of the board
	 */
	void setSetup(String setup[][]) {
		this.setup = setup;
	}

	/**
	 * Places the character on the board in a
	 * position specified earlier
	 */
	public void setCharacter() {
		setup[rPosition][cPosition] = "^";
	}
	
	/**
	 * prints the board to the console and
	 * waits before doing anything else
	 */
	public void printBoard() {
		for(int rIndex = 0; rIndex < setup.length; rIndex++) {
			System.out.println();
			for(int cIndex = 0; cIndex < setup[rIndex].length; cIndex++)
			System.out.print(setup[rIndex][cIndex]);
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Move the character up
	 */
	public void moveUp() {
		setup[rPosition][cPosition] = ".";
		rPosition--;
		setup[rPosition][cPosition] = "^";
	}
	
	/**
	 * Move the character down
	 */
	public void moveDown() {
		setup[rPosition][cPosition] = ".";
		rPosition++;
		setup[rPosition][cPosition] = "v";
	}

	/**
	 * Move the character left
	 */
	public void moveLeft() {
		setup[rPosition][cPosition] = ".";
		cPosition--;
		setup[rPosition][cPosition] = "<";
	}
	
	/**
	 * Move the character right
	 */
	public void moveRight() {
		setup[rPosition][cPosition] = ".";
		cPosition++;
		setup[rPosition][cPosition] = ">";
	}
	
	/**
	 * Creates asteroids at random and from
	 * random sides. Never lets more than 5
	 * asteroids exist at a time.
	 */
	public void createAsteroid() {
		if (asteroidCounter < MAXASTEROIDS) {
			int randomSide = (int) (Math.random() * 4);
			int randomSection = (int) (Math.random() * 9);
			switch (randomSide) {
				case 0:
					Asteroid Top = new Asteroid("Top",0,randomSection);
					for (int index = 0; index <= asteroidCounter; index++) {
						if (asteroidArray[index] == null) {
							asteroidArray[asteroidCounter] = Top;
						}
					}
					asteroidCounter++;
					setup[0][randomSection] = "*";
					break;
					
				case 1:
					Asteroid Bottom = new Asteroid("Bottom",9,randomSection);
					for (int index = 0; index <= asteroidCounter; index++) {
						if (asteroidArray[index] == null) {
							asteroidArray[asteroidCounter] = Bottom;
						}
					}
					asteroidCounter++;
					setup[9][randomSection] = "*";
					break;
					
				case 2:
					Asteroid Left = new Asteroid("Leftside",randomSection,0);
					for (int index = 0; index <= asteroidCounter; index++) {
						if (asteroidArray[index] == null) {
							asteroidArray[asteroidCounter] = Left;
						}
					}
					asteroidCounter++;
					setup[randomSection][0] = "*";
					break;
					
				case 3:
					Asteroid Right = new Asteroid("Rightside",randomSection,9);
					for (int index = 0; index <= asteroidCounter; index++) {
						if (asteroidArray[index] == null) {
							asteroidArray[asteroidCounter] = Right;
						}
					}
					asteroidCounter++;
					setup[randomSection][9] = "*";
					break;
			}
		}
	}
	
	/**
	 * Moves all the asteroids on screen at once
	 */
	public void moveAsteroid() {
		for(int index = 0; index < asteroidCounter; index++) {
			if (asteroidArray[index] != null) {
				setup[asteroidArray[index].getrPosition()][asteroidArray[index].getcPosition()] = ".";
				asteroidArray[index].move();
				try {
					setup[asteroidArray[index].getrPosition()][asteroidArray[index].getcPosition()] = "*";
				}
				catch(Exception e){
					asteroidArray[index] = null;
					asteroidCounter--;
				}
			}
		}
	}
	
	/**
	 * detects if the character hit an asteroid
	 * @return a boolean that is true if you hit an asteroid
	 * otherwise false
	 */
	public boolean hitAsteroid() {
		for(int rIndex = 0; rIndex < setup.length; rIndex++) {
			for(int cIndex = 0; cIndex < setup[rIndex].length; cIndex++)
			if (setup[rIndex][cIndex].equalsIgnoreCase("v") ||
				setup[rIndex][cIndex].equalsIgnoreCase("^") ||
				setup[rIndex][cIndex].equalsIgnoreCase("<") ||
				setup[rIndex][cIndex].equalsIgnoreCase(">")) {
				return false;
			}
		}
		return true;
	}
}