package net.krishlogic.ds.linkedlist;

import net.krishlogic.ds.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList {

	public Node head;
	public Node headA;

	public void append(Node node) {
		Node temp = head;

		if (temp == null) {
			head = node;

			return;
		}

		while(temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;
	}

	private void printAll(Node node, boolean newLine) {
		Node temp = node;
		while(temp != null) {
			if(newLine) {
				System.out.println(temp.id);
			} else {
				System.out.print(temp.id + ",");
			}

			temp = temp.next;
		}

		System.out.println("");
	}

	public void printAll(Node node) {
		printAll(node, false);
	}

	public void printAll(boolean newLine) {
		printAll(head, newLine);
	}

	public void printAll() {
		printAll(false);
	}

	public void deleteNode(int id) {
		Node temp = head;

		if (temp!=null && temp.id == id) {
			head = head.next;

			return;
		}

		Node prev = null;
		while(temp != null && temp.id != id) {

			prev = temp;
			temp = temp.next;
		}

		if (temp !=null) {
			//delete the node
			prev.next = temp.next;
		}
	}

	public int getLength() {
		Node temp = head;
		int count = 0;

		while(temp != null) {
			temp = temp.next;

			count++;
		}

		return count;
	}

	public int getLength(Node node) {

		if (node == null) {
			return 0;
		}

		return 1 + getLength(node.next);
	}

	public boolean isExists(int id) {
		Node temp = head;
		while (temp != null) {
			if (temp.id == id) {
				return true;
			}
			temp = temp.next;
		}

		return false;
	}

	public boolean isExists(Node node, int id) {

		if (node == null) {
			return false;
		}

		if (node.id == id) {
			return true;
		}

		return isExists(node.next, id);
	}

	public void swapNodes(int x, int y) {
		Node currX = head;
		Node prevX = null;
		Node currY = head;
		Node prevY = null;

		if (x == y) return;

		if (currX == null || currY == null)
			return;

		while (currX != null && currX.id != x) {
			prevX = currX;
			currX = currX.next;
		}

		while(currY != null && currY.id != y) {
			prevY = currY;
			currY = currY.next;
		}

		if (prevX!=null) {
			prevX.next = currY;
		} else {
			head = currY;
		}

		if (prevY != null) {
			prevY.next = currX;
		} else {
			head = currX;
		}

		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;

		printAll(false);
	}

	public int getNthNode(int n) {

		Node temp = head;

		while(temp != null) {
			if (n==0) {
				return temp.id;
			}
			temp = temp.next;
			n--;
		}

		return -1;
	}

	public int getMiddleNodeID() {
		Node slow = head;
		Node fast = head;
		while(slow != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow.id;
	}

	public int getRepeatedCount(int id) {

		Node temp = head;
		int count = 0;
		while(temp !=null) {
			if (temp.id == id) {
				count++;
			}

			temp = temp.next;
		}

		return count;
	}

	public Node reverse() {
		Node curr = head;
		Node prev = null;
		Node next = null;

		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;

		return head;
	}

	public Node reverse(Node curr, Node prev) {
		if (curr.next == null) {
			head = curr;
			curr.next = prev;

			return null;
		}

		Node n1 = curr.next;
		curr.next = prev;

		reverse(n1, curr);

		return head;
	}

	public void printReverse(Node node) {

		if (node == null) {
			return;
		}

		printReverse(node.next);

		System.out.print(node.id + ",");
	}

	public Node mergeSortedLinkedList(Node l1, Node l2) {

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		if (l1.id >= l2.id) {
			l2.next = mergeSortedLinkedList(l1, l2.next);

			return l2;
		} else {
			l1.next = mergeSortedLinkedList(l1.next, l2);

			return l1;
		}
	}

	public void deleteList() {
		this.head = null;
	}

	public void resetList() {
		deleteList();

		Node node = new Node(10);
		Node node1 = new Node(20);
		Node node2 = new Node(30);
		Node node3 = new Node(40);
		Node node4 = new Node(50);
		Node node5 = new Node(60);
		Node node6 = new Node(70);

		append(node);
		append(node1);
		append(node2);
		append(node3);
		append(node4);
		append(node5);
		append(node6);
	}

	public boolean isPalindrome() {
		deleteList();
		append(new Node(10));
		append(new Node(20));
		append(new Node(30));
		append(new Node(20));
		append(new Node(10));

		Stack stack = new Stack();

		Node temp = head;

		while (temp != null) {
			stack.push(temp.id);
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			int id = (int) stack.pop();
			if (id != temp.id) {
				return false;
			}

			temp = temp.next;
		}

		return true;
	}

	public int getIntersection(Node n1, Node n2) {
		int count1 = getLength(n1);
		int count2 = getLength(n2);

		int d;
		int intersectionNodeValue;

		if (count1 > count2) {
			d = count1 - count2;
			intersectionNodeValue = getIntersectionNode(d, n1, n2);
		} else {
			d = count2 - count1;
			intersectionNodeValue = getIntersectionNode(d, n1, n2);
		}

		return intersectionNodeValue;
	}

	private int getIntersectionNode(int count, Node node1, Node node2) {

		for (int i=0; i<count; i++) {
			if (node1 == null) {
				return -1;
			}

			node1 = node1.next;
		}

		while (node1 != null && node2 != null) {
			if (node1.id == node2.id) {
				return node1.id;
			}

			node1 = node1.next;
			node2 = node2.next;
		}

		return -1;
	}

	public void removeDuplicatesSorted() {
		append( new Node(70));

		Node temp = head;
		Node nextNext;
		while (temp.next != null) {
			nextNext = temp.next.next;
			if (temp.next.id == nextNext.id) {
				System.out.println("removed duplicate: " + temp.next.id);
				temp.next = null;
				temp.next = nextNext;
			}

			temp = temp.next;
		}
	}

	public void removeDuplicatesUnSorted() {
		append(new Node(40));
		Set<Integer> hashSet = new HashSet<>();
		Node prev = null;
		Node curr = head;
		Node next;

		while (curr != null) {

			next = curr.next;

			if (hashSet.contains(curr.id)) {
				curr.next = null;
				curr = next;
				prev.next = curr;
			} else {
				hashSet.add(curr.id);
				prev = curr;
				curr = curr.next;
			}
		}

		printAll();
	}


	public void swapPairwise() {
		Node temp = head;

		System.out.println("before");
		printAll();

		while( temp!= null && temp.next != null) {

			int num = temp.id;
			temp.id = temp.next.id;
			temp.next.id = num;

			temp = temp.next.next;
		}

		printAll();
	}

	public void moveLastToFirst() {

		resetList();

		Node temp = head;
		Node last = null;
		Node secLast = null;
		while (temp.next != null) {
			last = temp.next;
			secLast = temp;

			temp = temp.next;
		}

		secLast.next = null;
		last.next =head;

		head = last;

		printAll();
	}

	public void sortedIntersection(Node head, Node head2) {
		Node response = null;
		Node temp = head;
		Node temp2 = head2;
		while (temp.next != null && temp2.next != null) {

			if (temp.id  == temp2.id) {
				response = append(response, new Node(temp2.id));
				temp = temp.next;
				temp2 = temp2.next;
			} else if (temp.id > temp2.id) {
				temp2 = temp2.next;
			} else {
				temp = temp.next;
			}
		}

		this.head = response;
		printAll();
	}

	public Node push(Node head, Node node) {
		node.next = null;
		if (head == null) {
			head = node;

			return head;
		}

		node.next = head;

		head = node;

		return head;
	}

	public Node append(Node node, Node nodeToAppend) {
		Node temp = node;

		if (temp == null) {
			node = nodeToAppend;

			return node;
		}

		while(temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;

		return temp;
	}

	public void deleteAlt() {

		if (head == null) {
			return;
		}

		Node prev = head;
		Node curr = head.next;

		while (prev !=null && curr != null) {
			prev.next = curr.next;
			curr = null;

			prev = prev.next;

			if (prev != null) {
				curr = prev.next;
			}
		}

		printAll();
	}

	public void altNodes() {
		Node temp = head;
		boolean flag = true;
		Node a = null;
		Node b = null;
		while (temp != null) {
			if (flag) {
				Node x = temp;
				x.next = null;
				a = append(a, x);
			} else {
				Node y = temp;
				y.next = null;
				b = append(b, y);
			}

			temp = temp.next;

			flag = !flag;
		}

		printReverse(a);
		printReverse(b);
	}

	public boolean areIdentical(Node n1, Node n2) {

		while (n1 != null && n2 != null) {
			if (n1.id != n2.id) {
				return false;
			}

			n1 = n1.next;
			n2 = n2.next;
		}

		return (n1 == null && n2 == null);
	}

	private Node getMiddleNode(Node node) {

		Node slowPtr = node;
		Node fastPtr = node.next;

		while(fastPtr != null) {
			fastPtr = fastPtr.next;
			if (fastPtr != null) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
		}

		return slowPtr;
	}

	private Node sortedMerge(Node left, Node right) {

		if (left == null) {
			return right;
		}

		if (right == null) {
			return left;
		}

		if (left.id <= right.id) {
			left.next = sortedMerge(left.next, right);

			return left;
		} else {
			right.next = sortedMerge(left, right.next);

			return right;
		}
	}

	public Node mergeSort(Node node) {

		if (node == null || node.next == null) {
			return node;
		}

		Node middle = getMiddleNode(node);
		Node postMiddle = middle.next;
		middle.next = null;

		Node left = mergeSort(node);
		Node right = mergeSort(postMiddle);

		Node sorted = sortedMerge(left, right);

		return sorted;
	}

	public Node reverse(Node node, int k) {

		Node prev; Node next;
		prev = next = null;
		Node curr = node;
		int count = 0;

		while (count <k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (next != null)
			node.next = reverse(next, k);

		return prev;
	}

	public Node reverseAlt(Node node, int k) {
		Node prev = null;
		Node next = null;
		Node curr = node;

		int count = 0;

		while(count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

			count++;
		}

		if (node != null) {
			node.next = curr;
		}

		count = 0;
		while (count < k-1 && curr != null) {
			curr = curr.next;
			count++;
		}

		if (curr != null) {
			curr.next = reverseAlt(curr.next, k);
		}

		return prev;
	}

	public void delLesserNodes() {

		Node prev, next, current;
		prev = next = null;
		current = head;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;

		current = head;

		int maxNodeId = current.id;
		Node temp;

		while (current != null && current.next != null) {
			if (maxNodeId > current.next.id) {
				temp = current.next;
				current.next = temp.next;
				temp = null;
			} else {
				current = current.next;
				maxNodeId = current.id;
			}
		}

		prev = next = null;
		current = head;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;

		printAll(prev);
	}

	public void detectAndRemoveLoop() {
		Set<Integer> visited = new HashSet<>();
		Node prev = null;
		Node current = head;
		while (current != null) {
			if (visited.contains(current.id)) {
				//loop found
				prev.next = null;

				break;
			} else {
				prev = current;
				current = current.next;
				visited.add(prev.id);
			}
		}

		printAll();
	}

	public void addTwoLL() {
		// creating first list
		Node head1 = new Node(7);
		head1.next = new Node(5);
		head1.next.next = new Node(9);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(6);

		head1 = reverse(head1, null);

		// creating seconnd list
		Node head2 = new Node(8);
		head2.next = new Node(4);

		head2 = reverse(head2, null);
		Node result;
		Node h1 = head1;
		Node h2 = head2;

		int num1 = 0;
		int num2 = 0;
		String numS1 ="";
		String numS2="";

		while (h1 != null) {
			numS1 = numS1+ h1.id;
			h1 = h1.next;
		}

		while (h2 != null) {
			numS2 = numS2+ h2.id;
			h2 = h2.next;
		}

		num1 = Integer.parseInt(numS1);
		num2 = Integer.parseInt(numS2);

		int sum = num1 + num2;
		System.out.println(num1 + " " + num2 + " " + sum);
		deleteList(); //local clear

		while (sum > 0) {
			int rem = sum % 10;
			sum = sum /10;
			append(new Node(rem));
		}

		printAll();
	}

	public void rotate(int k) {

		Node temp = head;

		while(k > 0) {

			Node prev = null;

			while (temp.next != null) {
				prev = temp;
				temp = temp.next;
			}

			prev.next = null;
			temp.next = head;

			head = temp;

			k--;
		}

		printAll();
	}


	public void findTriplet(Node n1, Node n2, Node n3, int tripSum) {
		Node h1 = n1;

		while(h1 != null) {
			Node h2 = n2;
			Node h3 = n3;
			while (h2 != null && h3 != null) {
				int sum = h1.id + h2.id + h3.id;

				if (sum == tripSum) {
					System.out.println("Triplet found: " + h1.id + " " + h2.id + " " + h3.id);
					return;
				}

				if (h2.id >= h3.id) {
					h3 = h3.next;
				} else {
					h2 = h2.next;
				}
			}

			h1 = h1.next;
		}
	}


	public void skipMDeleteNNodes(int m, int n) {

		Node temp = head;

		while (m>1 && temp != null) {
			temp = temp.next;
			m--;
		}

		if(temp == null) {
			return;
		}

		Node prev = temp;
		temp = temp.next;

		while (temp != null && n>0) {
			n--;
			Node t = temp.next;
			temp = null;
			prev.next = t;
			temp = t;
		}

		printAll();
	}

	public Node doInsertionSort() {

		Node current = head;
		headA = null;

		while (current!=null) {
			Node next = current.next;
			insertionSort(current);
			current = next;
		}

		printAll(headA);

		return headA;
	}

	public void insertionSort(Node node) {

		if (headA == null || headA.next.id >= node.id) {
			node.next = headA;
			headA = node;
		}
		Node temp = headA;
		while(temp.next != null && temp.next.id < node.id) {
			temp = temp.next;
		}

		Node x = temp.next;
		temp.next = node;
		node.next = x;
	}

	public void deleteLastOccurance(int key) {
		Node current = head;
		Node prev = null;
		while (current != null && current.next != null) {
			if (current.next.id == key) {
				prev = current;
			}
			current = current.next;
		}

		Node c = prev.next;
		Node n = c.next;

		prev.next = n;

		printAll();
	}


	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList();
		Node node = new Node(10);
		Node node1 = new Node(20);
		Node node2 = new Node(30);
		Node node3 = new Node(40);
		Node node4 = new Node(50);
		Node node5 = new Node(60);
		Node node6 = new Node(70);

		linkedList.append(node);
		linkedList.append(node1);
		linkedList.printAll();
		linkedList.deleteNode(20);
		linkedList.printAll(true);
		linkedList.append(node1);
		linkedList.append(node2);
		linkedList.append(node3);
		System.out.println(linkedList.getLength());
		System.out.println(linkedList.getLength(linkedList.head));
		System.out.println(linkedList.isExists(30));
		System.out.println(linkedList.isExists(linkedList.head, 30));
		linkedList.append(node4);
		linkedList.append(node5);
		linkedList.append(node6);

		linkedList.swapNodes(20, 50);
		System.out.println("Nth node: " + linkedList.getNthNode(3));
		linkedList.swapNodes(50, 20);
		System.out.println("middle node: " + linkedList.getMiddleNodeID());
		System.out.println("repeated count: " + linkedList.getRepeatedCount(20));
		System.out.println("reverse: "); linkedList.reverse(); linkedList.printAll();
		System.out.println("reverse back recursive: "); linkedList.reverse(linkedList.head, null); linkedList.printAll();

		Node head2;
		Node nodeA = new Node(5);
		Node nodeB = new Node(12);
		Node nodeC = new Node(30);
		head2 = nodeA;
		head2.next = nodeB;
		head2.next.next = nodeC;

		System.out.println("merge two sorted lined list: ");
		linkedList.head =linkedList.mergeSortedLinkedList(linkedList.head, head2);
		linkedList.printAll();

		System.out.println("isPalindrome :" + linkedList.isPalindrome());

		linkedList.resetList();

		Node nodeD = new Node(35);
		head2.next.next.next = nodeD;
		System.out.println("find intersection node: " + linkedList.getIntersection(linkedList.head, head2));
		System.out.println("print reverse: "); linkedList.printReverse(linkedList.head);
		System.out.println("remove duplicates: "); linkedList.removeDuplicatesSorted();
		linkedList.resetList();
		System.out.println("remove duplicates unsorted: "); linkedList.removeDuplicatesUnSorted();
		System.out.println("swapPairwise: "); linkedList.swapPairwise();
		System.out.println("move last to first : "); linkedList.moveLastToFirst();
		linkedList.resetList();
		Node nodeE = new Node(40);
		head2.next.next.next.next = nodeE;

		System.out.println("REVISIT: WRONG A intersection B: "); linkedList.sortedIntersection(linkedList.head, head2);
		linkedList.resetList();

		System.out.println("Delete Alt: "); linkedList.deleteAlt();
		System.out.println("REVISIT: Alt Nodes:"); //linkedList.altNodes();

		System.out.println("Identical LinkedList: " +  linkedList.areIdentical(linkedList.head, linkedList.head));

		linkedList.resetList();
		linkedList.append(new Node(22));
		linkedList.append(new Node(33));

		System.out.println("Merge sort a list: "); Node n = linkedList.mergeSort(linkedList.head);
		linkedList.printAll(n);
		linkedList.resetList();
		System.out.println("Reverse a list for a given sizeL : "); n = linkedList.reverse(linkedList.head, 2);
		linkedList.printAll(n);

		linkedList.resetList();
		System.out.println("Reverse alt K nodes:"); n = linkedList.reverseAlt(linkedList.head, 2);
		linkedList.printAll(n);
		linkedList.resetList();
		System.out.println("delete greater than on right side: "); linkedList.delLesserNodes();

		linkedList.deleteList();
		LinkedList list = new LinkedList();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		// Creating a loop for testing
		list.head.next.next.next.next.next = list.head.next.next;
		System.out.println("detect and remove loop: "); list.detectAndRemoveLoop();
		linkedList.deleteList();

		System.out.println("add two LL: "); linkedList.addTwoLL();
		linkedList.resetList();
		System.out.println("Rotate k times: "); linkedList.rotate(2);
		System.out.println("Linked List triplet sum: "); linkedList.findTriplet(linkedList.head, linkedList.head, linkedList.head, 100);
		linkedList.resetList();
		System.out.println("Skip M and deleteN nodes:"); linkedList.skipMDeleteNNodes(2, 2);

		//System.out.println("insertion sort: "); linkedList.doInsertionSort();
		linkedList.resetList();
		System.out.println("Delete last occurance "); linkedList.deleteLastOccurance(50);
	}
}