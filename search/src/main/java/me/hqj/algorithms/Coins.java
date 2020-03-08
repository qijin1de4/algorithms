package me.hqj.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Coins {

    public int coinChange(int[] coins, int amount) {

         List<Integer> coinList = Arrays.stream(coins).boxed().collect(Collectors.toList());
         coinList.sort(  (i,j) -> {
            if(j>i) return 1;
            else return -1;
        });
         coinList.stream().forEach(System.out::println);
         for(Integer coin : coinList){
             if(amount % coin == 0) return amount % coin; // 单个面值硬币正好，立即返回。
         }

         List<List<Integer>> allPossbileCombinationList = new ArrayList<>();

         for(Integer coin : coinList){ //在给定金额的情况下，获取每个硬币可能的个数。小于金额的硬币面值的所有倍数。
             int mult = 0;
             List<Integer> thisCoinPossibleSolutions = new ArrayList<>();
                do{
                    thisCoinPossibleSolutions.add(coin * mult);
                    mult+=1;
                }while(coin * mult < amount);
         }

         class recursiveFind {

             void find(List<List<Integer>> possibles, int columnIndex, int rowIndex, int moneyCount, int coinCount, List<Integer> solutions ){
                    if(columnIndex < possibles.size()){
                        int thisCoinCount = coinCount;
                        int thisMoneyCount = moneyCount;
                        List<Integer> thisConinPossible = possibles.get(columnIndex);
                        for(int i = 0; i < thisConinPossible.size(); i++){

                        }

                    }
             }
         }

         for(List<Integer> thisCoinPossibleSolutions : allPossbileCombinationList){
                for(int i = 0; i < thisCoinPossibleSolutions.size(); i++) {

                }
         }

        return -1;
    }

}
