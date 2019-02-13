/**
 * @author < JING LI > This class contains the solution for Worksheet1
 */

 public class Worksheet1 {

	// Exercise 1

	 /**
	  * The method for raising integer m to the power of integer n.
	  * The method will continuously call it self until the value of 
	  * n equals 1.
	  */
	 static int power(int m, int n) {
		 if( n == 0 ) {
			 return 1;
		 }else if( n == 1) {
			 return m;
		 }else {
			 return m * power(m, n-1);
		 }
	}

	 /**
	  * The more efficient method for raising integer m to the power of integer n.
	  * When n is divisible by 2, we change the value of m to m*m, and n to n/2,
	  * which can effectively simplify the process of calculating the big numbers.
	  */
	 static int fastPower(int m, int n) {
		 if( n == 0 ) {
			 return 1;
		 }else if( n == 1) {
			 return m;
		 }else if(n%2 ==0){
			 return fastPower(m*m, n/2);
		 }else {
			 return m * fastPower(m, n-1);
		 } 
	}
	 

	// Exercise 2

	 /**
	  * The method that returns a new list with all the elements of a with sign 
	  * negated, for example, positive integers become negatives and negative 
	  * integers become positives.
	  */
	 static List<Integer> negateAll(List<Integer> a) {
		 if(a.isEmpty()) {
			 return a;
		 }else {
			 //To create a new List temp to store the changed List.
			 List<Integer> temp = new List<Integer>(-a.getHead(),negateAll(a.getTail()));
			 return temp;
		 }
	}
	 

	// Exercise 3

	 /**
	  * The method that find an integer x which is assumed to be in the list a, 
	  * by executing the method, which will return the position of the first occurrence 
	  * of x in a. And if x does not appear in the list, the program will throw an 
	  * IllegalArgumentException.
	  */
	 static int find(int x, List<Integer> a) {
		 if(a.isEmpty()) {
			 throw new IllegalArgumentException("Cannot find the elements!");
		 }
		 if(a.getHead() == x) {
			 return 0;
		 }else {
			 return 1 + find(x,a.getTail());
		 }
	}
	 

	// Exercise 4

	 /**
	  * The methed that test a given list of integers a, which will return a 
	  * boolean value indicating whether all its elements are positive,
	  */
	 static boolean allPositive(List<Integer> a) {
		 if(a.isEmpty()) {
			 return true;
		 }
		 if(a.getHead()<0) {
			 return false;
		 }else {
			 return allPositive(a.getTail());
		 }
	}


	// Exercise 5

	 /**
	  * The method that deal with a given list of integers a, which will return
	  *  a new list that contains all the positive elements of a. The elements
	  *  should appear in the result in the same relative order as in a.
	  * @param a
	  * @return
	  */
	 static List<Integer> positives(List<Integer> a) {
		 if(a.isEmpty()) {
			 return a;
		 }
		 if(a.getHead()>0) {
			List<Integer> temp = new List<Integer>();
			return temp = new List<Integer>(a.getHead(),positives(a.getTail()));
		 }else {
			return positives(a.getTail());
		 }
	}
	 

	// Exercise 6

	 /**
	  * The method testing a given list of integers a, and this method will return
	  *  a boolean value indicating whether a is sorted in ascending order.
	  */
	 static boolean sorted(List<Integer> a) {
		 if(a.isEmpty()) {
			 return true;
		 }
		 if(a.getTail().isEmpty()) {
			 return true;
		 }
		 if(a.getHead()>a.getTail().getHead()) {
			 return false;
		 }else {
			 return sorted(a.getTail());
		 }
	}


	// Exercise 7

	 /**
	  * The method will merge two sorted lists a and b, and the method will return
	  *  a new sorted list that contains all the elements of a and all the elements of b.
	  *  Furthermore, all the  duplicate copies of elements in a or b or their
	  *  combination are retained.
	  * @param a
	  * @param b
	  * @return
	  */
	 static List<Integer> merge(List<Integer> a, List<Integer> b) {
		List<Integer> temp = new List<Integer>();
		if(a.isEmpty()) {
			return b;
		}
		if(b.isEmpty()) {
			return a;
		}
		
		if(a.getHead()<=b.getHead()) {
			temp = new<Integer> List(a.getHead(),merge(a.getTail(),b));
		}else {
			temp = new<Integer> List(b.getHead(),merge(a,b.getTail()));
		}
		return temp;
	}
	 

	// Exercise 8

	 /**
	  * The method will dispose a sorted list a, and it will return a copy of 
	  * the list a with all duplicate copies removed.
	  */
	static List<Integer> removeDuplicates(List<Integer> a) {
		if(a.getTail().isEmpty()) {
			return a;
		}
		List<Integer> temp = new List<Integer>();
		if(a.getHead() != a.getTail().getHead()) {
			temp = new List<Integer>(a.getHead(),removeDuplicates(a.getTail()));
		}else {
			temp = removeDuplicates(a.getTail());
		}
		return temp;
	}


}
