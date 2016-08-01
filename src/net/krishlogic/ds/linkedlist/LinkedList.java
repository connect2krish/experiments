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
	
	public void deleteNodePosition(int position) {
		
		if (head == null){
			return;
		}
		
		Node temp = head;
		
		if (position == 0) {
			head = temp.next;
			
			return;
		}
		
		for (int i=0; temp != null && i < position-1; i++) {
			temp = temp.next;
		}
		
		if (temp == null || temp.next == null) {
            return;			
		}
 		
		Node next = temp.next.next;
		 
        temp.next = next;		
	}
	
	public void delete(int key) {
		Node temp = head;
		Node prev = null;
		
		while (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		
		if (temp == null) {
			return;
		}
		
		prev.next = temp.next;
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
		
		list.delete(2);
		list.printAll();

		list.deleteNodePosition(1);
		list.printAll();
		
	}
}