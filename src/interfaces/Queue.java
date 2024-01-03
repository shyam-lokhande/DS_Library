/**
 * 
 */
package interfaces;

/**
 * @author Shyam
 *
 */
public interface Queue<T> extends Collection<T> {
	public boolean offer(T obj);
	public T poll();
	public T peek();
}
