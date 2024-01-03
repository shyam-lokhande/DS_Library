package main;
import classes.ArrayList;
import classes.BinaryTree;

/**
 * 
 */

/**
 * @author Shyam
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Tree methods
		BinaryTree<Integer> b=new BinaryTree<Integer>();
		Integer[] nodes= {1,2,4,null,null,5,null,null,3,null,6,null,null};
		
		//Takes preorder sequence only and build the tree 
		b.buildTree(nodes);
		System.out.println("Root node of built tree is "+b.getRoot());
		
		//Returns preorder sequence of the tree
		ArrayList<Integer> list=new ArrayList<Integer>();
		list=b.preorder(list, b.getRoot());
		System.out.println("Root node of built tree is "+list.get(8));
		
		
		
	}

}
