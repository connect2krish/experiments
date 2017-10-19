package net.krishlogic.lintcode;

public class Problem569 {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int temp = num;
        int total = 0;
        while(temp > 0) {
            int t = temp % 10;
            total = total + t;
            temp = temp/10;
        }

        return addDigits(total);
    }

    public static void main(String args[]) {
        Problem569 p = new Problem569();
        System.out.println(p.addDigits(121));
    }
}
