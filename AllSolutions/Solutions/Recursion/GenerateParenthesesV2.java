package Solutions.Recursion;

import java.util.*;

public class GenerateParenthesesV2 {
    public void parenthesis(int n,String state,
                            int open, int close,List<String> res){

        if(open > n){
            return;
        }

        if(open == n && close == n){
            res.add(state);
            return;
        }

        if(close > open){
            return;
        }

        this.parenthesis(n,state+'(',open+1,close,res);
        this.parenthesis(n,state+')',open,close+1,res);
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<String>();
        String state = "";
        this.parenthesis(n,state,0,0,res);
        return res;
    }
}

