package com.bu.graph.impl;

import com.bu.graph.Graph;

import java.util.Arrays;

/**
 * @author haizhuangbu
 * @date 2023/10/23 15:40
 * @mark Prim 普雷姆算法 最小生成树
 */
public class Prim {

    private Graph graph;

    private boolean[] visited;

    private int[] path;

    private int[] low;

    public Prim() {

        graph = new Graph(5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 7);
        graph.addEdge(1, 3, 10);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 3, 5);

        visited = new boolean[5];

        path = new int[5];
        Arrays.fill(path, Integer.MAX_VALUE);
        low = new int[5];
        Arrays.fill(low, Integer.MAX_VALUE);

    }

    public void prim(int start) {

        low[start] = 0;
        path[start] = 0;

        int[][] g = graph.getGraph();
        int min;

        for (int i = 0; i < g.length - 1; i++) {
            min = findMin();
            visited[min] = true;

            for (int j = 0; j < g[min].length; j++) {

                if (!visited[j] && low[j] > g[min][j] && g[min][j] != 0) {
                    low[j] = g[min][j];
                    path[j] = min;
                }

            }

        }


    }

    private int findMin() {

        int minVal = Integer.MAX_VALUE;

        int min = -1;

        for (int i = 0; i < low.length; i++) {

            if (!visited[i] && low[i] < minVal) {
                minVal = low[i];
                min = i;
            }
        }

        if (min != -1) return min;

        return -1;
    }


    public static void main(String[] args) {
        Prim prim = new Prim();
        prim.prim(0);
        for (int i = 0; i < prim.path.length; i++) {
            System.out.print(prim.path[i] + "  ");
        }
        System.out.println();
    }

}
