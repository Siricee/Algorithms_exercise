package queue;

public class TestQueue {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(4);
		System.out.println(queue.put(new String("this")));
		System.out.println(queue.put(new String("f**king")));
		System.out.println(queue.put(new String("data")));
		System.out.println(queue.put(new String("struction")));
		System.out.println(queue.put(new String("is full?")));
			
		System.out.println(queue.isFull());
		System.out.println(queue.isEmpty());
		
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.peek());

	}

}

class ArrayQueue {
	private final Object[] items;
	private int head = 0;
	private int tail = 0;

	/**
	 * 初始化队列
	 * 
	 * @param capacity
	 *            队列长度
	 */

	public ArrayQueue(int capacity) {
		this.items = new Object[capacity];
	}

	/**
	 * 入队
	 * 
	 * @param item
	 * @return
	 */
	public boolean put(Object item) {
		if (head == (tail + 1) % items.length) {
			// 队列已满
			return false;
		}
		items[tail] = item;
		tail = (tail + 1) % items.length;// tail标记向后移一位
		return true;
	}

	/**
	 * 获取队列头元素，不出队
	 * 
	 * @return
	 */
	public Object peek() {
		if (head == tail) {
			// 说明队空
			return null;
		}
		return items[head];
	}

	/**
	 * 出队
	 * 
	 * @return
	 */
	public Object poll() {
		if (head == tail) {
			return null;
		}
		Object item = items[head];
		items[head] = null;// 没用的元素赋空值
		head = (head + 1) % items.length;
		return item;
	}

	public boolean isFull() {
		return head == (tail + 1) % items.length;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	/**
	 * 队列元素
	 * 
	 * @return
	 */
	public int size() {
		if (tail >= head) {
			return tail - head;
		} else {
			return tail + items.length - head;
		}
	}
}