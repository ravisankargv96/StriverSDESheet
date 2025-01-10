package Solutions.BinarySearch;

public class SearchInRotatedSortedArrayV4 {
    public int pivotElement(int[] nums){
        int n = nums.length;
        int st = 0;
        int end = n-1;
        while(st <= end){
            int mid = st - (st - end)/2;

            if(nums[mid] >= nums[0]){

                int right = mid+1 < n ?
                        nums[mid+1]: Integer.MIN_VALUE;

                if(nums[mid-1] < nums[mid] &&
                        nums[mid] > right){
                    return mid;
                } else{
                    st = mid+1;
                }

            }else{
                end = mid -1;
            }
        }
        return n;
    }

    public int binarySearch(int[] nums,int st,int end,int target){
        while(st <= end){
            int mid = st - (st - end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target) {
                st = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {

        int n = nums.length;

        int pivotInd = pivotElement(nums);
        if(nums[0] <= target && target <= nums[pivotInd]){
            return binarySearch(nums,0,pivotInd,target);
        } else{
            return binarySearch(nums,pivotInd+1,n-1,target);
        }
    }

    public static void main(String[] args){
        SearchInRotatedSortedArrayV4 searchInRotatedSortedArray = new SearchInRotatedSortedArrayV4();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 3;
        int ans = searchInRotatedSortedArray.search(nums,target);
        System.out.println(ans);
    }
}
