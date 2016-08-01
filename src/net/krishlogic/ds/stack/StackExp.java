package net.krishlogic.ds.stack;

public class StackExp {
	
	private String[] array;
	private int size=0;
	
	public StackExp(int capacity) {
		array = new String[capacity];
	}
	
	public void push(String value) {
		array[size++] = value;
	}
	
	public String pop() {
		String value = array[size-1];
		array[--size] = null;
		
		return value;
	}
	
	public String peek() {
		
		if(size == 0){
			throw new RuntimeException("peek exception");
		}
		
		return array[size-1];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void printAll() {
		for (int i=0; i < size; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		
		StackExp stackExp = new StackExp(10);
		
		stackExp.push("hello");
		stackExp.push("hi");
		stackExp.printAll();
		System.out.println("peek: " + stackExp.peek());
		System.out.println("isEmpty: " + stackExp.isEmpty());
		stackExp.pop();
		stackExp.printAll();		
	}
}
