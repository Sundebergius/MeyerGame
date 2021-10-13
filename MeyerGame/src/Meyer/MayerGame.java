package Meyer;

import java.util.ArrayList;
import java.util.Iterator;

public class MayerGame {

	Dice dice1;
	Dice dice2;
	ArrayList<Player> players = new ArrayList<Player>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MayerGame game = new MayerGame();

	}

	public MayerGame() {
		players.add(new Player("Kurt"));
		players.add(new Player("Gert"));
		players.add(new Player("Brian"));
		players.add(new Player("Mathilde"));
		players.add(new Player("Yvonne"));

		dice1 = new Dice();
		dice2 = new Dice();
		playRound();

	}

	public void playRound() {
		// ArrayList<Integer> results = new ArrayList<Integer>();

		for (Player player : players) {
			int resultPlayer = player.throwDice(dice1, dice2);
		}

		Player winner = null;
		for (Player player : players) {
			if (winner == null) {
				winner = player;
			} else {

				if (winner.getPlayerResults() < player.getPlayerResults()) {
					winner = player;
				}
			}

		}
		for (Player player : players) {
			if (winner != player) {
				player.looseLife();
			}
		}

		Iterator<Player> myIterator;
		myIterator = players.iterator();
		while (myIterator.hasNext()) {
			Player p = myIterator.next();
			if (p.getLives() == 0) {
				myIterator.remove();
			}
		}

		System.out.println("The winner of the round is " + winner.getName() + "!");

		System.out.println();
		
		if (players.size() > 1) {
			playRound();
		} else {
			System.out.println("The winner of the game is " + winner.getName() + "!");
		}

		/*
		 * if (sumPlayer1 > sumPlayer2) { player2.looseLife(); System.out.println(
		 * player1.getName() + " wins the round! Player 2 has " + player2.getLives() +
		 * " lives left. ");
		 * 
		 * } else { player1.looseLife(); System.out.println( player2.getName() +
		 * " wins the round! Player 1 has " + player1.getLives() + " lives left. ");
		 * 
		 * }
		 * 
		 * if (player1.getLives() == 0 || (player2.getLives() == 0)) { if
		 * (player1.getLives() == 0) { System.out.println(player2.getName() +
		 * " has won the game! "); } else { System.out.println(player1.getName() +
		 * " has won the game! "); } } else { playRound(); }
		 */
	}

	public void resetGame() {
		// Player.resetLives();
	}

}
