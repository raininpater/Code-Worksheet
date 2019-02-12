import java.io.FileNotFoundException;

public class Sig2WordsMap {
	public static void main(String[]args) throws FileNotFoundException {
		MapDictionary ld = new MapDictionary();
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i] + ": " + ld.signatureToWords(args[i]));
		}
	}
}
