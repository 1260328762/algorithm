package com.cl.algorithm.graph;

import java.util.*;

/**
 * @author chenliang
 * @date 2020-06-17
 * 无向图
 */
public class Graph {

    /**
     * 顶点个数
     */
    private int v;

    private LinkedList<Integer>[] list;

    public Graph(int size) {
        this.v = size;
        list = new LinkedList[v];
        for (int i = 0; i < size; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void add(int orig, int dest) {
        // 无向图一个顶点存两次
        list[orig].add(dest);
        list[dest].add(orig);
    }


    /**
     * 广度优先搜索算法(Breadth-First-Search)
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        boolean[] visited = new boolean[v];
        visited[s] = true;
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < list[poll].size(); i++) {
                // 顶点
                Integer vertex = list[poll].get(i);
                if (!visited[vertex]) {

                    prevMap.put(vertex, poll);
                    if (vertex == t) {
                        // 打印节点
                        System.out.println(prevMap);
                        print(prevMap, s, t);
                        return;
                    }
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }
        }
    }

    /**
     * 深度优先算法(Depth-First-Search)
     *
     * @param start
     * @param end
     */
    public void dfs(int start, int end) {
        if (start == end) return;
        boolean[] visited = new boolean[v];
        visited[start] = true;
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recDfs(start, end, visited, prev);
        print(prev, start, end);
    }

    public void recDfs(int start, int end, boolean[] visited, int[] prev) {
        if (found) return;
        visited[start] = true;
        if (start == end){
            found = true;
            return;
        }
        for (int i = 0; i < list[start].size(); i++) {
            Integer vertex = list[start].get(i);
            if (!visited[vertex]) {
                prev[vertex] = start;
                recDfs(vertex, end, visited, prev);
            }
        }
    }


    /**
     * 按层查找, 找出指定节点的第几层
     */
    public void levelSearch(int start, int level){
        int[] result = new int[v];
        boolean[] visited = new boolean[v];
        List<Integer> levelList = new ArrayList<>();
        levelList.add(start);
        visited[start] = true;
        while (level-- > 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer integer : levelList) {
                LinkedList<Integer> nextLevel = list[integer];
                while (!nextLevel.isEmpty()) {
                    Integer pop = nextLevel.pop();
                    if (!visited[pop]) {
                        temp.add(pop);
                        visited[pop] = true;
                    }
                }
            }
            levelList.clear();
            levelList.addAll(temp);
        }
        System.out.println(levelList);
    }


    boolean found = false; // 全局变量或者类成员变量

    // public void dfs(int s, int t) {
    //     found = false;
    //     boolean[] visited = new boolean[v];
    //     int[] prev = new int[v];
    //     for (int i = 0; i < v; ++i) {
    //         prev[i] = -1;
    //     }
    //     recurDfs(s, t, visited, prev);
    //     print(prev, s, t);
    // }
    //
    // private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
    //     if (found) return;
    //     visited[w] = true;
    //     if (w == t) {
    //         found = true;
    //         return;
    //     }
    //     for (int i = 0; i < list[w].size(); ++i) {
    //         int q = list[w].get(i);
    //         if (!visited[q]) {
    //             prev[q] = w;
    //             recurDfs(q, t, visited, prev);
    //         }
    //     }
    // }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    private void print(HashMap<Integer, Integer> map, int s, int t) { // 递归打印s->t的路径
        String result = t + "";
        while (map.get(t) != null) {
            result += t = map.get(t);
        }
        System.out.println(new StringBuilder(result).reverse());
    }

}
