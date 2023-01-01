package first_spring_class;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collection;

public class IMyList<T> implements MyList<T>, Iterable<T> {

	private int size;
	private Noda<T> begin;
	private Noda<T> end;
		
	public IMyList() {
		clear();
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public void clear() {
		begin = new Noda<T>(null, null, null);
		end = new Noda<T>(null, begin, null);
		begin.next = end;
		size = 0;
	}
	
	@Override
	public void add(T data) {
		add(this.size, data);
	}
	
	@Override
	public void add(int index, T data) {
		addBefore(getNoda(index, this.size), data);
	}
	
	private void addBefore(Noda<T> noda, T data) {
		Noda<T> newNoda = new Noda<T>(data, noda.prev, noda);
		newNoda.prev.next = newNoda;
		noda.prev = newNoda;
		size++;
	}
	
	private Noda<T> getNoda(int index, int size) {
		Noda<T> current;
		if (index > size)
			throw new IndexOutOfBoundsException("getNoda index: " + index + "size: " + size);

		if (index < size / 2) {
			current = begin.next;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		} else {
			current = end;
			for (int i = size; i > index; i--) {
				current = current.prev;
			}
		}
		return current;
	}
	
	@Override
	public boolean removeT(T o) {
	    Noda<T> current;
	    current = begin;
	    while (current != null && current.data != o) {
	        current = current.next;
	    }
	    if (current == null) {
	    	return false;
	    }
	    if (current.next != null) {
	        current.next.prev = current.prev;
	    }
	    if (current.prev != null) {
	        current.prev.next = current.next;
	    }
	    return true;
	}
	
	//@Override
	private T remove(Noda<T> noda) {
			noda.next.prev = noda.prev;
			noda.prev.next = noda.next;
			this.size--;
			return noda.data;
		
	}
	
	@Override
	public boolean constains(T e) {
		
			 for (T data : this) {
				 if(data.equals(e)){
					 return true;
					 }
			 }
			 return false;
	}
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	private Noda<T> getByIndex(int index) {
	    Noda<T> node = null;
	    if (!isEmpty() && (index >= 0 && index < size)) {
	        node = begin;
	        for(int i=0; i<=index; i++){
	            node = node.next;
	        }
	    }
	    return node;
	}
	@Override
	public Object[] toArray() {
	    Object[] array = new Object[size];
	    for (int i = 0; i < size; i++) {
	        array[i] = getByIndex(i).data;
	    }
	    return array;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (T data : this)
			sb.append(data + " ");
		sb.append("]");
		return sb.toString();
	}
	
	private class MyIterator implements Iterator<T> {
		private Noda<T> current = begin.next;
		private boolean flagToRemove = false;

		@Override
		public void remove() {
			if (!flagToRemove)
				throw new IllegalStateException();
			
			IMyList.this.remove(current.prev);
			flagToRemove = false;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();

			T nextItem = current.data;
			current = current.next;
			flagToRemove = true;
			return nextItem;
		}

		@Override
		public boolean hasNext() {
			return current != end;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}
}
