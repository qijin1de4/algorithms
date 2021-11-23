package me.hqj.algorithms;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    static class Test {

        private int x;

        public Test(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int hashCode () {
            return 1;
        }
    }

    public static void main(String[] args) {
        Test t1 = new Test(1);
        Test t2 = new Test(2);

        Set<Test> set = new HashSet<>();

        set.add(t1);

        System.out.println(set.size());

        set.add(t2);

        System.out.println(set.size());

        for(Test t : set) {

            System.out.println(t.getX());
        }

        set.remove(t1);


        for(Test t : set) {

            System.out.println(t.getX());
        }

        System.out.println(set.contains(t2));
    }
}
