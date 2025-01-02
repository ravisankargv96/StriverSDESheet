package BinarySearch;

public class SearchInRotatedSortedArray {

    /**
     * BruteForce: Linear Search T.C. O(N); S.C. O(1)
     * Optimal: Binary Search T.C. O(logN); S.C. O(1)
     * */

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 3;

        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int pos = obj.search(nums,target);
        System.out.println(pos);
    }

    //BruteForce : LinearSearch O(N)
    public int search1(int[] nums, int target){

        int n = nums.length;
        for(int i = 0; i<n; i++){

            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    }

    //Modified Binary Search O(logN) -> Sol 1
    /**
     * based on the mid value there will be
     * left sorted region i.e. nums[l] <= nums[mid]
     *      with in range i.e. nums[l] <= target && target <= nums[mid] :-> converge to this region
     *      out of range
     * right sorted region i.e. nums[mid] <= nums[r]
     *      with in range i.e. nums[mid+1] <= target && target <= nums[r] :-> converge to this region
     *      out or range
     * return -1
     **/
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){

            int mid = low - (low - high)/2;

            if(nums[mid] == target){
                return mid;
            }


            if(nums[low] <= nums[mid]){ //leftSorted Region

                if(nums[low] <= target && target < nums[mid]){ //with in range
                    high = mid-1;
                } else{
                    low = mid+1; //out of range
                }

            } else{ // rightSorted Region

                if(nums[mid] < target && target <= nums[high]){ //with in range
                    low = mid+1;
                } else{
                    high = mid-1; //out of range
                }
            }
        }

        return -1; // no target found
    }

    //Modified BinarySearch Sol2 -> LoveBabbar's approach

    public int getPivot(int[] nums, int target){

        int n = nums.length;
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low - (low - high)/2;

            if(nums[0] <= nums[mid]){
                int rightEle = mid+1 < n ? nums[mid+1] : Integer.MIN_VALUE;

                if(nums[mid] < rightEle){
                    low = mid+1;
                } else{
                    return mid;
                }
            } else{
                high = mid - 1;
            }
        }

        return -1;
    }

    //BinarySearch for Asc
    //BinarySearch for Desc
}
