package Arrays2;

import java.util.*;

public class MergeSortedArrayWithoutExtraSpace {

    /**
     * 1. LeetCode Version of the Question, If arr1 has extra space to fit
     * 2. Striver Version, if arr doesn't have extra space to fit
     * */
    public void swap(int[] nums1, int i, int [] nums2, int j){
        int copy = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = copy;
    }

    public void sort(int[] nums2){
        int pivot = nums2[0];

        int i = 1;
        while(i < nums2.length && nums2[i] <= pivot){
            nums2[i-1] = nums2[i];
            i++;
        }
        nums2[i-1] = pivot;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        while(i < nums1.length - nums2.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                i++;
            } else{
                swap(nums1,i,nums2,j);
                i++;
                sort(nums2);
            }
        }

        for(j = 0; j < nums2.length; j++){
            nums1[i+j] = nums2[j];
        }
    }


    //2. if arr doesn't have extra space to fit

    /**
     * BruteForce T.C. O(N) S.C. O(N)
     * Applying MergingAlgo used in MergeSort
     */

    public void mergeStrvSol1(int[] arr1, int arr2[], int n, int m) {

        int arr3[] = new int[n + m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr3[k++] = arr1[i];
        }
        for (int i = 0; i < m; i++) {
            arr3[k++] = arr2[i];
        }
        Arrays.sort(arr3);
        k = 0;
        for (int i = 0; i < n; i++) {
            arr1[i] = arr3[k++];
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = arr3[k++];
        }

    }

    // Optimal Approach.
    public void mergeStrv(int[] arr1, int arr2[], int n, int m) {
        // code here
        int i, k;
        for (i = 0; i < n; i++) {
            // take first element from arr1
            // compare it with first element of second array
            // if condition match, then swap
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            // then sort the second array
            // put the element in its correct position
            // so that next cycle can swap elements correctly
            int first = arr2[0];
            // insertion sort is used here or //use bubble sort algo
            for (k = 1; k < m && arr2[k] < first; k++) {
                arr2[k - 1] = arr2[k];
            }
            arr2[k - 1] = first;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        MergeSortedArrayWithoutExtraSpace sol = new MergeSortedArrayWithoutExtraSpace();
        sol.merge(nums1,nums1.length,nums2,nums2.length);


        //2. Striver Version
        int arr1[] = {1,4,7,8,10};
        int arr2[] = {2,3,9};

        System.out.println("Before merge:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        sol.mergeStrv(arr1, arr2, arr1.length, arr2.length);

        System.out.println("After merge:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
