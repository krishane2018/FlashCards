import java.io.IOException;
import java.util.Scanner;

/**
 * Program used to simulate the use of multiplication flashcards.
 * 
 * @author Krishan
 *
 */
public class MultiplicationFlashCardApplication {

	/**
	 * Simulates the usage of multiplication flashcards until the user quits.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * User inputs space separated integers which are parsed into an integer array.
		 * Integer array is passed as a parameter for the MultiplicationFlashCards
		 * constructor.
		 */

		Scanner scanner = new Scanner(System.in);
		System.out.println("Which times tables would you like to test?" +
		" (Between 1 and 12 inclusive)");
		String[] stringMultipliers = scanner.nextLine().split(" ");
		int[] integerMultipliers = new int[stringMultipliers.length];
		for (int i = 0; i < stringMultipliers.length; i++) {
			integerMultipliers[i] = Integer.parseInt(stringMultipliers[i]);
		}
		MultiplicationFlashCards myCards = new MultiplicationFlashCards(integerMultipliers);

		/*
		 * Application continues to run till the user quits.
		 */

		String yesOrNo = "Y";
		int score = 0;
		while (yesOrNo.equals("Y") && myCards.nextCard()) {
			if (myCards.getScore() > score) {
				System.out.println("You're correct!");
			} else {
				System.out.println("Sorry, please try again.");
			}
			score = myCards.getScore();
			System.out.println("Score = " + score);
			System.out.println("Next? (Y or N)");
			yesOrNo = scanner.nextLine().toUpperCase();

		}

		System.out.println("You've got a score of " + myCards.getScore() + " so far.");
		scanner.close();

	}

}
