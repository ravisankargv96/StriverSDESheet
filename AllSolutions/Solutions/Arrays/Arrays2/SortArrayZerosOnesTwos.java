package Arrays2;

import java.util.*;

//purely Algo based question.
// explain the insites of that algo
public class SortArrayZerosOnesTwos {
    /** Sort the given array using inbuilt sort
     * T.C. O(n*log(n))
     * S.C. O(1)
     * */
    public void sortBruteForce(int[] nums){
        Arrays.sort(nums);
    }

    /** As nums[i] are with bounded range([0,1,2]),
     * we can use countSort
     * T.C. O(n)
     * S.C. O(n)
     * */
    public void countSortBruteForce(int[] nums){
        int n = nums.length;

        int[] frequency = new int[n];

        for(int i = 0; i<n; i++){
            frequency[nums[i]]++;
        }

        int i = 0;

        for(int j = 0; j<3; j++){
            for(int k = frequency[j]; k >0; k--){
                nums[i] = j;
                i++;
            }
        }

    }

    /** DNF Sorting algo
     * */
    public void swap(int[] nums, int low, int high){
        int copy = nums[low];
        nums[low] = nums[high];
        nums[high] = copy;
    }

    public void sortZerosOnesAndTwos(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int mid = low;

        while(mid <= high){

            if(nums[mid] == 2){
                swap(nums,mid,high);
                high--;
            } else if (nums[mid] == 1) {
                mid++;
            } else{
                swap(nums,mid,low);
                low++;
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};

        SortArrayZerosOnesTwos obj = new SortArrayZerosOnesTwos();
        obj.sortZerosOnesAndTwos(nums);

        for(int i = 0; i<nums.length; i++){
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
}
