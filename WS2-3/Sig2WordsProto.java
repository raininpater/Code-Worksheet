import java.io.FileNotFoundException;

public class Sig2WordsProto {

	public static void main(String[] args) throws FileNotFoundException {
		for (int i = 0; i < args.length; i++) {

			System.out.println(args[i] + ": " + PredictivePrototype.signatureToWords(args[i]));

		}

	}
}
