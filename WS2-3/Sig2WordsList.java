import java.io.FileNotFoundException;

/**
 * The command-line program Sigs2WordsList for testing the ListDictionary class.
 * 
 * @author Jing Li
 *
 */
public class Sig2WordsList {

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		ListDictionary ld = new ListDictionary("words");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + ld.signatureToWords(args[i]));
		}
		long end = System.currentTimeMillis();
		System.out.println("Time cost = " + (end - start) + "ms");
	}
}
