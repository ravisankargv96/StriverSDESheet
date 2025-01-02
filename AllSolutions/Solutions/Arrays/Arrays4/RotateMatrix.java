package Arrays4;

public class RotateMatrix {
    /**
     * 1. BruteForce: Using ExtraSpace
     * T.C. O(N^2)
     * S.C. O(N^2)
     * 2. Optimized approach:
     * a. Transpose the matrix
     * b. Reverse each column
     * T.C. O(N^2)
     * S.C. O(1)
     * */

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

    }
}
