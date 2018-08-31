package graph;

public class ListGraph_DPS_DFS_Test {

	public static void main(String[] args) {
		int[] vertexes = { 0, 1, 2, 3, 4, 5, 6, 7 };
		ListGraphWithBFS graphBfs = new ListGraphWithBFS(vertexes);
		ListGraphWithDFS graphDfs = new ListGraphWithDFS(vertexes);

		graphBfs.addEdges(0, new int[] { 1, 3, 4, 5 });
		graphBfs.addEdges(2, new int[] { 3, 4, 5, 6 });
		graphBfs.addEdges(4, new int[] { 6, 7 });
		graphBfs.addEdges(1, new int[] { 3, 5, 6 });

		graphDfs.addEdges(0, new int[] { 1, 3, 4, 5 });
		graphDfs.addEdges(2, new int[] { 3, 4, 5, 6 });
		graphDfs.addEdges(4, new int[] { 6, 7 });
		graphDfs.addEdges(1, new int[] { 3, 5, 6 });

		// output results
		graphBfs.printListGraph();
		graphBfs.breadthFirstTravel();

		System.out.println();
		System.out.println("*************");

		graphDfs.printListGraph();
		graphDfs.depthFirstTravel();

	}

}
