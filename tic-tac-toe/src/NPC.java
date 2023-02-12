import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Ryu
 * @since 2022-06-15
 */

public class NPC {
	public String npcString;
	
	public NPC() {
		this.npcString = "O";
	}
	
	/**
	 * Randomly picks an integer between 0(inclusive) and 9(exclusive) which is the index of the grid
	 * where the NPC will place an O
	 * 
	 * @return the randomly picked index 
	 */
	public int getIndex() {
		return ThreadLocalRandom.current().nextInt(0, 9);
	}
	
	
	public int getIndex2(){
		return 0;
	}
	
	
	public String getString() {
		return this.npcString;
	}
}