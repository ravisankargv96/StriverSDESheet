package Arrays4;

public class SearchInATwoDMatrix {

    /**1. SortedRowWise - rewrite the code O(log(m*n))
     * [[1,3,5,7],
     *  [10,11,16,20],
     *  [23,30,34,60]]
     * */
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n-1;

        while(low <= high){
            int mid = high - (high - low)/2;

            int row = mid/n;
            int col = mid % n;

            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] < target){
                low = mid+1;
            } else{
                high = mid - 1;
            }
        }

        return false;

    }

    /**
     * 2. Rows & columns areSorted, But is different from above
     * Complete the code of this version
     * Input:
     * matrix = [[1,  4,  7,  11, 15],
     *           [2,  5,  8,  12, 19],
     *           [3,  6,  9,  16, 22],
     *           [10, 13, 14, 17, 24],
     *           [18, 21, 23, 26, 30]]
     * target = 5
     * Output: true
     */

    public boolean searchMatrixII(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n-1;

        while(i < m && j >= 0){

            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] < target){
                i++;
            } else{
                j--;
            }
        }

        return false;
    }

}
