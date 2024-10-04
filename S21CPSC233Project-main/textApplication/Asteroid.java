package textApplication;

/**
 * Handles all the aspects of the asteroids on screen,
 * including their position and how they move
 * @author James Khalil and Joshua Tolentio
 * 
 */
public class Asteroid {
	//Instance variables
	private String direction;
	private int rPosition;
	private int cPosition;
	
	/**
	 * Constructor class for asteroid
	 * @param direction determines if the asteroid moves
	 * left, right, up, or down
	 * @param rPosition is the row position
	 * @param cPosition is the column position
	 */
	Asteroid(String direction, int rPosition,int cPosition){
		this.direction = direction;
		this.rPosition = rPosition;
		this.cPosition = cPosition;
	}
	
	/**
	 * Determines how the asteroid should move
	 */
	public void move() {
		if (direction.equalsIgnoreCase("Top")) {
			rPosition++;
		}
		else if (direction.equalsIgnoreCase("Bottom")) {
			rPosition--;
		}
		else if (direction.equalsIgnoreCase("Leftside")) {
			cPosition++;
		}
		else if (direction.equalsIgnoreCase("Rightside")) {
			cPosition--;
		}
	}

	/**
	 * Getter method
	 * @return column position
	 */
	int getcPosition() {
		return cPosition;
	}

	/**
	 * Getter method
	 * @return row position
	 */
	int getrPosition() {
		return rPosition;
	}
	
	

}