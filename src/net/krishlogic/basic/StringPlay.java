package net.krishlogic.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringPlay {

    private static int NO_OF_CHARS = 256;
    private static int NO_OF_ALPHABETS = 26;

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

    /**
     * http://www.geeksforgeeks.org/count-number-of-substrings-with-exactly-k-distinct-characters/
     * @param str
     * @param k
     * @return
     */

    public static int printKDistinctCharacters(String str, int k) {
        int[] cnt = new int[26]; //26 alphabets
        int result = 0;
        int length = str.length();
        System.out.println("REVISIT THIS ONE");

        for (int i=0; i<length; i++) {
            int distinctCount =0;
            Arrays.fill(cnt, 0);
            for (int j=i; j<length; j++) {
                if (cnt[str.charAt(j) - 'a'] == 0) {
                    //System.out.print(str.charAt(j));
                    distinctCount++;
                }

                cnt[str.charAt(j) - 'a']++;

                if (distinctCount == k) {
                    result++;
                    //System.out.println("");
                }
            }
        }

        return result;
    }


    /**
     * http://www.geeksforgeeks.org/find-kth-character-of-decrypted-string/
     * @param str
     * @param k
     * @return
     */
    public static char getKthDecryptedString(String str, int k) {

        String expand="";

        for (int i=0; i<str.length();) {
            int frequency = 0;
            String temp= "";
            while(i<str.length() && str.charAt(i) >= 'a' && str.charAt(i) <='z') {
                temp += str.charAt(i);
                i++;
            }

            while(i<str.length() && str.charAt(i) >='1' && str.charAt(i) <='9') {
                frequency = frequency * 10 + Character.getNumericValue(str.charAt(i));
                i++;
            }

            for(int j=1; j<=frequency; j++) {
                expand +=temp;
            }
        }

        return expand.charAt(k-1);
    }

    /**
     * http://www.geeksforgeeks.org/count-characters-position-english-alphabets/
     * @param str
     * @return
     */
    public static int countCharAtSamePosition(String str) {
        int result = 0;
        for(int i=0; i<str.length(); i++) {
            if (i == str.charAt(i)-'a' || i == str.charAt(i) - 'A') {
                result++;
            }
        }

        return result;
    }

    /**
     * http://www.geeksforgeeks.org/check-two-strings-k-anagrams-not/
     * @param str1
     * @param str2
     * @param k
     * @return
     */
    public static boolean areKAnagrams(String str1, String str2, int k) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0 || k < 1) {
            return false;
        }

        char[] charArr1 = new char[NO_OF_ALPHABETS];
        char[] charArr2 = new char[NO_OF_ALPHABETS];

        for (int i=0; i<str1.length(); i++) {
            charArr1[str1.charAt(i) - 'a']++;
        }

        for (int j=0; j<str2.length(); j++) {
            charArr2[str2.charAt(j) - 'a']++;
        }

        int count =0;
        for (int x=0; x<NO_OF_ALPHABETS; x++) {

            if (charArr1[x] > charArr2[x]) {
                count = count + Math.abs(charArr1[x] - charArr2[x]);
            }

            if (count > k) {
                return false;
            }
        }

        return true;
    }

    /**
     * http://www.geeksforgeeks.org/count-words-in-a-given-string/
     * @param str
     * @return
     */
    public static int countWordsInAString(String str) {
        int count = 0;
        boolean state = true;
        if (str == null || str.length() == 0) {
            return count;
        }
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c == '\n' || c == ' ' || c == '\t' || c== '\r') {
                state = true;
                continue;
            }

            if (state) {
                state = false;
                count++;
            }
        }

        return count;
    }

    /**
     * http://www.geeksforgeeks.org/count-substrings-with-same-first-and-last-characters/
     * @param str
     * method1 - O(n2);
     * @return
     */
    public static int countSubstringWithSameFirstAndLastChar1(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }
        int count =0;
        for (int i=0; i<str.length(); i++) {
            for (int j=i; j<str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }


    /**
     * http://www.geeksforgeeks.org/count-substrings-with-same-first-and-last-characters/
     * @param str
     * method2 - O(n);
     * @return
     */
    public static int countSubstringWithSameFirstAndLastChar2(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] c = new char[NO_OF_CHARS];
        int count = 0;

        for (int i=0; i<str.length(); i++) {
            c[str.charAt(i) - 'a']++;
        }

        for (int i=0; i<str.length(); i++) {
            count += c[i] * (c[i] + 1)/2;
        }

        return count;
    }

    public static void main(String args[]) {
        System.out.println(reversAnArrayWithoutAffectingSpecialChars("aB,3$Es"));
        System.out.println("remove dupe" + removeDuplicatesFromString("aaaggtrrqeet"));
        System.out.println("Is Panagram: " + isPanagram("The quick brown fox jumps over the dog"));
        System.out.println("Remove spaces: " + removeSpaces(" a b c d "));
        System.out.println("second most freq char: " + secondMostFrequentChar("aabc"));
        System.out.println("Kth non-repeating char: " + kNonRepeatingChar("aaabccdeff", 3));
        System.out.println("Kth distinct " + printKDistinctCharacters("abcbaa", 3)); // need to revisit.
        System.out.println("Kth Decrypted String: " + getKthDecryptedString("ab4c12ed3", 21));
        System.out.println("Count characters at same position: " + countCharAtSamePosition("AbgdeF"));
        System.out.println("areKAnagrams -- grammar, anagrams, 3:=> " + areKAnagrams("anagrams", "grammar", 3));
        System.out.println("count words in a givn str: " + countWordsInAString("One two       three\n four\tfive  "));
        System.out.println("count substring with same first and last chars= " + countSubstringWithSameFirstAndLastChar1("aba") + " method 2: " + countSubstringWithSameFirstAndLastChar2("aba"));

    }
}