package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ListGraphWithDFS extends ListGraph{

	public ListGraphWithDFS(int[] vertexes) {
		super(vertexes);
	}
	
	public void breadthFirstTravel() {
		System.out.println("邻接表的广度优先遍历");
		Queue<Integer> queue = new LinkedList<>();
		//初始化各个顶点的访问状态。
		ListGraphNode[] currentNodes = this.getNodes();
		
		int[] visited = new int [currentNodes.length];
		int unvisited = getUnVisited(visited);
		while(unvisited >= 0) {
			//起始顶点入队
			queue.add(unvisited);
			while(!queue.isEmpty()) {
				//出队顶点并访问
				int index = (Integer)queue.poll();
				System.out.println(currentNodes[index].value+",");
				
				//标记被访问
				visited[index] = -1;
				ListGraphNode node = currentNodes[index].next;
				while(node!= null) {
					if(visited[node.index] == 0) {
						queue.add(node.index);
					}
					node = node.next;
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
