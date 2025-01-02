package Solutions.Arrays.Arrays1;

import java.util.*;

public class FourSum {

    public void twoPointer(int pi, int pj,int p, long target, int[] nums, List<List<Integer>> ans){
        int i = p;
        int j = nums.length-1;

        while(i < j){
            if((long)nums[i] + (long)nums[j] < target){
                while(i+1 < j && nums[i] == nums[i+1]){
                    i++;
                }
                i++;
            } else if((long)nums[i] + (long)nums[j] > target){
                while(j-1 > i && nums[j] == nums[j-1]){
                    j--;
                }
                j--;
            } else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[pi]);
                temp.add(nums[pj]);
                temp.add(nums[i]);
                temp.add(nums[j]);
                ans.add(temp);
                while(i+1 < j && nums[i] == nums[i+1]) i++;
                i++;
                while(j-1 > i && nums[j] == nums[j-1]) j--;
                j--;
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i< n; i++){

            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j< n; j++){

                if(j > i+1 && nums[j] == nums[j-1]) continue;

                long sum = (long)target - (long)nums[i] - (long)nums[j];
                twoPointer(i,j,j+1,sum,nums,ans);
            }
        }

        return ans;
    }

    public static void main (String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        FourSum sol = new FourSum();
        List<List<Integer>> ls = sol.fourSum(arr, target);
        //System.out.println("raj");
        for(int i = 0; i<ls.size(); i++) {

            for(int j = 0; j<ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
