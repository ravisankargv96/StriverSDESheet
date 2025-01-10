package Solutions.Arrays;

public class SingleNumberV2 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }

}

