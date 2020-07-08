package me.hqj.algorithms;

import me.hqj.algorithms.math.Fibonacci;
import me.hqj.algorithms.math.impl.ForkJoinFibonacci;
import me.hqj.algorithms.math.impl.RecursiveFibonacci;
import me.hqj.algorithms.sort.Sort;
import me.hqj.algorithms.sort.impl.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        /*
        Main main = new Main();
        main.addRouteBuilder(new MyRouteBuilder());
        main.run(args);
        */
        //fibonacciSeq(10);
        sort();
    }

    public static void fibonacciSeq(int length){
        Fibonacci fibonacci = new RecursiveFibonacci();
        System.out.println("RecursiveFibonacci sequence :" +  Arrays.stream(fibonacci.getSequence(length)).boxed().collect(Collectors.toList()));
        fibonacci = new ForkJoinFibonacci();
        System.out.println("ForkJoinFibonacci sequence :" +  Arrays.stream(fibonacci.getSequence(length)).boxed().collect(Collectors.toList()));
    }

    public static void runCoins(){
        Coins coins = new Coins();
        coins.coinChange(new int[] {5,3,7}, 214);

        List<String> skus = Arrays.asList("1");

        System.out.println(skus.stream().reduce( (str1, str2) -> str1 + "," + str2).get());
        System.out.println(skus.stream().reduce("", (str1, str2) -> str1 + "," + str2));
    }

    public static void sort(){

        Sort sort = new RecursiveMergeSort();
        int[] arr = new int[]{3,44,28,5,40,1001,23,7,9};
        System.out.println("Merge sort" +  Arrays.stream(sort.sort(arr)).boxed().collect(Collectors.toList()));

        sort = new ForkJoinMergeSort();
        System.out.println("ForkJoin Merge sort : " +  Arrays.stream(sort.sort(arr)).boxed().collect(Collectors.toList()));

        sort = new InsertionSort();
        System.out.println("Insertion sort : " +  Arrays.stream(sort.sort(arr)).boxed().collect(Collectors.toList()));

        sort = new ShellSort();
        System.out.println("Shell sort : " +  Arrays.stream(sort.sort(arr)).boxed().collect(Collectors.toList()));

        ShellSort shellSort = (ShellSort) sort;
        System.out.println("Shell sort with specified gaps : " +  Arrays.stream(shellSort.sort(arr, new int[]{1})).boxed().collect(Collectors.toList()));

        sort = new QuickSort();
        System.out.println("Quick sort : " +  Arrays.stream(sort.sort(arr)).boxed().collect(Collectors.toList()));

        ForkJoinQuickSort forkJoinQuickSort = new ForkJoinQuickSort();
        System.out.println("forkJoinQuickSort sort : " +  Arrays.stream(forkJoinQuickSort.sort(arr)).boxed().collect(Collectors.toList()));

    }

    private static void otherTests(){
        Pattern priceRangePattern = Pattern.compile("max=(\\d+)\\$min=(\\d+)");
        Matcher matcher =priceRangePattern.matcher("max=20$min=10");
        if(matcher.find()){
            System.out.println(matcher.group(1)+"-"+matcher.group(2));
        }
    }
}

