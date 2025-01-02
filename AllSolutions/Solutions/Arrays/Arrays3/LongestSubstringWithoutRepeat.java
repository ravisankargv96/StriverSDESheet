package Arrays3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    /**
     * 1. BruteForce: forEach Substring, track the nonRepeated ones Length;
     * 2. Optimized Approach : TwoPointer OneFollowing the other.
     * */

    public static int solveSol1(String str) {

        if(str.length()==0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++)
        {
            Set< Character > se = new HashSet< >();
            for (int j = i; j < str.length(); j++) // forEach substring
            {
                if (se.contains(str.charAt(j))) // Tracking the NonRepeatedOnes.
                {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(str.charAt(j));
            }
        }
        return maxans;
    }

    //2. Optimal Approach
    public static int solve(String s) {
        HashMap < Character, Integer > mpp = new HashMap< Character, Integer >();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))){
                left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            }

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }




    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest " +
                "substring without repeating " +
                "characters is " + solve(str));

    }
}
