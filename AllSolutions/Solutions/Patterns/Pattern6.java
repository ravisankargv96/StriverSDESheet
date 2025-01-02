package Solutions.Patterns;

public class Pattern6 {

    /*
    Time Complexity - O(N^2)
    Space Complexity - O(1)

    where N is the given input.

         |01234567
        -|--------
        0|1      1
        1|12    21
        2|123  321
        3|12344321

    */

    //pattern12
    public static void numberCrown(int n) {

        int num = 1, gap = (n - 1) * 2;
        for (int i = 0; i < n; i++) {

            int curr = 0;
            for (int j = 0; j < num; j++) {
                curr++;
                System.out.print(curr);
            }

            for (int j = 0; j < gap; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < num; j++) {
                System.out.print(curr);
                curr--;
            }

            System.out.print("\n");

            num++;
            gap -= 2;

        }
    }


    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where N is the given input integer.

         |0 1 2 3 4 5 6 7
        _|_ _ _ _ _ _ _ _
        0|* * * * * * * *
        1|* * *     * * *
        2|* *         * *
        3|*             *
        4|*             *
        5|* *         * *
        6|* * *     * * *
        7|* * * * * * * *

    */

    //pattern 19
    public static void symmetry(int n) {


        for(int i = 0; i < 2*n; i++) {

            for(int j = 0; j < 2*n; j++) {

                if(i < n && (j < (n - i) || j >= (n + i))) {
                    System.out.print("*");
                } else if(i >= n && (j <= (i - n) || j >= (2*n - i + n - 1))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

                System.out.print(" ");
            }

            System.out.print("\n");
        }
    }


    /*
    Time Complexity : O( N*N )
    Space complexity: O( N*N )

    Where N is the dimension of the square matrix.

         |0 1 2 3 4 5 6 7
        _|_ _ _ _ _ _ _ _
        0|*             *
        1|* *         * *
        2|* * *     * * *
        3|* * * * * * * *
        4|* * *     * * *
        5|* *         * *
        6|*             *

    */

    //pattern20
    public static void symmetryV2(int n) {


        for(int i = 0; i < 2*n-1; i++) {

            for(int j = 0; j < 2*n; j++) {

                if (i < n && (j <= i || j >= (2*n - i - 1))) {
                    System.out.print("*");
                } else if (i >= n && (j < (2*n - i - 1) || j > i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

                System.out.print(" ");
            }

            System.out.println();
        }
    }



    public static void main(String[] args) {
        numberCrown(4);
        symmetry(4);
        symmetryV2(4);
    }

}
