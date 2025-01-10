package Solutions.Arrays;

import java.util.*;

public class LargestNumberV2 {

    public String largestNumber(int[] num){

        String[] NUM = new String[num.length];

        for(int i = 0; i<num.length; i++){
            NUM[i] = String.valueOf(num[i]);
        }


        Arrays.sort(NUM, new Comparator<String>() {
            @Override
            public int compare(String left, String right) {

                String leftRight = left + right;
                String rightLeft = right + left;

                return rightLeft.compareTo(leftRight);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < NUM.length; i++){
            sb.append(NUM[i]);
        }

        //if string is like "0000" -> result = 0;

        java.math.BigInteger result = new java.math.BigInteger(sb.toString());

        return result.toString();
    }

    public static void main(String[] args) {

    }
}
