package net.krishlogic.ds.linkedlist;

import net.krishlogic.ds.Node;

public class LinkedList {
	public Node head;
	
	public void insertAtTop(int id) {
		
		Node newNode = new Node(id);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAfter(Node prevNode, int id) {
		if (prevNode == null) {
			return;
		}
		
		Node newNode = new Node(id);
		
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
		
		while (temp != null && temp.id == key) {
			head = temp.next;
			return;
		}
		
		while (temp != null && temp.id != key) {
			prev = temp;
			temp = temp.next;
		}
		
		if (temp == null) {
			return;
		}
		
		prev.next = temp.next;
	}
	
	public void append(int id) {
		//create the node
		Node newNode = new Node(id);
		
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
			System.out.println("id: " + n.id);
			n = n.next;
		}
	}

	public int getCount() {
		int count = 0;
		Node n = head;

		while(n != null) {
			count++;
			n = n.next;
		}

		return count;
	}
	
	public void swap(int x, int y) {
		
		if (x == y) {
			return;
		}
		
		Node prev = null, currX = head;
		
		while (currX != null && currX.id != x) {
			
		}
		
	}
	
	public void swapNodes(int x, int y) {
		
	    // Nothing to do if x and y are same
        if (x == y) return;
 
        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.id != x)
        {
            prevX = currX;
            currX = currX.next;
        }
 
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.id != y)
        {
            prevY = currY;
            currY = currY.next;
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;		
	}

	public int getMidpoint() {
		if (head != null) {
			Node slowPtr = head;
			Node fastPtr = head;

			while (fastPtr != null && fastPtr.next != null) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next.next;
			}

			return slowPtr.id;
		}

		return -1;
	}
	
	public int getNth(int n) {
		
		Node ptr = head;
		int count = 0;
		
		if (head!=null) {
			while (ptr != null && ptr.next != null) {
				if (count == n) {
					return ptr.id;				
				}
				
				count++;
				ptr = ptr.next;
			}
		}
		
		return -1;
	}

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		
		list.head = new Node(1);
		list.insertAtTop(2);
		list.insertAfter(list.head, 5);
		list.append(7);
		list.append(8);
		list.append(9);
		list.append(10);
		list.printAll();
		System.out.println("count=" + list.getCount());
		System.out.println("mid point: " + list.getMidpoint());
		System.out.println("Get 4th: " + list.getNth(4));
		
		list.delete(2);
		list.printAll();
		System.out.println("count=" + list.getCount());

		list.deleteNodePosition(1);
		list.printAll();
		
		System.out.println("count=" + list.getCount());
		
		//x=5 and y=9 swap
		list.swapNodes(7, 9);
		list.printAll();
	}
}