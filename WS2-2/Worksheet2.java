/**
 * 
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1

	/**
	 * The method that returns a new tree containing all the elements of a with their sign negated.
	 * @param t The Tree of integer whose elements'sign will be negated.
	 * @return The new Tree of Integer whose sign-negated elements was returned.
	 */
	static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty()) {
			return t;
		} else {
			return new Tree<Integer>(-t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
		}
	}

	// Exercise 2

	/**
	 * The method that will return a boolean value indicating whether all the values in its nodes are positive.
	 * @param a The argument of the method, which is a tree of integers a 
	 * @return A boolean value indicating whether all the values in its nodes are positive is returned.
	 */
	static boolean allPositive(Tree<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalStateException();
		} else if (a.getValue() <= 0) {
			return false;
		} else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
			if (a.getValue() > 0) {
				return true;
			} else {
				return false;
			}
		} else if (a.getLeft().isEmpty()) {
			return allPositive(a.getRight());
		} else if (a.getRight().isEmpty()) {
			return allPositive(a.getLeft());
		} else {
			return allPositive(a.getLeft()) && allPositive(a.getRight());
		}
	}


	// Exercise 3

	/**
	 * The method which returns the level of a given node value.
	 * @param a A tree of integer.
	 * @param x An integer of the value of one node of the tree
	 * @return The level of the x in the tree is returned.
	 */
	static int level(Tree<Integer> a, int x) {
		if (!exists(a, x)) {
			return 0;
		} else if (x == a.getValue()) {
			return 1;
		} else {
			return (level(a.getLeft(), x) > 0 ? 1 + level(a.getLeft(), x) : 0)
					+ (level(a.getRight(), x) > 0 ? 1 + level(a.getRight(), x) : 0);
		}
	}

	static boolean exists(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return false;
		} else if (x == a.getValue()) {
			return true;
		} else {
			return exists(a.getLeft(), x) || exists(a.getRight(), x);
		}
	}



	// Exercise 4
	
	/**
	 * The method produce and return a list containing the values in a by traversing the nodes in postorder.
	 * @param a a given tree f integers a 
	 * @return a list contains all the elements from the tree are listed in the postorder 
	 * with the order of the left, right and the root
	 */
	static <E> List<E> postorder(Tree<E> a) {
		if (a.isEmpty()) {
			return new List<E>();
		} else {
			return append(postorder(a.getLeft()),
					append(postorder(a.getRight()), new List<E>(a.getValue(), new List<E>())));
		}
	}

	static <E> List<E> append(List<E> list, List<E> list2) {
		if (list.isEmpty()) {
			return list2;
		} else {
			return new List<E>(list.getHead(), append(list.getTail(), list2));
		}
	}



	// Exercise 5
	
	/**
	 * The method that returns a boolean value indicating whether a is a binary search tree.
	 * @param a a given tree with integers
	 * @return true if the given tree is a binary search tree, else return false
	 */
	static boolean isSearchTree(Tree<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalStateException();
		}
		if (sorted(inorder(a))) {
			return true;
		} else {
			return false;
		}
	}

	static List<Integer> inorder(Tree<Integer> t) {
		if (t.isEmpty())
			return new List<>();
		else {
			return append(inorder(t.getLeft()), new List<>(t.getValue(), inorder(t.getRight())));
		}
	}

	static boolean sorted(List<Integer> a) {
		if (a.isEmpty()) {
			return true;
		}
		if (a.getTail().isEmpty()) {
			return true;
		}
		if (a.getHead() >= a.getTail().getHead()) {
			return false;
		} else {
			return sorted(a.getTail());
		}
	}


	// Exercise 6

	/**
	 * The method that prints the values stored in it in descending order.
	 * @param a a given tree with integers
	 * print the elements from the tree into a descending order
	 */
	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty())
			return;
		else {
			printDescending(a.getRight());
			System.out.print(a.getValue());
			printDescending(a.getLeft());
		}
	}


	// Exercise 7

	/**
	 * The efficient method to find the maximum value stored in the tree.
	 * @param a is a given binary search tree with integers
	 * @return the maximum value in the binary search tree, when the right sub tree is 
	 * empty, the maximum value is the root, and when the left tree is empty, maximum value 
	 * will be the rightmost node
	 */
	static int max(Tree<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalStateException();
		}
		if (a.getRight().isEmpty()) {
			return a.getValue();
		} else {
			return max(a.getRight());
		}
	}


	// Exercise 8

	/**
	 * The method deletes the value x from a and return the resulting tree.
	 * @param a is a given binary search tree with integers
	 * @param x the value which will be deleted from the tree
	 * @return the resulting tree after deleting the given value
	 */
	static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return new Tree<Integer>();
		}
		if (a.getValue() != x) {
			return new Tree<Integer>(a.getValue(), delete(a.getLeft(), x), delete(a.getRight(), x));
		} else {
			if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
				return new Tree<Integer>();
			} else if (a.getLeft().isEmpty()) {
				return new Tree<Integer>(a.getRight().getValue(), delete(a.getRight().getLeft(), x),
						delete(a.getRight().getRight(), x));
			} else if (a.getRight().isEmpty()) {
				return new Tree<Integer>(a.getLeft().getValue(), delete(a.getLeft().getLeft(), x),
						delete(a.getLeft().getRight(), x));
			} else {
				return new Tree<Integer>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())),
						delete(a.getRight(), max(a.getLeft())));
			}
		}
	}



	// Exercise 9
	
	/**
	 * The method check to see a tree if it is height-balanced, returning a boolean value.
	 * @param a is a given tree with integers 
	 * @return true if the given tree is in the height balanced
	 */
	static <E> boolean isHeightBalanced(Tree<E> a) {
		if (a.isEmpty()) {
			return true;
		}
		if (Math.abs(a.getRight().getHeight() - a.getLeft().getHeight()) > 1) {
			return false;
		} else {
			return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
		}
	}



	// Exercise 10

	/**
	 * The modified method of insert and delete methods that maintain the height-balanced property of trees.
	 * @param a is a given balanced binary search tree with integers
	 * @return the resulting tree after deleting or inserting a value from the tree and still maintain 
	 * it's hieght-balanced property
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {

		if (a.isEmpty()) {
			return insert(a, x);
		} else {
			if (isHeightBalanced(insert(a, x))) {
				return insert(a, x);
			} else {
				return balance(insert(a, x));
			}
		}

	}

	/**
	 * The method that height-balancing the tree if it is not height-balanced
	 * @param a A tree of integer 
	 * @return A height-balanced tree is returned.
	 */
	static Tree<Integer> balance(Tree<Integer> a) {
		if (a.isEmpty()) {
			return a;
		} else {
			if (Math.abs(a.getRight().getHeight() - a.getLeft().getHeight()) <= 1) {
				return new Tree<Integer>(a.getValue(), balance(a.getLeft()), balance(a.getRight()));
			} else {
				if (a.getRight().getHeight() - a.getLeft().getHeight() == -2) {
					if (a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight() == -1
							) {
						return new Tree<Integer>(a.getLeft().getValue(),
								new Tree<Integer>(a.getLeft().getLeft().getValue(),
										balance(a.getLeft().getLeft().getLeft()),
										balance(a.getLeft().getLeft().getRight())),
								new Tree<Integer>(a.getValue(), balance(a.getLeft().getRight()),
										balance(a.getRight())));
					} else if (a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight() == 1
							|| a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight() == 0) {
						return new Tree<Integer>(a.getLeft().getRight().getValue(),
								new Tree<Integer>(a.getLeft().getValue(), balance(a.getLeft().getLeft()),
										balance(a.getLeft().getRight().getLeft())),
								new Tree<Integer>(a.getValue(), balance(a.getLeft().getRight().getRight()),
										balance(a.getRight())));
					} else {
						return new Tree<Integer>(a.getValue(), balance(a.getLeft()), balance(a.getRight()));
					}
				} else if (a.getRight().getHeight() - a.getLeft().getHeight() == 2) {
					if (a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight() == 1
							|| a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight() == 0) {
						return new Tree<Integer>(a.getRight().getValue(),
								new Tree<Integer>(a.getValue(), balance(a.getLeft()), balance(a.getRight().getLeft())),
								new Tree<Integer>(a.getRight().getRight().getValue(), balance(a.getRight().getRight().getLeft()),
										balance(a.getRight().getRight().getRight())));
					} else if (a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight() == -1) {
						return new Tree<Integer>(a.getRight().getLeft().getValue(),
								new Tree<Integer>(a.getValue(), balance(a.getLeft()),
										balance(a.getRight().getLeft().getLeft())),
								new Tree<Integer>(a.getRight().getValue(), balance(a.getRight().getLeft().getRight()),
										balance(a.getRight().getRight())));
					}
				} else {
					return new Tree<Integer>(a.getValue(), balance(a.getLeft()), balance(a.getRight()));
				}
			}
		}
		return new Tree<Integer>(a.getValue(), balance(a.getLeft()), balance(a.getRight()));
	}

	/**
	 * The method to insert an integer to a tree.
	 * @param a A tree of integer.
	 * @param x An integer to be inserted to the tree
	 * @return The tree that contains integer x is returned.
	 */
	static Tree<Integer> insert(Tree<Integer> a, int x) {
		if (a.isEmpty())
			return new Tree<Integer>(x);

		else if (x < a.getValue())
			return new Tree<Integer>(a.getValue(), insert(a.getLeft(), x), a.getRight());

		else
			return new Tree<Integer>(a.getValue(), a.getLeft(), insert(a.getRight(), x));
	}

	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		if(a.isEmpty()) {
			return new Tree<Integer>();
		}else {
			if(isHeightBalanced(delete(a,x))) {
				return delete(a,x);
			}else {
				return balance(delete(a,x));
			}
		}
	}

}
