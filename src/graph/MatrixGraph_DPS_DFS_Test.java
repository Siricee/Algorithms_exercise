package graph;

public class MatrixGraph_DPS_DFS_Test {

	public static void main(String[] args) {
		int[] vertexes = {0,1,2,3,4,5,6,7};
		MatrixGraphWithDPS graphDps = new MatrixGraphWithDPS(vertexes);
		MatrixGraphWithDFS graphDfs = new MatrixGraphWithDFS(vertexes);
		
		graphDps.addEdge(0, 1);
		graphDps.addEdge(0, 2);
		graphDps.addEdge(1, 3);
		graphDps.addEdge(1, 5);
		graphDps.addEdge(2, 6);
		graphDps.addEdge(2, 5);
		
		
		graphDfs.addEdge(0, 1);
		graphDfs.addEdge(0, 2);
		graphDfs.addEdge(1, 3);
		graphDfs.addEdge(1, 5);
		graphDfs.addEdge(2, 6);
		graphDfs.addEdge(2, 5);
		
		
		//output results
		graphDps.printMatrix();
		graphDps.depthFirstTravel();
		
		System.out.println();
		System.out.println("*************");
		
		graphDfs.printMatrix();
		graphDfs.breadthFirstTravel();
	}

}
