package classes;
import interfaces.Deque;
import interfaces.List;

public class SinglyLL<T> implements Deque<T>,List<T>{
	private Node head;
	private Node tail;
	private int len;
	
	private class Node{
		T val;
		Node next;
		
		Node(T v){
			this.val=v;
			next=null;
		}
	}
	
	SinglyLL(){
		head=null;
		tail=null;
		len=0;
	}
	
	//------------------------------------------------------ Collection interface Methods -----------------------------------------------------------------------//
	
	public boolean add(T obj) {
		try {
			if(head==null) {
				tail=head=new Node(obj);
			}
			else {
				tail.next=new Node(obj);
				tail=tail.next;
			}
			this.len++;
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void clear() {
		tail=head=null;
		len=0;
	}

	public boolean contains(T obj) {
		Node temp=head;
		while(temp!=null) {
			if(temp.val==obj) return true;
			temp=temp.next;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(len==0) return true;
		return false;
	}
	
	public boolean remove(T obj) {
		if(len==0) return false;
		if(head.val==obj) {
			if(len==1) {
				tail=null;
			}
			head=head.next;
			len--;
			return true;
		}
		Node temp=head;
		while(temp!=null && temp.next!=null) {
			if(temp.next.val==obj) {
				if(temp.next==tail) {
					tail=temp;
				}
				temp.next=temp.next.next;
				len--;
				return true;
			}
			temp=temp.next;
		}
		return false;
	}
	
	public T remove(int index) {
		if(len==0) return null;
		if(index<len && index>=0) {
			Node temp=head;
			if(index==0) {
				head=temp.next;
				if(len==1) {
					tail=head;
				}
				len--;
				return temp.val;
			}
			else {
				while(index>1) {
					temp=temp.next;
					index--;
				}
				T res=temp.next.val;
				temp.next=temp.next.next;
				if(len==index+1) {
					tail=temp;
				}
				len--;
				return res;
			}
		}
		return null;
	}
	
	public int size() {
		return len;
	}
	
	public Object[] toArray() {
		Node temp=head;
		Object[] arr= new Object[len];
		int i=0;
		while(temp!=null) {
			arr[i]=temp.val;
			i++;
		}
		return arr;
	}
	
	//------------------------------------------------------ List interface Methods -----------------------------------------------------------------------------//
	
	//0 based indexing
	public void add(int index,T obj) {
		try {
			if(index>len && index<0) return ;
			Node temp=head;
			if(index==0) {
				head=new Node(obj);
				if(len==0) {
					tail=head;
				}
			}
			else {
				while(index>0) {
					temp=temp.next;
					index--;
				}
				Node temp2=temp.next;
				temp.next=new Node(obj);
				temp=temp.next;
				temp.next=temp2;
			}
			this.len++;
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public T get(int index) {
		if(index<len && index>=0) {
			Node temp=head;
			if(index==0) return head.val;
			else if(index==len-1) return tail.val;
			else {
				while(index>0) {
					temp=temp.next;
				}
				return temp.val;
			}
		}
		return null;
	}
	
	public int indexOf(T obj) {
		Node temp=head;
		int index=0;
		while(temp!=null) {
			if(temp.val==obj) return index;
			temp=temp.next;
			index++;
		}
		return -1;
	}
	
	public int lastIndexOf(T obj) {
		Node temp=head;
		int index=0,res=-1;
		while(temp!=null) {
			if(temp.val==obj) res=index;
			temp=temp.next;
			index++;
		}
		return res;
	}
	
	public List<T> subList(int fromIndex, int toIndex){
		List<T> l=new SinglyLL<T>();
		
		boolean check= (fromIndex>=toIndex && toIndex<len && fromIndex>=0)?true:false;
		
		if(check) {
			Node temp=head;
			int local=fromIndex;
			
			while(fromIndex>0) {
				temp=temp.next;
			}
			
			while(local<fromIndex) {
				l.add(temp.val);
				temp=temp.next;
				local++;
			}
			
			return l;
		}
		return null;
	}
	
	//------------------------------------------------------ DeQueue interface Methods -----------------------------------------------------------------------//
	
	public T set(int index,T obj) {
		
		if(index<len && index>=0) {
			Node temp=head;
			
			while(index>0) {
				temp=temp.next;
				index--;
			}
			
			T res=temp.val;
			temp.val=obj;
			return res;
		}
		return null;
	}
	
	public boolean addAll(T[] arr) {
		try {
			Node temp=head;
			
			for(int i=0;i<arr.length;i++) {
				Node newNode=new Node(arr[i]);
				
				if(head==null) {
					head=newNode;
					temp=head;
				}
				else {
					temp.next=newNode;
					temp=temp.next;
				}
			}
			
			this.tail=temp;
			this.len+=arr.length;
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void addFirst(T obj) {
		if(head==null) {
			tail=head=new Node(obj);
		}
		else {
			Node temp=head;
			head=new Node(obj);
			head.next=temp;
		}
		this.len++;
	}
	
	public T getFirst() {
		if(len>0) return head.val;
		return null;
	}
	
	public T getLast() {
		if(len>0) return tail.val;
		return null;
	}
	
	public T removeFirst() {
		return remove(0);
	}
	
	public T removeLast() {
		return remove(len-1);
	}
	
	//------------------------------------------------------ Queue interface Methods -----------------------------------------------------------------------//
	
	public boolean offer(T obj) {
		try {
			Node newNode=new Node(obj);
			
			if(len==0) {	
				head=tail=newNode;
			}
			else {
				tail.next=newNode;
				tail=newNode;
			}
			
			len++;
			return true;	
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public T poll() {
		try {
			T res=null;
			
			if(this.isEmpty()) {
				return res;
			}
			else if(len==1) {
				res=head.val;
				head=tail=null;
			}
			else{
				res=head.val;
				head=head.next;
			}
			
			len--;
			return res;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public T peek() {
		try {
			T res=null;
			
			if(this.isEmpty()) {
				return res;
			}
			res=head.val;
			return res;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//------------------------------------------------------ Deque interface Methods -----------------------------------------------------------------------//
	
	public boolean offerFirst (T obj) {
		try {
			Node newNode=new Node(obj);
			
			if(len==0) {	
				head=tail=newNode;
			}
			else {
				newNode.next=head;
				head=newNode;
			}
			
			len++;
			return true;	
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	public boolean offerLast(T obj) {
		return offer(obj);
	}
	
	public T pollFirst() {
		return poll();
	}
	
	public T pollLast() {
		try {
			Node temp=head;
			
			if(len==0) {	
				return null;
			}
			else if(len==1){
				T t=head.val;
				head=tail=null;
				return t;
			}
			while(temp.next!=tail) {
				temp=temp.next;
			}
			T t = tail.val;
			temp.next=null;
			tail=temp;
			
			len++;
			return t;	
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public T peekFirst() {
		return peek();
	}
	
	public T peekLast() {
		if(tail==null) return null;
		return tail.val;
	}
}
