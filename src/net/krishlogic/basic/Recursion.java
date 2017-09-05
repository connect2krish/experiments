package net.krishlogic.basic;

public class Recursion {

    public String stringReverse(String string) {

        if (string == null || string.length() == 0) {
            return string;
        }

        return stringReverse(string.substring(1)) + string.charAt(0);
    }

    public static void main(String args[]) {
        Recursion recursion = new Recursion();

        System.out.println(recursion.stringReverse("hello"));
    }
}
