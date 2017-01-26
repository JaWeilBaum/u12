import java.util.Arrays;

public class Minimum<T> {

	public static void main(String[] args) {
		Integer[] objectarray = {new Integer(1), new Integer(1345)};
		Minimum<Integer> minimum = new Minimum<Integer>(objectarray);
		System.out.println(minimum.getMinimum());
	}
	
	
	private T array[];
	
	public Minimum(T[] array) {
		this.array = array;
	}
	
	public T getMinimum() {
		Arrays.sort(this.array);
		return this.array[0]; 
	}
	
}
