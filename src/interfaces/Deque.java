/**
 * 
 */
package interfaces;

/**
 * @author Shyam
 *
 */
public interface Deque<T> extends Collection<T>,Queue<T> {
	// Don't throw exceptions
	public boolean offerFirst(T obj);
	public boolean offerLast(T obj);
	public T pollFirst();
	public T pollLast();
	public T peekFirst();
	public T peekLast();
}
