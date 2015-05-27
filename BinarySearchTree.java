/**
 * Binary Search Tree Assignment
 * 
 * 1. write contains (4pts) COMPLETE
 * 2. write traverseInorder (4pts) COMPLETE
 * 3. write randomizedSort (5pts) COMPLETE
 * 4. write delete (5pts) COMPLETE
 * 5. improve insert to self balance using AVL (4pts) COMPLETE 
 * 6. improve delete to self balancing using AVL (3pts) COMPLETE 
 * 
 * @author Jamie Konigsberg
 * Goal: Finish Binary Search Tree Assignment (Above)
 * Date: 11/11/14
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BinarySearchTree {
	public static void main(String[] args) 
	{
		BinarySearchTree bst = new BinarySearchTree('d');
		bst.insert('b');
		bst.insert('c');	
		bst.insert('f');
		bst.insert('a');
		bst.insert('e');
		bst.insert('g');
		bst.insert('h');
		System.out.println(bst.contains('c'));
		System.out.println(bst.contains('h'));
		System.out.println(bst.contains('j'));
		System.out.println(bst.traverseInorder());
		List<Character> tryit = new ArrayList<Character>();
		tryit.add('a');
		tryit.add('b');
		tryit.add('c');
		tryit.add('d');
		tryit.add('e');
		tryit.add('g');
		tryit.add('h');
		System.out.println(bst.randomizedSort(tryit));
		BinarySearchTree bst4 = new BinarySearchTree('d');
		bst4.insert('d');
		bst4.insert('c');
		bst4.insert('e');
		bst4.insert('b');
		bst4.insert('a');
		bst4.insert('g');
		bst4.insert('f');
		bst4.insert('h');
		System.out.println();
		bst4.print();
		System.out.println(bst4.delete('b'));
		System.out.println(bst4.delete('e'));
		bst4.print();
		System.out.println(bst4.traverseInorder());		
	}

	private static Node root;

	public BinarySearchTree(char c) {
		root = new Node(c);
	}

	public void print() {
		root.print();
	}

	public void insert(char c) {
		insert(c, root);
		isBalance(root);
	}

	/**
	 * insert for an unbalanced BST.
	 * @param c the letter to insert
	 * @param n the root node to insert from
	 * 
	 * PART 5:
	 * modify this function to balance on insert using AVL algorithm
	 * 
	 */
	private void insert(char c, Node n) {
		if(c==n.data) return;						//c already in tree
		else if(c<n.data) {							//c is less than n
			if(n.left==null) {
				n.left = new Node(c); 	//there is no child to the left, add c
				n.left.parent = n;
			}
			else insert(c, n.left);					//insert c in left subtree
		} else {									//c is greater than n
			if(n.right==null) {
				n.right = new Node(c);//there is no child to the right, add c
				n.right.parent = n;
			}
			else insert(c, n.right);				//insert c in right subtree
		}
	}

	/**
	 * STEP 1:
	 * determine whether c is in the tree
	 * @param c a letter to look for
	 * @return true if c is in the tree
	 */
	public boolean contains(char c) {
		return contains(c,root);
	}

	public boolean contains(char c, Node n) {
		if(n == null) return false;
		if(c==n.data) return true;
		else if(c<n.data) return contains(c, n.left);
		else return contains(c, n.right);
	}

	/**
	 * STEP 2:
	 * do an inorder traversal of the tree
	 * ex.
	 * 
	 *        d               
	 *       / \       
	 *		/   \      
	 *	   /     \     
	 *    /       \    
	 *    b       e       
	 *   / \       \   
	 *  /   \       \  
	 *  a   c       g   
	 *  		     \ 
	 *       		  h
	 *        
	 * should return ['a','b','c','d','e','g','h']
	 */
	public List<Character> traverseInorder() {
		return traverse(root);
	}

	public static List<Character> traverse(Node n) {
		List<Character> l = new ArrayList<Character>();
		if(n == null) return l;
		if(n.left != null) l.addAll(traverse (n.left));
		l.add(n.data);
		if(n.right!= null) l.addAll(traverse (n.right));
		return l;
	}

	/**
	 * STEP 3:
	 * 
	 * Sort the given list by creating a bst from the list.  
	 * Make sure to insert the list in a randomized order, to help 
	 * promote a balanced tree
	 * @param unsorted a list of items
	 * @return a new sorted lest
	 */
	public static List<Character> randomizedSort(List<Character> unsorted) {
		Collections.shuffle(unsorted);
		BinarySearchTree bst3 = new BinarySearchTree(unsorted.get(0));
		for(int i = 0; i < unsorted.size(); i++)
		{
			bst3.insert(unsorted.get(i));
		}
		return bst3.traverseInorder();
	}



	/**
	 * STEP 4: complete this function
	 * STEP 6: improve to self balance with AVL
	 * delete the char c from the tree
	 * @param c the letter to delete
	 * @return true if successful, false if it does not exist
	 */
	public boolean delete(char c) {
		return delete(c,root);
	}

	private boolean delete(char c, Node n) 
	{
		if(c==n.data) 
		{					
			if(n.left == null && n.right == null)
			{
				if(n.data < n.parent.data)
				{
					n.parent.left = null;
				}
				else n.parent.right = null;
				isBalance(root);
				return true;
			}

			else if(n.left == null)
			{
				if(n.data < n.parent.data)
				{
					n.parent.left = n.right;
					n.right.parent = n.parent; 
				}
				else
					n.parent.right = n.right;
					n.right.parent = n.parent; 
				isBalance(root);
				return true; 
			}
			else if(n.right==null) {
				if(n.data < n.parent.data)
				{
					n.parent.left = n.left;
					n.left.parent = n.parent; 
				}
					n.parent.right = n.left; 
					n.left.parent = n.parent;
				isBalance(root);
				return true; 

			}

			else { 
				n.data = successor(n);
				print();
				return delete(n.data,n.right); 
			}

		}
		else if(c<n.data) 
		{

			if(n.left==null) return false; 	
			else return delete(c, n.left);					
		} else 
		{									
			if(n.right==null) return false;
			else return delete(c, n.right);	
		}
	}//method


	private char successor(Node n) { 
		n = n.right;
		while(n.left!= null) {
			n = n.left;
		}
		return n.data;
	}

	public static int howmanychildren(Node n)
	{ 
		if(n==null) return 0;

		int count = 1;
		if(n.left != null) 
		{
			count += howmanychildren(n.left);
		}
		if(n.right != null) 
		{
			count += howmanychildren(n.right);
		}
		return count; 
	}
	
	
	public void isBalance(Node n) 
	{

		if(n==null) return;
		int leftweight = howmanychildren(n.left);
		System.out.println(leftweight);
		int rightweight = howmanychildren(n.right);
		System.out.println(rightweight);
		if((leftweight + 1 < rightweight) || (rightweight +1 < leftweight))
		{
			rotate(n);
			isBalance(n);
		}
		else 
		{
			isBalance(n.left);
			isBalance(n.right);
		}
	}

	public void rotate(Node n) 
	{
		Node parentNode;
		boolean parentleft = false;
		boolean parentright = false;
		Node five;
		Node three;
		Node four;
		Node A;
		Node B;
		Node C;
		Node D;

		//left right case:
		if(n.bal()==2 && n.left.bal()==-1)
		{
			//assignment:
			five = n;
			parentNode = five.parent;  //null
			if(parentNode!=null) parentleft = five.parent.data>five.data;
			three = five.left;
			three.parent = five;
			four = three.right;
			four.parent = three;
			A = three.left; //null
			B = four.left;  //null
			C = four.right; //null
			D = five.right; //null

			//build the correct tree:
			if(parentNode!= null)
			{
				if(parentleft) parentNode.left = four;
				else parentNode.right = four;
			} 
			else {
				root = four;
			}
			four.parent = parentNode;
			four.left = three;
			three.parent = four;
			four.right = five;
			five.parent = four;
			three.left = A;
			three.right = B;
			five.left = C;
			five.right = D;
			if(A!=null) A.parent = three;
			if(B!=null) B.parent = three;
			if(C!=null) C.parent = five;
			if(D!=null) D.parent = five;
		}
		//LL 
		else if(n.bal()==2 && n.left.bal()>=0)
		{
			//assignment:		
			five = n;
			parentNode = five.parent;  //null
			if(n.parent!=null) parentleft = five.parent.data>five.data;
			four = five.left;
			four.parent = five;
			three = four.left;
			three.parent = four;
			A = three.left; //null
			B = three.right;  //null
			C = four.right; //null
			D = five.right; //null	

			//build the correct tree:
			if(parentNode!=null) {
				if(parentleft) parentNode.left = four;
				else parentNode.right = four;
			}
			else {
				root = four;
			}
			four.parent = parentNode;
			four.left = three;
			three.parent = four;
			four.right = five;
			five.parent = four;
			three.left = A;
			three.right = B;
			five.left = C;
			five.right = D;
			if(A!=null) A.parent = three;
			if(B!=null) B.parent = three;
			if(C!=null) C.parent = five;
			if(D!=null) D.parent = five;
		}
		//RL Case:
		else if(n.bal()==-2 && n.right.bal()==1)
		{
			//assignment:		
			three = n;
			parentNode = three.parent;  //null
			if(n.parent!= null) parentleft = three.parent.data>three.data;
			five = three.right; 
			five.parent = three;
			four = five.left; 
			four.parent = five;
			A = three.left; //null
			B = four.left;  //null
			C = four.right; //null
			D = five.right; //null	

			//build the correct tree:
			if(n.parent!= null) {
				if(parentleft)  parentNode.left = four;
				else parentNode.right = four;
			}
			else root = four;
			four.parent = parentNode;
			four.left = three;
			three.parent = four;
			four.right = five;
			five.parent = four;
			three.left = A;
			three.right = B;
			five.left = C;
			five.right = D;
			if(A!=null) A.parent = three;
			if(B!=null) B.parent = three;
			if(C!=null) C.parent = five;
			if(D!=null) D.parent = five;
		}
		else //RR
		{
			//assignment:		
			three = n;
			parentNode = three.parent;  //null
			if(n.parent!= null) parentleft = three.parent.data>three.data;
			four = three.right; 
			four.parent = three;
			five = four.right;
			five.parent = four;
			A = three.left; //null
			B = four.left;  //null
			C = five.left; //null
			D = five.right; //null	

			//build the correct tree:
			if(n.parent!= null) {
				if(parentleft) parentNode.left = four;
				else parentNode.right = four;
			}
			else root = four;
			four.parent = parentNode;
			four.left = three;
			three.parent = four;
			four.right = five;
			five.parent = four;
			three.left = A;
			three.right = B;
			five.left = C;
			five.right = D;
			if(A!=null) A.parent = three;
			if(B!=null) B.parent = three;
			if(C!=null) C.parent = five;
			if(D!=null) D.parent = five;
		}//closest else
	}
}//class


class Node {
	char data;
	Node left;
	Node right;
	Node parent;

	public Node(char d) {
		data = d;
	}

	public int bal() {
		int leftweight = BinarySearchTree.howmanychildren(this.left);
		System.out.println(leftweight);
		int rightweight = BinarySearchTree.howmanychildren(this.right);
		System.out.println(rightweight);
		return leftweight-rightweight;
	}


	public String toString() {
		return ""+ data;
	}

	public void print() {
		BTreePrinter.printNode(this);
	}

}

/* from http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram */
class BTreePrinter {

	public static void printNode(Node root) {
		int maxLevel = BTreePrinter.maxLevel(root);
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinter.printWhitespaces(firstSpaces);

		List<Node> newNodes = new ArrayList<Node>();
		for (Node node : nodes) {
			if (node != null) {
				System.out.print(node.data);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			BTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BTreePrinter.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static int maxLevel(Node node) {
		if (node == null)
			return 0;

		return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}
}

