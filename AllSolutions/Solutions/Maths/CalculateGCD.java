package Solutions.Maths;


public class CalculateGCD {

    /*
    Time Complexity: O(a)

    Space Complexity: O(1)

    Where 'a' is minimum of 'n' and 'm'.
    */

    public static int calcGCD_BruteForce(int n, int m){
        int ans = 1;

        // Iterating through all integers from 1 to min(n,m) and
        // finding the greatest integer that divides both 'n' and 'm'.
        for (int i = 1; i <= Math.min(n, m); i++)
        {
            if (n % i == 0 && m % i == 0)
            {
                ans = i;
            }
        }
        return ans;
    }


    /*
    Time Complexity: O(log(a))

    Space Complexity: O(1)

    Where 'a' is minimum of 'n' and 'm'.
    */

    public static int calcGCD(int n, int m){
        if (m > n)
        {
            int temp = n;
            n = m;
            m = temp;
        }

        // Base case of gcd(n,0) = n.
        if (m == 0)
        {
            return n;
        }

        // Using Euclidean Theorem.
        return calcGCD(m, n % m);
    }

}