package net.krishlogic.euler;

import java.util.Date;

/*
    2million summation prime
    Ans: 142913828922
    time taken: 1328875 ms
 */
public class Problem10 {

    public static void main(String args[]) {

        long sum = 2;

        Date date = new Date();
        System.out.println("Time complexity start: " + date.getTime());

        for (long i=3;i <2000000; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(i)) {
                sum+= i;
                System.out.println(i);
            }
        }

        System.out.println("Time complexity End: " + System.currentTimeMillis());

        System.out.println("Total time " + (System.currentTimeMillis() - date.getTime()));

        System.out.println(sum);
    }

    private static boolean isPrime(long num) {
        for (long i=2; i<num; i++) {

            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
