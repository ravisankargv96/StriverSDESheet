package Solutions.BinarySearch;

public class BitonicArray {

    // [Integer.MIN_VALUE]
    // [Integer.MIN_VALUE,Integer.MIN_VALUE+1]
    // are edge cases for this solution.

    public int findPeakElement(int[] arr){

        // given a bitonic array
        int low = 0;
        int high = arr.length-1;

        while(low <= high){

            // get the mid element
            int mid = low - (low - high)/2;

            // getting left & right element
            int leftEle = mid - 1 >= 0 ? arr[mid-1] : Integer.MIN_VALUE;
            int rightEle = mid + 1 < arr.length ? arr[mid+1] : Integer.MIN_VALUE;

            // based on leftEle, arr[mid], rightEle there will be only 3 slopes
            // increasing, peakpoint, decreasing slope

            if(leftEle < arr[mid] && arr[mid] < rightEle){

                //increasing slope
                low = mid + 1;
            } else if(leftEle < arr[mid] && arr[mid] > rightEle){

                //peak point
                return mid;
            } else {

                //decreasing slope
                high = mid - 1;
            }

        }

        //if it's bitonic array above binary search will be converged.

        return -1; //ideally this line shouldn't execute.
    }
}
