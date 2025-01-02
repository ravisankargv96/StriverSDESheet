package Solutions.Arrays.Arrays1;

import java.util.*;

// Memorize the Extended Moore's Algo
public class MajorityElementNBy3 {

    /*
    * BruteForce Solution with TC: O(n^2) SC: O(1)
    * */
    public static ArrayList< Integer > majorityElementSol1(int arr[], int n) {
        ArrayList < Integer > ans = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == arr[i])
                    cnt++;
            }

            if (cnt > (n / 3))
                ans.add(arr[i]);
        }

        return ans;
    }

    /*
     * HashMap Solution with TC: O(n) + SC: O(n)
     * */

    public static ArrayList < Integer > majorityElementSol2(int arr[], int n) {
        HashMap <Integer, Integer > mp = new HashMap < > ();
        ArrayList < Integer > ans = new ArrayList < > ();

        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        for (int x: mp.keySet()) {
            if (mp.get(x) > (n / 3))
                ans.add(x);
        }

        return ans;
    }

    /*
     * Boyer Moore's Voting Algo with TC: O(n) + SC: 1
     * Optimized Approach
     * */

    public static ArrayList < Integer > majorityElement(int[] nums, int n) {

        int number1 = -1, number2 = -1, count1 = 0, count2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
        }
        if (count1 > len / 3)
            ans.add(number1);
        if (count2 > len / 3)
            ans.add(number2);
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3, 2};
        ArrayList < Integer > majority = majorityElement(arr, 5);
        System.out.print("The majority element is: ");
        HashSet < Integer > s = new HashSet < > (majority);
        for (int it: s) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}
