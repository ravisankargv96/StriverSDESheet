package LeetCode_copies.SubmittedCodes21_40.RotateImage;

/**
 * Rotate the matrix on horizontal axis (swap rows) and then transpose to get
 * the result.
 *
 * Time Complexity:
 * O(N/2) -> for rotating along horizontal axis (swap rows). Only rows reference will be visited not the whole rows.
 * O(N*N - N) -> Transpose of the matrix. All elements will be visited once except the diagonal. Diagonal has N elements.
 *
 * Total time complexity = O(N/2 + N*N - N) ~ O(N^2)
 *
 * Space Complexity: O(1)
 *
 * N = Size of matrix.
 *
 * Note for anticlockwise, change the order. Transpose first and then rotate on
 * horizontal axis.
 */
class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;

        // Rotate the original matrix on horizontal axis. (swap rows)
        for (int i = 0; i < n / 2; i++) {
            int[] tempRow = matrix[i]; // Only reference will be saved
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tempRow;
        }

        // Transpose the rotated matrix
        for (int i = 0; i < n - 1; i++) { // Selecting a row
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
