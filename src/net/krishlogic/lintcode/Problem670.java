package net.krishlogic.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The words are same rotate words if rotate the word to the right by loop, and get another. Count how many different rotate word sets in dictionary.

 E.g. picture and turepic are same rotate words.

 Given dict = ["picture", "turepic", "icturep", "word", "ordw", "lint"]
 return 3.

 "picture", "turepic", "icturep" are same ratote words.
 "word", "ordw" are same too.
 "lint" is the third word that different from the previous two words.
 */

public class Problem670 {
    /*
       * @param words: A list of words
       * @return: Return how many different rotate words
       */
    public int countRotateWords(List<String> words) {
        // Write your code here
        Set<String> strSet= new HashSet<>();
        //sort all words

        for (int i=0; i<words.size(); i++) {
            String currWord = words.get(i);
            if (i==0) {
                strSet.add(currWord);
                continue;
            }

            String prevWord = words.get(i-1);

            if (currWord.length() != prevWord.length()) {
                strSet.add(currWord);
                continue;
            } else {
                boolean isMatch = rotateTillMatch(currWord, prevWord);
                if (!isMatch){
                    strSet.add(currWord);
                }
            }
        }

        System.out.println(strSet);

        return strSet.size();
    }

    public boolean rotateTillMatch(String wordToRotate, String previousWord) {
        char[] charRotate = wordToRotate.toCharArray();

        for (int i=0; i<charRotate.length-1; i++) {
            for (int j=charRotate.length-1; j>0; j--) {
                char temp = charRotate[j];
                charRotate[j] = charRotate[j-1];
                charRotate[j-1] = temp;
            }

            char[] check = charRotate;
            String str = new String(check);

            if (str.equalsIgnoreCase(previousWord)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String[] arr = {"abba", "abab", "baba", "abab", "baba", "bbaa", "aabb"};

        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList(arr));

        Problem670 p = new Problem670();
        System.out.println(p.countRotateWords(wordList));

    }
}
