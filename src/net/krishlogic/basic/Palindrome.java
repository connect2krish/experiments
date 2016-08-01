package net.krishlogic.basic;

//Is given word a palindrome

public class Palindrome {

	static String word = "moonnoom";
	
	public static void main(String[] args) {
		System.out.println(isEquals());
	}
	
	private static boolean isEquals() {
		
		if (word == null) {
			return false;
		}
		
		if (word.length()==0) {
			return false;
		}

		if (word.length()==1) {
			return true;
		}
		
		int w1Length = word.length();
		
		char[] w1Array = word.toCharArray();
		
		if (w1Length % 2 == 0) {		
			for (int i=0; i< w1Length/2; i++) {
				if (w1Array[i] != w1Array[w1Length-1-i]) {
					return false;
				}
			}
		} else {
			for (int j=0; j < w1Length/2 - 1; j++) {
				if (w1Array[j] != w1Array[w1Length-1-j]) {
					return false;
				}				
			}
		}
		
		return true;
	}
}