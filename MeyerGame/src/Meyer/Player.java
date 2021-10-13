package Meyer;

public class Player {

	private String name;
	private int lives = 6;
	private int playerResult; 
	private boolean playerAlive;

	public boolean isPlayerAlive() {
		return playerAlive;
	}

	public void setPlayerAlive(boolean playerAlive) {
		this.playerAlive = playerAlive;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void looseLife() {
		lives--;
		System.out.println(getName() + " has " + getLives() + " lives left. ");
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
	
	public int getPlayerResults() {
		return playerResult;
	}
	
	

	public int throwDice(Dice dice1, Dice dice2) {
		int dieValue1 = dice1.rollDice();
		int dieValue2 = dice2.rollDice();
		int diesValueTotal = dieValue1 + dieValue2;
		System.out.println(getName() + " rolled: " + diesValueTotal);
		playerResult = diesValueTotal;
		return diesValueTotal;
	}

	public void resetLives() {
		this.lives = 6;
	}
}
