import java.util.HashSet;
import java.util.Set;

/**
 * This class set the constructors of tree used in the TreeDictionary class.
 * 
 * @author Jing Li
 */
public class Tree {

	private Set<String> words;
	private Tree[] children = new Tree[8];

	/**
	 * Constructors for the null tree.
	 */
	public Tree() {
		this.words = new HashSet<>();
		this.children = new Tree[8];
	}

	/**
	 * Constructors for the tree
	 * 
	 * @param words    The set that stores the words of a signature
	 * @param children The subtrees of this node(root).
	 */
	public Tree(Set<String> words, Tree[] children) {
		this.words = words;
		this.children = children;
	}

	/**
	 * The method that search the tree and find the set of words of the input
	 * signature.
	 * 
	 * @param tree The tree to be searched.
	 * @param sigs The signature to be searched.
	 * @return A set of words that match the signature is returned.
	 */
	public Set<String> search(Tree tree, char[] sigs) {
		if (tree == null) {
			throw new IllegalStateException();
		}
		if (sigs.length != 1) {
			return search(tree.getChildren()[Character.getNumericValue(sigs[0]) - 2], deleteFirst(sigs));
		} else {
			return tree.getChildren()[Character.getNumericValue(sigs[0]) - 2].getWords();
		}
	}

	/**
	 * The method to delete the first element of an array of char.
	 * 
	 * @param arr The array to be deleted first.
	 * @return The new array of char is returned.
	 */
	static char[] deleteFirst(char[] arr) {
		char[] temp = new char[arr.length - 1];
		System.arraycopy(arr, 1, temp, 0, temp.length);
		return temp;
	}

	/**
	 * The method that test a tree contains a signature or not.
	 * 
	 * @param a
	 * @param sigs
	 * @return True The tree contains the signature. False The tree doesn't contain
	 *         the signature.
	 */
	public boolean containsSig(Tree a, char[] sigs) {

		if (a.getChildren()[Character.getNumericValue(sigs[0]) - 2] == null) {
			return false;
		} else {
			if (sigs.length == 1) {
				return true;
			} else {
				return containsSig(a.getChildren()[Character.getNumericValue(sigs[0]) - 2], deleteFirst(sigs));
			}
		}
	}

	/**
	 * Getter for the words
	 * 
	 * @return The set of words is returned.
	 */
	public Set<String> getWords() {
		return words;
	}

	/**
	 * Getter for the subTree
	 * 
	 * @return The subTree of the root is returned.
	 */
	public Tree[] getChildren() {
		return children;
	}
}