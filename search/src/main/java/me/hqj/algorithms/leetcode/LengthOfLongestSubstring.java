package me.hqj.algorithms.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长不重复字符串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.equals("")) {
            return 0;
        }

        char[] ca = s.toCharArray();

        Character[] temp = new Character[ca.length];

        int max = 1;

        for(int i = 0; i < ca.length; i++) {
            int pos = cPosInTemp(temp, ca[i]);
            if(pos >= 0) {
                int length = countArrLen(temp);
                if(length > max) {
                    max = length;
                }
                /**
                 * 从c在cArr数组的位置开始，向后切出一个子数组并返回
                 * 例如：
                 * [a,b,c,d], a --> [b,c,d]
                 * [a,b,c,d], c --> [d]
                 * [a,b,c,d], d --> []
                 */
                Character[] newTemp = new Character[ca.length];
                System.arraycopy(temp, pos+1, newTemp, 0, length - pos );
                temp = newTemp;
            }
            append2Arr(temp, ca[i]);
        }

        return Math.max(max, countArrLen(temp));
    }

    /**
     * 返回 字符 在字符数组中的位置，如果该字符在数组中不存在就返回 -1
     * @param cArr
     * @param c
     * @return
     */
    private static int cPosInTemp(Character[] cArr, Character c) {
        if(c == null) {
            return -1;
        }
        for(int i = 0; i < cArr.length; i++) {
            if(c.equals(cArr[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 计算数组实际长度
     * @param cArr
     * @return
     */
    private static int countArrLen(Character[] cArr) {
        if(cArr == null) {
            return 0;
        }
        int i = 0;
        while(i < cArr.length && cArr[i] != null) {
            i++;
        }
        return i;
    }

    /**
     * 从c在cArr数组的位置开始，向后切出一个子数组并返回
     * 例如：
     * [a,b,c,d], a --> [b,c,d]
     * [a,b,c,d], c --> [d]
     * [a,b,c,d], d --> []
     * @param cArr
     * @param c
     * @return
     */
    private static Character[] truncateArr(Character[] cArr, Character c) {
        //System.arraycopy();
        return null;
    }

    /**
     * 将字符c添加到字符串数组的最后：
     * [a,b], c --> [a,b,c]
     * @param cArr
     * @param c
     */
    private static void append2Arr(Character[] cArr, Character c) {
        if(c != null && cArr != null) {
            for(int i = 0 ; i < cArr.length; i++) {
                if(cArr[i] == null) {
                    cArr[i] = c;
                    return;
                }
            }
        }
    }
}
