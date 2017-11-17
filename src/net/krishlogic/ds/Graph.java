package net.krishlogic.ds;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    private int vertices;
    private LinkedList<Integer> myList[];

    public Graph(int vertices) {
        this.vertices = vertices;
        myList = new LinkedList[this.vertices];
        for (int i=0; i<this.vertices; i++) {
            myList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int dest) {
        myList[v].add(dest);
    }

    public void BFS(int s) {

        Queue queue = new LinkedList();
        queue.add(s);

        boolean visited[] = new boolean[vertices];
        visited[s] = true;

        while(!queue.isEmpty()) {

            int val= (int) queue.poll();
            LinkedList myL = myList[val];
            System.out.print(val + " ");

            Iterator list = myL.listIterator();
            while(list.hasNext()) {
                int temp = (int) list.next();
                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.add(temp);
                }
            }
        }
    }

    public void DFS(int s) {
        printDFSPath(s, new boolean[this.vertices]);
    }

    private void printDFSPath(int s, boolean[] visited) {
        Iterator iterator = myList[s].listIterator();
        visited[s] = true;
        System.out.print(s + " ");
        while(iterator.hasNext()) {
            int a = (int) iterator.next();
            if (!visited[a]) {
                visited[a] = true;

                printDFSPath(a, visited);
            }
        }
    }

    public void DFSUnOrdered() {
        boolean[] visited = new boolean[this.vertices];

        for(int i=0; i<this.vertices; i++) {
            if (!visited[i]) {
                printDFSPath(i, visited);
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

        g.BFS(2); // ans: 2031
        System.out.println("");
        g.DFS(2); // ans: 2013
        System.out.println("");
        g.DFSUnOrdered(); //0123
    }

}