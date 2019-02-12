import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeDictionary {

	Node all = new Node();
	public TreeDictionary() throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("words"));
		while(sc.hasNextLine()) {
			String word = sc.next();
			if(PredictivePrototype.isValidWord(word)) {
				
			}
		}
	}
	
	
}
