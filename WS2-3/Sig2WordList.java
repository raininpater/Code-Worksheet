import java.io.FileNotFoundException;

public class Sig2WordList {

	public static void main(String[]args) throws FileNotFoundException {
		ListDictionary ld = new ListDictionary();
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i] + ": " + ld.signatureToWords(args[i]));
		}
	}
}
