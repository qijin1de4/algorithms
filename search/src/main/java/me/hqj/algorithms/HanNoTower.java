package me.hqj.algorithms;

/**
 *
 */
public class HanNoTower {

    public static void hanNo(char a, char b, char c, int n) {
        if( n > 0) {
            hanNo(a, c, b, n - 1);
            System.out.println( a + " -> " + c );
            hanNo(b, a, c , n -1);
        }
    }

    public static void main(String[] args) {
        hanNo('A', 'B', 'C', 10);
    }
}
