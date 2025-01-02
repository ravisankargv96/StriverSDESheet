package BinarySearch;

public class SearchInBitonicArray {
    public static void main(String[] args) {
        SearchInBitonicArray obj = new SearchInBitonicArray();
        int[] arr = new int[]{1,2,3,1};
        int target = 2;
        int peakInd = obj.findPeakElement(arr);
        int pos = obj.search(arr,target,0,peakInd,true);
        if(pos != -1){
            System.out.println(pos);
        } else{
            System.out.println(obj.search(arr,target,peakInd + 1, arr.length-1, false));
        }
    }

    public int search(int[] arr, int target, int low, int high, boolean isAsc){

        while (low <= high){

            int mid = low - (low - high)/2;

            if(arr[mid] == target){
                return mid;
            } else if((arr[mid] < target && isAsc) || (arr[mid] > target && !isAsc)){
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }

    public int findPeakElement(int[] arr) {

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

            if(leftEle <= arr[mid] && arr[mid] < rightEle){

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

        return 0; //ideally this line shouldn't execute.

    }
}
