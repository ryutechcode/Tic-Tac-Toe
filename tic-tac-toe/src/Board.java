import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

/**
 * 
 * @author Ryu
 * @since 2022-06-15
 */
public class Board extends Canvas{
	String [][] grid;
	public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    
	public Board() {
		//this.grid = new String[3][3];
				this.grid =  new String [][] {{"X", "X", "X"},{"O", "O", "O"},{"X", "O", "X"}};
			}

			void setup() {
				JFrame frame = new JFrame("Tic-Tac-Toe");
		        Canvas canvas = new Board();
		        canvas.setSize(400, 400);
		        frame.add(canvas);
		        frame.pack();
		        frame.setVisible(true);	
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    }

			@Override
			public void paint(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				int w = WIDTH/3;
				int h = HEIGHT/3;
				g2.drawLine(w, 0, w, HEIGHT);
				g2.drawLine(w*2, 0, w*2, HEIGHT);
				g2.drawLine(0, h, WIDTH, h);
				g2.drawLine(0, h*2, WIDTH, h*2);

				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						int x = w * j;
						int y = h * i;
						String spot = this.grid[i][j];
						if(spot.equals("X")) {
							int xr = w/4;
							g2.setStroke(new BasicStroke(3));
							g2.drawLine(x+(3*xr), y+xr, x+xr, y+(3*xr));
							g2.drawLine(x+xr, y+xr, x+(3*xr), y+(3*xr));
						}
						else if(spot.equals("O")){
							int xr = w/4;
							g2.setStroke(new BasicStroke(3));
							g2.drawOval(x+xr, y+xr, 2*xr, 2*xr);
						}
					}
				}
	}
	
	/**
	 * adds the input string to a specified index of the grid array
	 * 
	 * @param index the index of the grid array where the String should be placed
	 * @param input the String which represents either the user or the computer (X or O)
	 */
	public void insert(int row, int col, String input) {
		this.grid[row][col] = input;
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
//	public String checkLeftCorner() {
//			if(this.grid[0].equals(this.grid[3]) && this.grid[0].equals(this.grid[6])) {
//				return this.grid[0];
//			}
//			else if(this.grid[0].equals(this.grid[1]) && this.grid[0].equals(this.grid[2])) {
//				return this.grid[0];
//			}
//			else {
//				return "";
//			}
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public String checkRightCorner() {
//		if(this.grid[8].equals(this.grid[5]) && this.grid[8].equals(this.grid[2])) {
//			return this.grid[8];
//		}
//		else if(this.grid[8].equals(this.grid[7]) && this.grid[8].equals(this.grid[6])) {
//			return this.grid[8];
//		}
//		else {
//			return "";
//		}
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public String checkMiddle() {
//		if(this.grid[4].equals(this.grid[0]) && this.grid[4].equals(this.grid[8])) {
//			return this.grid[4];
//		}
//		else if(this.grid[4].equals(this.grid[2]) && this.grid[4].equals(this.grid[6])) {
//			return this.grid[4];
//		}
//		else if(this.grid[4].equals(this.grid[1]) && this.grid[4].equals(this.grid[7])) {
//			return this.grid[4];
//		}
//		else if(this.grid[4].equals(this.grid[3]) && this.grid[4].equals(this.grid[5])) {
//			return this.grid[4];
//		}
//		else {
//			return "";
//		}
//	}
//	
}