package Solutions.Patterns;

public class Pattern8 {

    /*
    Time complexity: O(N^2)
    Space complexity: O(1)

    Where 'N' is the input integer.

         |0123456
        -|-------
        0|4444444
        1|4333334
        2|4322234
        3|4321234
        4|4322234
        5|4333334
        6|4444444

    */


    //pattern22
    public static void getNumberPattern(int n) {

        for (int i = 0; i < (2*n - 1); i++) {

            for (int j = 0; j < (2*n - 1); j++) {

                int x = Math.abs(i - n + 1);
                int y = Math.abs(j - n + 1);
                int currCell = (int)Math.max(x, y) + 1;
                System.out.print(currCell);
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        getNumberPattern(4);
    }
}
