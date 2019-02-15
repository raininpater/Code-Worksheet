import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class TreeDictionary implements Dictionary {

	Tree all = new Tree();

	public TreeDictionary() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("words"));
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

	@Override
	public Set<String> signatureToWords(String signature) {

		return all.search(all, signature.toCharArray());
	}

//	public static void main(String[] args) throws FileNotFoundException {
//		TreeDictionary a = new TreeDictionary();
//		System.out.println(a.signatureToWords("4663"));
//	}

}
