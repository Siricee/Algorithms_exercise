package graph;

public class ListGraphTest {

	public static void main(String[] args) {
		int[] vertexes = {3,5,7,8,9};
		ListGraph graph = new ListGraph(vertexes);
		
		graph.addEdges(3, new int[]{7,8,9});
		graph.addEdges(5, new int[]{5,7});
		graph.addEdges(8, new int[] {9});
		
		graph.printListGraph();

	}

}
