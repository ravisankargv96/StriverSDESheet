package Arrays4;

import java.util.*;

// Memory Based Solution. Only strike if you memorize the approach to solve this.

public class SetMatrixZeroes {

    /** setZeroesBruteForce
     * T.C. O(n^2 * O(2*N)) = O(N^3)
     * S.C. No extra space, Implicit conversion
     * Note: we can even maintain same time complexity with O(n^2) S.C.
     * */
    public static void setZeroesBruteForce(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {

                    // making nonzero elements of corresponding cols & rows as -1
                    // as to prevent loss of data

                    // traversing upper rows of jth col
                    int ind = i - 1;
                    while (ind >= 0) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind--;
                    }

                    // traversing lower rows of jth col
                    ind = i + 1;
                    while (ind < rows) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind++;
                    }

                    // traversing left cols of ith row
                    ind = j - 1;
                    while (ind >= 0) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind--;
                    }

                    // traversing right cols of ith row
                    ind = j + 1;
                    while (ind < cols) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind++;
                    }
                }
            }
        }

        // making -1 as 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] <= 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /** Acceptable solution (Learn this)
     * T.C. O(n^2)
     * S.C. O(N)
     * */
    public static void setZeroesSol1(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int rows[]=new int[m];
        int cols[]=new int[n];

        Arrays.fill(rows,-1);
        Arrays.fill(cols,-1);

        //particular ith row & jth col are flagged
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }

        }

        //If any i,j cell is flagged at either ith row or jth col,
        // making that cell as zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 0 || cols[j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /** Getting wrong solution Understand the code later.
     * T.C. O(n^2)
     * S.C. O(1) no extraspace is taken
     * */
    public static void setZeroesSol2(int[][] matrix){
        int col0 = 1;
        int m = matrix.length;
        int n = matrix[0].length;

        // taking the firstRow itself as rows array
        // taking the firstCol itself as cols array.
        // we need a separate track of col0 Since it'll merge with row[0] i.e. col0 + cols -> columns array

        // skipping col0 and performing iteration on mX(n-1) cols
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){

                if(j == 0){
                    if(matrix[i][j] == 0){
                        col0 = 0;
                        matrix[i][0] = 0;
                    }
                }else{

                    if(matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        // traversing from backwards
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--){
                if(j == 0){
                    if(col0 == 0){
                        matrix[i][j] = 0;
                    }
                }else{
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        //setZeroesBruteForce(arr);
        setZeroesSol1(arr);
        //setZeroesSol2(arr);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
