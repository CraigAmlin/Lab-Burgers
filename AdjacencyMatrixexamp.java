//Written by Sammy Jacobson, CS370
//Adapted from CodeAhoy.com, "Example of Graph Adjacency Matrix in Java"
//Establishes connection between vertices, displayed as boolean value, in a matrix
public class AdjacencyMatrixexamp {
    static int[][] mat;
    static int numofVertices;

    public static void main(String[] args) {
        numofVertices = 6;//hard-coded number of vertices

        mat = new int[numofVertices][numofVertices];
        //hard-coded boolean value for connected vertices
        mat[0][1] = 1;
        mat[1][2] = 1;
        mat[2][3] = 1;
        mat[3][1] = 1;

        //Prints overall statemet
        System.out.println("Here is the current adjacency matrix.");
        //Prints Column labels
        System.out.print("  ");
        for(int i = 0; i < numofVertices; i++){
            System.out.print((char)('A' + i) + " ");
        }
        System.out.println();
        //Prints row labels, and then matrix
        for(int i = 0; i < numofVertices; i++){
            System.out.print((char)('A' + i) + " ");
            for(int j = 0; j < numofVertices; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
