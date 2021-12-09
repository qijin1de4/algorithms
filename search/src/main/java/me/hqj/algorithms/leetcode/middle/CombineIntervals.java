package me.hqj.algorithms.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，
 * 并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class CombineIntervals {

    public static int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, ( a1, a2) -> {
            if(a1[0] > a2[0] ) {
                return 1;
            } else if (a1[0] < a2[0]) {
                return -1;
            }
            return 0;
        });

        int[] previous = intervals[0];

        for(int[] current : intervals) {
            if(previous[1] < current[0] ) {
                result.add(previous);
                previous = current;
            } else {
                previous[1] = Math.max(previous[1], current[1]);
            }
        }
        result.add(previous);
        return result.toArray( new int[][]{});
    }
}
