package com.bu.graph.impl;

import com.bu.graph.Graph;

import java.util.Arrays;

/**
 * @author haizhuangbu
 * @date 2023/10/24 09:17
 * @mark Floyd 弗洛伊德算法 最小生成树
 */
public class Floyd {

    private Graph graph;

    private int[][] path;

    private int max;

    public Floyd(int v) {

        graph = new Graph(v);
        int[][] graph1 = graph.getGraph();
        for (int u = 0; u < graph1.length; u++) {
            Arrays.fill(graph1[u], Integer.MAX_VALUE);
        }

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 7);
        graph.addEdge(1, 3, 10);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 3, 5);

        path = new int[v][v];

        max = v;

    }

    public void floyd() {

        int[][] g = graph.getGraph();

        for (int k = 0; k < max; k++) {

            for (int i = 0; i < max; i++) {

                for (int j = 0; j < max; j++) {
                    if (g[i][k] != Integer.MAX_VALUE && g[k][j] != Integer.MAX_VALUE && g[i][j] > g[i][k] + g[k][j]) {
                        g[i][j] = g[i][k] + g[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        Floyd floyd = new Floyd(5);

        floyd.floyd();
        for (int i = 0; i < floyd.path.length; i++) {
            for (int j = 0; j < floyd.path[i].length; j++) {
                System.out.print("[" + i + " , " + j + "]");
            }
            System.out.println();
            for (int j = 0; j < floyd.path[i].length; j++) {
                System.out.print("   " + floyd.path[i][j] + "   ");
            }
            System.out.println();

        }


    }


}
