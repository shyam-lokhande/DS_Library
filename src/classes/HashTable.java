/**
 * 
 */
package classes;

/**
 * @author Shyam
 *
 */
public class HashTable<T> {
	private int bucket=10;
	private ArrayList<SinglyLL<T>> table;
	
	HashTable(int b){
		this.bucket=b;
	
		table=new ArrayList<SinglyLL<T>>();
		
		for(int i=0;i<b;i++) {
			table.add(new SinglyLL<T>());
		}
	}
	
	public void insert(T obj) {
		try {
			int i=Integer.parseInt((String) obj)%bucket;
			table.get(i).add(obj);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void remove(T obj) {
		try {
			int i=Integer.parseInt((String) obj)%bucket;
			table.get(i).remove(obj);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean search(T obj) {
		try {
			int i=Integer.parseInt((String) obj)%bucket;
			return table.get(i).contains(obj);
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
