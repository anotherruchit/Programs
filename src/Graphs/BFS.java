package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ruchitmehta on 8/1/17.
 */
public class BFS {
    public int V;
    public LinkedList<Integer> adjacency[];

    public BFS(int v){
        this.V = v;
        adjacency = new LinkedList[v];
        for(int i = 0; i < V; i++){
            adjacency[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]){
        BFS graph = new BFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.printf("BFS traversal starting from vertex 2 : ");
        graph.BFStraversal(2);
    }

    public void addEdge(int v, int w){
        adjacency[v].add(w);
    }

    public void BFStraversal(int v){
        boolean[] visited = new boolean[V];

        Queue<Integer> queue =  new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()){

            int vertex = queue.poll();
            visited[vertex] = true;
            System.out.print(vertex + " ");
            Iterator<Integer> it = adjacency[vertex].iterator();

            while(it.hasNext()){
                int n = it.next();
                if(visited[n] == false){
                    queue.offer(n);
                }
            }
        }
    }
}
