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
		if(this.head == null)
			return null;
		return this.head.getElement();
	}
	
	public T last() {
		// TODO a)
	}
	
	public void prefix(Entry<T> newHead) {
		newHead.setNext(this.head);
		this.head = newHead;
		this.size++;
	}
	
	public void prefix(T element) {
		this.prefix(new Entry(element));
	}
	
	
	public void postfix(Entry<T> newLast) {
		// TODO b)
	}

	public void postfix(T element) {
		this.postfix(new Entry(element));
	}
	
	public List<T> rest() {
		if(this.head == null)
			return null;
		List<T> erg = new List<T>();
		erg.size = this.size - 1;
		erg.head = this.head.getNext();
		return erg;
	}
	
	public T proj(int index){
		if(this.head == null) {
			return null;
		}
		if(index >= this.size())
			return null;
		if(index == 1)
			return this.head.getElement();
		else
			return this.rest().proj(index - 1);
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void concat(List<T> list){
		// TODO c)
	}
	
	public List<T> clone(){
		// TODO d)
	}
	
	public List<T> concatClone(List<T> list){
		// TODO e)
	}
	
	public List<T> reverse() {
		// TODO f)
	}
	
	public void removeDuplicates() {
		// TODO g)
	}
	
	public String toString(){
		if(isEmpty())
			return "()";
		String str = "(";
		Entry<T> entry = head;
		while(entry != null) {
			str += entry.getElement();
			entry = entry.getNext();
			if(entry != null)
				str += ", ";
		}
		str += ")";
		return str;
	}
	
	// for i)
	public int sizeDyn() {
		int size = 0;
		if(this.head != null){		
			Entry<T> entry = this.head;
			while(entry != null){
				size++;
				entry = entry.getNext();
			}
		}
		return size;
	}
	
}