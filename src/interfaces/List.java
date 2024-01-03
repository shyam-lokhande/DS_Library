/**
 * 
 */
package interfaces;

/**
 * @author Shyam
 *
 */
public interface List<T> extends Collection<T> {
	public void add(int index,T obj);
//	public boolean addAll(Collection<? extends T> c);
//	public boolean addAll(int index, Collection<? extends T> c);
	public T get(int index);
//	public int hashcode();
	public int indexOf(T obj);
	public int lastIndexOf(T obj);
//	public boolean removeAll(Collection<?> c);
//	public boolean retainAll(Collection<?> c);
	public T set(int index, T obj);
	public List<T> subList(int fromIndex, int toIndex);
}
