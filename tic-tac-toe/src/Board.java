/**
 * 
 * @author Ryu
 * @since 2022-06-15
 */
public class Board {
	public String[] grid;
	
	public Board() {
		this.grid = new String[9];
		for(int i = 0; i < this.grid.length; i++) {
				this.grid[i] = "_";
		}
	}
	
	/**
	 * adds the input string to a specified index of the grid array
	 * 
	 * @param index the index of the grid array where the String should be placed
	 * @param input the String which represents either the user or the computer (X or O)
	 */
	public void add(int index, String input) {
		this.grid[index] = input;
	}
	
	/**
	 * sets up the grid array into a 3-by-3 format and stores it into a single string
	 */
	public String toString() {
		String str = "";
		
		for(int i = 0; i < 8; i ++) {
			str += this.grid[i] + " ";
			if((i+1) % 3 == 0) {
				str += System.lineSeparator();
			}
		}
		str += this.grid[8];
		return str;
	}
	
	/**
	 * check whether the specified tile of the grid is empty
	 * 
	 * @param index the index of the grid array to be checked
	 * @return true if the tile is empty, false otherwise
	 */
	public boolean tileIsEmpty(int index) {
		if(grid[index].equals("_")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return true if the whole grid is filled, false otherwise
	 */
	public boolean gridIsFull() {
		for(int i = 0; i < this.grid.length; i++) {
			if(tileIsEmpty(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public String checkLeftCorner() {
			if(this.grid[0].equals(this.grid[3]) && this.grid[0].equals(this.grid[6])) {
				return this.grid[0];
			}
			else if(this.grid[0].equals(this.grid[1]) && this.grid[0].equals(this.grid[2])) {
				return this.grid[0];
			}
			else {
				return "";
			}
	}
	
	/**
	 * 
	 * @return
	 */
	public String checkRightCorner() {
		if(this.grid[8].equals(this.grid[5]) && this.grid[8].equals(this.grid[2])) {
			return this.grid[8];
		}
		else if(this.grid[8].equals(this.grid[7]) && this.grid[8].equals(this.grid[6])) {
			return this.grid[8];
		}
		else {
			return "";
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String checkMiddle() {
		if(this.grid[4].equals(this.grid[0]) && this.grid[4].equals(this.grid[8])) {
			return this.grid[4];
		}
		else if(this.grid[4].equals(this.grid[2]) && this.grid[4].equals(this.grid[6])) {
			return this.grid[4];
		}
		else if(this.grid[4].equals(this.grid[1]) && this.grid[4].equals(this.grid[7])) {
			return this.grid[4];
		}
		else if(this.grid[4].equals(this.grid[3]) && this.grid[4].equals(this.grid[5])) {
			return this.grid[4];
		}
		else {
			return "";
		}
	}
	
}