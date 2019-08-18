import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Used to construct language flash cards.
 * 
 * @author Krishan
 *
 */

public class LanguageFlashCards extends AbstractFlashCards {

	private String COMMA_DELIMITER = ",";
	private String filename;

	/**
	 * Constructs a deck of flashcards by reading a csv file and adding new cards
	 * with the obtained data.
	 * 
	 * @param filename The name of the csv file that is to be read.
	 * @throws IOException
	 */
	public LanguageFlashCards(String filename) throws IOException {
		this.filename = filename;

		/*
		 * myBuffer reads the file and the data obtained is used to add flashcards to
		 * the HashMap and ArrayList with addCard method.
		 */

		FileReader myFile = new FileReader(this.filename);
		BufferedReader myBuffer = new BufferedReader(myFile);

		String question = myBuffer.readLine();
		String[] questionAndAnswer = new String[2];
		while ((question = myBuffer.readLine()) != null) {
			questionAndAnswer = question.split(COMMA_DELIMITER);
			super.addCard(questionAndAnswer[0], questionAndAnswer[1]);
		}
		this.reset();
		myFile.close();
		myBuffer.close();

	}

}
