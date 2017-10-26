package net.krishlogic.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
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

    /**
     * http://www.geeksforgeeks.org/maximum-consecutive-repeating-character-string/
     * @param str
     * @return
     */
    public static char maxConsecitiveRepeatingChar(String str) {

        if (str == null || str.length() == 0) {
            throw new RuntimeException("invalid string");
        }
        int resultCount = 0;
        int currentCount = 0;
        char repeatingChar = str.charAt(0);
        for (int i=0; i<str.length()-1; i++) {

            if (str.charAt(i) == str.charAt(i+1)) {
                currentCount++;
            } else {
                if (currentCount > resultCount) {
                    resultCount = currentCount;
                    repeatingChar = str.charAt(i);
                }
                currentCount = 0;
            }
        }

        System.out.println("char: " + repeatingChar + " repeated " + resultCount + " times");

        return repeatingChar;
    }

    /**
     * http://www.geeksforgeeks.org/count-strings-can-formed-using-b-c-given-constraints/
     * @param n
     * @param bCount
     * @param cCount
     * @return
     */
    public static int getCountOfStringsByABC(int n, int bCount, int cCount) {

        if (bCount < 0 || cCount <0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (bCount == 0 && cCount == 0) {
            return 1;
        }

        int res = getCountOfStringsByABC(n-1, bCount, cCount);
        res += getCountOfStringsByABC(n-1, bCount-1, cCount);
        res += getCountOfStringsByABC(n-1, bCount, cCount-1);

        return  res;
    }

    public static void groupWordsWithSameCharSet() {
        String[] lst = {"may", "student", "students", "dog", "studentssess", "god", "cat", "act", "tab", "bat", "flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle"};
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i=0; i< lst.length; i++) {
            String key = getKey(lst[i]);

            if(map.containsKey(key)) {
                List<Integer> get_al = map.get(key);
                get_al.add(i);
                map.put(key, get_al);
            } else {
                ArrayList<Integer> new_al = new ArrayList<>();
                new_al.add(i);
                map.put(key, new_al);
            }
        }

        for (Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> val = entry.getValue();

            for (int s : val) {
                System.out.print (lst[s] + " ,");
            }

            System.out.println("");
        }
    }

    private static String getKey(String str) {
        boolean[] visited = new boolean[NO_OF_CHARS];
        Arrays.fill(visited, false);

        for (int j = 0; j < str.length(); j++)
            visited[str.charAt(j) - 'a'] = true ;
        String key = "";
        for (int j=0; j < NO_OF_CHARS; j++) {
            if (visited[j]) {
                key = key + (char)('a'+j);
            }
        }

        return key;
    }

    public static int getTotalAnagramSubstrings(String str) {

        int length = str.length();
        int result = 0;

//        Map<String, char[]> map = new HashMap<>();
//
        char[] freq = new char[NO_OF_CHARS];

        for (int i=0; i<str.length(); i++) {

            for (int j=i; j<length; j++) {
                freq[str.charAt(j) - 'a']++;
            }
        }

        for (Character c : freq) {
            result += (c * (c-1))/2;
        }

        return result;
    }

    public static int countEvenSubstringDigits(String str) {

        int length = str.length();
        int count = 0;

        for (int i=0; i<length; i++) {
            int temp = str.charAt(i) - '0';

            if (temp % 2 ==0) {
                count += (i+1);
            }
        }

        return count;
    }

    public static void printDistinct(String str) {

        char[] arr = new char[NO_OF_CHARS];

        for (int i=0; i<str.length(); i++) {
            arr[str.charAt(i)]++;
        }

        for (int i=0; i<str.length(); i++) {
            if(arr[str.charAt(i)] == 1) {
                System.out.print(str.charAt(i));
            }
        }

    }

    /**
     * http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
     * @param str
     * @param pattern
     */
    public static String getSmallestWindowChar(String str, String pattern) {

        int patternLength = pattern.length();
        int length = str.length();

        char[] patternArr = new char[NO_OF_CHARS];
        char[] strArr = new char[NO_OF_CHARS];

        for (int i=0; i< patternLength; i++) {
            patternArr[pattern.charAt(i)]++;
        }

        int count = 0;
        int index = -1;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i=0; i<length; i++) {
            strArr[str.charAt(i)]++;

            if (patternArr[str.charAt(i)] != 0 &&
                    strArr[str.charAt(i)] <= patternArr[str.charAt(i)] ) {

                count++;
            }


            if (count == patternLength) {
                while(strArr[str.charAt(start)] > patternArr[str.charAt(start)] || patternArr[str.charAt(start)] == 0) {
                    if(strArr[str.charAt(start)] > patternArr[str.charAt(start)]) {
                        strArr[str.charAt(start)]--;
                        start++;
                    }
                }
            }

            int len_window = i - start + 1;
            if (minLen > len_window)
            {
                minLen = len_window;
                index = start;
            }
        }

        if (index == -1) {
            return "No match found";
        }

        return str.substring(index, index + minLen);
    }

    public static String printCommonChars(String str1, String str2) {

        char[] arr1 = new char[NO_OF_CHARS];
        char[] arr2 = new char[NO_OF_CHARS];

        for (int i=0; i<str1.length(); i++) {
            arr1[str1.charAt(i)-'a']++;
        }

        for (int i=0; i<str2.length(); i++) {
            arr2[str2.charAt(i)-'a']++;
        }

        String chars = "";

        for (int i = 0 ; i < NO_OF_CHARS ; i++) {
            if (arr1[i] != 0 && arr2[i] != 0) {
                for (int j = 0 ; j < Math.min(arr1[i], arr2[i]) ; j++)
                    chars += (char)(i + 'a');
            }
        }

        return chars;

    }

    /**
     * http://www.geeksforgeeks.org/minimum-sum-squares-characters-counts-given-string-removing-k-characters/
     * @param str
     * @param k
     * @return
     */
    public static int getMinStringValue(String str, int k) {
        int[] charArr = new int[NO_OF_CHARS];

        for(int i=0; i<str.length(); i++) {
            charArr[str.charAt(i) - 'a']++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (int i=0; i<NO_OF_CHARS; i++) {
            if (charArr[i] != 0) {
                queue.add(charArr[i]);
            }
        }

        while(k!=0) {
            int temp = queue.peek();
            temp--;
            queue.poll();
            queue.add(temp);
            k--;
        }
        int result = 0;
        while(!queue.isEmpty()) {
            result += queue.peek() * queue.peek();
            queue.poll();
        }

        return result;
    }

    public static void main(String args[]) {
        System.out.println(reversAnArrayWithoutAffectingSpecialChars("aB,3$Es"));
        System.out.println("remove dupe" + removeDuplicatesFromString("aaaggtrrqeet"));
        System.out.println("Is Panagram: " + isPanagram("The quick brown fox jumps over the dog"));
        System.out.println("Remove spaces: " + removeSpaces(" a b c d "));
        System.out.println("second most freq char: " + secondMostFrequentChar("aabc"));
        System.out.println("Kth non-repeating char: " + kNonRepeatingChar("aaabccdeff", 3));
        System.out.println("REVISIT THIS ONE: Kth distinct " + printKDistinctCharacters("abcbaa", 3)); // need to revisit.
        System.out.println("Kth Decrypted String: " + getKthDecryptedString("ab4c12ed3", 21));
        System.out.println("Count characters at same position: " + countCharAtSamePosition("AbgdeF"));
        System.out.println("areKAnagrams -- grammar, anagrams, 3:=> " + areKAnagrams("anagrams", "grammar", 3));
        System.out.println("count words in a givn str: " + countWordsInAString("One two       three\n four\tfive  "));
        System.out.println("count substring with same first and last chars= " + countSubstringWithSameFirstAndLastChar1("aba") + " ---- method 2: " + countSubstringWithSameFirstAndLastChar2("aba"));
        System.out.println("consecutive repeating character: " + maxConsecitiveRepeatingChar("aaaabbaaccde"));
        System.out.println("REVISIT THIS ONE: count of Strings A B C " + getCountOfStringsByABC(3, 1, 2));
        System.out.println("REVISIT THIS ONE: Group words with same char set: "); groupWordsWithSameCharSet();
        System.out.println("REVISIT THIS ONE (wrong): Count of total anagram substrings: " + getTotalAnagramSubstrings("xyyx"));
        System.out.println("Number of even substrings in a string of digits: " + countEvenSubstringDigits("1234"));
        System.out.println("Print all distinct characters of a string in order: "); printDistinct("Geeks for Geeks");
        System.out.println("\nREVISIT THIS ONE (wrong) Find the smallest window in a string containing all characters of another string: " + getSmallestWindowChar("this is a test string", "tist"));
        System.out.println("Print common characters of two Strings in alphabetical order: " + printCommonChars("geeks", "forgeeks"));
        System.out.println("Minimum sum of squares of character counts in a given string after removing k characters: " + getMinStringValue("abbccc", 2));
    }
}