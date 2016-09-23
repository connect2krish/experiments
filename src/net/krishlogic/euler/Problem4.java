package net.krishlogic.euler;

/*
    A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit numbers.
 */

import java.util.ArrayList;
import java.util.List;

public class Problem4 {

    public static void main(String args[]) {
       palindroneThreeDigit();
    }

    private static void palindroneThreeDigit() {

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 100; i < 1000; i++) {

            for (int j = 100; j < 1000; j++) {
                int k = i * j;

                if (k % 10 == 0) {
                    continue;
                }

                if (isPalindrome(k)) {
                    list.add(k);
                }
            }
        }

        if (list.size() > 0) {
            int largestNum = 100;
            for (int num : list) {
                if (num > largestNum) {
                    largestNum = num;
                }
            }

            System.out.println(largestNum);
        }
    }



    private static boolean isPalindrome(int number) {

        List<Integer> numList = new ArrayList<Integer>();

        int value = number;

        while(value >= 0) {
            if (value >=0) {
                int val = value % 10;
                if (value > 9) {
                    value = value / 10;
                    numList.add(val);
                } else {
                    numList.add(val);
                    break;
                }
            } else {
                break;
            }
        }

        int size = numList.size();

        if (size <= 1) {
            return false;
        }

        for (int x=0; x < size; x++) {

            if (numList.get(x) != numList.get(size -1- x)) {

                return false;
            }
        }

        return true;
    }
}
