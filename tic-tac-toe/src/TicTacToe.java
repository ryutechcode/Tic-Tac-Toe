/**
 * 
 * @author Ryu
 * @since 2022-06-15
 */

public class TicTacToe {
	public Board board;
	public NPC npc;
	public User user;
	public boolean winnerExists;
	
	public TicTacToe() {
		this.board = new Board();
		this.npc = new NPC();
		this.user = new User();
		this.winnerExists = false;
	}
	
	/**
	 * display welcome message.
	 */
	public void welcome() {
		System.out.println("Welcome to Tic-Tac-Toe game!");
		System.out.println();
	}
	
	/**
	 * display thank you message.
	 */
	public void exit() {
		System.out.println("Thank you for playing!");
		System.out.println();
	}
	
	/**
	 * 
	 */
	public void addUserInput() {
		int index = user.getIndex();
		if(this.board.tileIsEmpty(index)) {
			this.board.add(index, user.getString());
			return;
		}
		else {
			System.out.println("The specified tile is already filled");
			System.out.println("Choose another tile");
			System.out.println();
			this.addUserInput();
		}
	}
	
	/**
	 * 
	 */
	public void addNPCInput() {
		int index = npc.getIndex();
		if(this.board.tileIsEmpty(index)) {
			this.board.add(index, npc.getString());
			return;
		}
		else {
			this.addNPCInput();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean checkWinner() {
		if(this.board.checkLeftCorner().equals("X") || this.board.checkMiddle().equals("X") || this.board.checkRightCorner().equals("X")) {
			this.WinnerIsUser();
			this.winnerExists = true;
			return true;
		}
		else if(this.board.checkLeftCorner().equals("O") || this.board.checkMiddle().equals("O") || this.board.checkRightCorner().equals("O")) {
			this.WinnerIsNPC();
			this.winnerExists = true;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 */
	private void WinnerIsUser() {
		System.out.println("Congratulations! You've Won!");
		System.out.println();
	}
	
	/**
	 * 
	 */
	private void WinnerIsNPC() {
		System.out.println("Computer Won.");
		System.out.println();
	}
	
	/**
	 * 
	 */
	public void GameWasDraw() {
		System.out.println("It was a draw.");
		System.out.println();	
	}
	
	/**
	 * 
	 * @return return true if there was a winner, false otherwise
	 */
	public boolean thereWasAWinner() {
		return this.winnerExists;
	}
	
	/**
	 * 
	 * @return 
	 */
	public boolean finished() {
		return this.board.gridIsFull() || this.checkWinner();
	}
	
	/**
	 * display the current board
	 */
	public void showBoard() {
		System.out.println(this.board.toString());
		System.out.println();
	}
}