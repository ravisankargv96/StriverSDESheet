package Solutions.Arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/description/

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length - 1;

        int dir = 1;

        while (top <= bottom && left <= right) {

            if(dir == 1){
                // Traverse Right
                for (int j = left; j <= right; j ++) {
                    res.add(matrix[top][j]);
                }
                top++;

                dir = 2;
            } else if (dir == 2) {

                // Traverse Down
                for (int j = top; j <= bottom; j ++) {
                    res.add(matrix[j][right]);
                }
                right--;

                dir = 3;
            } else if (dir == 3) {

                // Traverse Left
                for (int j = right; j >= left; j --) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;

                dir = 4;
            } else{

                // Traver Up
                for (int j = bottom; j >= top; j --) {
                    res.add(matrix[j][left]);
                }
                left ++;

                dir = 1;
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
