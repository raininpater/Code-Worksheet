import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {

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

	public static boolean isValidWord(String word) {
		char[] words = word.toLowerCase().toCharArray();
		for (int i = 0; i < words.length; i++) {
			if (words[i] < 97 || words[i] > 122) {
				return false;
			}
		}
		return true;
	}

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

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(wordToSignature("Hello, World"));
		System.out.println(signatureToWords("4663"));
	}

}
