package linkedLIst;

public class TestLinkedList {

	public static void main(String[] args) {

		System.out.println("*****init list*****");
		LinkedList list = new LinkedList();
		list.addFirst(new String("1 node"));
		list.addFirst(new String("2 node"));
		list.addFirst(new String("3 node"));
		list.addFirst(new String("4 node"));

		list.printAll();
		System.out.println("******insert node*******");

		list.add(new String("insert node"), 2);
		list.printAll();
		
		System.out.println("*****reverse list**********");
		list.reverse();
		list.printAll();
		
		
		System.out.println("*******delete node******");
		list.removeFirst();
		list.removeLast();

		list.printAll();

	}

}

class Node {
	private Object data;
	private Node next;

	public Object getData() {
		return data;
	}

	public void setData(Object data2) {
		this.data = data2;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

class LinkedList {
	/**
	 * @param size
	 *            链表长度
	 * @param Node
	 *            头结点、尾节点
	 */
	private int size = 0;
	private Node first;
	private Node last;

	/**
	 * 链表初始化
	 */
	public LinkedList() {

	}

	/******** public method *********/

	/**
	 * 在链表中插入1个元素时头尾元素都是一个元素
	 * 
	 * @param data
	 */
	private void fillStart(Object data) {
		first = new Node();
		first.setData(data);
		last = first;
		// 只有一个结点时first和last都指向同一个结点。
	}

	/**
	 * 获取指定下标元素
	 * 
	 * @param index
	 * @return
	 */
	public Node get(int index) {
		Node temp = first;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * 在元素只有一个时清除first和last元素
	 */
	private void clear() {
		first = null;
		last = null;
		size = 0;
	}

	/******** ! End public method *********/

	/**
	 * 链表头部插入
	 * 
	 * @param data
	 */
	public void addFirst(Object data) {
		if (size == 0) {
			fillStart(data);
		} else {
			Node node = new Node();
			node.setData(data);
			node.setNext(first);// 把元素的下一个位置指针指向头元素。
			first = node;// 将刚插入的元素设置为链表头元素。
		}
		size += 1;
	}

	/**
	 * 链表后部插入
	 * 
	 * @param data
	 */
	public void addLast(Object data) {
		if (size == 0) {
			// 为空初始化前后元素
			fillStart(data);
		} else {
			Node node = new Node();
			node.setData(data);
			last.setNext(node);
			last = node;// 把最后插入的元素设置为链表尾的元素
		}
		size += 1;
	}

	/**
	 * 在链表指定位置后面插入
	 * 
	 * @param data
	 *            需要插入的数据
	 * @param index
	 *            下标从0开始
	 */
	public void add(Object data, int index) {
		if (size > index) {
			if (size == 0) {
				fillStart(data);
				size += 1;
			} else if (index == 0) {
				addFirst(data);
			} else if (size == index + 1) {
				addLast(data);
			} else {
				Node temp = get(index);
				Node node = new Node();
				node.setData(data);
				node.setNext(temp.getNext());
				temp.setNext(node);
				size += 1;
			}
		} else {
			throw new IndexOutOfBoundsException("超出链表长度范围");
		}
	}

	/**
	 * 删除链表头元素
	 */
	public void removeFirst() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表已经空了！");
		} else if (size == 1) {
			// 只剩一个元素了！！first和last指向同一个元素
			clear();
		} else {
			Node temp = first;
			first = temp.getNext();
			temp = null;
			size -= 1;
		}
	}

	/**
	 * 删除链表尾部元素
	 */
	public void removeLast() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		} else if (size == 1) {
			clear();
		} else {
			Node temp = get(size - 2);// 获取最后元素之前的一个元素
			temp.setNext(null);
			size -= 1;
		}
	}

	/**
	 * 删除链表中间的元素
	 * 
	 * @param index
	 */
	public void removeMiddle(int index) {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		} else if (size == 1) {
			clear();
		} else {
			if (index == 0) {
				removeFirst();
			} else if (size == index - 1) {
				removeLast();
			} else {
				Node temp = get(index - 1);
				Node next = temp.getNext();
				temp.setNext(next.getNext());
				next = null;
				size -= 1;
			}
		}
	}

	/**
	 * 打印所有元素数据
	 */
	public void printAll() {
		Node temp = first;
		System.out.println(temp.getData());
		for (int i = 0; i < size - 1; i++) {
			temp = temp.getNext();
			System.out.println(temp.getData());
		}
	}

	/**
	 * 逆序链表，原理基于指针反转
	 * 解释：每次反转涉及2个节点，用到3个指针，然后3个指针均向后移重复下一次操作。
	 */
	public void reverse() {
		Node temp = first;
		last = temp;
		Node next = first.getNext();
		for (int i = 0; i < size - 1; i++) {
			Node nextNext = next.getNext();
			next.setNext(temp);
			
			temp = next;//挪动temp 和 nextNext指针
			next = nextNext;
		}
		last.setNext(null);
		first = temp;
	}

}
