import static org.junit.Assert.*;
import org.junit.Test;
/**
 * This class contains the test cases for Worksheet2 solutions.
 * @author Jing Li
 * @version 05/02/2019
 */

public class Worksheet2Test {
	
	// Testing negate a tree method 
	@Test
	public void test1() {
		Tree<Integer> A = new Tree<Integer>();
		Tree<Integer> expectedA = new Tree<Integer>();
		Tree<Integer> B = new Tree<Integer>(12, new Tree<Integer>(8), new Tree<Integer>(-15));
		Tree<Integer> expectedB = new Tree<Integer>(-12, new Tree<Integer>(-8), new Tree<Integer>(15));
		assertEquals(Worksheet2.negateAll(A), expectedA);
		assertEquals(Worksheet2.negateAll(B), expectedB);
	}
	
	// Testing check for positive method
	@Test(expected = IllegalStateException.class)
	public void test2() {
		Tree<Integer> A = new Tree<Integer>(3, new Tree<Integer>(2), new Tree<Integer>(5, new Tree<Integer>(4), new Tree<Integer>(6)));
		Tree<Integer> B = new Tree<Integer>(5, new Tree<Integer>(-1), new Tree<Integer>());
		Tree<Integer> C = new Tree<Integer>();
		assertTrue(Worksheet2.allPositive(A));
		assertFalse(Worksheet2.allPositive(B));
		Worksheet2.allPositive(C);
	}
	
	// Testing level of a node method
	@Test
	public void test3() {
		Tree<Integer> t = new Tree<Integer>(5, new Tree<Integer>(3, new Tree<Integer>(1), new Tree<Integer>(4)), new Tree<Integer>(8, new Tree<Integer>(6), new Tree<Integer>()));
		assertEquals(Worksheet2.level(t, 5), 1);
		assertEquals(Worksheet2.level(t, 1), 3);
		assertEquals(Worksheet2.level(t, 2), 0);
	}
	
	// Testing postorder traversal method
	@Test
	public void test4() {
		Tree<Integer> A = new Tree<Integer>(3, new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>()), new Tree<Integer>(5, new Tree<Integer>(4), new Tree<Integer>(6)));
		Tree<Integer> B = new Tree<Integer>();
		Tree<Integer> C = new Tree<Integer>(3, new Tree<Integer>(2), new Tree<Integer>());
		Tree<Integer> D = new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>(5));
		List<Integer> expectedA = new List<Integer>(1, new List<Integer>(2, new List<Integer>(4, new List<Integer>(6, new List<Integer>(5, new List<Integer>(3, new List<Integer>()))))));
		List<Integer> expectedB = new List<Integer>();
		List<Integer> expectedC = new List<Integer>(2, new List<Integer>(3, new List<Integer>()));
		List<Integer> expectedD = new List<Integer>(5, new List<Integer>(3, new List<Integer>()));
		assertEquals(Worksheet2.postorder(A), expectedA);
		assertEquals(Worksheet2.postorder(B), expectedB);
		assertEquals(Worksheet2.postorder(C), expectedC);
		assertEquals(Worksheet2.postorder(D), expectedD);
	}
	
	// Testing search tree property method
	@Test(expected = IllegalStateException.class)
	public void test5() {
		Tree<Integer> A = new Tree<Integer>(3, new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>()), new Tree<Integer>(5, new Tree<Integer>(4), new Tree<Integer>(6)));
		Tree<Integer> B = new Tree<Integer>();
		Tree<Integer> C = new Tree<Integer>(5, new Tree<Integer>(4, new Tree<Integer>(), new Tree<Integer>(7)), new Tree<Integer>(8));
		assertTrue(Worksheet2.isSearchTree(A));
		Worksheet2.isSearchTree(B);
		assertFalse(Worksheet2.isSearchTree(C));
	}
	
	// Testing maximum value in a search tree method
	@Test
	public void test6() {
		Tree<Integer> A = new Tree<Integer>(12, new Tree<Integer>(8, new Tree<Integer>(7), new Tree<Integer>()), new Tree<Integer>(16, new Tree<Integer>(14), new Tree<Integer>(18)));
		Tree<Integer> B = new Tree<Integer>(12);
		Tree<Integer> C = new Tree<Integer>(12, new Tree<Integer>(8), new Tree<Integer>());
		assertEquals(Worksheet2.max(A), 18);
		assertEquals(Worksheet2.max(B), 12);
		assertEquals(Worksheet2.max(C), 12);
	}
	
	// Testing delete a value in a search tree method
	@Test
	public void test7() {
		Tree<Integer> t = new Tree<Integer>(3, new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>()), new Tree<Integer>(5, new Tree<Integer>(4), new Tree<Integer>(6)));
		Tree<Integer> expectedA = new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>(5, new Tree<Integer>(4), new Tree<Integer>(6)));
		Tree<Integer> expectedB = new Tree<Integer>(3, new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>()), new Tree<Integer>(4, new Tree<Integer>(), new Tree<Integer>(6)));
		Tree<Integer> expectedC = new Tree<Integer>(3, new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>()), new Tree<Integer>(5, new Tree<Integer>(), new Tree<Integer>(6)));
		assertEquals(Worksheet2.delete(t, 3), expectedA);
		assertEquals(Worksheet2.delete(t, 5), expectedB);
		assertEquals(Worksheet2.delete(t, 4), expectedC);
	}
		
	// Testing check for height-balanced property method
	@Test
	public void test8() {
		Tree<Integer> A = new Tree<Integer>(84, new Tree<Integer>(48, new Tree<Integer>(30), new Tree<Integer>()), new Tree<Integer>());
		Tree<Integer> B = new Tree<Integer>(4, new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>(3)), new Tree<Integer>(5));
		Tree<Integer> C = new Tree<Integer>(84, new Tree<Integer>(), new Tree<Integer>(98, new Tree<Integer>(), new Tree<Integer>(100)));
		Tree<Integer> D = new Tree<Integer>(84, new Tree<Integer>(), new Tree<Integer>());
		Tree<Integer> E = new Tree<Integer>(84, new Tree<Integer>(48, new Tree<Integer>(), new Tree<Integer>(50)), new Tree<Integer>());
		assertFalse(Worksheet2.isHeightBalanced(A));
		assertTrue(Worksheet2.isHeightBalanced(B));
		assertFalse(Worksheet2.isHeightBalanced(C));
		assertTrue(Worksheet2.isHeightBalanced(D));
		assertFalse(Worksheet2.isHeightBalanced(E));
	}
	
	// Testing insertion with height-balancing method
	@Test
	public void test9() {
		Tree<Integer> A = new Tree<Integer>(84, new Tree<Integer>(48), new Tree<Integer>());
		Tree<Integer> B = new Tree<Integer>(84, new Tree<Integer>(), new Tree<Integer>(98));
		Tree<Integer> ExpectedA = new Tree<Integer>(48, new Tree<Integer>(30), new Tree<Integer>(84));
		Tree<Integer> ExpectedB = new Tree<Integer>(50, new Tree<Integer>(48), new Tree<Integer>(84));
		Tree<Integer> ExpectedC = new Tree<Integer>(98, new Tree<Integer>(84), new Tree<Integer>(100));
		Tree<Integer> ExpectedD = new Tree<Integer>(90, new Tree<Integer>(84), new Tree<Integer>(98));
		assertEquals(Worksheet2.insertHB(A, 30), ExpectedA);
		assertEquals(Worksheet2.insertHB(A, 50), ExpectedB);
		assertEquals(Worksheet2.insertHB(B, 100), ExpectedC);
		assertEquals(Worksheet2.insertHB(B, 90), ExpectedD);
	}
	
	// Testing deletion with height-balancing method
	@Test
	public void test10() {
		Tree<Integer> t = new Tree<Integer>(4, new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>(3)), new Tree<Integer>(5));
		Tree<Integer> ExpectedA = new Tree<Integer>(3, new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>()), new Tree<Integer>(4));
		Tree<Integer> ExpectedB = new Tree<Integer>(4, new Tree<Integer>(1, new Tree<Integer>(), new Tree<Integer>(3)), new Tree<Integer>(5));
		Tree<Integer> ExpectedC = new Tree<Integer>(4, new Tree<Integer>(2, new Tree<Integer>(1), new Tree<Integer>()), new Tree<Integer>(5));
		assertEquals(Worksheet2.deleteHB(t, 5), ExpectedA);
		assertEquals(Worksheet2.deleteHB(t, 2), ExpectedB);
		assertEquals(Worksheet2.deleteHB(t, 3), ExpectedC);
	}
}