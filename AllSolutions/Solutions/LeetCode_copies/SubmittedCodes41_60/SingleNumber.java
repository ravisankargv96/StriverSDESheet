package LeetCode_copies.SubmittedCodes41_60;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }

}

