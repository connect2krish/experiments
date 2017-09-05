package net.krishlogic.ds.stack;

public class Stack {
    private static final int MAX_CAP = 100;
    int top;
    int[] intArr = new int[MAX_CAP];

    public Stack() {
        top = -1;
    }

    public void push(int value) {

        if (top > MAX_CAP) {
            throw new RuntimeException("Stack overflow");
        }

        intArr[++top] = value;
    }

    public int pop() {
        int value = intArr[top--];
        return value;
    }

    public int peek() {
        return intArr[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    private void printAll() {
        for (int i=top; i >= 0; i--) {
            System.out.println("poped: " + pop());
        }
    }

    public void printAll(boolean dry) {

        if (dry) {
            for(int i=0;i<=top;i++) {
                System.out.println("dry run: " + intArr[i]);
            }
        } else {
            printAll();
        }
    }


    public int evaluatePostfix(String expression) {

        char[] c = expression.toCharArray();

        for (char c1 : c) {

            System.out.println(c1);
            if (Character.isDigit(c1)) {

                push(c1-'0'); //'0' = 48 .. character value.(ascii)

            } else { //assuming this will be an operator:

                int value = response(c1);
                push(value);
            }
        }

        return pop();
    }

    private int response(Character c1) {
        int val1 = pop();
        int val2 = pop();
        switch (c1) {
            case '+' : {
                return val2 + val1;
            }

            case '-' : {
                return val2 - val1;
            }

            case '/': {
                return val2 / val1;
            }

            case '*': {
                return val2 * val1;
            }

            default: {
                return -1;
            }
        }
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("peeking:: " + stack.peek());
        stack.push(4);

        stack.printAll();

        System.out.println("isEmpty: " + stack.isEmpty());

        String expression = "231*+9-";

        stack.top = -1;

        int eval = stack.evaluatePostfix(expression);

        System.out.println("evaluated postfix: " + eval);
    }
}
