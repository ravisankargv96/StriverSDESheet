package Solutions.StackAndQueueI;

import java.util.*;

public class ValidParenthesesV2 {

    public boolean isValid(String s) {

        int n = s.length();
        char[] carray = s.toCharArray();
        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i<n; i++){

            if(carray[i] == '(' || carray[i] == '{' || carray[i] == '['){
                st.push(carray[i]);
            } else if (carray[i] == ')' && !st.isEmpty() && st.peek() == '('){
                st.pop();
            } else if (carray[i] == ']' && !st.isEmpty() && st.peek() == '['){
                st.pop();
            } else if (carray[i] == '}' && !st.isEmpty() && st.peek() == '{'){
                st.pop();
            } else{
                return false;
            }

        }

        return st.isEmpty();

    }
}
