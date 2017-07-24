package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by ruchitmehta
 */
public class DFS {
    public int V; // number of vertices
    public LinkedList<Integer> adjacency[];

    //constructor
    public DFS(int v){
        V = v;
        adjacency = new LinkedList[V];
        for(int i = 0; i < V; i++){
            adjacency[i] = new LinkedList<>();
        }
    }

    // Function to add edge to the graph
    public void addEdge(int v, int w){
        adjacency[v].add(w);
    }

    // Recursive helper function for DFS
    public void DFSUtil(int v, boolean[] visited){

        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        Iterator<Integer> it = adjacency[v].iterator();
        while(it.hasNext()){
            int n = it.next();
            if(visited[n] != true){
                DFSUtil(n, visited);
            }
        }
    }

    public void DFS(){
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                DFSUtil(i, visited);
            }
        }
    }

    public static void main(String args[]){
        DFS graph = new DFS(5);

        graph.addEdge(0,1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 4);

        System.out.println("Following is Depth First Traversal");
        graph.DFS();
    }

}
