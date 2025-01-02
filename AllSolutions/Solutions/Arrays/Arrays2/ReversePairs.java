package Arrays2;

import java.util.*;

public class ReversePairs {
    /**
     * 1. BruteForce T.C. O(N^2) S.C. O(1)
     * 2. MergeSort T.C. O(N*logN) S.C. O(N)
     * */

    // 1. BruteForce
    public static int reversePairsSol1(int arr[]) {
        int Pairs = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2 * arr[j]) Pairs++;
            }
        }
        return Pairs;
    }

    //2. MergeSort
    public static int reversePairsSol2(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1;
        for(int i = low;i<=mid;i++) {
            while(j<=high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid+1));
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while(left <= mid && right<=high) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]);
            }
            else {
                temp.add(nums[right++]);
            }
        }

        while(left<=mid) {
            temp.add(nums[left++]);
        }
        while(right<=high) {
            temp.add(nums[right++]);
        }

        for(int i = low; i<=high;i++) {
            nums[i] = temp.get(i - low);
        }
        return cnt;
    }

    public static int mergeSort(int[] nums, int low, int high) {
        if(low>=high) return 0;
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid);
        inv += mergeSort(nums, mid+1, high);
        inv += merge(nums, low, mid, high);
        return inv;
    }


    public static void main(String args[])
    {
        int arr[]={1,3,2,3,1};
        System.out.println("The Total Reverse Pairs are "+ reversePairsSol1(arr));
    }
}


