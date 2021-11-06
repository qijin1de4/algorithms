package me.hqj.algorithms.leetcode;

/**
 * LeetCode
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        if( height == null || height.length < 2) {
            return 0;
        }

        int i = 0, j = height.length - 1;

        int max = Math.min(height[i], height[j]) * (j-i);

        int maxI = i;

        int maxJ = j;

        while(i < j - 1) {
            //左向右移动
            if(height[maxI] == Math.min(height[maxI], height[maxJ])) {
                if(height[++i] > height[maxI]) {
                    maxI = i;
                    int newArea = Math.min(height[i], height[maxJ]) * (maxJ-maxI);
                    if(newArea > max) {
                        max = newArea;
                    }
                }
            } else {
                if(height[--j] > height[maxJ]) {
                    maxJ = j;
                    int newArea = Math.min(height[j], height[maxI]) * (maxJ-maxI);
                    if(newArea > max) {
                        max = newArea;
                    }
                }
            }
        }

        return max;
    }
}
