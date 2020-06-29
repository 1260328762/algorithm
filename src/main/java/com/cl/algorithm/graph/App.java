package com.cl.algorithm.graph;

import java.util.Arrays;

/**
 * @author chenliang
 * @date 2020-06-17
 */
public class App {
    public static void main(String[] args) {
        // DirectionGraph graph = new DirectionGraph();
        //
        // graph.add(0, 1);
        // graph.add(1, 2);
        // graph.add(3, 4);
        // graph.add(2, 5);
        // graph.add(2, 4);
        //
        // graph.dfs();

        int[][] arr = new int[][]{{1, 0}, {2, 1}};
        System.out.println(Arrays.toString(DirectionGraph.canFinish(3, arr)));
    }
}
