import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Abstract class used as a guideline to make flashcards for subclasses.
 * 
 * @author Krishan
 *
 */
public abstract class AbstractFlashCards {

	private HashMap<String, String> flashCards;
	private ArrayList<String> unansweredCards;
	private int score;
	private Scanner scanner;
	private Random random;

	/**
	 * Constructs a new empty set of flashcards and initializes the generic instance
	 * variables.
	 */

	public AbstractFlashCards() {
		flashCards = new HashMap<String, String>(); // initialization of instance variables
		unansweredCards = new ArrayList<String>();
		scanner = new Scanner(System.in);
		random = new Random();
		score = 0;
	}

	/**
	 * Adds a new flashcard to the deck of existing flashcards.
	 * 
	 * @param question String containing the question of the added flashcard.
	 * @param answer   String containing the answer of the added flashcard.
	 */

	protected void addCard(String question, String answer) {
		flashCards.put(question, answer);
	}

	/**
	 * Puts back all answered cards to the deck and shuffles it and resets the
	 * score.
	 */

	public void reset() {

		/*
		 * Resets the score and clears the ArrayList holding the flashcards. Readds them
		 * to the deck in a random order using the HashMap.
		 */

		score = 0;
		String[] questions = flashCards.keySet().toArray(new String[flashCards.size()]);
		unansweredCards.clear();
		for (String question : questions) {
			unansweredCards.add(random.nextInt(unansweredCards.size() + 1), question);
		}

	}

	/**
	 * Determines whether all the flash cards have been answered.
	 * 
	 * @return A boolean representing whether all the flash cards have been
	 *         answered.
	 */
	public boolean hasNext() {
		return (unansweredCards.size() > 0);
	}

	/**
	 * Outputs the next question from the deck of unanswered flashcards and asks the
	 * user for an answer. If the user is correct, their score is incremented by 1
	 * and the answered card is removed from the deck. Otherwise, the flashcard is
	 * inserted
	 * 
	 * @return A boolean representing whether all the flash cards have been
	 *         answered.
	 */
	public boolean nextCard() {

		/*
		 * Prints first flashcard in ArrayList and determines if user answer is correct.
		 * Flashcard removed from ArrayList if user is correct and score is incremented.
		 * Flashcard is randomly put back into the ArrayList if the user is incorrect.
		 */

		System.out.println(unansweredCards.toString());
		System.out.println(unansweredCards.get(0));
		if (scanner.hasNext(flashCards.get(unansweredCards.get(0)))) {
			score++;
		} else {
			unansweredCards.add(random.nextInt(unansweredCards.size()), unansweredCards.get(0));
		}
		scanner.nextLine();
		unansweredCards.remove(0);
		return hasNext();
	}

	/**
	 * Gets the score of the player.
	 * 
	 * @return An integer representing the score of the player.
	 */

	public int getScore() {
		return score;
	}
}
