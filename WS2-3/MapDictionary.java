import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapDictionary implements Dictionary {

	Map<String, HashSet<String>> all = new HashMap<>();

	public MapDictionary() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("words"));
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

	@Override
	public Set<String> signatureToWords(String signature) {
		if(all.containsKey(signature)) {
			return all.get(signature);
		}else {
			return new HashSet<String>();
		}
	}

}
