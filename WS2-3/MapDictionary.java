import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * The class contains a constructor for the class MapDictionary that takes a
 * String path to the dictionary and stores the dictionary in a multi-valued
 * Map.
 * Time cost = 4550ms
 * 
 * @author Jing Li
 */
public class MapDictionary implements Dictionary {

	/**
	 * The Map implementation I selected is the Hashmap, for this kid of Map, each
	 * element contains a key, in which I stores the signature; and a value, in
	 * which I store the set of words that match the signature. By this way I can
	 * easily find and return the set of words if I have found the signature of the
	 * words(key).
	 */
	Map<String, HashSet<String>> all = new HashMap<>();

	/**
	 * The constructor for the class MapDictionary that takes a String path to the
	 * dictionary and stores the dictionary in a multi-valued Map.
	 * 
	 * @throws FileNotFoundException Throw an exception if can't find the file.
	 */
	public MapDictionary(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		while (sc.hasNextLine()) {
			String word = sc.next();
			if (PredictivePrototype.isValidWord(word)) {
				if (all.containsKey(PredictivePrototype.wordToSignature(word))) {
					all.get(PredictivePrototype.wordToSignature(word)).add(word.toLowerCase());
				} else {
					HashSet<String> set = new HashSet<>();
					set.add(word.toLowerCase());
					all.put(PredictivePrototype.wordToSignature(word), set);
				}
			}
		}
		sc.close();
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
		if (all.containsKey(signature)) {
			return all.get(signature);
		} else {
			return new HashSet<String>();
		}
	}

}
