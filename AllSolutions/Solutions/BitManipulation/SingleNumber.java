package LeetCode60Questions.BitManipulation;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }

}

