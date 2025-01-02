package DynamicProgramming;

import java.util.*;

public class WordBreak {

    /** BruteForce approach checking all possible partiontions and confirming
     * either one of the partitions is present in wordDict or not
     * */
    public boolean wordBreakSol1(String s, int pos, List<String> ans, HashSet<String> wordDict){

        if(pos == s.length()){

            for(int i = 0; i<ans.size(); i++){
                if(!wordDict.contains(ans.get(i))){
                    return false;
                }
            }
            return true;
        }

        for(int i = 0; i<s.length(); i++){
            String str = s.substring(i,i+1);
            ans.add(str);

            boolean depth = wordBreakSol1(s,pos+1,ans,wordDict);
            if(depth){
                return true;
            }

            ans.remove(ans.size()-1);
        }
        return false;
    }

    /** Pruning the function tree for some function calls if given substring is not present in the wordDict
     * But however we are calculating same subproblem here more and more times
     * i.e. s(1,8) = s(1,2) + s(3,8)
     * s(3,8)= s(3,6) + s(6,8)
     * Using DP we can solve this problem effectively.
     * */
    public boolean wordBreakSol2(String s, int pos, HashSet<String> wordDict){

        if(pos == s.length()){
            return true;
        }

        for(int i = 0; i<s.length(); i++){

            String str = s.substring(i,i+1);
            if(wordDict.contains(str)){

                boolean depth = wordBreakSol2(s,i+1,wordDict);

                if(depth){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean wordBreakSol3(String s, int pos, HashSet<String> wordDict,
                                 int[] dp){

        if(dp[pos] != -1){
            return dp[pos] == 1;
        }

        if(pos == s.length()){
            dp[pos] = 1;
            return dp[pos] == 1;

        }

        for(int i = pos; i < s.length(); i++){
            String substr = s.substring(pos,i+1);
            if(wordDict.contains(substr)){

                boolean depth = wordBreakSol3(s,i+1,wordDict,dp);
                if(depth){
                    dp[pos] = 1;
                    return dp[pos] == 1;
                }
            }
        }
        dp[pos] = 0;
        return dp[pos] == 1;

    }

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> words = new HashSet<String>();
        for(int i = 0; i<wordDict.size(); i++){
            words.add(wordDict.get(i));
        }

        int[] dp = new int[s.length()+1];
        for(int i = 0; i<s.length()+1; i++){
            dp[i] = -1;
        }

        return wordBreakSol3(s,0,words,dp);
    }
}
