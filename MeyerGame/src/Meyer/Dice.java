package Meyer;

public class Dice {

	private int dice1;

	public int rollDice() {
		int dice1 = (int)(Math.random()*6+1);
		int sum = dice1;
		
		return sum;
		
	}
}


