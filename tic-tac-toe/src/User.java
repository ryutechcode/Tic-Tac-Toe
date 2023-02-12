import java.util.Scanner;

/**
 * 
 * @author Ryu
 * @since 2022-06-15
 */

public class User {
	public String userString;
	public Scanner reader;
	
	public User() {
		this.userString = "X";
		this.reader = new Scanner(System.in);
	}
	
	/**
	 * User decides which tile on the grid they want to place a X.
	 * If the index is not valid (i.e. not an integer, no input, etc), then display a warning message
	 * and ask for a new index.
	 * 
	 * @return a valid index that the user had chosen
	 */
	public int getIndex() {
		System.out.print("Which tile do you want to place your X:");
		String indexAsString = reader.nextLine();
		try {
	        int index = Integer.parseInt(indexAsString);
	        if(this.checkIndexIsValid(index)) {
	        	return index;
	        }
	        else {
	        	return this.getIndex();
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("The tile you chose is not valid.");
	        System.out.println("Try again.");
	        System.out.println();
			return this.getIndex();
	    }
	}
	
	/**
	 * checks whether the index is between an expected range 0(inclusive) and 9(exclusive).
	 * 
	 * @param index where the is placed in the grid
	 * @return
	 */
	public boolean checkIndexIsValid(int index) {
		if(index >= 0 && index < 9) {
			return true;
		}
		else {
			System.out.println("The index you chose is not in the valid range.");
	        System.out.println("Try again.");
	        System.out.println();
			return false;
		}
	}
	
	public String getString() {
		return this.userString;
	}
}