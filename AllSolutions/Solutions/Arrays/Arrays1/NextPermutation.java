package Solutions.Arrays.Arrays1;

//Purely Algo based question.
// take the insites while explaining algo clearly.

/**
 * 1. ignoring the descending sequence (sequence may contain rep or nonrep no.)
 *    by stopping ith pointer at lesser No. in the sequence
 * 2. find the nextGreater element in the descending sequence
 * 3. swapping the ith & jth number
 *    inshort we have replaced the ith number with next Greater digit available to its right;
 * 4. making the right side of i to the ascending sequence, (since it's the shortest number sequence)
 * */

public class NextPermutation {

    public void swap(int[] arr, int low, int high){
        int copy = arr[low];
        arr[low] = arr[high];
        arr[high] = copy;
    }
    public void reverse(int[] arr, int low, int high){
        while(low <= high){
            swap(arr,low,high);
            low++;
            high--;
        }
    }

    public void nextPermutation(int[] nums){
        // ignoring the descending sequence (sequence may contain rep or nonrep no.)
        // stopping ith pointer at ascending sequence
        int n = nums.length;

        int i = nums.length-2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i == -1){
            reverse(nums,i+1,n-1);
        } else{

            // find the nextGreater element in the descending sequence
            int j = n-1;
            while(nums[j] <= nums[i]){
                j--;
            }

            //swapping the ith & jth number
            swap(nums,i,j);

            // inshort we have replaced the ith number with next Greater digit available to its right;
            // making the right side one to the ascending sequence, since it's the shortest number
            reverse(nums,i+1,n-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,4,3};

        NextPermutation obj = new NextPermutation();
        obj.nextPermutation(nums);

        for(int i = 0; i<nums.length; i++){
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
}
