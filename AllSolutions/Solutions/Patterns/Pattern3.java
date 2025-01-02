package Solutions.Patterns;

public class Pattern3 {

    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where 'N' is the input.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|* * * * *
        1|* * * *
        2|* * *
        3|* *
        4|*

    */

    //pattern5
    public static void pattern3(int n) {

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(j < (n-i))
                {
                    System.out.print("* ");
                }
            }
            System.out.print("\n");
        }
    }


    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where 'N' is the input.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|1 2 3 4 5
        1|1 2 3 4
        2|1 2 3
        3|1 2
        4|1

    */

    //pattern6
    public static void pattern3V2(int n) {

        for(int i = 0; i < n; i++)
        {
            int count = 1;
            for(int j = 0; j < n; j++)
            {
                if(j < (n-i))
                {
                    System.out.print(count + " ");
                    count++;
                }
            }
            System.out.print("\n");
        }
    }


    /*
    Time Complexity : O(N^2)
    Space complexity: O(1)

    Where 'N' is the input.

         |0 1 2 3 4
        _|_ _ _ _ _
        0|A B C D E
        1|A B C D
        2|A B C
        3|A B
        4|A

    */

    //pattern 15
    public static void pattern3V3(int n) {

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {

                char letter = (char)((int)'A' + j);
                if(j < (n-i))
                {
                    System.out.print(letter + " ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {

        System.out.println();
        pattern3(5);
        System.out.println();
        pattern3V2(5);
        System.out.println();
        pattern3V3(5);

    }

}
