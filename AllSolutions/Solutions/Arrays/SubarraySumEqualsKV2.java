package Solutions.Arrays;

import java.util.*;

public class SubarraySumEqualsKV2 {

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        //getting a prefix array
        int sum = 0;
        List<Integer> prefixSum = new ArrayList<Integer>();

        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            prefixSum.add(sum);
            if(sum == k){
                count++;
            }
        }

        Map<Integer,List<Integer>> hm = new HashMap<>();

        for(int i = 0; i<prefixSum.size(); i++){
            int a = prefixSum.get(i);
            int b = a - k;

            if(hm.containsKey(b)){
                count += hm.get(b).size();
            }

            if(!hm.containsKey(a)){
                hm.put(a,new ArrayList<>());
            }
            hm.get(a).add(i);
        }

        return count;

    }
}
