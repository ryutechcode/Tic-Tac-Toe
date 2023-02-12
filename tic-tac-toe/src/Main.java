import java.util.Scanner;

/**
 * 
 * @author Ryu
 * @since 2022-06-15
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		System.out.print("Press Enter");
		reader.nextLine();
		System.out.println();
		game.welcome();
		reader.nextLine();
		//instructions
		
		while(!game.finished()) {
			game.addUserInput();
			game.showBoard();
			if(game.finished()) {
				break;
			}
			game.addNPCInput();
			game.showBoard();
		}
		if(!game.thereWasAWinner()) {
			game.GameWasDraw();
		}
		
		game.exit();
		reader.close();
	}

}