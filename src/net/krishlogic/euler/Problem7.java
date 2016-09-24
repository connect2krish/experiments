package net.krishlogic.euler;

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */

public class Problem7 {

    public static void main(String args[]) {
        calculate();
    }

    private static void calculate() {
        int count = 2;
        int primeCount=1;
        boolean flag = true;

        while(flag) {
            if (isPrime(++count)) {
                primeCount ++;
                if (primeCount >= 10001) {
                    System.out.println("number is: " + count);
                    flag = false;
                }
            }
        }
    }

    private static boolean isPrime(int value) {

        for (int i=2; i<value; i++) {

            if (value % i == 0) {
                return false;
            }
        }

        return true;

    }
}
