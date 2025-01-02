package Solutions.Patterns;

public class Pattern2 {

    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where N is the given input.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|*
        1|* *
        2|* * *
        3|* * * *
        4|* * * * *

    */

    //pattern2
    public static void pattern2(int n) {

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where N is the given input.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|1
        1|1 2
        2|1 2 3
        3|1 2 3 4
        4|1 2 3 4 5

    */

    //pattern3
    public static void pattern2V2(int n) {

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print((j + 1) + " ");
            }
            System.out.print("\n");
        }
    }


    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where N is the given input.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|1
        1|2 2
        2|3 3 3
        3|4 4 4 4
        4|5 5 5 5 5

    */

    //pattern4
    public static void pattern2V3(int n) {

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print((i + 1) + " ");
            }
            System.out.print("\n");
        }
    }

    /*
    Time Complexity : O(N*N)
    Space complexity: O(1)

    Where N is the dimension of the square matrix.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|1
        1|2 3
        2|4 5 6
        3|7 8 9 10
        4|11 12 13 14 15

    */

    //pattern13
    public static void pattern2V4(int n) {

        int curr = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print(curr + " ");
                curr++;
            }

            System.out.print("\n");
        }
    }


    /*
    Time Complexity : O(N*N)
    Space complexity: O(1)

    Where N is the dimension of the square matrix.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|A
        1|A B
        2|A B C
        3|A B C D
        4|A B C D E

    */

    //pattern14
    public static void nLetterTriangle(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {

                char letter = (char)((int)'A' + j);
                System.out.print(letter + " ");

            }

            System.out.print("\n");
        }
    }

    /*
    Time Complexity : O(N*N)
    Space complexity: O(1)

    Where N is the dimension of the square matrix.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|A
        1|B B
        2|C C C
        3|D D D D
        4|E E E E E

    */

    //pattern16
    public static void nLetterTriangleV2(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {

                char letter = (char)((int)'A' + i);
                System.out.print(letter + " ");

            }

            System.out.print("\n");
        }
    }

    /*
    Time Complexity : O(N*N)
    Space complexity: O(1)

    Where N is the dimension of the square matrix.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|E
        1|D E
        2|C D E
        3|B C D E
        4|A B C D E

    */

    //pattern18
    public static void nLetterTriangleV3(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {

                char letter = (char)((int)'A' + (n - 1) - i + j);
                System.out.print(letter + " ");

            }

            System.out.print("\n");
        }
    }


    /*
    Time Complexity - O(N^2)
    Space Complexity - O(1)

    where N is the given input.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|1
        1|0 1
        2|1 0 1
        3|0 1 0 1
        4|1 0 1 0 1

    */

    //pattern11
    public static void nBinaryTriangle(int n) {

        int num = 1;
        for (int i = 0; i < n; i++) {

            int curr = 0;
            for (int j = 0; j < num; j++) {
                curr = (i + j) % 2 == 0 ? 1 : 0;
                System.out.print(curr + " ");
            }

            System.out.print("\n");
            num++;
        }
    }

    public static void main(String[] args) {

        System.out.println();

        pattern2(5);

        System.out.println();

        pattern2V2(5);

        System.out.println();

        pattern2V3(5);

        System.out.println();

        pattern2V4(5);

        System.out.println();

        nLetterTriangle(5);

        System.out.println();

        nLetterTriangleV2(5);

        System.out.println();

        nLetterTriangleV3(5);

        System.out.println();

        nBinaryTriangle(5);
    }
}
