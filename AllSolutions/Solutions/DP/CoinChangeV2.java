package Solutions.DP;

import java.util.*;

public class CoinChangeV2 {
//    This is similar to word break and perfect square
//
//    Permutations O(n^s), n is number of coins and s is the amount. Since we only need the min coins, so it is ok to visit a combination multiple times.
    public int coinChange(int[] coins, int amount) {
        if(amount<0) return -1;
        if(amount==0) return 0;
        int cc=-1;
        for(int i=0;i<coins.length;i++) {
            int coin=coinChange(coins, amount-coins[i]);
            if(coin>=0) cc=cc<0?coin+1:Math.min(cc,coin+1);
        }
        return cc;
    }

    public int coinChangeSol2(int[] coins, int amount) {
        Map<Integer,Integer> map=new HashMap<>();
        return coinChangeSol2(coins,amount,map);
    }
    private int coinChangeSol2(int[] coins, int amount, Map<Integer,Integer> mem ){
        if(amount<0) return -1;
        if(amount==0) return 0;
        Integer c=mem.get(amount);
        if(c!=null) return c;
        int cc=-1;
        for(int i=0;i<coins.length;i++) {
            int coin=coinChangeSol2(coins, amount-coins[i],mem);
            if(coin>=0) cc=cc<0?coin+1:Math.min(cc,coin+1);
        }
        mem.put(amount,cc);
        return cc;
    }

//    dp O(ns) pseudo polynomial. From #1, we can see that f(x)=min(1+f(x-ci))

    public int coinChangeSol3(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++)
            for(int c:coins)
                if(i>=c) dp[i]=Math.min(dp[i],dp[i-c]+1);
        return dp[amount]>amount?-1:dp[amount];
    }

//    BFS O(ns). The problem asks for fewest coins. It is natrual to think of BFS which guarantess shortest path.

    public int coinChangeSol4(int[] coins, int amount) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int cs = 0;
        boolean[] vstd = new boolean[amount+1];
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0;i<n;i++) {
                int sum = q.poll();
                if(sum==amount) {
                    return cs;
                }
                if(sum>amount || vstd[sum]) {
                    continue;
                }
                vstd[sum]=true;
                for(int coin:coins) {
                    q.add(sum+coin);
                }
            }
            cs++;
        }
        return -1;
    }
}
