package com.cl.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author chenliang
 * @date 2020-06-29
 * 有向图
 */
public class DirectionGraph {

    private LinkedList<Integer>[] items;

    private int size = 6;

    public DirectionGraph() {
        items = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            items[i] = new LinkedList<>();
        }
    }


    /**
     * 添加
     * @param s 起始顶点
     * @param t 结束顶点
     */
    public void add(int s, int t) {
        items[s].add(t);
    }


    /**
     * 拓扑排序，Kahn算法
     */
    public void Kahn(){
        int[] inDegree = new int[size];
        
        // 先找出每个节点的入度
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < items[i].size(); j++) {
                Integer vertex = items[i].get(j);
                inDegree[vertex]++;
            }
        }
        System.out.println("入度: " + Arrays.toString(inDegree));

        // 收集入度为0的顶点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }

        // 遍历打印入度为0的节点
        while (!queue.isEmpty()) {
            Integer vertex = queue.pop();
            System.out.print(vertex + " -> ");

            // 对应的顶点入度减一
            LinkedList<Integer> edges = items[vertex];
            for (Integer vertex2 : edges) {
                inDegree[vertex2]--;
                if (inDegree[vertex2] == 0)
                    queue.add(vertex2);
            }
        }
    }

    /**
     * 拓扑排序 深度优先算法实现
     */
    public void dfs(){
        // 构建逆邻接表
        LinkedList<Integer>[] inverseItems = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            inverseItems[i] = new LinkedList<>();
        }

        // 生成逆邻接表
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> vertexList = items[i];
            for (Integer vertex : vertexList) {
                inverseItems[vertex].add(i);
            }
        }

        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] =  true;
                dfs(i, inverseItems, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer>[] inverseItems, boolean[] visited) {
        for (int i = 0; i < inverseItems[vertex].size(); i++) {
            Integer integer = inverseItems[vertex].get(i);
            if (visited[integer]) continue;
            visited[integer] = true;
            dfs(integer, inverseItems, visited);
        }
        System.out.print(vertex + " -> ");
    }
}
