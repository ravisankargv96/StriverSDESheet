package Solutions.Patterns;

public class Pattern5 {

    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where N is the given input integer.

         |01234
        -|-----
        0|*
        1|**
        2|***
        3|****
        4|*****
        5|****
        6|***
        7|**
        8|*

    */

    //pattern10
    public static void rightStarTriangle(int n) {

        int stars = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
            stars ++;
        }
        stars = n - 1;
        for (int i = n; i < 2 * n - 1; i++) {

            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
            stars --;
        }
    }

    public static void main(String[] args) {
        rightStarTriangle(5);
    }

}
