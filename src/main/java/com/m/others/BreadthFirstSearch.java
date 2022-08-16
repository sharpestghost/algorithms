package com.m.others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
//TODO: re-edit
public class BreadthFirstSearch {

    public static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private final int size;
    private Integer[] prev;
    private final List<List<Edge>> graph;

    public BreadthFirstSearch(List<List<Edge>> graph) {
        if (graph != null) {
            size = graph.size();
            this.graph = graph;
        }
        else {
            throw new IllegalArgumentException("Graph cannot be null");
        }
    }


    public List<Integer> reconstructPath(int start, int end) {
        bfs(start);
        List<Integer> path = new ArrayList<>();
        for (Integer at = end; at != null; at = prev[at]) path.add(at);
        Collections.reverse(path);
        if (path.get(0) == start) return path;
        path.clear();
        return path;
    }

    // Perform a breadth first search on a graph a starting node 'start'.
    private void bfs(int start) {
        prev = new Integer[size];
        boolean[] visited = new boolean[size];
        Deque<Integer> queue = new ArrayDeque<>(size);

        // Start by visiting the 'start' node and add it to the queue.
        queue.offer(start);
        visited[start] = true;

        // Continue until the BFS is done.
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Edge> edges = graph.get(node);

            // Loop through all edges attached to this node. Mark nodes as visited once they're
            // in the queue. This will prevent having duplicate nodes in the queue and speedup the BFS.
            for (Edge edge : edges) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    prev[edge.to] = node;
                    queue.offer(edge.to);
                }
            }
        }
    }

    // Initialize an empty adjacency list that can hold up to n nodes.
    public static List<List<Edge>> createEmptyGraph(int n) {
        List<List<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        return graph;
    }

   //add a directed edge with cost
    public static void addDirectedEdge(List<List<Edge>> graph, int u, int v, int cost) {
        graph.get(u).add(new Edge(u, v, cost));
    }

    //add a two-directed edge
    public static void addUndirectedEdge(List<List<Edge>> graph, int u, int v, int cost) {
        addDirectedEdge(graph, u, v, cost);
        addDirectedEdge(graph, v, u, cost);
    }

    //add a two-directed edge without cost
    public static void addUnweightedUndirectedEdge(List<List<Edge>> graph, int u, int v) {
        addUndirectedEdge(graph, u, v, 1);
    }

}
