package Meyer;

public class MayerGame {

	Player player1;
	Player player2;
	Dice dice1;
	Dice dice2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MayerGame game = new MayerGame();

	}

	public MayerGame() {
		player1 = new Player("Kurt");
		player2 = new Player("Gert");
		dice1 = new Dice();
		dice2 = new Dice();
		startGame();

	}

	public void startGame() {
		
		int sumPlayer1 = player1.throwDice(dice1, dice2);
		int sumPlayer2 = player2.throwDice(dice1, dice2);
		
		
		if (!(player1.getLives() == 0) || !(player2.getLives() == 0)) {
		if(sumPlayer1 > sumPlayer2) {
			player1.setLives(player1.getLives()-1);
		}
		else if (sumPlayer1 < sumPlayer2) {
			player2.setLives(player2.getLives()-1);
		} 
		} else {
			System.out.println();
		}
		
		if(sumPlayer1 > sumPlayer2) {
			System.out.println(player1.getName() + " wins!");
		} else {
			System.out.println(player2.getName() + " wins!");
		}
	}

}
