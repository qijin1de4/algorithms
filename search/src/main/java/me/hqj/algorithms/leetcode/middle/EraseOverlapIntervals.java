package me.hqj.algorithms.leetcode.middle;

import java.util.Arrays;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 *
 */
public class EraseOverlapIntervals { // * * * * *

    public static int eraseOverlapIntervals(int[][] intervals) {

        int count = 0;

        Arrays.sort(intervals, (a1, a2) -> {
            if (a1[0] > a2[0]) {
                return 1;
            } else if (a1[0] < a2[0]) {
                return -1;
            }
            return 0;
        });

        int[] previous = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if(previous[0] == current[0] && previous[1] == current[1]) {
                count++;
                continue;
            }
            if(previous[1] > current[0]) { // 有重合
                if(previous[1] > current[1]) { // 如果两个区间有重合，总是删除结束时间较晚的区间
                    previous = current;
                }
                count++;
            } else {
                previous = current;
            }
        }
        return count;
    }


}
