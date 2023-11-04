package me.hqj.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
 * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个 不为空的 单词列表。因为是从词典中获得的，所以该单词列表内的单词已经 按这门新语言的字母顺序进行了排序。
 * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output:
 * "wertf"
 *
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output:
 * "zx"
 *
 * Example 3:
 *
 * ""
 * ""
 */
public class MarsDict {

    public String alphabetSeq(String[] dict) {

        Map<Character, List<Character>> ajdList = new HashMap<>();

        for(int i = 0; i < dict.length -1; i++) {
            String w1 = dict[i];
            String w2 = dict[i+1];
            int n1 = w1.length();
            int n2 = w2.length();
            for(int j= 0 ; j < Math.max(n1, n2); j++) {

            }
        }

        return "";
    }

}
