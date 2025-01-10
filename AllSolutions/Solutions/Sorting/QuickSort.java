package Solutions.Sorting;

import java.util.*;

public class QuickSort {

    public static int partition2(int[] arr, int low, int high){
        // Not sure about this partition algo
        int pivot = arr[high];

        int i = low;
        int j = high;
        while(i < j){

            while(arr[i] <= pivot){
                i++;
            }
            while(arr[j] >= pivot){
                j--;
            }

            if(i < j){
                //swapping arr[i] and arr[j]
                int iCopy = arr[i];
                arr[i] = arr[j];
                arr[j] = iCopy;
            }
        }
        return 0;
    }
    public static int partition(int[] arr,int low, int high){
        int pivot = arr[high];

        int i = -1;
        for(int j = 0; j < high; j++){

            if(arr[j] < pivot){
                i++;
                //swaping i & j
                int iCopy = arr[i];
                arr[i] = arr[j];
                arr[j] = iCopy;
            }
        }
        //try to write swapping in a function
        // swapping pivot with arr[i+1]
        int iPlus1Copy = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = iPlus1Copy;
        return i+1;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int pi = partition(arr,low,high);
        quickSort(arr,low,pi-1);
        quickSort(arr,pi+1,high);
    }

    public static void main(String[] args){
        int[] arr = new int[]{10,80,30,90,40,50,70};
        int low = 0;
        int high = arr.length -1;
        quickSort(arr,low,high);
        System.out.println(Arrays.toString(arr));
    }
}
