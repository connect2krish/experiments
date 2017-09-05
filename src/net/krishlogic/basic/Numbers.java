package net.krishlogic.basic;

public class Numbers {

    public int reverseInteger(int number) {

        int reversedNumber = 0;

        while(number != 0) {
            int digit = number % 10;
            number = number / 10;

            reversedNumber = reversedNumber * 10 + digit;
        }

        return reversedNumber;
    }

    public static void main(String args[]) {
        Numbers numbers = new Numbers();
        System.out.println(numbers.reverseInteger(1234));
    }
}
