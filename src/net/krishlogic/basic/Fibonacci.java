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
		int temp3;
		for (int i = 2; i <= num; i++) {
			temp3 = temp1 + temp2;
			temp1 = temp2;
			temp2 = temp3;

			System.out.println(temp1);
		}		
	}	
}