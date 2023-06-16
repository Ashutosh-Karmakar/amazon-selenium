package selenium.ashu.two;

import org.apache.commons.text.RandomStringGenerator;

public class randomEnglishWord {
	  
	public static void main(String args[]) {
		  for (int i = 0; i < 10; i++) {
	            String randomWord = generateRandomWord();
	            System.out.println(randomWord);
	        }
	}
	
	 public static String generateRandomWord() {
	        int wordLength = random.nextInt(MAX_WORD_LENGTH - MIN_WORD_LENGTH + 1) + MIN_WORD_LENGTH;
	        StringBuilder wordBuilder = new StringBuilder();

	        for (int i = 0; i < wordLength; i++) {
	            char randomLetter = (char) ('a' + random.nextInt(ALPHABET_SIZE));
	            wordBuilder.append(randomLetter);
	        }

	        return wordBuilder.toString();
	 }
}
