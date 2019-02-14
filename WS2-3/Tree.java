import java.util.HashSet;
import java.util.Set;

public class Tree {
	
	Set<String> words;

	Tree[] children = new Tree[8];

	public Tree() {

		this.words = new HashSet<>();
		this.children = new Tree[8];

	}

	public Tree(Set<String> words, Tree[] children) {
		this.words = words;
		this.children = children;
	}
	
	public Set<String> search(Tree tree, char[] sigs) {
		if(tree==null) {
			throw new IllegalStateException();
		}
		if(sigs.length != 1) {
			return search(tree.getChildren()[Character.getNumericValue(sigs[0])-2], deleteFirst(sigs));
		}else {
			return tree.getChildren()[Character.getNumericValue(sigs[0])-2].getWords();
		}
	}
	
    static char[] deleteFirst(char[] arr) {
        char[] temp = new char[arr.length - 1];
        System.arraycopy(arr, 1, temp, 0, temp.length);
        return temp;
    }
    
    public boolean containsSig(Tree a, char[] sigs) {
    	
    		if(a.getChildren()[Character.getNumericValue(sigs[0])-2]==null) {
    			return false;
    		}else {
    			if(sigs.length == 1) {
    				return true;
    			}else {
    	    		return containsSig(a.getChildren()[Character.getNumericValue(sigs[0])-2], deleteFirst(sigs));
    			}
    		}
    	}
    

	public Set<String> getWords() {
		return words;
	}

	public void setWords(Set<String> words) {
		this.words = words;
	}

	public Tree[] getChildren() {
		return children;
	}

	public void setChildren(Tree[] children) {
		this.children = children;
	}

}