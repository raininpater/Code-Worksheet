import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/** @author 
 *  <Jing Li>
 * This class contains the test cases for Worksheet1 solutions.
 *  <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet1Test {
	
	List<Integer> list1 = new List<Integer>(1,new List<Integer>
			(2,new List<Integer>(3,new List<Integer>(4,new List<Integer>(5,new List<Integer>())))));
	List<Integer> list2 = new List<Integer>(-1,new List<Integer>
			(2,new List<Integer>(3,new List<Integer>(4,new List<Integer>(5,new List<Integer>())))));
	List<Integer> list3 = new List<Integer>(3,new List<Integer>
			(3,new List<Integer>(7,new List<Integer>(8,new List<Integer>(9,new List<Integer>(9, new List<Integer>(10,new List<Integer>())))))));
	List<Integer> list4 = new List<Integer>(8,new List<Integer>(9, new List<Integer>()));
	List<Integer> list5 = new List<Integer>(3, new List<Integer>(9,new List<Integer>()));
	List<Integer> list6 = new List<Integer>(3,new List<Integer>
	(3,new List<Integer>(7,new List<Integer>(7,new List<Integer>(9,new List<Integer>(9, new List<Integer>(9,new List<Integer>())))))));
	List<Integer> list7 = new List<Integer>(1,new List<Integer>
	(1,new List<Integer>(1,new List<Integer>(2,new List<Integer>(2,new List<Integer>(2, new List<Integer>(2,new List<Integer>())))))));
	
	//Test the power method of Exercise1
	@Test
	public void test1() {

		int expectedResult12 = 1;
		int expectedResult22 = 4;
		int expectedResult32 = 9;
		int actualResult12 = Worksheet1.power(1,2);
		int actualResult22 = Worksheet1.power(2,2);
		int actualResult32 = Worksheet1.power(3,2);
		
		assertEquals(expectedResult12, actualResult12);
		assertEquals(expectedResult22, actualResult22);
		assertEquals(expectedResult32, actualResult32);
	}
	
	//Test the fastPower method of Exercise1
	@Test
	public void test2() {

		int expectedResult12 = 1;
		int expectedResult22 = 4;
		int expectedResult32 = 9;
		int actualResult12 = Worksheet1.fastPower(1,2);
		int actualResult22 = Worksheet1.fastPower(2,2);
		int actualResult32 = Worksheet1.fastPower(3,2);
		
		assertEquals(expectedResult12, actualResult12);
		assertEquals(expectedResult22, actualResult22);
		assertEquals(expectedResult32, actualResult32);
	}
	
	//Test the negateAll method of Exercise2
	@Test
	public void test3() {

		List<Integer> expectedResult1 = new List<Integer>(-1,new List<Integer>
		(-2,new List<Integer>(-3,new List<Integer>(-4,new List<Integer>(-5,new List<Integer>())))));
		List<Integer> expectedResult2 = new List<Integer>(1,new List<Integer>
		(-2,new List<Integer>(-3,new List<Integer>(-4,new List<Integer>(-5,new List<Integer>())))));
		List<Integer> expectedResult3 = new List<Integer>(-3,new List<Integer>
		(-3,new List<Integer>(-7,new List<Integer>(-8,new List<Integer>(-9,new List<Integer>(-9, new List<Integer>(-10,new List<Integer>())))))));
		List<Integer> actualResult1 = Worksheet1.negateAll(list1);
		List<Integer> actualResult2 = Worksheet1.negateAll(list2);
		List<Integer> actualResult3 = Worksheet1.negateAll(list3);
		
		assertEquals(expectedResult1, actualResult1);
		assertEquals(expectedResult2, actualResult2);
		assertEquals(expectedResult3, actualResult3);
	}
	
	//Test the find method of Exercise3
	@Test(expected = IllegalArgumentException.class)
	public void test4() {

		int expectedResult1 = 2;
		int expectedResult2 = 2;
		int expectedResult3 = 2;
		int actualResult1 = Worksheet1.find(3,list1);
		int actualResult2 = Worksheet1.find(3,list2);
		int actualResult3 = Worksheet1.find(5,list3);
		
		assertEquals(expectedResult1, actualResult1);
		assertEquals(expectedResult2, actualResult2);
		assertEquals(expectedResult3, actualResult3);
		Worksheet1.find(100, list3);
	}
	
	//Test the allPositives method of Exercise4
	@Test
	public void test5() {
		
		assertTrue(Worksheet1.allPositive(list1));
		assertFalse(Worksheet1.allPositive(list2));
		assertTrue(Worksheet1.allPositive(list3));
		assertTrue(Worksheet1.allPositive(list4));
		assertTrue(Worksheet1.allPositive(list5));
	}
	
	//Test the positives method of Exercise5
	@Test
	public void test6() {

		List<Integer> expectedResult1 = new List<Integer>(1,new List<Integer>
		(2,new List<Integer>(3,new List<Integer>(4,new List<Integer>(5,new List<Integer>())))));
		List<Integer> expectedResult2 = new List<Integer>
		(2,new List<Integer>(3,new List<Integer>(4,new List<Integer>(5,new List<Integer>()))));
		List<Integer> expectedResult3 = new List<Integer>(3,new List<Integer>
		(3,new List<Integer>(7,new List<Integer>(8,new List<Integer>(9,new List<Integer>(9, new List<Integer>(10,new List<Integer>())))))));
		List<Integer> actualResult1 = Worksheet1.positives(list1);
		List<Integer> actualResult2 = Worksheet1.positives(list2);
		List<Integer> actualResult3 = Worksheet1.positives(list3);
		
		assertEquals(expectedResult1, actualResult1);
		assertEquals(expectedResult2, actualResult2);
		assertEquals(expectedResult3, actualResult3);
	}
	
	//Test the sorted method of Exercise6
	@Test
	public void test7() {

		assertTrue(Worksheet1.sorted(list1));
		assertTrue(Worksheet1.sorted(list2));
		assertTrue(Worksheet1.sorted(list3));
		assertTrue(Worksheet1.sorted(list4));
		assertTrue(Worksheet1.sorted(list5));
	}
	
	//Test the merge method of Exercise7
	@Test
	public void test8() {

		List<Integer> expectedResult1 = new List<Integer>(1,new List<Integer>
		(2,new List<Integer>(3,new List<Integer>(4,new List<Integer>(5,new List<Integer>(8,new List<Integer>(9,new List<Integer>())))))));
		List<Integer> expectedResult2 = new List<Integer>(1,new List<Integer>
		(2,new List<Integer>(3,new List<Integer>(3,new List<Integer>(4,new List<Integer>(5,new List<Integer>(9,new List<Integer>())))))));
		List<Integer> expectedResult3 = new List<Integer>(3,new List<Integer>(8,new List<Integer>(9, new List<Integer>(9,new List<Integer>()))));
		List<Integer> actualResult1 = Worksheet1.merge(list1,list4);
		List<Integer> actualResult2 = Worksheet1.merge(list1,list5);
		List<Integer> actualResult3 = Worksheet1.merge(list4,list5);
		
		assertEquals(expectedResult1, actualResult1);
		assertEquals(expectedResult2, actualResult2);
		assertEquals(expectedResult3, actualResult3);
	}
	
	//Test the removeDuplicates method of Exercise8
	@Test
	public void test9() {

		List<Integer> expectedResult1 = new List<Integer>(3,new List<Integer>
		(7,new List<Integer>(8,new List<Integer>(9, new List<Integer>(10,new List<Integer>())))));
		List<Integer> expectedResult2 = new List<Integer>(3,new List<Integer>
		(7, new List<Integer>(9,new List<Integer>())));
		List<Integer> expectedResult3 = new List<Integer>(1,new List<Integer>(2,new List<Integer>()));
		List<Integer> actualResult1 = Worksheet1.removeDuplicates(list3);
		List<Integer> actualResult2 = Worksheet1.removeDuplicates(list6);
		List<Integer> actualResult3 = Worksheet1.removeDuplicates(list7);
		
		assertEquals(expectedResult1, actualResult1);
		assertEquals(expectedResult2, actualResult2);
		assertEquals(expectedResult3, actualResult3);
	}
	
}
