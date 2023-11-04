package me.hqj.algorithms.saima.stars3;

import java.util.ArrayList;
import java.util.List;

public class BaseCombination {
    public static void main(String[] args) {
        int n = 25; // 总数
        int m = 10; // 基数数量
        int[] baseNumbers = {1, 2, 5}; // 基数数组

        List<List<Integer>> combinations = findCombinations(baseNumbers, n, m);

        // 输出结果
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> findCombinations(int[] baseNumbers, int n, int m) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        // 调用递归函数查找组合
        findCombinationsHelper(baseNumbers, n, m, 0, combinations, currentCombination);

        return combinations;
    }

    /**
     *
     * @param baseNumbers
     * @param sum 总数
     * @param numOfCoins 硬币数量
     * @param startIndex
     * @param combinations
     * @param currentCombination
     */
    private static void findCombinationsHelper(int[] baseNumbers, int sum, int numOfCoins, int startIndex,
                                               List<List<Integer>> combinations, List<Integer> currentCombination) {
        if (sum == 0 && numOfCoins == 0) {
            // 找到一个有效组合
            combinations.add(new ArrayList<>(currentCombination));
        } else if (numOfCoins > 0) {
            for (int i = startIndex; i < baseNumbers.length; i++) {
                if (sum >= baseNumbers[i]) {
                    // 选择当前基数
                    currentCombination.add(baseNumbers[i]);
                    // 递归调用查找下一个基数
                    findCombinationsHelper(baseNumbers, sum - baseNumbers[i], numOfCoins - 1, i, combinations, currentCombination);
                    // 回溯，移除当前基数
                    currentCombination.remove(currentCombination.size() - 1);
                }
            }
        }
    }
}
