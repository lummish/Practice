//Stack.java
import java.util.NoSuchElementException;
import java.util.Random;
import java.lang.Math;

public class Stack<T extends Comparable<? super T>> {
	private int size;
	private Node<T> top;

	public Stack(){
		size = 0;
		top = null;
	}

	public int size() {
		return size;
	}

	public void push(T data) {
		if (data == null) {
			return;
		}
		size++;
		Node<T> toPush = new Node<>(data);
		toPush.setNext(top);
		top = toPush;
	}

	public T pop() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		size--;
		T toPop = top.getData();
		top = top.getNext();
		return toPop;
	}

	public T peek() {
		return top.getData();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void stackSort() {
		Stack<T> buffer = new Stack<>();
		while (!isEmpty()) {
			if (buffer.isEmpty()) {
				buffer.push(pop());
			}
			else {
				if (peek().compareTo(buffer.peek()) > 0) {
					T cur = pop();
					
					while(!buffer.isEmpty() && buffer.peek().compareTo(cur) < 0) {
						push(buffer.pop());
					}

					buffer.push(cur);

					while(!isEmpty() && peek().compareTo(buffer.peek()) < 0) {
						buffer.push(pop());
					}
				}
				else {
					buffer.push(pop());
				}
			}
		}

		while(!buffer.isEmpty()) {
			push(buffer.pop());
		}
	}

	public void printStack() {
		Node<T> cursor = top;
		System.out.print("[ ");

		while(cursor != null) {
			System.out.format("%2d ", cursor.getData());
			cursor = cursor.getNext();
		}

		System.out.println("]");
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Random rand = new Random();
		for (int i = 0; i < 50; i++) {
			s.push(new Integer(rand.nextInt(100)));
		}
		s.printStack();
		s.stackSort();
		s.printStack();
	}
}