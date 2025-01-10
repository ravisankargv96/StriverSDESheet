package Solutions.BinarySearch;

import java.util.*;

public class FirstandLastPosOfElementV3 {
    public static int lowerBound(ArrayList<Integer> arr,int n,int k){
        int ans = -1;

        int st = 0;
        int end = n-1;

        while(st <= end){
            int mid = st - (st-end)/2;
            if(arr.get(mid) == k){
                ans = mid;
                end = mid-1;
            } else if(arr.get(mid) > k){
                end = mid-1;
            } else{
                st = mid+1;
            }
        }
        return ans;
    }
    public static int upperBound(ArrayList<Integer> arr,int n,int k){
        int ans = -1;
        int st = 0;
        int end = n-1;

        while(st <= end){
            int mid = st - (st-end)/2;
            if(arr.get(mid) == k){
                ans = mid;
                st = mid+1;
            } else if (arr.get(mid) > k){
                end = mid-1;
            } else{
                st = mid+1;
            }
        }
        return ans;
    }
    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int[] res = new int[2];
        res[0] = lowerBound(arr,n,k);
        res[1] = upperBound(arr,n,k);
        return res;
    }

    public static void main(String[] args){
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        //{0,5,5,6,6,6}
//        arr.add(0);
//        arr.add(5);
//        arr.add(5);
//        arr.add(6);
//        arr.add(6);
//        arr.add(6);
//        int n = 6;
//        int k = 3;
//        int[] res = firstAndLastPosition(arr,n,k);
//        System.out.println(Arrays.asList(res));

        int[] arr = new int[]{0,1,0};
        for(int i = 1; i < arr.length-1; i++){

            if(arr[i-1] < arr[i] && arr[i] < arr[i+1]){
                System.out.println(i);
            }
        }

        System.out.println(-1);
    }
}
