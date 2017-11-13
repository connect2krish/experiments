package net.krishlogic.ds.linkedlist;

import net.krishlogic.ds.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList {

	public Node head;

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

	public void printAll(boolean newLine) {
		Node temp = head;
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
	}
}