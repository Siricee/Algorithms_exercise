package graph;

public class MatrixGraph_Dijkstra_test {

	public static void main(String[] args) {
		int[] vertexes = { 1, 2, 3, 4, 5, 6 };

		MatrixGraph_Dijkstra matrix = new MatrixGraph_Dijkstra(vertexes);

		matrix.addEdge(1, 2, 16);
		matrix.addEdge(2, 1, 16);
		
		matrix.addEdge(1, 3, 1);
		matrix.addEdge(3, 1, 1);
		
		matrix.addEdge(1, 5, 12);
		matrix.addEdge(5, 1, 12);
		
		matrix.addEdge(1, 6, 15);
		matrix.addEdge(6, 1, 15);
		
		matrix.addEdge(2, 4, 2);
		matrix.addEdge(4, 2, 2);
		
		matrix.addEdge(2, 6, 8);
		matrix.addEdge(6, 2, 8);
		
		matrix.addEdge(3,5,5);
		matrix.addEdge(5,3,5);
		
		matrix.addEdge(4,6,3);
		matrix.addEdge(6,4,3);
		
		matrix.addEdge(5,6,8);
		matrix.addEdge(6,5,8);
		
		matrix.addEdge(4,5,9);
		matrix.addEdge(5,4,9);
		
		matrix.dijkstra(1);

	}

}
