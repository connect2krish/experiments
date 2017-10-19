package net.krishlogic.lintcode;

public class Problem491 {

    public boolean isPalindrome(int num) {
        // write your code here

        int num1 = num;

        int total = 0;
        while(num1 > 0) {
            if (num1 == 0) {
                break;
            }
            int temp = num1 % 10;
            total = total * 10 + temp;
            num1 = num1 /10;
        }

        return (total == num);
    }

    public static void main(String[] args) {
        int num = 45;
        Problem491 p = new Problem491();
        System.out.println(p.isPalindrome(num));
    }
}
