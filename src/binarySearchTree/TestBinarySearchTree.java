package binarySearchTree;

public class TestBinarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree bstree = new BinarySearchTree(null);
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
		System.out.println("*****遍历二叉查找树******");
		bstree.preOrder(bstree.getRoot());
		System.out.println("size = " + bstree.size());

		System.out.println("*****搜索节点******");
		System.out.println(bstree.search(9).getData());
		System.out.println(bstree.search(1).getData());
		System.out.println(bstree.search(24));

		System.out.println("*****删除节点******");
		bstree.deleteNode(42);
		System.out.println("size = " + bstree.size());

		System.out.println("*****遍历二叉查找树******");
		bstree.preOrder(bstree.getRoot());

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

// 二叉查找树
class BinarySearchTree {

	private BinaryTreeNode root;

	public BinarySearchTree(BinaryTreeNode root) {
		super();
		this.root = root;
	}

	public BinarySearchTree() {
		super();
	}

	/**
	 * 二叉查找树的查找
	 * 
	 * @param data
	 * @return
	 */
	public BinaryTreeNode search(int data) {
		return search(root, data);
	}

	/**
	 * 递归二叉查找树
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	private BinaryTreeNode search(BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		} else if (node.getData() == data) {
			return node;
		} else if (node.getData() < data) {
			return search(node.getRightChild(), data);
		} else {
			return search(node.getLeftChild(), data);
		}
	}

	/**
	 * 二叉查找树的插入操作 如果能找到某个值，直接忽略；如果没有这个值，就把它放到最终查找的位置即可。
	 */
	public void insertNode(int data) {
		if (root == null) {
			root = new BinaryTreeNode();
			root.setData(data);
		} else {
			searchAndInsert(null, root, data);
		}
	}

	/**
	 * 递归二叉查找树（如果没有找到就建一个新的节点）
	 * 
	 * @param parent
	 * @param node
	 * @param data
	 * @return
	 */
	private BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
		if (node == null) {
			node = new BinaryTreeNode();
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

	/************ 二叉查找树的删除操作 ****************/
	/**
	 * 二叉查找树查找父节点
	 * 
	 * @param data
	 * @return
	 */
	public BinaryTreeNode searchParent(int data) {
		return searchParent(null, root, data);
	}

	/**
	 * 递归二叉查找树
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	public BinaryTreeNode searchParent(BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		} else if (node.getData() == data) {
			return node;
		} else if (node.getData() < data) {
			return search(node.getRightChild(), data);
		} else {
			return search(node.getLeftChild(), data);
		}
	}

	/**
	 * 递归二叉查找树
	 * 
	 * @param parent
	 * @param node
	 * @param data
	 * @return
	 */
	private BinaryTreeNode searchParent(BinaryTreeNode parent, BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		} else if (node.getData() == data) {
			return node;
		} else if (node.getData() < data) {
			return search(node.getRightChild(), data);
		} else {
			return search(node.getLeftChild(), data);
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

	public BinaryTreeNode getRoot() {
		return root;
	}

	/**
	 * 二叉查找树的删除操作
	 */
	// public void deleteNode(int data) {
	//// // 对根节点直接赋值为空
	//// if (root.getData() == data) {
	//// root = null;
	//// return;
	//// }
	// // 整个过程都要知道父节点，因为java是引用传递，不能直接赋值。C语言可以用指针。
	// BinaryTreeNode parent = searchParent(data);
	//
	// if (parent == null) {
	// return;
	// }
	// BinaryTreeNode node = search(parent, data);
	//
	// if (node.getLeftChild() == null && node.getRightChild() == null) {
	// // 叶子节点此时没有子节点，直接删除
	// if (parent.getLeftChild() != null && parent.getRightChild().getData() ==
	// data) {
	// parent.setLeftChild(null);
	// } else {
	// parent.setRightChild(null);
	// }
	// } else if (node.getLeftChild() != null && node.getRightChild() == null) {
	// // 左子树不为空树
	// if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data)
	// {
	// parent.setLeftChild(node.getLeftChild());
	// } else {
	// parent.setRightChild(node.getLeftChild());
	// }
	// } else if (node.getLeftChild() == null && node.getRightChild() != null) {
	// // 右子树不为空树
	// if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data)
	// {
	// parent.setLeftChild(node.getRightChild());
	// } else {
	// parent.setRightChild(node.getRightChild());
	// }
	// } else {
	// // 左右子树都不为空树
	// // 1.查找右子树中最左的子节点
	// BinaryTreeNode deleteNode = node;// 要删除的节点
	// BinaryTreeNode temp = node.getRightChild();// 要删除节点的右子树根
	//
	// if (temp.getLeftChild() == null) {
	// // 如果右子树没有左孩子节点，直接上移
	// temp.setLeftChild(deleteNode.getLeftChild());
	// } else {
	// // 右子树左孩子不为空
	// while (temp.getLeftChild() != null) {
	// node = temp;
	// temp = temp.getLeftChild();
	// }
	// // 2.继承节点原右子树上移
	// node.setLeftChild(temp.getRightChild());
	//
	// // 3.继承节点就位
	// temp.setLeftChild(deleteNode.getLeftChild());
	// temp.setRightChild(deleteNode.getRightChild());
	// }
	// // 4.更新父节点为删除节点的原父节点
	// if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data)
	// {
	// parent.setLeftChild(temp);
	// } else {
	// parent.setRightChild(temp);
	// }
	// }
	// }

	public void deleteNode(int data) {

		// 整个过程都要知道父节点，因为java是引用传递，不能直接赋值。C语言可以用指针。
		BinaryTreeNode parent = searchParent(data);

		if (parent == null) {
			return;
		}
		BinaryTreeNode node = search(parent, data);

		if (node.getLeftChild() == null && node.getRightChild() == null) {
			// 叶子节点此时没有子节点，直接删除
			if (parent.getRightChild() != null && parent.getRightChild().getData() == data) {
				parent.setRightChild(null);
			} else {
				parent.setLeftChild(null);
			}
		} else if (node.getLeftChild() != null && node.getRightChild() == null) {
			// 左子树不为空树
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(node.getLeftChild());
				node.setLeftChild(null);
			} else {
				parent.setRightChild(node.getLeftChild());
				node.setLeftChild(null);
			}
		} else if (node.getLeftChild() == null && node.getRightChild() != null) {
			// 右子树不为空树
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(node.getRightChild());
				node.setRightChild(null);
			} else {
				parent.setRightChild(node.getRightChild());
				node.setRightChild(null);
			}
		} else {
			// 左右子树都不为空树
			// 1.查找右子树中最左的子节点
			BinaryTreeNode deleteNode = node;// 要删除的节点
			BinaryTreeNode del_leftchild = node.getLeftChild();// 要删除节点的左子树根

			BinaryTreeNode max = getMax(del_leftchild);//左子树的最右结点

			if (deleteNode.getData() > parent.getData()) {
				if (max.getLeftChild() == null) {
					max.setRightChild(deleteNode.getRightChild());
					max.setLeftChild(deleteNode.getLeftChild());
					searchParent(max, max.getData()).setRightChild(null);
					parent.setRightChild(max);
					deleteNode.setLeftChild(null);
					deleteNode.setRightChild(null);
				}else{
					//施工中
					max.setRightChild(deleteNode.getRightChild());
					max.setLeftChild(deleteNode.getLeftChild());
					searchParent(max, max.getData()).setRightChild(null);
					parent.setRightChild(max);
					deleteNode.setLeftChild(null);
					deleteNode.setRightChild(null);
				}
			}
		
		}
	}

	/**
	 * 获取最大值，即子树中最右节点
	 * 
	 * @param node
	 * @return node
	 */
	public BinaryTreeNode getMax(BinaryTreeNode node) {
		BinaryTreeNode max = null;
		while (node.getRightChild() != null) {
			max = node.getRightChild();
		}
		return max;
	}

	/************* 二叉树的遍历 *************/
	/**
	 * 访问节点
	 * 
	 * @param node
	 */
	public void visted(BinaryTreeNode node) {
		node.getData();
		System.out.println(node.getData());
	}

	/**
	 * 先序遍历
	 * 
	 * @param node
	 */

	public void preOrder(BinaryTreeNode node) {
		if (node != null) {
			visted(node);
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());

		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 */

	public void midOrder(BinaryTreeNode node) {
		if (node != null) {
			midOrder(node.getLeftChild());
			visted(node);
			midOrder(node.getRightChild());
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param node
	 */

	public void postOrder(BinaryTreeNode node) {
		if (node != null) {
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			visted(node);
		}
	}

}