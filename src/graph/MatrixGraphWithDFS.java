package graph;

import java.util.Stack;

public class MatrixGraphWithDFS extends MatrixGraph {

	public MatrixGraphWithDFS(int[] vertexes) {
		super(vertexes);
	}

	// 邻接矩阵的深度优先遍历
	public void depthFirstTravel() {
		System.out.println("邻接矩阵的深度优先遍历");

		// init stack初始化栈

		int[] currentMapping = this.getMapping();
		int num = currentMapping.length;

		Stack<Integer> stack = new Stack<>();

		// 初始化各顶点的访问状态
		int[] visited = new int[num];
		// 从未访问过的顶点中任选一个顶点作为起始顶点
		int unvisited = getUnVisited(visited); //unvisited变量是未访问的mapping中元素下标。
		while (unvisited >= 0) {
			// 访问起始顶点，并入栈
			visited[unvisited] = 1;
			stack.push(unvisited);
			System.out.print(currentMapping[unvisited] + ",");
			while (!stack.isEmpty()) {
				// 获取栈顶元素，不出栈
				int index = stack.peek();
				// 遍历找到未访问的mapping数组元素下标
				boolean found = false;
				for (int i = 0; i < currentMapping.length; i++) {
					// 不能是自己 且  未被访问、可到达
					if (index != i && visited[i] == 0 && getMatrix()[index][i] > 0) {
						// 如果找到则访问并入栈
						visited[i] = i;
						stack.push(new Integer(i));
						System.out.println(currentMapping[i] + ",");
						found = true;
						break;
					}
				}
				// 如果未找到，出栈元素
				if (!found) {
					stack.pop();
				}
			}

			unvisited = getUnVisited(visited);//一次深搜之后开始下一次从未被访问的节点开始
		}
	}

	/**
	 * 从访问标记数组中获取第一个发现的未被访问的顶点下标
	 * 
	 * @param visited
	 * @return 如果都被访问了返回-1
	 */
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
