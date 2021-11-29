package me.hqj.algorithms.leetcode.middle;

import me.hqj.algorithms.leetcode.common.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemprature {

    public int[] dailyTemperatures(int[] temperatures) {

        if(temperatures == null || temperatures.length == 0) {
            return temperatures;
        }

        int[] days = new int[temperatures.length];

        Stack<Node> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            while( !stack.isEmpty()) {
                Node node = stack.peek();
                if(temperatures[i] <= node.temperature) {
                    stack.push(new Node(temperatures[i], i));
                    break;
                } else {
                    node = stack.pop();
                    days[node.pos] = i - node.pos;
                }
            }
            stack.push(new Node(temperatures[i], i));
        }

        return days;
    }

    static class Node {
        int temperature;
        int pos;

        public Node(int temperature, int pos) {
            this.temperature = temperature;
            this.pos = pos;
        }
    }

}
