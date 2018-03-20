package graph;

public class MatrixGraphTest {

	public static void main(String[] args) {
		int[] vertexes = {2,3,4,6,7,8};
		//init graph
		MatrixGraph graph =  new MatrixGraph(vertexes);
		graph.addEdge(2,4);
		graph.addEdge(3,6);
		graph.addEdge(7,8);
		graph.addEdge(6,3);
		graph.addEdge(2,6);
		graph.addEdge(3,8);
		//graph.addEdge(3,5);
		
		graph.printMatrix();

	}

}
