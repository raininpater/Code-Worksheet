import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {
	String signature;
	Set<String> words;

	List<Node> children = new ArrayList<>();

	public Node() {

		this.signature = null;
		this.words = new HashSet<>();
		this.children = new ArrayList<>();

	}

	public Node(String signature, Set<String> words, List<Node> children) {
		this.signature = signature;
		this.words = words;
		this.children = children;
	}

}