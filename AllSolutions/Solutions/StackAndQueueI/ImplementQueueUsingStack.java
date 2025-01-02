package StackAndQueueI;

import java.util.*;

class MyQueue {
    Stack<Integer> st;
    Stack<Integer> auxSt;
    public MyQueue() {

        st = new Stack<Integer> ();
        auxSt = new Stack<Integer> ();
    }

    /** Making push operation O(n)
     * Such that stack pop() in queue format */
    public void push(int x) {

        // transfering the st -> auxSt
        while (st.empty() == false) {
            auxSt.push(st.peek());
            st.pop();
        }

        // Insert element in the st
        st.push(x);

        // transfering from auxSt -> st
        while (auxSt.empty() == false) {
            st.push(auxSt.peek());
            auxSt.pop();
        }

    }

    /** Pop() just like a regular queue.poll() */
    public int pop() {
        // shift input to output
        if (st.size() == 0) {
            System.out.println("Stack is empty");
            return -1;
        }

        int val = st.peek();
        st.pop();
        return val;
    }

    /** Get the front element. */
    public int peek() {
        // shift input to output
        if (st.size() == 0) {
            System.out.println("Stack is empty");
            return -1;
        }

        return st.peek();
    }


    int size() {
        return st.size();
    }
}


public class ImplementQueueUsingStack {
    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());

    }
}
