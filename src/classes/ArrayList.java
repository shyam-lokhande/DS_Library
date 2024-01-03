/**
 * 
 */
package classes;

import java.util.Arrays;

import interfaces.Collection;
import interfaces.List;

/**
 * Import Statements
 */


/**
 * @author Shyam
*/
public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_CAPACITY=10;
	private int capacity;
	
	private int size=0;
	private Object[] data;
	

	//--------------------------------------------------------------------------- Constructors -----------------------------------------------------------------------//
	

	public ArrayList() {
		capacity=DEFAULT_CAPACITY;
		this.data= new Object[capacity];
	}
	
	public ArrayList(int capacity) {
		if(capacity>0) {
			this.data= new Object[capacity];
			this.capacity=capacity;
		}
		else
			throw new IllegalArgumentException("Illegal Capacity : "+capacity);
	}
	
	public ArrayList(Collection<? extends T> c) {
		Object[] a=c.toArray();
		if((this.size=a.length)!=0) {
			if(c.getClass()==ArrayList.class) this.data=a;
			else this.data=Arrays.copyOf(a, size, Object[].class);
		}
		else {
			this.data= new Object[capacity];
		}
	}
	
	//----------------------------------------------------------------------- Helping Methods ----------------------------------------------------------------------------//
	
	private boolean checkIndex(int index) {
		if(index<size && index>=0) return true;
		return false;
	}
	
	private boolean checkSize() {
		if(size<=capacity*3/2) return true;
		return false;
	}
	
	private void growList() {
		capacity=capacity*2;
		Object[] newData=new Object[capacity];
		for(int i=0;i<size;i++) {
			newData[i]=data[i];
		}
		this.data=newData;
	}
	
	//-------------------------------------------------------------- Collection Interface Methods -----------------------------------------------------------------------//
	
	public boolean add(T obj) {
		try {
			if(size<capacity*(3/2)) {
				data[size]=obj;
				size++;
				return true;
			}
			growList();
			data[size]=obj;
			size++;
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public void clear() {
		try {
			capacity=DEFAULT_CAPACITY;
			data= new Object[DEFAULT_CAPACITY];
			size=0;
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public boolean contains(T obj) {
		for(int i=0;i<size;i++) {
			if(data[i]==obj) return true;
		}
		return false;
	}
//	public boolean containsAll(Collection<?> c);
//	public boolean equals(Object obj) {
	
	public boolean isEmpty() {
		if(size==0) return true;
		return false;
	}
	
	public boolean remove(T obj) {
		try {
			int i=-1;
			for(i=0;i<size;i++) {
				if(data[i]==obj) {
					break;
				}
			}
			if(i==-1) return false;
			for(int j=i;j<size-1;j++) {
				data[j]=data[j+1];
			}
			size--;
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
//	public removeAll(NewCollection<?> c);
//	public boolean retainAll(NewCollection<?> c);
	
	public int size() {
		return size;
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(data, size);
	}
	
	//------------------------------------------------------------------ List Interface Methods -----------------------------------------------------------------------//
	
	public void add(int index,T obj) {
		try {
			if(checkIndex(index)) {
				if(!checkSize()) this.growList();
				for(int i=size;i>index;i--) {
					data[i]=data[i-1];
				}
				data[index]=obj;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
//	public boolean addAll(NewCollection<? extends T> c);
//	public boolean addAll(int index, NewCollection<? extends T> c);
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if(checkIndex(index)) return (T)data[index];
		return null;
	}
//	public int hashcode();
	public int indexOf(T obj) {
		try {
			int i=-1;
			for(i=0;i<size;i++) {
				if(data[i]==obj) return i;
			}
			return i;
		}catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}
	public int lastIndexOf(T obj) {
		try {
			int index=-1;
			for(int i=0;i<size;i++) {
				if(data[i]==obj) index=i;
			}
			return index;
		}catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}
//	public boolean removeAll(NewCollection<?> c);
//	public boolean retainAll(NewCollection<?> c);
	public T set(int index, T obj) {
		try {
			Object temp=null;
			if(checkIndex(index)) {
				 temp=(T)data[index];
				data[index]=obj;
			}
			return (T)temp;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public List<T> subList(int fromIndex, int toIndex){
		try {
			if(fromIndex<=toIndex && checkIndex(fromIndex) && checkIndex(toIndex)) {
				List<T> l=new ArrayList<T>();
				for(int i=fromIndex;i<toIndex;i++) {
					l.add((T)data[i]);
				}
				return l;
			}
			return null;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}
