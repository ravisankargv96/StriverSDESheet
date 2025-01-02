package SubmittedCodes21_40;

public class RotateImage {

    public void swap(int[] array, int i, int j){
        int iCopy = array[i];
        array[i] = array[j];
        array[j] = iCopy;
    }

    public void reverseArray(int[] array){

        int i = 0;
        int j = array.length - 1;

        while(i <= j){
            this.swap(array,i,j);
            i++;
            j--;
        }
    }

    public void reverseMatrix(int[][] matrix){

        for(int i = 0; i<matrix.length; i++){
            this.reverseArray(matrix[i]);
        }
    }

    public void transpose(int[][] matrix){

        for(int i = 0; i< matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){

                int Copy = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = Copy;
            }
        }
    }

    public void rotate(int[][] matrix) {

        this.transpose(matrix);
        this.reverseMatrix(matrix);

    }
}
