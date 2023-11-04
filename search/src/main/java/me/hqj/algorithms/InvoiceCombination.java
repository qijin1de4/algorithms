package me.hqj.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 有n张发票，报销金额为m。求大于或等于m的发票组合
 * 并且求出发票金额只和最接近m的组合
 */
public class InvoiceCombination {

    public static void main(String[] args) {
        List<List<Double>> combinations = new ArrayList<>();
        findCombination(new double[]{68.2, 68.0,68.0,68.0,68.0,68.0,68.0,136.51,78.1,97.62},
                combinations, new ArrayList<>(), 450d, 0);
        combinations.forEach(c -> {
            System.out.println(c);
            System.out.println(c.stream().reduce(0d, Double::sum));
        });

        List<Double> maxCombination =
        combinations.stream().max((c1, c2) -> {
            double sum1 =
            c1.stream().reduce(0d, Double::sum);
            double sum2 =
                    c2.stream().reduce(0d, Double::sum);
            double diff1 = Math.abs(sum1 - 450d);
            double diff2 = Math.abs(sum2 - 450d);
            if(diff1 == diff2)
                return 0;
            if(diff1 < diff2)
            return 1;
            else
                return -1;

        }).get();

        System.out.println(maxCombination);
        System.out.println(maxCombination.stream().reduce(0d, Double::sum));

    }

    private static void findCombination(double[] invoices, List<List<Double>> combinations, List<Double> combination, double remain, int idx) {
        if(remain <= 0d) {
            combinations.add(new ArrayList<>(combination));
        } else {
            for(int i = idx; i < invoices.length; i++) {
                combination.add(invoices[i]);
                findCombination(invoices, combinations, combination, remain - invoices[i], i+1);
                combination.remove(combination.size() -1);
            }
        }
    }

}
