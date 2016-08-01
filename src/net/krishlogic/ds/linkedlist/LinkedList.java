package net.krishlogic.ds.linkedlist;

public class LinkedList {
	public Node head;
	
	public void insertAtTop(int data) {
		
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAfter(Node prevNode, int data) {
		if (prevNode == null) {
			return;
		}
		
		Node newNode = new Node(data);
		
		newNode.next = prevNode.next;		
		prevNode.next = newNode;
		
	}
	
	public void append(int data) {
		//create the node
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = null;
		
		Node last = head;
		while (last.next != null) {
			last = last.next;		
		}
		
		last.next = newNode;
			
	}
	
	public void printAll() {
		Node n = head;
		
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		
		list.head = new Node(1);
		list.insertAtTop(2);
		list.insertAfter(list.head, 5);
		list.append(7);
		list.printAll();
	}
}