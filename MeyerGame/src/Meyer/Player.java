package Meyer;

public class Player {
	
	private String name;
	private int lives = 6;

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player(String name) {
		this.name = name;
	}
	
	public int throwDice(Dice dice1, Dice dice2) {
		int dieValue1 = dice1.rollDice();
		int dieValue2 = dice2.rollDice();
		int diesValueTotal = dieValue1 + dieValue2;
		System.out.println(getName() + " rolled: " + diesValueTotal);
		return diesValueTotal;
	}
}
