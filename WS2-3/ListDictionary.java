import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ListDictionary implements Dictionary {

	List<WordSig> all = new ArrayList<WordSig>();

	public ListDictionary() throws FileNotFoundException {

		Scanner sc = new Scanner(new File("words"));
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
				}else {
					break;
				}
			}
			for (int i = index - 1; i >= 0; i--) {
				if (signature.equals(all.get(i).getSignature())) {
					set.add(all.get(i).getWords());
				}else {
					break;
				}
			}
			return set;
		}
	}
}
