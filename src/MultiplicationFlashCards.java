import java.io.IOException;

/**
 * Used to construct multiplication flash cards.
 * 
 * @author Krishan
 *
 */

public class MultiplicationFlashCards extends AbstractFlashCards {

	/**
	 * Constructs a deck of flashcards by adding the multiplication tables of the
	 * number specified as flashcards to the deck.
	 * 
	 * @param multiplier The integer that multiplication tables will be generated
	 *                   for and added to the flashcards deck.
	 * @throws IOException
	 */

	public MultiplicationFlashCards(int multiplier) {
		this(new int[] { multiplier }); // constructor chaining
	}

	/**
	 * Constructs a deck of flashcards by adding the multiplication tables of the
	 * numbers specified as flashcards to the deck.
	 * 
	 * @param multipliers An integer array containing integers that multiplication
	 *                    tables will be generated for and added to the flashcards
	 *                    deck.
	 * @throws IOException
	 */

	public MultiplicationFlashCards(int[] multipliers) {
		String question; // loops through multipliers and adds
		String answer; // multiplication tables to ArrayList and
		for (int multiplier : multipliers) { // HashMap with addCard method.
			for (int j = 1; j < 13; j++) {
				question = multiplier + " * " + j;
				answer = String.valueOf(multiplier * j);
				super.addCard(question, answer);
			}
		}
		this.reset();
	}
}
