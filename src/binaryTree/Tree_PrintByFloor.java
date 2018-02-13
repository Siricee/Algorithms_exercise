package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_PrintByFloor {

	public static void main(String[] args) {
		//构造二叉查找树
		Tree bstree = new Tree(null);
		bstree.insertNode(42);
		bstree.insertNode(14);
		bstree.insertNode(65);
		bstree.insertNode(9);
		bstree.insertNode(23);
		bstree.insertNode(55);
		bstree.insertNode(72);
		bstree.insertNode(1);
		bstree.insertNode(68);
		bstree.insertNode(88);
		bstree.insertNode(70);
		
		
		//执行按层打印方法：
		bstree.printByFloor(bstree);

	}

}

class Node {
	private int data;
	private Node leftChild;
	private Node rightChild;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node() {
		super();
	}

}

class Tree {
	private Node root;

	public Node getRoot() {
		return root;
	}

	public Tree() {
		super();
	}

	public Tree(Node root) {
		super();
		this.root = root;
	}
	public void insertNode(int data) {
		if (root == null) {
			root = new Node();
			root.setData(data);
		} else {
			searchAndInsert(null, root, data);
		}
	}

	private Node searchAndInsert(Node parent, Node node, int data) {
		if (node == null) {
			node = new Node();
			node.setData(data);
			if (data > parent.getData()) {
				parent.setRightChild(node);
			} else {
				parent.setLeftChild(node);
			}
			return node;
		} else if (node.getData() == data) {
			return node;
		} else if (node.getData() < data) {
			return searchAndInsert(node, node.getRightChild(), data);
		} else {
			return searchAndInsert(node, node.getLeftChild(), data);
		}
	}

	// 遍历方法
	public void midOrder(Node node) {
		if (node != null) {
			midOrder(node.getLeftChild());
			visted(node);
			midOrder(node.getRightChild());
		}
	}

	public void visted(Node node) {
		node.getData();
		System.out.println(node.getData());
	}

	
	/**
	 * @author Sirice
	 * 说明：本方法为按层打印二叉树。
	 * 该算法属于广度优先遍历的一种，实现需要3个变量
	 * cur lastFloor_maxValue floor_maxValue和一个队列Queue
	 * floor_maxValue为下一行最右子节点（子树根）
	 * lastFloor_maxValue为当前行已记录的最右子节点
	 * 换行条件为当cur等于当前行最大子节点时说明当前位于该行结尾，打印换行并将当前行最大值指向下一行最大值
	 * 两个变量相当于两个Iterator。
	 * 
	 * 个人认为左程云的last和nlast变量名根本表达不明白这个换行条件。
	 */
	public void printByFloor(Tree tree) {

		Queue<Node> queue = new LinkedList<>();
		Node cur = null;
		Node lastFloor_maxValue = null;
		Node floor_maxValue = null;

		cur = tree.getRoot();
		lastFloor_maxValue = cur;
		queue.offer(cur);

		while (queue.size() != 0) {

			cur = queue.poll();
			System.out.print(cur.getData() + "   ");
			if (cur.getLeftChild() != null) {
				queue.offer(cur.getLeftChild());
				floor_maxValue = cur.getLeftChild();
			}
			if (cur.getRightChild() != null) {
				queue.offer(cur.getRightChild());
				floor_maxValue = cur.getRightChild();
			}
			//注意此处换行条件
			if (cur == lastFloor_maxValue) {
				System.out.println();
				lastFloor_maxValue = floor_maxValue;
			}
		}
	}

}