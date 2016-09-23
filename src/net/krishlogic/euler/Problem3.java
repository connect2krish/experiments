package net.krishlogic.euler;

/**
 *
 The prime factors of 13195 are 5, 7, 13 and 29.

 What is the largest prime factor of the number 600851475143 ?

 */
public class Problem3 {
	
	public static void main(String args[]) {
		getLargestPrimeFactor("600851475143");
	}
	
	private static void getLargestPrimeFactor(String val) {
		
		Double holder = Double.parseDouble(val);
		
		for (double d = 2; d <= holder; d++) {
			
			if (holder % d == 0) {
				holder = holder/d;
				System.out.println(d);
				d = 1;
			}
			
		}
	}
}
