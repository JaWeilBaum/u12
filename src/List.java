import javax.crypto.SealedObject;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

public class List<T> {
	private int size;
	private Entry<T> head;

	public List() {
		this.size = 0;
		this.head = null;
	}

	public int size() {
		return this.size;
	}

	public T first() {
		if (this.head == null)
			return null;
		return this.head.getElement();
	}

	public T last() {
		Entry<T> entry = head;
		if (entry != null) {
			while (entry.getNext() != null)
				entry = entry.getNext();
			return entry.getElement();
		} else {
			return null;
		}
	}

	public void prefix(Entry<T> newHead) {
		newHead.setNext(this.head);
		this.head = newHead;
		this.size++;
	}

	public void prefix(T element) {
		this.prefix(new Entry<T>(element));
	}

	public void postfix(Entry<T> newLast) {
		Entry<T> entry = this.head;
		while (entry.getNext() != null)
			entry = entry.getNext();
		entry.setNext(newLast);
		this.size++;
	}

	public void postfix(T element) {
		this.postfix(new Entry<T>(element));
	}

	public List<T> rest() {
		if (this.head == null)
			return null;
		List<T> erg = new List<T>();
		erg.size = this.size - 1;
		erg.head = this.head.getNext();
		return erg;
	}

	public T proj(int index) {
		if (this.head == null) {
			return null;
		}
		if (index >= this.size())
			return null;
		if (index == 1)
			return this.head.getElement();
		else
			return this.rest().proj(index - 1);
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void concat(List<T> list) {
		Entry<T> entry = this.head;
		while (entry.getNext() != null)
			entry = entry.getNext();
		if (list.head != null)
			entry.setNext(list.head);
	}

	public List<T> clone() {
		List<T> list = new List<>();
		Entry<T> entry = this.head;
		list.head = new Entry<T>(this.head.getElement());
		while (entry.getNext() != null) {
			entry = entry.getNext();
			list.postfix(entry.getElement());
		}
		return list;
	}

	public List<T> concatClone(List<T> list) {
		List<T> newList = this.clone();
		List<T> newList2 = list.clone();
		newList.concat(newList2);
		return newList;

	}

	public List<T> reverse() {
		List<T> list = new List<>();
		Entry<T> entry = this.head;
		list.head = new Entry<T>(entry.getElement());
		while (entry.getNext() != null) {
			entry = entry.getNext();
			list.prefix(new Entry<T>(entry.getElement()));
		}
		return list;
	}

	private boolean contains(List<T> list, T element) {
		try {
		Entry<T> entrySearch = list.head;
		while (entrySearch != null) {
			if (((T)(element)) == ((T)entrySearch.getElement())) {
				return true;
			}
			entrySearch = entrySearch.getNext();
		}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public void removeDuplicates() {
		List<T> list = new List<>();
		Entry<T> entry = this.head;
		list.head = new Entry<T>(entry.getElement());
		entry = entry.getNext();
		while (entry != null) {
			if (!list.contains(list, entry.getElement())) {
				list.postfix(entry.getElement());
			}
			entry = entry.getNext();
		}
		this.head = list.head;
		this.size = list.size;
	}

	public String toString() {
		if (isEmpty())
			return "()";
		String str = "(";
		Entry<T> entry = head;
		while (entry != null) {
			str += entry.getElement();
			entry = entry.getNext();
			if (entry != null)
				str += ", ";
		}
		str += ")";
		return str;
	}

	// for i)
	public int sizeDyn() {
		int size = 0;
		if (this.head != null) {
			Entry<T> entry = this.head;
			while (entry != null) {
				size++;
				entry = entry.getNext();
			}
		}
		return size;
	}

}