package Graphs;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.LinkedList;

/**
 * Created by ruchitmehta
 */
public class GraphNode {
    private int id;
    LinkedList<GraphNode> adjacent = new LinkedList<>();
    public GraphNode(int id){
        this.id = id;
    }

//    public GraphNode getNode(int id){
//
//    }

//    public void addEdge(int source, int destination){
//        GraphNode u = getNode(source);
//        GraphNode v = getNode(destination);
//        u.adjacent.add(v);
//    }


}
