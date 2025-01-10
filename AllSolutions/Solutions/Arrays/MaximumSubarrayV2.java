package Solutions.Arrays;

public class MaximumSubarrayV2 {
    public int maxSubArray(int[] nums) {
        int sum = 0 ;
        int prev_max = nums[0] ;

        for(int i = 0 ; i<nums.length ; i++){
            sum+=nums[i];
            if(sum>prev_max){
                prev_max=sum;
            }
            if(sum<0){
                sum=0 ;
            }
        }
        return prev_max ;
    }
}
