import java.util.Set;

/**
 * The interface of Dictionary, which contains a method of signatureToWords.
 * @author Jing Li
 *
 */
public interface Dictionary {

	/**
	 * The method method that will take a string type of signature and 
	 * return a set of lists.
	 * @param signature The signature of words which will be transformed to 
	 * a set of words.
	 * @return A set of words is returned. 
	 */
	public Set<String> signatureToWords(String signature);
}
