public class Entry<T> {
	private T element;
	private Entry<T> next;

	public Entry(T element) {
		this.element = element;
		this.next = null;
	}

	public T getElement() {
		return this.element;
	}

	public Entry<T> getNext() {
		return this.next;
	}

	public void setNext(Entry<T> next) {
		this.next = next;
	}
}