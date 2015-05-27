
public class LinkedList {
	/*
	 * Tester Code:
	 */
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add('f');
		l.add('b');
		l.add('e');
		l.add('c');
		l.add('q');
		l.add('d');
		l.print();
		l.bubblesort();
		l.print();
		l.insertionsort();
		l.print();
		}

	/*
	 * Linked List Code: 
	 */
	Node first;
	int size;

	public LinkedList() {
		first = new Node('0');
		size=1;
	}

	private Node get(int index, Node n) {
		if(index==0) return n;
		if(n.link==null) return null;
		return get(index-1, n.link);
	}

	public char get(int index) {
		return get(index+1,first).value;
	}

	public void set(char c, int index) {
		get(index, first).value=c;
	}

	public void add(char c) {
		Node last = get(size-1,first);
		Node yuka = new Node(c);
		last.link = yuka;
		yuka.linkprevious = last;
		size++;
	}

	void add(char c, int index) {
		Node p = get(index,first);
		Node t = p.link;
		t.linkprevious = p;
		Node dog = new Node(c);
		p.link = dog;
		p.link.link = t;
		dog.linkprevious = p;
		t.linkprevious.linkprevious = p;
	}

	char remove(int index) {
		Node p = get(index, first);
		Node t = p.link;
		t.linkprevious = p;
		p.link = p.link.link;
		p.link.linkprevious = p;
		return t.value;

	}

	/* 
	 * 1. print the list.
	 * ex. "a > b > c > d"
	 */
	void print() {
		Node temp = first;
		System.out.print(temp.value + ">");
		while(temp.link!= null) {
			temp = temp.link;
			System.out.print( temp.value + ">");
		}
		System.out.println("null");
	}

	/*
	 * 3. sort the list
	 */
	void bubblesort() {

		for(int j = size; j > 0; j--) {
			for (int i = 1; i < size-1; i++) {
				Node temp1 = get(i,first);
				Node temp2 = get(i, first).link;
				Node temp = temp1.linkprevious;
				Node temp3 = temp2.link;
				if(temp1.value > temp2.value) {
					if (temp != null) {
						temp.link = temp2;
						temp2.linkprevious = temp;
					} else
						temp2.linkprevious = null;

					temp2.link = temp1;
					temp1.linkprevious = temp2;

					if (temp3 != null) {
						temp3.linkprevious = temp1;
						temp1.link = temp3;
					} else 
						temp1.link = null;

				}
			}
		}
	}


	/*
	 * 2. modify the node to be doubly linked
	 * (you will need to do some work above, too)
	 */
	class Node {
		public Node(char c) {
			value = c;
		}

		char value;
		Node link;
		Node linkprevious;
	}


	/***
	 * 4. Bonus: Insertion(?) Sort 
	 * 
	 */
	void insertionsort() {
		for(int j = 1; j < size; j++) {
			for (int i = 1; i < j; i++) {

				Node temp1 = get(i,first);
				Node temp2 = get(i, first).link;
				Node temp = temp1.linkprevious;
				Node temp3 = temp2.link;

				if(temp2.value < temp1.value) {
					if (temp != null) {
						temp.link = temp2;
						temp2.linkprevious = temp;
					} else
						temp2.linkprevious = null;

					temp2.link = temp1;
					temp1.linkprevious = temp2;

				if (temp3 != null) {
						temp3.linkprevious = temp1;
						temp1.link = temp3;
					} else 
						temp1.link = null;
				}
			}		

		}
	}
}


