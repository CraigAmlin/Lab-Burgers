//Written by Sammy Jacobson, CS370
//Adapted from CodeAhoy.com, "Graph Representation using Adjacency Lists"
//Establishes connections between nodes, stored within Linked lists
import java.util.LinkedList;

//Class to establish a node, with a name and its adjacencies
class Node{
    String name;
    LinkedList<Node> adjacent;

    public Node(String name){
        this.name = name;
        this.adjacent = new LinkedList<>();
    }
}
public class AdjacencyListexamp {
    public static void main(String[] args) {
        //Creates 4 nodes
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");

        //Establishes connections between nodes, adds "edges"
        A.adjacent.add(B);
        B.adjacent.add(C);
        B.adjacent.add(D);
        C.adjacent.add(D);

        //All nodes stored within an array
        Node[] nodes = {A, B, C, D};

        //Prints the adjacency list
        printAdjacencyList(nodes);

    }
    public static void printAdjacencyList(Node[] nodes){
        for(Node node : nodes){
            System.out.print(node.name + ": ");
            for(Node adjacency : node.adjacent){
                System.out.print(adjacency.name + " ");
            }
            System.out.println();
        }
    }
}
