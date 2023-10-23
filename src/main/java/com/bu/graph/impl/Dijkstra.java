package com.bu.graph.impl;

import com.bu.graph.Graph;

import java.util.Arrays;

/**
 * @author haizhuangbu
 * @date 2023/10/23 14:40
 * @mark Dijkstra 迪克斯特拉 最短路径算法
 */
public class Dijkstra {

    private boolean[] visited;

    private int[] low;

    private Graph graph;

    public Dijkstra() {

        graph = new Graph(5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 7);
        graph.addEdge(1, 3, 10);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 3, 5);

        visited = new boolean[5];

        low = new int[5];
        Arrays.fill(low, Integer.MAX_VALUE);


    }


    public void dijkstra(int start) {
        if (visited[start]) return;
        int[][] g = graph.getGraph();
        visited[start] = true;
        int min = -1;
        for (int i = 0; i < g[start].length; i++) {
            if (g[start][i] != 0) {
                if (low[start] != Integer.MAX_VALUE && low[start] + g[start][i] < low[i]) {
                    low[i] = low[start] + g[start][i];
                }
            }
            min = findMin();
        }

        if (min != -1) dijkstra(min);


    }

    private int findMin() {

        int minVal = Integer.MAX_VALUE;
        int min = -1;
        for (int i = 1; i < low.length; i++) {
            if (low[i] < minVal && !visited[i]) {
                minVal = low[i];
                min = i;
            }
        }
        if (min != -1) return min;
        return -1;
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.low[0] = 0;

        dijkstra.dijkstra(0);

        for (int i = 0; i < dijkstra.low.length; i++) {
            System.out.print(dijkstra.low[i] + "  ");
        }
        System.out.println();

    }


}
