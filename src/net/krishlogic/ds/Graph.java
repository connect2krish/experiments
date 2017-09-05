package net.krishlogic.ds;

import sun.awt.image.ImageWatched.Link;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int vertex;
    private LinkedList<Integer> adjacentList[];

    public Graph(int vertex) {
        this.vertex = vertex;
        this.adjacentList = new LinkedList[this.vertex];

        for (int i=0; i<this.vertex; i++) {
            this.adjacentList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int edge) {
        this.adjacentList[vertex].add(edge);
    }

    public void BFSTraversal(int source) {
        boolean[] visited = new boolean[this.vertex];

        LinkedList<Integer> queue = new LinkedList();
        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            source = queue.poll();
            System.out.println("poped: " + source);

            Iterator<Integer> iterator = this.adjacentList[source].listIterator();

            while (iterator.hasNext()) {
                int x = iterator.next();
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFSTraversal(1);
    }
}
