package Solutions.Recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateBalancedParenthesisV3 {

    public void generateParenthesis(int pos,int n, String st,
                                    int open,int close,
                                    List<String> ans){
        if(open == n && close == n){
            ans.add(st);
            return;
        }
        if(open > n || close > n || close > open){
            return;
        }

        this.generateParenthesis(pos+1,n,st + '(', open + 1, close,ans);
        this.generateParenthesis(pos+1,n,st + ')',open,close + 1,ans);
    }
    public void execute(){

        List<String> ans = new ArrayList<String>();
        this.generateParenthesis(0,20,"",0,0,ans);

        System.out.println(Arrays.toString(ans.toArray()));
    }
    public static void main(String[] args){
        GenerateBalancedParenthesisV3 generateBalancedParenthesis = new GenerateBalancedParenthesisV3();
        generateBalancedParenthesis.execute();
    }
}
