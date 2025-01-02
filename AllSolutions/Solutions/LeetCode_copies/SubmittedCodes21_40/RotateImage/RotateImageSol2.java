package LeetCode_copies.SubmittedCodes21_40.RotateImage;

/**
 * Find the box starting at the diagonal and then rotate each group of four
 * elements in that box.
 *
 * Find each box's boundary. For example:
 * rowTop,  colRight,   rowBottom,  colLeft
 * 0,       n-1,        n-1,        0
 * 1,       n-1-1,      n-1-1,      1
 * 2,       n-1-2,      n-1-2,      2
 * ...
 * i,       n-1-i,      n-1-i,      i
 *
 * Now find the indexes and their destination index:
 * (i, j) will move to (j, n-1-i)
 * (j, n-1-i) will move to (n-1-i, n-1-j)
 * (n-1-i, n-1-j) will move to (n-i-j, i)
 * (n-i-j, i) will move to (i, j)
 *
 * Time Complexity: O(N^2) --> All cells are visited once.
 *
 * Space Complexity: O(1)
 *
 * N = Size of matrix.
 */

class RotateImageSol2 {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}