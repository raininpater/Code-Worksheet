import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * This class three methods, wordToSignature takes takes a word and returns a
 * numeric signature. isValidWord tests if a word is a alphabetic word or not.
 * signatureToWords takes the given numeric signature and returns a set of
 * possible matching words from the dictionary.
 * 
 * Time cost = 2596ms
 * 
 * @author Jing Li
 *
 */
public class PredictivePrototype {

	/**
	 * The reason why we should use the StringBuffer class rather than String class
	 * is that every time when we change a variable of String type, it will create
	 * The method takes a word and returns a numeric signature.
	 * 
	 * @param word The word to be transformed to a signature.
	 * @return A String type of signature is returned.
	 */
	public static String wordToSignature(String word) {
		char[] words = word.toLowerCase().toCharArray();
		StringBuffer sB = new StringBuffer();
		for (int i = 0; i < words.length; i++) {
			if (words[i] >= 97 && words[i] <= 99) {
				sB.append("2");
			} else if (words[i] >= 100 && words[i] <= 102) {
				sB.append("3");
			} else if (words[i] >= 103 && words[i] <= 105) {
				sB.append("4");
			} else if (words[i] >= 106 && words[i] <= 108) {
				sB.append("5");
			} else if (words[i] >= 109 && words[i] <= 111) {
				sB.append("6");
			} else if (words[i] >= 112 && words[i] <= 115) {
				sB.append("7");
			} else if (words[i] >= 116 && words[i] <= 118) {
				sB.append("8");
			} else if (words[i] >= 119 && words[i] <= 122) {
				sB.append("9");
			} else {
				sB.append(" ");
			}
		}
		return sB.toString();
	}

	/**
	 * The method that test whether a word is an alphabetic word
	 * 
	 * @param word The word to be tested.
	 * @return True: the word is an alphabetic word. False: The word is a
	 *         non-alphabetic word.
	 */
	public static boolean isValidWord(String word) {
		char[] words = word.toLowerCase().toCharArray();
		for (int i = 0; i < words.length; i++) {
			if (words[i] < 97 || words[i] > 122) {
				return false;
			}
		}
		return true;
	}

	/**
	 * The method takes the given numeric signature and returns a set of possible
	 * matching words from the dictionary.
	 * 
	 * @param signature The signature to be transformed to words
	 * @return A set of words was returned.
	 * @throws FileNotFoundException If the file is not found, throw an exception.
	 */
	public static Set<String> signatureToWords(String signature) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("words"));
		Set<String> all = new HashSet<String>();
		while (sc.hasNextLine()) {
			String words = sc.next();
			if (isValidWord(words) && signature.equals(wordToSignature(words))) {
				all.add(words.toLowerCase());
			}
		}
		sc.close();
		return all;
	}
}
