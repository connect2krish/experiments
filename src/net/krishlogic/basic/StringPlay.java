package net.krishlogic.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringPlay {

    private static int NO_OF_CHARS = 256;

    private static boolean isAlphabet(char a) {
        return (a >= 'a' && a<='z') || (a>='A' && a<='Z');
    }

    /**
     * http://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
     * @param str
     * @return
     */
    public static String reversAnArrayWithoutAffectingSpecialChars(String str) {

        if (str == null || str.length()==0) {
            return str;
        }

        char[] arr = str.toCharArray();

        int l = 0;
        int r = arr.length-1;

        while(l<r) {
            if (!isAlphabet(arr[l])) {
                l++;
            } else if (!isAlphabet(arr[r])) {
                r--;
            } else {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;

                l++;
                r--;
            }
        }

        return new String(arr);
    }

    /**
     * http://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/
     * ip: aabc
     * op: abc
     */
    public static String removeDuplicatesFromString(String str) {
        Set<Character> hashSet = new LinkedHashSet<>();

        for (int i=0; i<str.length(); i++) {
            hashSet.add(str.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (Character c: hashSet) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public static boolean isPanagram(String str) {

        Set<Character> charSet = new HashSet<>();
        str = str.toLowerCase();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (isAlphabet(c)) {
                charSet.add(c);
            }
        }

        return charSet.size() == 26;
    }

    /**
     * http://www.geeksforgeeks.org/remove-spaces-from-a-given-string/
     * try with O(n)
     * @param str
     * @return
     */
    public static String removeSpaces(String str) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();

    }

    /**
     *
     * http://www.geeksforgeeks.org/c-program-find-second-frequent-character/
     * second most frequently used char
     */
    public static char secondMostFrequentChar(String str) {
        //total characters possible
        char[] countOf = new char[NO_OF_CHARS];

        for(int i=0;i<str.length(); i++) {
            countOf[str.charAt(i)]++;
        }

        int first = 0; int second = 0;
        for (int i=0; i<NO_OF_CHARS; i++) {
            if (countOf[i] > countOf[first]) {
                second = first;
                first = i;
            } else if (countOf[i] > countOf[second] && countOf[i] != countOf[first]) {
                second = i;
            }
        }

        return (char) second;
    }

    /**
     * find Kth non-repeating character
     * @param str
     * @return
     */
    public static char kNonRepeatingChar(String str, int k) {

        int[] count = new int[NO_OF_CHARS];
        int[] index = new int[NO_OF_CHARS];
        int length = str.length();
        for (int i=0; i< NO_OF_CHARS; i++) {
            count[i] = 0;
            index[i] = length;
        }

        for (int i=0; i<length; i++) {

            char ch = str.charAt(i);
            count[ch]++;

            if (count[ch] == 1) {
                index[ch] = i;
            }

            if (count[ch] > 1) {
                index[ch] = length;
            }
        }

        Arrays.sort(index);

        return (index[k-1] != length) ? str.charAt(index[k-1]) : ' ';
    }

    public static void main(String args[]) {
        System.out.println(reversAnArrayWithoutAffectingSpecialChars("aB,3$Es"));
        System.out.println("remove dupe" + removeDuplicatesFromString("aaaggtrrqeet"));
        System.out.println("Is Panagram: " + isPanagram("The quick brown fox jumps over the dog"));
        System.out.println("Remove spaces: " + removeSpaces(" a b c d "));
        System.out.println("second most freq char: " + secondMostFrequentChar("aabc"));
        System.out.println("Kth non-repeating char: " + kNonRepeatingChar("aaabccdeff", 3));
    }
}