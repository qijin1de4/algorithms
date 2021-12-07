package me.hqj.algorithms.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不重复字符串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestNoRepeatSubstr {

    public static int lengthOfLongestSubstring(String s) {

        int max = 0;
        if(s != null && s.length() > 0) {

            Map<Character, Integer> hash = new HashMap<>();

            // i 快指针， j 慢指针
            int i = 0,j = 0;
            while( i < s.length()) {
                Character c = s.charAt(i);
                if(hash.containsKey(c)) {
                    int cPos = hash.get(c);
                    max = Math.max(i - j, max);
                    while(j <= cPos) {
                        hash.remove(s.charAt(j++));
                    }
                }
                hash.put(c, i);
                i++;
            }
            max = Math.max(i - j, max);
        }
        return max;
    }

}
