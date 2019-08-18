import java.io.IOException;
import java.util.Scanner;

/**
 * Program used to simulate the use of language flashcards.
 * 
 * @author Krishan
 *
 */
public class LanguageFlashCardApplication {

	/**
	 * Simulates the usage of language flashcards until the user quits.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * Asks for name of file and following input String is used as the parameter for
		 * the LanguageFlashCards constructor.
		 */

		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the filename containing your flashcards? Exact letters!");
		String filename = scanner.nextLine();
		LanguageFlashCards myCards = new LanguageFlashCards(filename);

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
