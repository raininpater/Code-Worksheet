import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class TreeDictionary implements Dictionary {

	Tree all = new Tree();
	public TreeDictionary() throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("words"));
		while(sc.hasNextLine()) {
			String word = sc.next();
			Tree cur = all;
			if(PredictivePrototype.isValidWord(word)) {
				char[] sig = PredictivePrototype.wordToSignature(word).toCharArray();
				if(all.containsSig(all, sig)) {
					all.search(all, sig).add(word.toLowerCase());
				}else {
					for(char c :sig) {
						if(cur.getChildren()[Character.getNumericValue(c)-2]==null) 
							cur.getChildren()[Character.getNumericValue(c)-2] = new Tree();
							cur = cur.getChildren()[Character.getNumericValue(c)-2];			
					}
					cur.words.add(word.toLowerCase());
				}
			}
		}
	}
	

	
	
	@Override
	public Set<String> signatureToWords(String signature) {
		return all.search(all, signature.toCharArray());
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		TreeDictionary a = new TreeDictionary();
		System.out.println(a.signatureToWords("4663"));
	}
	
}
