//Node.java

public class Node<T extends Comparable<? super T>>{
	private T data;
	private Node<T> next;

	public Node (T data) {
		this.data = data;
		this.next = null;
	}

	public void setNext(T data) {
		this.next = new Node<T>(data);
	}

	public void setNext(Node<T> n) {
		this.next = n;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public T getData() {
		return this.data;
	}
}