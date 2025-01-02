package SubmittedCodes;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;
        int n = s.length();
        int max = 0;

        HashSet<Character> hs = new HashSet<>();

        while(j <n){
            if(!hs.contains(s.charAt(j))){
                hs.add(s.charAt(j));
                max = Math.max(hs.size(),max);
                j++;
            } else {
                hs.remove(s.charAt(i));
                i++;
            }
        }

        return max;

    }
}
