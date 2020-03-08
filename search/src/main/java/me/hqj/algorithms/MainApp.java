package me.hqj.algorithms;

import org.apache.camel.main.Main;

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
        Coins coins = new Coins();
        coins.coinChange(new int[] {5,3,7}, 214);
    }

}

