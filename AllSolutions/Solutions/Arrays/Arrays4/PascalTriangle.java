package Arrays4;

import java.util.*;

// Memory Based approach.
// Only canable to solve easily if you have hardcoded stuff that needs to be taken care of.
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // adding first row & second row hardcodedly
        if(numRows > 0){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            res.add(temp);
        }
        if(numRows > 1){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            temp.add(1);
            res.add(temp);
        }

        // from third row it follows logic
        for (int i = 2; i < numRows; i++) {

            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    row.add(1);
                } else {
                    row.add(res.get(i-1).get(j - 1) + res.get(i-1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> ans = generate(numRows);

        System.out.println("Solution is: \n");

        int m = ans.size();

        for(int i = 0; i<m; i++){
            for(int j = 0; j< ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j));
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
