import java.io.FileNotFoundException;

/**
 * The command-line programs for testing the method of signatureToWords in the
 * PredictivePrototype class.
 * 
 * @author Jing Li
 *
 */
public class Sig2WordsProto {

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < args.length; i++) {

			System.out.println(args[i] + ": " + PredictivePrototype.signatureToWords(args[i]));

		}
		long end = System.currentTimeMillis();
		System.out.println("Time cost = " + (end - start) + "ms");
		}
}
