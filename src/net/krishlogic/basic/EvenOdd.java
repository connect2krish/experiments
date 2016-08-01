package net.krishlogic.basic;
//find if num is even or odd
//print 10 even nums
//print 10 odd nums
public class EvenOdd {
	
	static int num = 6;
	static int LIMIT = 10;
	
	public static void main(String[] args) {
		//isEvenOrODD
		System.out.println(isEven());
		System.out.println(isOdd());
		
		printEvens();
		printOdds();		
	}

	private static boolean isOdd() {
		return num % 2 != 0;
	}
	
	private static boolean isEven() {
		return num % 2 == 0;
	}
	
	private static void printEvens() {
		int count = 0;
		for (int i=0; count < LIMIT; i++) {
			if (i % 2 == 0) {
				count ++;
				System.out.println(i);
			}
		}
	}
	
	private static void printOdds() {
		int count = 0;
		for (int i=0; count < LIMIT; i++) {
			if (i % 2 != 0) {
				count ++;
				System.out.println(i);
			}
		}
	}
}
