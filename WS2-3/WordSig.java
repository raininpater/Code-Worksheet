
public class WordSig implements Comparable<WordSig>{

	private String words;
	private String signature;
	
	public WordSig(String words, String signature) {
		this.words = words;
		this.signature = signature;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public int compareTo(WordSig ws) {
		int check = this.signature.compareTo(ws.signature);
		return check;
	}
}
