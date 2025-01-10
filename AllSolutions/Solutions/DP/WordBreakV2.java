package Solutions.DP;

import java.util.*;

//Recursion, Average O(2^n)
//T(n) = T(n-1)+T(n-2)+...+T(1)
//=> T(n+1) = T(n)+T(n-1)+T(n-2)+...+T(1)
//=>T(n+1) = 2T(n)

//java is more expensive due to use of substring

public class WordBreakV2 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(0, s, new HashSet(wordDict));
    }

    private boolean wordBreak(int p, String s, Set<String> dict) {
        int n = s.length();
        if (p == n) {
            return true;
        }
        for (int i = p + 1; i <= n; i++) {
            if (dict.contains(s.substring(p, i)) && wordBreak(i, s, dict)) {
                return true;
            }
        }
        return false;
    }


//DFS with Memoization. There is redundancy in #1. A substr may be checked multiple times. We can cache the result by memoization. This is the optimal solution.


    Boolean[] mem;

    public boolean wordBreaksol2(String s, List<String> wordDict) {
        mem = new Boolean[s.length()];
        return wordBreak(0, s, new HashSet<String>(wordDict));
    }

    private boolean wordBreaksol2(int p, String s, Set<String> dict) {
        int n = s.length();
        if (p == n) {
            return true;
        }
        if (mem[p] != null) {
            return mem[p];
        }
        for (int i = p + 1; i <= n; i++) {
            if (dict.contains(s.substring(p, i)) && wordBreak(i, s, dict)) {
                return mem[p] = true;
            }
        }
        return mem[p] = false;
    }

//  dp. For dp problems, many times we go into iterative dp directly without even thinking about dfs. This is a great example showing that dfs is better than dp. DFS returns as soon as it finds one way to break the word while dp computes if each substring starting/ending at i is breakable. The test cases of this problem do not show it but it is shown in a similar problem Concatenated Words.
    public boolean wordBreaksol3(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[n]=true;
        Set<String> dict=new HashSet(wordDict);
        for(int i=n-1;i>=0;i--) {
            for(int j=i+1;!dp[i] && j<=n;j++) {
                dp[i] = dp[j] & dict.contains(s.substring(i,j));
            }
        }
        return dp[0];
    }
}