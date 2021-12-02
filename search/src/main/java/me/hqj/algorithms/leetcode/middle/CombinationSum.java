package me.hqj.algorithms.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标 target的唯一组合。
 *
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        selectOne(candidates, target, new ArrayList<>(), result);
        return result;
    }

    /**
     * 递归地取一个元素
     * @param candidates
     * @param target
     * @param subList 用于存放中间结果的list
     * @param result 题解list
     */
    private void selectOne(int[] candidates, int target, List<Integer> subList, List<List<Integer>> result) {
        int subSum = sum(subList);
        if( subSum < target) { //递归控制条件：如果数组只和小于目标值才进一步递归
            for(int i : candidates) {
                List<Integer> newSub = new ArrayList<>(subList);
                newSub.add(i);
                selectOne(candidates, target, newSub, result);
            }
        } else if(subSum == target && !alreadyContains(subList, result)) { //如果候选数组之和等于目标值，并且未曾计入结果
            result.add(subList);
        }
    }

    private int sum(List<Integer> list) {
        int i = 0;
        for(int x : list) {
            i += x;
        }
        return i;
    }

    /**
     * 去重
     * @param subList
     * @param result
     * @return
     */
    public boolean alreadyContains(List<Integer> subList, List<List<Integer>> result) {
        for (List<Integer> list : result) {
            if(list.size() == subList.size()
                && list.containsAll(subList)
                && subList.containsAll(list)) {
                    subList.sort(Integer::compareTo);
                    list.sort(Integer::compareTo);
                    if(subList.equals(list)) {
                        return true;
                    }
            }
        }
        return false;
    }

    //TODO 回溯算法实现

}
