package org.example.interview;

import java.util.ArrayList;
import java.util.List;

public class WordBuilder {

//    Given a word and a dictionary write a function to determine if the word can be
//    formed from the beginning and ending of two dictionary elements;

    public boolean canBeBuild(String s, String[] words) {
        if (words.length == 0) {
            return false;
        }
        List<Integer> beginnings = new ArrayList<>();
        List<Integer> endings = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int beg = sameBeginningLength(words[i], s);
            if (beg > 0) {
                beginnings.add(beg);
            }

            int end = sameEndingLength(words[i], s);
            if (end > 0) {
                endings.add(end);
            }
        }

        return checkIfCanBeBuild(s, beginnings, endings);
    }

    private static boolean checkIfCanBeBuild(String s, List<Integer> beginnings, List<Integer> endings) {
        for (int i = 0; i < beginnings.size(); i++) {
            for (int j = 0; j < endings.size(); j++) {
                if (beginnings.get(i) + endings.get(i) >= s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    private int sameBeginningLength(String s, String baseWord) {
        int counter = 0;
        int length = Math.min(s.length(), baseWord.length());
        for (int i = 0; i < length; i++)
            if (s.charAt(i) == baseWord.charAt(i)) {
                counter++;
            } else {
                break;
            }
        return counter;
    }

    private int sameEndingLength(String s, String baseWord) {
        int counter = 0;
        int length = Math.min(s.length(), baseWord.length());
        for (int i = length - 1; i >= 0; i--)
            if (baseWord.endsWith(s.substring(i))) {
                counter++;
            } else {
                break;
            }
        return counter;
    }
}
