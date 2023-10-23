package com.bu.graph;

/**
 * @author haizhuangbu
 * @date 2023/10/23 14:14
 * @mark Graph 图
 */
public class Graph {

    // 邻接矩阵
    private int[][] graph;

    public Graph(int v) {
        graph = new int[v][v];
    }

    public void addEdge(int start, int end, int weight) {
        graph[start][end] = weight;
    }

    public void foreach() {
        for (int i = 0; i < graph.length; i++) {

            for (int j = 0; j < graph[i].length; j++) {
                System.out.print("[" + i + " - " + j + "]  ");
            }
            System.out.println();

            for (int j = 0; j < graph[i].length; j++) {
                System.out.print("   " + graph[i][j] + "    ");
            }
            System.out.println();
        }
    }


    public int[][] getGraph() {
        return graph;
    }

}
