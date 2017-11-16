package net.krishlogic.ds.stack;

import java.util.Stack;

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

	public void printAll(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +", ");
		}
	}

	public void stockSpanProblem() {
		int[] price = new int[] {10, 4, 5, 90, 120, 80};
		int[] span = new int[price.length];
		int length = price.length;
		java.util.Stack<Integer> stack = new Stack<>();

		stack.push(0);
		span[0] = 1;

		for (int i=0; i<length; i++) {
			while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
				stack.pop();
			}

			span[i] = stack.isEmpty() ? i+1 : i - stack.peek();

			stack.push(i);
		}

		printAll(span);
	}

	public boolean isOpeningBracket(char c) {
		return c=='{' || c=='(' || c=='[';
	}

	public boolean isClosingBracket(char c) {
		return c=='}' || c==')' || c==']';
	}

	public boolean isMatchingPair(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
	}

	public boolean areParanthesisBalanced() {
		Stack<Character> stack = new Stack<>();
		char exp[] = {'{','(',')','}','[',']'};

		for (int i=0; i<exp.length; i++) {
			char c = exp[i];
			if (isOpeningBracket(c)) {
				stack.push(c);
			}

			if (isClosingBracket(c)) {

				if (!stack.isEmpty() && !isMatchingPair(stack.peek(), c)) {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		return stack.isEmpty();
	}

	public void nextGreaterElement() {
		int[] arr = new int[] {11, 13, 21, 3};
		Stack<Integer> stack = new Stack<>();
		int next = 0, element = 0;
		int[] resp = new int[arr.length];
		int count = 0;

		stack.push(arr[0]);
		for (int i=1; i<arr.length; i++) {
			next = arr[i];

			if (!stack.isEmpty()) {
				element = stack.pop();

				while (element < next) {
					resp[count] = next;
					count++;
					if (stack.isEmpty()) {
						break;
					}

					element = stack.pop();
				}

				if (element > next) {
					stack.push(element);
				}
			}

			stack.push(next);
		}

		while(!stack.isEmpty()) {
			resp[count] = -1;
			count++;
			stack.pop();
		}

		printAll(resp);

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
		stackExp.pop();
		System.out.println("isEmpty: " + stackExp.isEmpty());
		System.out.println("Stock span problem: "); stackExp.stockSpanProblem();
		System.out.println("\nare paranthesis balanced: " + stackExp.areParanthesisBalanced());
		System.out.println("\n Next Greater Element: "); stackExp.nextGreaterElement();
	}
}
