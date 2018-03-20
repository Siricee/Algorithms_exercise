package graph;

public class ListGraph {
	private ListGraphNode[] nodes;
	

	public ListGraphNode[] getNodes() {
		return nodes;
	}

	public void setNodes(ListGraphNode[] nodes) {
		this.nodes = nodes;
	}

	/**
	 * 初始化图的顶点
	 * 
	 * @param vertexes
	 */
	public ListGraph(int[] vertexes) {
		nodes = new ListGraphNode[vertexes.length];
		for (int i = 0; i < vertexes.length; i++) {
			nodes[i] = new ListGraphNode(vertexes[i], null);
		}
	}

	/**
	 * 添加start到可达的边
	 * 
	 * @param start
	 *            起始顶点
	 * @param end
	 *            可到达顶点的数组
	 */
	public void addEdges(int start, int[] end) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].value == start) {
				ListGraphNode node = nodes[i];
				for (int j = 0; j < end.length; j++) {
					node.next = new ListGraphNode(end[j], null);
					node = node.next;
				}
			}
		}
	}
	
	/**
	 * 打印邻接表数组
	 */
	public void printListGraph() {
		for(int i = 0;i<nodes.length;i++) {
			ListGraphNode node = nodes[i];
			while(node!=null) {
				System.out.print(node.value + " ");
				node = node.next;
			}
			System.out.println();
		}
	}

}

class ListGraphNode {
	int index;
	int value;
	ListGraphNode next;

	public ListGraphNode(int value, ListGraphNode next) {
		this.value = value;
		this.next = next;
	}

	public ListGraphNode(int index, int value, ListGraphNode next) {
		super();
		this.index = index;
		this.value = value;
		this.next = next;
	}
}
