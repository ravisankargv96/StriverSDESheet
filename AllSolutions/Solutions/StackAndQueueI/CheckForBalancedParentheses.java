package StackAndQueueI;

import java.util.*;

public class CheckForBalancedParentheses {

    public static boolean isValid(String s) {

        int n = s.length();

        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i<n; i++) {

            char ch = s.charAt(i);

            // open brackets push to stack
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else {

                // instead of the 3 hardcode stuff we can use a hashMap
                // pop the elements in stack if closing braces matches with opening once
                if(st.size() > 0 &&
                        ((ch == ')' && st.peek() == '(') ||
                        (ch == ']' && st.peek() == '[') ||
                        (ch == '}' && st.peek() == '{'))){

                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.size() == 0;
    }

    public static void main (String[] args) {

        //String s="()[{}()]{"; //testcase 1

        //String s="()[{}()]}"; // testcase 2

        String s="()[{}()]"; // testcase 3
        if(isValid(s)){
            System.out.println("True");
        } else{
            System.out.println("False");
        }

    }

}
