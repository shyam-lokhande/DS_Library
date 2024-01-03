/**
 * 
 */
package interfaces;

/**
 * @author Shyam
 *
 */
public interface Collection<T> {
	public boolean add(T obj);
	public void clear();
	public boolean contains(T obj);
//	public boolean containsAll(Collection<?> c);
	public boolean equals(Object obj);
	public boolean isEmpty();
	public boolean remove(T obj);
//	public removeAll(Collection<?> c);
//	public boolean retainAll(Collection<?> c);
	public int size();
	public Object[] toArray();
}
