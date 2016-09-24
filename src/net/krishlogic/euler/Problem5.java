package net.krishlogic.euler;
/*
    2520 is the smallest num divisble by 1-10
    find the smallest num divisible by 1-20
*/

public class Problem5 {

    public static void main(String args[]) {
        boolean flag = true;
        int count = 0;
        while(flag) {
            boolean isDiv = isDivisible(++count);
            if (isDiv) {
                flag = false;
            }

        }
    }

    private static boolean isDivisible(int number) {

        for (int i=2; i<=20; i++) {

            if (number % i == 0) {

                continue;

            } else {
                return false;
            }

        }

        System.out.println(number);

        return true;
    }
}
