import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * This class contains a constructor for the class ListDictionary that takes a
 * String path to the dictionary, reads stores it in an ArrayList. Each entry of
 * the ArrayList must be a pair, consisting of the word that has been read in
 * and its signature. For this purpose, you will need to create a class named
 * WordSig that pairs words and signatures
 * 
 * @author Jing Li
 *
 */
public class ListDictionary implements Dictionary {

	List<WordSig> all = new ArrayList<WordSig>();

	/**
	 * This is the constructor for the class ListDictionary that takes a String path
	 * to the dictionary, reads stores it in an ArrayList.
	 * Time cost = 3620ms
	 * 
	 * @throws FileNotFoundException Throw an exception if the file is not found.
	 */
	public ListDictionary(String path) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(path));
		while (sc.hasNextLine()) {
			String word = sc.next();
			if (PredictivePrototype.isValidWord(word)) {
				WordSig ws = new WordSig(word.toLowerCase(), PredictivePrototype.wordToSignature(word));
				all.add(ws);
			}
		}
		sc.close();

		Collections.sort(all);
	}

	/**
	 * The signatureToWords method must be re-written as an instance method in the
	 * List-Dictionary class to use the stored dictionary. The ArrayList<WordSig>
	 * must be stored in sorted order and the signatureToWords method must use
	 * binary search to perform the look-ups.
	 * 
	 * @param signature The signature to be transformed to a set of words.
	 * @return A set of words is returned.
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		Set<String> set = new HashSet<String>();
		int index = Collections.binarySearch(all, new WordSig(null, signature));
		if (index < 0) {
			return set;
		} else {
			set.add(all.get(index).getWords());
			for (int i = index + 1; i < all.size(); i++) {
				if (signature.equals(all.get(i).getSignature())) {
					set.add(all.get(i).getWords());
				} else {
					break;
				}
			}
			for (int i = index - 1; i >= 0; i--) {
				if (signature.equals(all.get(i).getSignature())) {
					set.add(all.get(i).getWords());
				} else {
					break;
				}
			}
			return set;
		}
	}
}
