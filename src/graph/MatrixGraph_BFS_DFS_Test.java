package graph;

public class MatrixGraph_BFS_DFS_Test {

	public static void main(String[] args) {
		int[] vertexes = {0,1,2,3,4,5,6,7};
		MatrixGraphWithDFS graphDfs = new MatrixGraphWithDFS(vertexes);
		MatrixGraphWithBFS graphBfs = new MatrixGraphWithBFS(vertexes);
		
		graphBfs.addEdge(0, 1);
		graphBfs.addEdge(0, 2);
		graphBfs.addEdge(1, 3);
		graphBfs.addEdge(1, 5);
		graphBfs.addEdge(2, 6);
		graphBfs.addEdge(2, 5);
		
		
		graphDfs.addEdge(0, 1);
		graphDfs.addEdge(0, 2);
		graphDfs.addEdge(1, 3);
		graphDfs.addEdge(1, 5);
		graphDfs.addEdge(2, 6);
		graphDfs.addEdge(2, 5);
		
		
		//output results
		graphBfs.printMatrix();
		graphBfs.breadthFirstTravel();
		
		System.out.println();
		System.out.println("*************");
		
		graphDfs.printMatrix();
		graphDfs.depthFirstTravel();
	}

}
