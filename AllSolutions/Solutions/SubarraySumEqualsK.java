package Solutions;

import java.util.*;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int count = 0;
        List<Integer> prefixSum = new ArrayList<Integer>();
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            prefixSum.add(sum);
            if(sum == k){
                count++;
            }
        }

        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0; i<prefixSum.size(); i++){
            int a = nums[i];
            int b = a - k;
            if(hm.containsKey(b)){
                count += hm.get(b).size();
            }
            if(!hm.containsKey(a)){
                hm.put(a,new ArrayList<Integer>());
            }
            hm.get(a).add(i);
        }

        return count;

    }

    public static void main(String[] args){
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int[] nums = new int[]{1,1,1};
        int k = 2;
        subarraySumEqualsK.subarraySum(nums,k);
    }

}
