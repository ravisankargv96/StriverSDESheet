package BinarySearch;

public class SearchSingleElementInSortedArray {

    /**
     * BruteForce: using Xor T.C. O(N); S.C. O(1)
     * Optimal: BinarySearch T.C. O(logN); S.C. O(1)
     * */

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};

        SearchSingleElementInSortedArray obj = new SearchSingleElementInSortedArray();
        int pos = obj.search(nums);
        System.out.println(pos);
    }

    //Using Xor -> T.C. O(N); S.C. O(1)
    public int search1(int[] nums){

        int xor = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            xor ^= nums[i];
        }

        return xor;
    }

    //using Binary Search
    // Even-Odd Pair, single, Odd-Even Pair
    public int search(int[] nums){

        int n = nums.length;

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low - (low - high)/2;

            int leftElement = mid - 1 >= 0 ? nums[mid-1] : Integer.MIN_VALUE;
            int rightElement = mid+1 < n ? nums[mid+1] : Integer.MAX_VALUE;

            boolean isPair = ((nums[mid] == leftElement)^(nums[mid] == rightElement));

            if(!isPair){
                return mid;
            } else{
                boolean isEvenOdd = ((mid %2 == 0 && nums[mid] == rightElement) ||
                        (mid % 2 != 0 && leftElement == nums[mid]));

                if(isEvenOdd){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return -1;
    }
}
