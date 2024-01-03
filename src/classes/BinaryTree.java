/**
 * 
 */
package classes;

/**
 * @author Shyam
 *
 */
public class BinaryTree<T> {
	
	private Node root=null;
	private int idx=-1;
	
	private class Node{
		Node left,right;
		T data;
		
		public Node(T d) {
			left=null;
			right=null;
			data=d;
		}
	}
	
	public Node getRoot() {
		return root;
	}

	// Takes preorder sequence and builds tree 
	public Node buildTreeHelper(T nodes[]) {
		idx++;
		if(nodes[idx]==null) return null;
		
		Node newNode=new Node(nodes[idx]);
		newNode.left=buildTreeHelper(nodes);
		newNode.right=buildTreeHelper(nodes);
		return newNode;
	}
	
	public Node buildTree(T nodes[]) {
		this.root=buildTreeHelper(nodes);
		return root;
	}
	
	public ArrayList<T> preorder(ArrayList<T> l,Node root){
		if(root==null) {
			l.add(null);
			return l;
		}
		l.add(root.data);
		preorder(l,root.left);
		preorder(l,root.right);
		return l;
	}
	
	public ArrayList<T> inorder(ArrayList<T> l,Node root){
		if(root==null) {
			l.add(null);
			return l;
		}
		preorder(l,root.left);
		l.add(root.data);
		preorder(l,root.right);
		return l;
	}
	
	public ArrayList<T> postorder(ArrayList<T> l,Node root){
		if(root==null) {
			l.add(null);
			return l;
		}
		preorder(l,root.left);
		preorder(l,root.right);
		l.add(root.data);
		return l;
	}
}
