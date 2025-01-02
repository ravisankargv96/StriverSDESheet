package Solutions.Patterns;

public class Pattern7 {

    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where 'N' is the given input integer.

         |0123
        -|----
        0|****
        1|*  *
        2|*  *
        3|****

    */

    // pattern21
    public static void getStarPattern(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    System.out.print('*');
                }
                else {
                    System.out.print(' ');
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        getStarPattern(4);
    }
}
