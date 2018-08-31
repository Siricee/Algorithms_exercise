package graph;

/**
 * 这个图没用继承，因为这个图不是简单的邻接矩阵图，是无向带权图，矩阵中存储距离。
 * @author Sirice
 */
public class MatrixGraph_Dijkstra {
	
	private int[] mapping;
	private int[][] matrix;

	/**
	 * 初始化图的顶点
	 * 
	 * @param vertexes
	 */
	public MatrixGraph_Dijkstra(int[] vertexes) {
		int length = vertexes.length;
		mapping = new int[length];
		matrix = new int[length][length];
		for (int i = 0; i < length; i++) {
			mapping[i] = vertexes[i];
		}
	}

	/**
	 * 添加具有权值的边
	 * 
	 * @param start
	 * @param end
	 * @param value
	 */
	public void addEdge(int start, int end, int value) {
		int x = -1;
		int y = -1;
		// 寻找坐标
		for (int i = 0; i < mapping.length; i++) {
			if (x != -1 && y != -1) {
				break;
			}
			if (start == mapping[i]) {
				x = i;
			}
			if (end == mapping[i]) {
				y = i;
			}
		}
		// 判断顶点是否存在
		if (x == -1 || y == -1 || x > mapping.length - 1 || y > mapping.length - 1) {
			throw new IndexOutOfBoundsException("数组越界");
		}

		matrix[x][y] = value;
	}

	/**
	 * 实现最短路径算法
	 * 
	 * @param start
	 */
	public void dijkstra(int start) {
		int length = mapping.length;
		int x = -1;
		for (int i = 0; i < length; i++) {
			if (mapping[i] == start) {
				x = i;
				break;
			}
		}
		if (x == 1) {
			throw new RuntimeException("未找到起始顶点");
		}

		int[] S = new int[length];// 自动初始化为0，都属于未得到最短路径的顶点。
		int[][] distance = matrix;// 存储v到u的最短距离
		int[] path = new int[length];// 存储x到u时最短路径时u前一个顶点。

		// 初始化path数组

		for (int i = 0; i < length; i++) {
			// 如果可达就赋值
			if (matrix[x][i] > 0) {
				path[i] = x;
			} else {
				// 不可达，赋值前一个下标为-1
				path[i] = -1;
			}
		}

		S[x] = 1;// 起始顶点赋值给S
		for (int i = 0; i < length; i++) {
			// 首先寻找start顶点到各顶点的最短路径
			int min = Integer.MAX_VALUE;
			int v = 0;
			for (int j = 0; j < length; j++) {
				// S[j] == 1的话说明已经找到最短距离
				// 过滤掉不可达的情况
				if (S[j] != 1 && x != j && distance[x][j] != 0 && distance[x][j] < min) {
					min = distance[x][j];
					v = j;
				}

			}
			// v是目前x到各顶点最短的
			S[v] = 1;
			// 修正最短距离distance及最短距离path
			for (int j = 0; j < length; j++) {
				// 1.只修正未找到最短路径的
				// 2.修正后新的顶点需要可达
				// 3.如果使用新的最短路径比原有路径短，或者以前不可达，使用新的最短路径可达了
				// 符合上面三点即可修正路径。
				if (S[j] != 1 && distance[v][j] != 0
						&& (min + distance[v][j] < distance[x][j] || distance[x][i] == 0)) {
					// 说明加入了中间顶点之后找到了更短的路径
					distance[x][j] = min + distance[v][j];
					path[j] = v;
				}
			}
		}
		// 打印最短路径值
		for (int i = 0; i < length; i++) {
			if (distance[x][i] != 0) {
				System.out.println(mapping[x] + "--->" + mapping[i] + "--->" + ":" + distance[x][i]);

				System.out.println("逆序最短路径输出:");
				int index = i;
				while (index != -1) {
					System.out.println(mapping[index]);
					index = path[index];
				}
				System.out.println();
			}

		}

	}

}
