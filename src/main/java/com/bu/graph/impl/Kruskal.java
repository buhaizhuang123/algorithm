package com.bu.graph.impl;

import com.bu.graph.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author haizhuangbu
 * @date 2023/10/24 14:41
 * @mark Kruskal 克鲁斯卡尔算法 最小生成树
 */
public class Kruskal {


    private Graph graph;


    private List<Edge> edges;

    public Kruskal(int v) {
        graph = new Graph(v);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 7);
        graph.addEdge(1, 3, 10);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 3, 5);


        edges = sort();

    }

    public void kruskal() {
        int[] end = new int[5];
        ArrayList<Edge> finalSet = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {

            Edge edge = edges.get(i);

            int start = edge.start;

            int end1 = edge.end;

            int p1 = getEnd(end, start);
            int p2 = getEnd(end, end1);

            if (p1 != p2) {
                end[p2] = p1;
                finalSet.add(edge);
            }

        }

        finalSet.forEach(i -> System.out.println("[ " + i.start + " : " + i.end + "]"));


    }


    public int getEnd(int[] end, int n) {
        while (end[n] != 0) {
            n = end[n];
        }
        return n;


    }

    public ArrayList<Edge> sort() {
        ArrayList<Edge> edges = new ArrayList<>();
        int[][] g = graph.getGraph();

        for (int i = 0; i < g.length; i++) {

            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] != 0)
                    edges.add(new Edge(i, j, g[i][j]));
            }
        }
        edges = (ArrayList<Edge>) edges.stream().sorted(Comparator.comparingInt(i -> i.weight)
        ).collect(Collectors.toList());

        return edges;
    }


    public static class Edge {

        private int start;

        private int end;

        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }


        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }
    }


    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal(5);
        kruskal.kruskal();
    }

}
