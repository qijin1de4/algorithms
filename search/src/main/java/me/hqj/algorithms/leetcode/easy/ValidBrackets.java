package me.hqj.algorithms.leetcode.easy;

import me.hqj.algorithms.common.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 */
public class ValidBrackets {

    public static boolean isValid(String s) {

        if(s == null || s.length() == 0) {
            return false;
        }

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(stack.size() == 0) {
                stack.push(arr[i]);
            } else {
                switch(arr[i]) {
                    case '[' :
                    case '{' :
                    case '(' :
                        stack.push(arr[i]);
                        break;
                    case ']' :
                    case ')' :
                    case '}' :
                        char c = stack.pop();
                        if( arr[i] == ']' && c != '[' ||
                            arr[i] == ')' && c != '(' ||
                            arr[i] == '}' && c != '{') {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.size() == 0;
    }
}
