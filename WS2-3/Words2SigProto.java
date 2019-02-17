/**
 * The command-line programs for testing the method of wordToSignature in the
 * PredictivePrototype class.
 * 
 * @author Jing Li
 *
 */
public class Words2SigProto {

	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(PredictivePrototype.wordToSignature(args[i]));
		}
	}
}
