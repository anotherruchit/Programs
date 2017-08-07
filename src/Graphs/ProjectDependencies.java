package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by ruchitmehta on 8/3/17.
 *  Grammarly phone screen
 *  http://www.geeksforgeeks.org/topological-sorting/
 *  The above algorithm is simply DFS with an extra stack. So time complexity is same as DFS which is O(V+E).
 *
 */
public class ProjectDependencies {

    LinkedList<Integer> adjacency[];
    private int V;

    public ProjectDependencies(int v) {
        this.V = v;
        adjacency = new LinkedList[v];
        for(int i = 0; i < V; i++){
            adjacency[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]){
        ProjectDependencies graph = new ProjectDependencies(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.findProjectOrder();
    }

    public void findProjectOrder(){
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            visited[i] = false;
        }

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                findProjectOrderUtil(i, visited, stack);
            }
        }

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    private void findProjectOrderUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> iterator = adjacency[v].iterator();
        while(iterator.hasNext()){
            int w = iterator.next();
            if(visited[w] == false){
                findProjectOrderUtil(w, visited, stack);
            }
        }

        // Push current vertex to stack which stores result
        stack.push(v);
    }


    public void addEdge(int v, int w){
        adjacency[v].add(w);
    }

}
