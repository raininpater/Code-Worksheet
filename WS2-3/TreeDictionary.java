import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class TreeDictionary implements Dictionary {

	Tree all = new Tree();

	/**
	 * The method stores the dictionary in your own tree implementation. It should
	 * support ecient search as well as ecient insertion of new words. In
	 * addition, TreeDictionary should support nding words when only some initial
	 * part of the signature (a pre x) is known. This is so that the user can see
	 * the part of the word they intend to type as they are typing.
	 * 
	 * Time cost = 6513ms
	 * 
	 * @throws FileNotFoundException Throws an exception if the file is not found.
	 */
	public TreeDictionary(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		while (sc.hasNextLine()) {
			String word = sc.next();
			Tree cur = all;
			if (PredictivePrototype.isValidWord(word)) {
				char[] sig = PredictivePrototype.wordToSignature(word).toCharArray();
				if (all.containsSig(all, sig)) {
					for (int i = 0; i < sig.length; i++) {
						if (!cur.getChildren()[Character.getNumericValue(sig[i]) - 2].getWords()
								.contains(word.substring(0, i + 1))) {
							cur.getChildren()[Character.getNumericValue(sig[i]) - 2].getWords()
									.add(word.toLowerCase().substring(0, i + 1));
						}
						cur = cur.getChildren()[Character.getNumericValue(sig[i]) - 2];
					}
				} else {
					for (int i = 0; i < sig.length; i++) {
						if (cur.getChildren()[Character.getNumericValue(sig[i]) - 2] == null)
							cur.getChildren()[Character.getNumericValue(sig[i]) - 2] = new Tree();
						if (!cur.getChildren()[Character.getNumericValue(sig[i]) - 2].getWords()
								.contains(word.substring(0, i + 1))) {
							cur.getChildren()[Character.getNumericValue(sig[i]) - 2].getWords()
									.add(word.toLowerCase().substring(0, i + 1));
						}
						cur = cur.getChildren()[Character.getNumericValue(sig[i]) - 2];
					}
				}
			}
		}
	}

	/**
	 * The method that returns, in a Set<String>, the matching words (and prefixes
	 * of words) for the given signature. The character length of each of the
	 * returned words or prefixes must be the same as the input signature.
	 * 
	 * @param signature The signature inputed to the method
	 */
	@Override
	public Set<String> signatureToWords(String signature) {

		return all.search(all, signature.toCharArray());
	}
}
