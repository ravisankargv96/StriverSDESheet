package SubmittedCodes;

public class MergeSort {
    public void merge(int[] nums,int start,int mid,int end){
        //array1 = nums[start:mid]
        //array2 = nums[mid+1:end]
        int[] temp = new int[end-start+1];

        int i = start, j = mid+1;
        int k = 0;

        while(i <= mid && j <= end){
            if(nums[i]<= nums[j]){
                temp[k] = nums[i];
                i++;
                k++;
            } else{
                temp[k] = nums[j];
                j++;
                k++;
            }
        }

        for(;i<= mid; i++){
            temp[k] = nums[i];
            k++;
        }

        for(;j<= end; j++){
            temp[k] = nums[j];
            k++;
        }

        //copying temp to nums array;
        for(k = start; k<= end; k++){
            nums[k] = temp[k-start];
        }
    }

    public void mergeSort(int[] nums,int start,int end){
        if(start < end){
            int mid = start - (start - end)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums,0,n-1);
        return nums;
    }
}
