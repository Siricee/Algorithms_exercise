package graph;

public class ListGraph_DPS_DFS_Test {

	public static void main(String[] args) {
		int[] vertexes = { 0, 1, 2, 3, 4, 5, 6, 7 };
		ListGraphWithDPS graphDps = new ListGraphWithDPS(vertexes);
		ListGraphWithDFS graphDfs = new ListGraphWithDFS(vertexes);

		graphDps.addEdges(0, new int[] { 1, 3, 4, 5 });
		graphDps.addEdges(2, new int[] { 3, 4, 5, 6 });
		graphDps.addEdges(4, new int[] { 6, 7 });
		graphDps.addEdges(1, new int[] { 3, 5, 6 });

		graphDfs.addEdges(0, new int[] { 1, 3, 4, 5 });
		graphDfs.addEdges(2, new int[] { 3, 4, 5, 6 });
		graphDfs.addEdges(4, new int[] { 6, 7 });
		graphDfs.addEdges(1, new int[] { 3, 5, 6 });

		// output results
		graphDps.printListGraph();
		graphDps.depthFirstTravel();

		System.out.println();
		System.out.println("*************");

		graphDfs.printListGraph();
		graphDfs.breadthFirstTravel();

	}

}
