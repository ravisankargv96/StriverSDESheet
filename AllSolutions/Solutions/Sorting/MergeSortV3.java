package Solutions.Sorting;

class MergeSortV3 {
    public void merging(int[] nums, int low, int mid, int high,int[] cnt){

        int[] temp = new int[high-low+1];

        int i = low;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= high){
            if(nums[i] <= nums[j]){
                temp[k] = nums[i];
                k++;
                i++;
            } else{
                cnt[0] = (nums[i] > 2 * nums[j]) ? (cnt[0] + (mid - i + 1)) : cnt[0];
                temp[k] = nums[j];
                k++;
                j++;
            }
        }

        while(i <= mid){
            temp[k] = nums[i];
            i++;
            k++;
        }

        while(j <= high){
            temp[k] = nums[j];
            j++;
            k++;
        }

        for(k = 0; k<temp.length; k++){
            nums[low+k] = temp[k];
        }
    }

    public void mergeSort(int[] nums, int low, int high, int[] cnt){
        if(low >= high){
            return;
        }

        int mid = low - (low - high)/2;
        mergeSort(nums,low,mid,cnt);
        mergeSort(nums,mid+1,high,cnt);
        merging(nums,low,mid,high,cnt);
    }

    public int reversePairs(int[] nums) {

        int[] cnt = new int[0];
        mergeSort(nums,0,nums.length-1,cnt);
        return cnt[0];
    }
}