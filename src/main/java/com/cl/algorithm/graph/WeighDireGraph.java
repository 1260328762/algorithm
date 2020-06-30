package com.cl.algorithm.graph;

import java.util.LinkedList;

/**
 * @author chenliang
 * @date 2020-06-29
 * 有权有向图
 */
public class WeighDireGraph {
    private int size = 10;

    private LinkedList<Edge>[] item;

    public WeighDireGraph() {
        item = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            item[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        item[s].add(new Edge(s, t, w));
    }


    private static class Edge{
        private int sid;
        private int tid;
        private int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    public static class Vertex{
        private int id;
        // 从起始顶点到这个顶点的距离
        private int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

}
