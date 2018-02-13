package stack;

import java.util.Arrays;

public class TestStack {

	public static void main(String[] args) {
		Stack stack = new Stack(1);
		stack.push(7);
		stack.push(4);
		System.out.println(stack.size());//2
		stack.push(8);
		
		System.out.println(stack.peek());//8
		
		System.out.println(stack.pop());//8
		System.out.println(stack.isEmpty());//false
		System.out.println(stack.isFull());//false
	}

}

class Stack{
	
	private int size = 0;
	private int[] array;
	
	public Stack() {
		this(10);
	}
	public Stack(int init) {
		if(init < 10) {
			init = 10;
		}
		array = new int[init];
	}
	/**
	 * 入栈
	 * @param item 入栈元素整形值
	 */
	public void push(int item) {
		if(size == array.length) {
			array = Arrays.copyOf(array, size*2);
		}
		array[size++] = item;
	}
	
	/**
	 * 获取栈顶元素，但没出栈
	 * @return
	 */
	public int peek() {
		if(size == 0) {
			throw new IndexOutOfBoundsException("栈里已经是空的");
		}
		return array[size-1];
	}
	/**
	 * 出栈并获取栈中元素
	 * @return
	 */
	public int pop() {
		int item = peek();
		size-=1; //此处使元素个数-1，没必要删除该元素，下次入栈自然会覆盖。
		return item;
	}
	/**
	 * 判断栈是否已经满了
	 * @return Boolean
	 */
	public boolean isFull() {
		return size == array.length;
	}
	/**
	 * 是否为空藏
	 * @return boolean
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
}
