package graph;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixGraphWithBFS extends MatrixGraph {

	public MatrixGraphWithBFS(int[] vertexes) {
		super(vertexes);
	}
	
	//dfs
	public void breadthFirstTravel() {
		System.out.println("邻接矩阵的广度优先遍历");
		Queue<Integer> queue = new LinkedList<>();
		
		int[] currentMapping = this.getMapping();
		int num = currentMapping.length;
		//获取当前对象的mapping长度
		
		int[] visited = new int [num]; 
		int unvisited = getUnVisited(visited);
		while(unvisited >=0) {
			//起始顶点入队
			queue.add(unvisited);
			while(!queue.isEmpty()) {
				//出队顶点并访问
				int index = (Integer)queue.poll();
				if(visited[index] == 1) {
					continue;
				}
				System.out.println(currentMapping[index]+",");
				//标记被访问
				visited[index] = 1;
				//遍历所有未被访问的邻接顶点，放入队列中。
				for (int i = 0; i < currentMapping.length; i++) {
					//不能是自己、未被访问、可到达
					if(index != i && visited[i] == 0 && getMatrix()[index][i]>0) {
						queue.add(i);
					}
					
				}
			}
			unvisited = getUnVisited(visited);
		}
		
		System.out.println();
	}
	
	/**
	 * 从访问标记数组中获取第一个发现的未被访问的顶点下标。
	 * @param visited
	 * @return 都被访问了就返回-1
	 */
	private int getUnVisited(int[] visited) {
		int index = -1 ;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i] == 0) {
				index = i;
				break;
			}
		}
		return index;
		
	}
	

}
