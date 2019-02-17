import java.io.FileNotFoundException;

/**
 * The command-line programs for testing the method of signatureToWords in the
 * TreeDictionary class.
 * 
 * @author Jing Li
 */
public class Sig2WordsTree {

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		TreeDictionary tr = new TreeDictionary("words");
		for (int i = 0; i < args.length; i++) {
			System.out.println(tr.signatureToWords(args[i]));
		}
		long end = System.currentTimeMillis();
		System.out.println("Time cost = " + (end - start) + "ms");
	}
}
