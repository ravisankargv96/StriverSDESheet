package LeetCode60Questions.BinarySearch;

//The basic idea is from right corner, if the current number greater than target col - 1 in same row, else if the current number less than target, row + 1 in same column, finally if they are same, we find it, and return return.

public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
