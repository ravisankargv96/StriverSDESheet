package Solutions.BinarySearch;

public class SearchInsertPositionV2 {

    public int searchInsertPosition(int[] arr, int ele){

        /**
         * sorted array without duplicates
         * if ele is in array return it's position.
         * if not return where it should be inserted.
         */

        int pos = -1;

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){

            // get the mid element
            int mid = low-(low-high)/2;

            // comparing arr[mid] with element
            // <,>,=

            if(arr[mid] < ele){

                pos = mid;

                //move to higher region
                low = mid+1;
            } else if(arr[mid] > ele){
                //move to lower region
                high = mid-1;
            } else{

                return mid;
            }
        }

        return pos+1;
    }
}
