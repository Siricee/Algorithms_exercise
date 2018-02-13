package binaryTree;

/**
 * 
 * @author Sirice
 * 树的结构多次用到递归调用这一概念，如树的递归遍历、树的高度（分层递归，返回值+1）、树的节点数（左右两路递归）
 */


public class TestBinaryTree {
	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = new BinaryTreeNode(0);
		BinaryTree bintree = new BinaryTree(rootNode);
		BinaryTreeNode rootNodeLeft = new BinaryTreeNode(1);
		BinaryTreeNode rootNodeRight = new BinaryTreeNode(2);
		BinaryTreeNode rootNodeLeft$Left = new BinaryTreeNode(3);
		BinaryTreeNode rootNodeLeft$Right = new BinaryTreeNode(4);
		BinaryTreeNode rootNodeRight$Left = new BinaryTreeNode(5);
		BinaryTreeNode rootNodeRight$Right = new BinaryTreeNode(6);
		
		
		
		rootNode.setLeftChild(rootNodeLeft);
		rootNode.setRightChild(rootNodeRight);
		rootNodeLeft.setLeftChild(rootNodeLeft$Left);
		rootNodeLeft.setRightChild(rootNodeLeft$Right);
		rootNodeRight.setLeftChild(rootNodeRight$Left);
		rootNodeRight.setRightChild(rootNodeRight$Right);
		
		
		//rootNode = null;
		System.out.println(rootNode);
		System.out.println(rootNode.hasLeftChild(rootNode));
		System.out.println(rootNode.hasRightChild(rootNode));
		
		System.out.println("********访问方法测试********");
		bintree.visted(rootNode);//访问方法测试
		
		System.out.println("*********遍历树***********");
		System.out.println("先序遍历");
		bintree.preOrder(rootNode);
		System.out.println("中序遍历");
		bintree.midOrder(rootNode);
		System.out.println("后序遍历");
		bintree.postOrder(rootNode);
		
		System.out.println("子树遍历测试");
		bintree.midOrder(rootNodeLeft);


	
		System.out.println("遍历结束");
		System.out.println("树的规模= "+bintree.size());
		System.out.println("树的高度= "+bintree.height());
		
		System.out.println("*********测试获取根节点*********");
		System.out.println(bintree.getRoot().getData());	//succeed
		
		System.out.println("*******测试获取父节点*******");
		System.out.println(bintree.getParent(rootNodeRight$Right).getData()); //succeed
		
		System.out.println("********空值测试***********");
		System.out.println(rootNodeLeft$Right.getLeftChild());   //null
		
		System.out.println("***********清空子树测试***********");   //failed
		bintree.clear(rootNodeLeft);
		//bintree.clear(rootNode);
		bintree.preOrder(rootNode);
		System.out.println("*********清空树测试**********");   //failed
		bintree.clear();
		bintree.preOrder(rootNode);
		
	}
	
	
	
}

// 节点声明
class BinaryTreeNode {
	private int data;// 数据
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;

	public BinaryTreeNode(int data) {
		super();
		this.data = data;
	}

	public BinaryTreeNode() {
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public boolean hasLeftChild(BinaryTreeNode parent) {
		if (parent.getLeftChild() == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean hasRightChild(BinaryTreeNode parent) {
		if (parent.getRightChild() == null) {
			return false;
		} else {
			return true;
		}
	}
}

// 二叉树的构建
class BinaryTree {
	private BinaryTreeNode root;

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTree(BinaryTreeNode root) {
		super();
		this.root = root;
	}

	public BinaryTree() {
		super();
	}

	/*************** 清除节点相关方法 ***************/
	/**
	 * 清除某个子树所有节点
	 * 
	 * @param node
	 */
	public void clear(BinaryTreeNode node) {
		if (node != null) {
			clear(node.getLeftChild());
			clear(node.getRightChild());
			//node = null;
			node.setLeftChild(null);
			node.setRightChild(null);
		}
		System.out.println("结点清除。");
	}

	/**
	 * 清空树
	 */
	public void clear() {
		root.setLeftChild(null);
		root.setRightChild(null);
	}

	/**
	 * 判断二叉树是否为空
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/********** 获取二叉树高度相关方法 ***********/
	/**
	 * 获取二叉树的高度
	 * 
	 * @return
	 */
	public int height() {
		return height(root);
	}

	/**
	 * 获取某节点为子树的高度
	 * 
	 * @param node
	 * @return
	 */
	public int height(BinaryTreeNode node) {
		if (node == null) {
			return 0;// 递归结束 空子树高度为0
		} else {
			// 递归获取左子树高度
			int l = height(node.getLeftChild());
			// 递归获取左子树高度
			int r = height(node.getRightChild());
			// 高度算两边更高的一边，取最大值，（+1是加上自己这一层）
			return l < r ? r + 1 : l + 1;
		}
	}

	/*************** 获取节点数相关方法 *******************/
	/**
	 * 获取二叉树节点数
	 * 
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 * 获取某节点为子树的节点数
	 * 
	 * @param node
	 * @return
	 */
	public int size(BinaryTreeNode node) {
		if (node == null) {
			return 0;// 节点为空则节点数为0
		} else {
			// 需要计算本节点，+1
			// 递归获取左子树的节点数和右子树的节点数，最终相加
			return 1 + size(node.getLeftChild()) + size(node.getRightChild());
		}
	}

	/*********** 返回父节点的相关方法 **********/
	/**
	 * 查找node节点在二叉树中的父节点
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode node) {
		return (root == null || root == node) ? null : getParent(root, node);
	}

	/**
	 * 递归查找node节点在subTree子树中父节点
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
		if (subTree == null) {
			// 如果子树为空，没有父节点
			return null;
		}
		if (subTree.getLeftChild() == node || subTree.getRightChild() == node) {
			// 如果子树树根的左右孩子节点是待查节点，那么这个子树的树根就是待查节点的父节点。
			return subTree;
		}
		BinaryTreeNode parent = null;
		// 递归在左子树找，左子树没有就去右子树找。
		if ((parent = getParent(subTree.getLeftChild(), node)) != null) {
			return parent;
		} else {
			return getParent(subTree.getRightChild(), node);
		}
	}

	/******** 返回左右子树 **********/

	/**
	 * 获取某个节点的左子树
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getLeftTree(BinaryTreeNode node) {
		return node.getLeftChild();
	}

	/**
	 * 获取某个节点的右子树
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getRightTree(BinaryTreeNode node) {
		return node.getRightChild();
	}

	/**
	 * 给某节点插入左、右节点
	 * 
	 * @param parent
	 * @return
	 * @throws Exception
	 */
	public void insertLeft(BinaryTreeNode parent, BinaryTreeNode newNode) throws Exception {
		if (parent.hasLeftChild(parent) == false) {
			parent.setLeftChild(newNode);
		} else {
			throw new Exception("this parent already has a LeftChildNode!");
		}
	}

	public void insertRight(BinaryTreeNode parent, BinaryTreeNode newNode) throws Exception {
		if (parent.hasRightChild(parent) == false) {
			parent.setRightChild(newNode);
		} else {
			throw new Exception("this parent already has a RightChildNode!");
		}
	}
	
	/*************二叉树的遍历*************/
	/**
	 * 访问节点
	 * @param node
	 */
	public void visted(BinaryTreeNode node){
		node.getData();
		System.out.println(node.getData());
	}
	/**
	 * 先序遍历
	 * @param node
	 */
	
	public void preOrder(BinaryTreeNode node){
		if(node!=null){
			visted(node);
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	/**
	 * 中序遍历
	 * @param node
	 */
	
	public void midOrder(BinaryTreeNode node){
		if(node!=null){
			midOrder(node.getLeftChild());
			visted(node);
			midOrder(node.getRightChild());
		}
	}
	/**
	 * 后序遍历
	 * @param node
	 */
	
	public void postOrder(BinaryTreeNode node){
		if(node!=null){
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			visted(node);
		}
	}

}
