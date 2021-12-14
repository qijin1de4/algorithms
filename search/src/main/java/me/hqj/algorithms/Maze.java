package me.hqj.algorithms;

import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * 迷宫
 *
 * 从一个矩阵表示的迷宫中找到从起点到终点的路径
 *
 */
public class Maze {

    int[][] direction = new int[][] {
            {-1, 0}, //西
            { 1, 0}, //东
            { 0, 1}, //北
            { 0,-1}  //南
    };

    /**
     * 记录路径
     */
    Stack<int[]> path = new Stack<>();

    /**
     * 是否有从起点到出口的路径
     * @param maze
     * @return
     */
    public boolean hasPath2ExitDFS(int[][] maze, int[] start, int[] exit) {
        System.out.println();
        path.clear();
        if(maze != null && maze.length > 0
            && start != null && start.length > 0
            && exit != null && exit.length > 0) {
            if(dfs(copyArr(maze), start, exit)) {
                while(!path.isEmpty()) {
                    int[] passed = path.pop();
                    System.out.print("[" + passed[0] + "," + passed[1] + "] ");
                }
            } else {
                return false;
            }
            return true;
        }

        return false;
    }


    /**
     * 是否有从起点到出口的路径
     * @param maze
     * @return
     */
    public boolean hasPath2ExitBFS(int[][] maze, int[] start, int[] exit) {
        System.out.println();
        if(maze != null && maze.length > 0
                && start != null && start.length > 0
                && exit != null && exit.length > 0) {
            return bfs(copyArr(maze), start, exit);
        }
        return false;
    }

    /**
     * 深度遍历查找迷宫中从节点【x，y】到出口的路径
     * @param maze
     * @param exit
     * @return
     */
    private boolean dfs(int[][] maze, int[] start, int[] exit) {

//        if(start[0] == exit[0] && start[1] == exit[1]) { // 找到出口
        if(Objects.deepEquals(start, exit)) {
            return true;
        }

        maze[start[0]][start[1]] = 1; // 标记节点已经访问过，防止重复访问

        for(int[] d : direction) {
            int[] tryNext = new int[] {start[0] + d[0], start[1] + d[1]};
            if(safeToGo(maze, tryNext[0], tryNext[1]) && dfs(maze, tryNext, exit)) {
                path.push(tryNext);
                return true;
            }
        }

        return false;
    }

    /**
     *  广度优先搜索
     * @param maze
     * @param start
     * @param exit
     * @return
     */
    private boolean bfs(int[][] maze, int[] start, int[] exit) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int[] d : direction) {
                int x = current[0] + d[0], y = current[1] + d[1];
                int[] next = new int[] {x, y};
                if(safeToGo(maze, x, y)) {
                    maze[x][y] = 1;
                    queue.add(next);
                }
                if(Objects.deepEquals(exit, next)) {
                    return true;
                }
            }
        }
       return false;
    }

    /**
     * 判断坐标点 P [x,y] 是否可访问
     * 不可访问：
     * 1，P不超出了maze范围
     * 2，P是障碍墙（P点值为-1）
     * 3, P已经访问过（P点值为0）
     * @param maze
     * @param x
     * @param y
     * @return
     */
    private boolean safeToGo(int[][] maze, int x, int y) {
        if(x >= 0 && x < maze.length
          && y >= 0 && y < maze[x].length
          && maze[x][y] != -1 && maze[x][y] != 1) {
            return true;
        }
        return false;
    }

    /**
     * 找到抵达目标的最短路径
     * @param mazeArr
     * @return
     */
    public boolean getShortestPath(int[][] mazeArr, int[] start, int[] exit) {
        System.out.println();
        path.clear();
        if(mazeArr != null && mazeArr.length > 0
                && start != null && start.length > 0
                && exit != null && exit.length > 0) {

            int[][] maze = copyArr(mazeArr);
            // 处理
            for(int[] node : maze) {
                for(int i = 0; i < node.length; i++) {
                    if(node[i] == 0) {
                        node[i] = Integer.MAX_VALUE;
                    }
                }
            }
            findShortestPathDFS(maze, start, exit, 0);

            if(maze[exit[0]][exit[1]] < Integer.MAX_VALUE) {
                System.out.println("Found exit. path count : " + maze[exit[0]][exit[1]]);
            }
            return true;
        }

        return false;
    }

    /**
     * 找到到达exit的最短路径
     * @param maze
     * @param start
     * @param exit
     * @param count
     */
    private void findShortestPathDFS(int[][] maze, int[] start, int[] exit, int count) {
       if(Objects.deepEquals(start, exit)) {
                   return;
       }
       for(int[] d : direction) {
           int[] tryNext = new int[] {start[0] + d[0], start[1] + d[1]};
           if(safe2Go(maze, tryNext[0], tryNext[1]) && maze[tryNext[0]][tryNext[1]] > count + 1) {
               maze[tryNext[0]][tryNext[1]] = count + 1;
               findShortestPathDFS(maze, tryNext, exit, count + 1);
           }
       }
    }

    private void findShortestPathBFS(int[][] maze, int[] start, int[] exit, int count) {

    }

    /**
     * 判断坐标点 P [x,y] 是否可访问
     * 不可访问：
     * 1，P不超出了maze范围
     * 2，P是障碍墙（P点值为-1）
     * 3, P已经访问过（P点值为0）
     * @param maze
     * @param x
     * @param y
     * @return
     */
    private boolean safe2Go(int[][] maze, int x, int y) {
        if(x >= 0 && x < maze.length
                && y >= 0 && y < maze[x].length
                && maze[x][y] != -1) {
            return true;
        }
        return false;
    }


    /**
     *
     * @param arr
     * @return
     */
    private int[][] copyArr(int[][] arr) {
        if(ArrayUtils.isNotEmpty(arr)) {

            int[][] copy = new int[arr.length][];

            for(int i = 0; i < arr.length; i++) {
                System.arraycopy(arr[i], 0, copy[i], 0, arr[i].length);
            }

            return copy;
        }
        return null;
    }
}
