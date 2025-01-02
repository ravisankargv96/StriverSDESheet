package Solutions.Arrays;

class Solution {
    public void swap(int[] nums1, int i, int j){
        int temp = nums1[i];
        nums1[i] = nums1[j];
        nums1[j] = temp;
    }

    public void swap(int[] nums1, int i, int[] nums2, int j){
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }

    public void bubble(int[] nums){

        int n = nums.length;

        for(int j = 0; j < n-1; j++){
            if(nums[j] > nums[j+1]){
                swap(nums,j,j+1);
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n == 0){
            return;
        }

        for(int i = 0; i < m; i++){
            if(nums1[i] > nums2[0]){
                swap(nums1,i,nums2,0);
                bubble(nums2);
            }
        }

        for(int i = m; i < m+n; i++){
            nums1[i] = nums2[i-m];
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{0};
        int m = 0, n = 1;
        int[] nums2 = new int[]{1};

        s.merge(nums1,m,nums2,n);
    }
}
