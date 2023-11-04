package me.hqj.algorithms.saima.stars2.me.hqj.algorithms.saima.stars3;

/**
 * 给一个整数d，一个整数序列s
 * 求对s中的任意元素最少做多少次加d的操作使得s变为单调递增？
 */
public class MonotonicallyIncreasingSequence {
    public static void main(String[] args) {
//        int d = 3;
//        int[] s = {5, 2, 8, 6, 9};
        int d = 2;
        int [] s = {1,3,3,2};
        int result = minOperations(d, s);
        System.out.println("最少操作次数: " + result);
    }

    public static int minOperations(int d, int[] s) {
        int n = s.length;
        int operations = 0;

        for (int i = 1; i < n; i++) {
            if (s[i] <= s[i-1]) {
                int diff = s[i-1] - s[i] + 1;
                int addOperations = diff / d;
                if (diff % d != 0) {
                    addOperations++;
                }
                operations += addOperations;
                s[i] += addOperations * d;
            }
        }

        return operations;
    }
}
