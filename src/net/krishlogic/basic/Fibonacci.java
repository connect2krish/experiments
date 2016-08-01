package net.krishlogic.basic;

//print num of fibonacci sequence
// 8 = 1 1 2 3 5 8 13 21
public class Fibonacci {

	static int num = 8;
	public static void main(String[] args) {
		printFib();

	}

	private static void printFib() {
		
		int temp1 = 0;
		int temp2 = 1;
		System.out.println(1);
		for (int i = 0; i <= num; i++) {
			int temp3 = temp1;
			temp1 = temp2;
			temp2 = temp3 + temp1;
			
			System.out.println(temp2);
		}		
	}	
}