package graph;

public class MatrixGraph {

	private int[] mapping;// 下标映射元素值
	private int[][] matrix;// 图的二维数组
	

	public int[] getMapping() {
		return mapping;
	}


	public void setMapping(int[] mapping) {
		this.mapping = mapping;
	}


	public int[][] getMatrix() {
		return matrix;
	}


	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}


	/**
	 * 初始化图顶点
	 * 
	 * @param vertexes
	 *            顶点数组
	 */
	public MatrixGraph(int[] vertexes) {
		int length = vertexes.length;

		mapping = new int[length];
		matrix = new int[length][length];

		for (int i = 0; i < length; i++) {
			mapping[i] = vertexes[i];
		}
	}

	/**
	 * 添加边
	 * 
	 * @param start
	 * @param end
	 */
	public void addEdge(int start, int end) {
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
			throw new IndexOutOfBoundsException("边的顶点不存在");
		}
		
		//增加边
		matrix[x][y] = 1;
	}
	
	/**
	 * 输出矩阵
	 */
	public void printMatrix() {
		for(int i=0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
