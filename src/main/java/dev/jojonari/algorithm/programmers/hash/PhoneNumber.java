package dev.jojonari.algorithm.programmers.hash;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneNumber {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        int loopCount = phoneBook.length - 1;
        for (int i = 0; i < loopCount; i++) {
            if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                return false;
            }
        }
        return true;
    }
}
