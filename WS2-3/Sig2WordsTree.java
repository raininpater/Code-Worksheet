import java.io.FileNotFoundException;

public class Sig2WordsTree {

	public static void main(String[] args) throws FileNotFoundException {
		TreeDictionary tr = new TreeDictionary();
		for(int i=0;i<args.length; i++) {
			System.out.print(tr.signatureToWords(args[i]));
		}
	}
}
