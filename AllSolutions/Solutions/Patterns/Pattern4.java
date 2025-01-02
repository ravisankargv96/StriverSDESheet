package Solutions.Patterns;

public class Pattern4 {

    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where 'N' is the given input integer.

         |012345678
        -|---------
        0|    *
        1|   ***
        2|  *****
        3| *******
        4|*********

    */

    //pattern7
    public static void pattern4(int n) {

        int gap = n - 1, stars = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < gap; j++) {
                System.out.print(' ');
            }
            for (int j = gap ; j < gap + stars; j++) {
                System.out.print('*');
            }

            System.out.print("\n");

            gap--;
            stars += 2;

        }
    }


    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where 'N' is the given input integer.

         |012345678
        -|---------
        0|    A
        1|   BBB
        2|  CCCCC
        3| DDDDDDD
        4|EEEEEEEEE

    */

    public static void pattern4V4(int n) {

        int count = 0;
        int gap = n - 1;
        int stars = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < gap; j++) {
                System.out.print(' ');
            }
            for (int j = gap ; j < gap + stars; j++) {
                char ch = (char)((int)'A' + count);
                System.out.print(ch);
            }

            System.out.print("\n");

            gap--;
            stars += 2;
            count++;

        }
    }


    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where 'N' is the given input integer.

         |012345678
        -|---------
        0|*********
        1| *******
        2|  *****
        3|   ***
        4|    *

    */

    //pattern8
    public static void pattern4V2(int n) {

        int gap = 0, stars = 2 * n - 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < gap; j++) {
                System.out.print(' ');
            }
            for (int j = gap ; j < gap + stars; j++) {
                System.out.print('*');
            }

            gap++;
            stars -= 2;
            System.out.print("\n");

        }
    }


    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where 'N' is the given input integer.

         |012345678
        -|---------
        0|    *
        1|   ***
        2|  *****
        3| *******
        4|*********
        5|*********
        6| *******
        7|  *****
        8|   ***
        9|    *

    */

    //pattern9
    public static void pattern4V3(int n) {
        pattern4(n);
        pattern4V2(n);
    }

    public static void main(String[] args) {

        pattern4(5);
        pattern4V2(5);
        pattern4V3(5);
        pattern4V4(5);

    }
}
