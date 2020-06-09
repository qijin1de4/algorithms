package me.hqj.algorithms;

import java.util.Arrays;
import java.util.List;
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
        //runFibonacci();
        mergeSort();
    }

    public static void runFibonacci(){
        System.out.println("Fibonacci 5 :" + Fibonacci.getNumber(5));
        System.out.println("Fibonacci sequence :" +  Arrays.stream(Fibonacci.getSequence(50)).boxed().collect(Collectors.toList()));
    }

    public static void runCoins(){
        Coins coins = new Coins();
        coins.coinChange(new int[] {5,3,7}, 214);

        List<String> skus = Arrays.asList("1");

        System.out.println(skus.stream().reduce( (str1, str2) -> str1 + "," + str2).get());
        System.out.println(skus.stream().reduce("", (str1, str2) -> str1 + "," + str2));
    }

    public static void mergeSort(){
        int[] arr = new int[]{3,44,28,5,40,1001,23,7,9};
        System.out.println("Merge sort" +  Arrays.stream(Sort.mergeSort(arr)).boxed().collect(Collectors.toList()));
    }
}

