package Solutions;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Subsequence {

    public void generateSubsequence(int pos, String digit,
                                    String temp,List<String> ans){
        if(pos == digit.length()){
            ans.add(temp);
            return;
        }
        char c = digit.charAt(pos);
        this.generateSubsequence(pos+1,digit, temp + c,ans);
        this.generateSubsequence(pos+1,digit,temp,ans);
    }
    public void execute(){
        String digit = "1011";
        List<String> ans = new ArrayList<String>();
        this.generateSubsequence(0,digit,"",ans);

        System.out.println(Arrays.toString(ans.toArray()));
    }
    public static void main(String[] args){
        Subsequence subsequence = new Subsequence();
        subsequence.execute();
    }
}
