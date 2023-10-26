package com.bu.graph.impl;

import com.bu.graph.Graph;

import java.util.Arrays;

/**
 * @author haizhuangbu
 * @date 2023/10/24 10:34
 * @mark BellmanFord 贝尔曼福德算法 最短路径算法
 */
public class BellmanFord {

    private Graph graph;

    private int[] dis;

    public BellmanFord(int v) {
        graph = new Graph(v);


        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 7);
        graph.addEdge(3, 1, -7);
        graph.addEdge(1, 3, 10);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 3, 5);

        dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
    }


    public void bellmanFord(int start) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        int[][] g = graph.getGraph();

        for (int i = 1; i < g.length; i++) {
            boolean flag = false;
            for (int j = 0; j < g[i].length; j++) {
                for (int k = 0; k < g[j].length; k++) {
                    if (g[j][k] == 0) continue;
                    if (dis[k] > dis[j] + g[j][k]) {
                        dis[k] = dis[j] + g[j][k];
                        flag = true;
                    }
                    if (!flag) return;

                }
            }


        }

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (dis[i] > dis[j] + g[j][i]) {
                    System.out.println(" 负循环 ");
                    return;
                }
            }
        }
    }


    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord(5);
        bellmanFord.bellmanFord(0);
        for (int i = 0; i < bellmanFord.dis.length; i++) {
            System.out.println("[ " + i + " : " + bellmanFord.dis[i] + " ]");
        }
    }


}
