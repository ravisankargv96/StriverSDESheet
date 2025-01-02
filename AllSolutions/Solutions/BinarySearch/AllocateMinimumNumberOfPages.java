package BinarySearch;

import java.util.ArrayList;

public class AllocateMinimumNumberOfPages {

    /**
     * BruteForce Approach: using Recursion (not writing the code)
     * Optimal Approach: BinarySearch (memorize the approach)
     * find the search Space of available partitions [max(bookPages), sum(bookPages)]
     * apply binarySearch to check what is the minimum value exists in above page ranges
     * to minimize burden on student
     * */
    public boolean isPossible(ArrayList<Integer> A, int barrier, int B){

        int pages = 0;
        int students = 1;

        for(int i = 0; i< A.size(); i++){
            if(A.get(i) > barrier){
                return false;
            }

            if(pages + A.get(i) > barrier){
                pages = 0;
                students++;
            } else{
                pages += A.get(i);
            }
        }

        if(students <= B){
            return true;
        }

        return false;
    }

    public int books(ArrayList<Integer> A, int B){
        if(B > A.size()){
            return -1;
        }

        int low = A.get(0);
        int high = 0;
        for(int i = 0; i< A.size(); i++){
            low = Math.max(low, A.get(i));
            high += A.get(i);
        }

        int ans = -1;
        while(low <= high){
            int mid = low - (low - high)/2;

            if(isPossible(A,mid, B)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();

        A.add(12);
        A.add(34);
        A.add(67);
        A.add(90);
        int B = 2;

        AllocateMinimumNumberOfPages obj = new AllocateMinimumNumberOfPages();
        System.out.println(obj.books(A,B));
    }
}
