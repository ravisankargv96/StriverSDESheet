package Solutions.Patterns;

public class Pattern1 {

    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where N is the given input.

        |0 1 2 3 4
       _|_ _ _ _ _
       0|* * * * *
       1|* * * * *
       2|* * * * *
       3|* * * * *
       4|* * * * *

    */

    //pattern1
    public static void pattern1(int n) {

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args){

        pattern1(5);
    }

}
