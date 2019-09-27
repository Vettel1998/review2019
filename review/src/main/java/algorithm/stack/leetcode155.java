package algorithm.stack;

import java.util.Stack;

public class leetcode155 {
    public static void main(String[] args) {
        int i = 0;
        Integer integer = -1;
        System.out.println(i == integer);
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }

}


class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.empty()||x<=min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == min.peek())
            min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}