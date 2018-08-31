package graph;

import java.util.Stack;

public class ListGraphWithDFS extends ListGraph {

	public ListGraphWithDFS(int[] vertexes) {
		super(vertexes);
	}

	/**
	 * 邻接表深度优先遍历
	 */
	public void depthFirstTravel() {
		System.out.println("邻接表深度优先遍历");
		// init stack
		Stack<Integer> stack = new Stack<>();
		ListGraphNode[] currentNodes = this.getNodes();
		int num =  currentNodes.length;
		// 初始化各个顶点的访问状态
		int[] visited = new int[num];
		int unvisited = getUnVisited(visited);
		while (unvisited >= 0) {
			visited[unvisited] = 1;
			stack.push(unvisited);
			System.out.print(currentNodes[unvisited].value + ",");
			while (!stack.isEmpty()) {
				// 获取栈顶元素，不出栈
				int index = stack.peek();
				// 找到未被访问的邻接顶点
				boolean found = false;
				ListGraphNode node = currentNodes[index];
				while (node != null) {
					ListGraphNode next = node.next;
					if (node.next != null && visited[next.index] == 0) {
						// 如果找到，则访问并入栈
						visited[next.index] = 1;
						stack.push(next.index);
						System.out.println(next.value + ",");
						found = true;
						break;
					}
					node = node.next;
				}
				if (!found) {
					stack.pop();
				}

			}
			unvisited = getUnVisited(visited);
		}
		System.out.println();

	}

	public int getUnVisited(int[] visited) {
		int index = -1;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				index = i;
				break;
			}
		}
		return index;
	}

}
