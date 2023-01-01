package first_spring_class;

public interface MyList<T> {
	
	public void add(T data);
	public void add(int index, T data);
	public void clear();
	public boolean removeT(T o);
	public boolean isEmpty();
	public Object[] toArray();
	public int size();
	public boolean constains(T e);
}