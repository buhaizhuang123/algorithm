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
        dis[start] = 0;
        int[][] g = graph.getGraph();
        // 顶点数
        int n = g.length;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            flag = false;
            for (int j = 0; j < n; j++) {
//                if (dis[j] == Integer.MAX_VALUE) {
//                    continue;
//                }
//
//                for (int z = 0; z < g[j].length; z++) {
//                    if (dis[j] + g[z][j] < dis[z]) {
//                        dis[z] = dis[j] + g[z][j];
//                        flag = true;
//                    }
//                }
//
//                // dis[i] > dis[i] + g[i][j]
                if (dis[j] == Integer.MAX_VALUE && g[i][j] != 0 && dis[j] > dis[i] + g[i][j]) {
                    dis[j] = dis[i] + g[i][j];
                }
//
//                if (dis[i] != Integer.MAX_VALUE && g[j][i] != 0 && dis[j] > dis[i] + g[j][i]) {
//                    dis[j] = dis[i] + g[j][i];
//                }


            }
//            if (!flag) break;
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
