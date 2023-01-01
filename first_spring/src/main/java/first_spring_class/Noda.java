package first_spring_class;

public class Noda<T> {
	
	public T data;
	public Noda<T> prev;
	public Noda<T> next;

	public Noda(T data, Noda<T> prev, Noda<T> next) {
	this.data = data;
	this.prev = prev;
	this.next = next;
			
	}
}
