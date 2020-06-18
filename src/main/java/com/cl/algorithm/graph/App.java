package com.cl.algorithm.graph;

/**
 * @author chenliang
 * @date 2020-06-17
 */
public class App {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.add(0, 1);
        graph.add(0,3);
        graph.add(1, 2);
        graph.add(1, 4);
        graph.add(2, 5);
        graph.add(3, 4);
        graph.add(4, 5);
        graph.add(4, 6);


       graph.levelSearch(0, 2);

    }
}
