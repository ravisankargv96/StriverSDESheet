package StackAndQueueI;

import java.util.*;

class stack {
    Queue <Integer> q;

    stack(){
        q = new LinkedList<Integer>();
    }
    void push(int x) {
        q.add(x);
    }
    int pop() {

        // rotate n-1 elements in the queue
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }

        // remove the peek element
        return q.poll();
    }
    int peek() {

        // take the pop() operation
        int ele = pop();

        // insert the element into the queue
        q.add(ele);

        return ele;
    }
    int size() {
        return q.size();
    }
}

public class ImplementStackUsingQueue {
    public static void main(String[] args) {

        stack s = new stack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.peek());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.peek());
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}
