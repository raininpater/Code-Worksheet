
public class WordSig implements Comparable<WordSig> {

	private String words;
	private String signature;

	/**
	 * Constructor for the WordSig
	 * 
	 * @param words
	 * @param signature
	 */
	public WordSig(String words, String signature) {
		this.words = words;
		this.signature = signature;
	}

	/**
	 * Getter for the words
	 * 
	 * @return The words is returned
	 */
	public String getWords() {
		return words;
	}

	/**
	 * Getter for the signature
	 * 
	 * @return The signature is returned
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * The method that sort the WordSigs.
	 */
	@Override
	public int compareTo(WordSig ws) {
		int check = this.signature.compareTo(ws.signature);
		return check;
	}
}
