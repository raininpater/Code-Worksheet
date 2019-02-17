import java.io.FileNotFoundException;

/**
 * The class Sigs2WordsMap that uses the MapDictionary class. It should be
 * possible to modify just one line in your Sigs2WordsList program so that it
 * can work with any given implementation of the Dictionary interface.
 * 
 * @author Jing Li
 *
 */
public class Sig2WordsMap {
	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		MapDictionary ld = new MapDictionary("words");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + ld.signatureToWords(args[i]));
		}
		long end = System.currentTimeMillis();
		System.out.println("Time cost = " + (end - start) + "ms");
	}
}
