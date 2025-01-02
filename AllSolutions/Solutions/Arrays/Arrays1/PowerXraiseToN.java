package Solutions.Arrays.Solutions.Arrays.Arrays1;

// Memorize the Algo
public class PowerXraiseToN {
    /**
     * BruteForce
     * */
    public static double myPowSol1(double x, int n) {
        double ans = 1.0;
        for(int i = 0; i<n; i++){
            ans = ans * x;
        }
        return ans;
    }

    /**
     * Best Approach, using BinaryExponentiation;
     * Understand the mathematical formulae
     * x^n = {
     *          x^(n/2) * x^(n/2)       if n is even,
     *          x^(n/2) * x^(n/2) * x   if n is odd,
     *          1                       if n is 0
     *       }
     * */

    // use the recursion Code here
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / power(x, -n);
        } else if (n % 2 == 0) {
            double temp = power(x, n / 2);
            return temp * temp;
        } else {
            return x * power(x, n - 1);
        }
    }

    // Iterative Code
    public static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0) nn = -1 * nn;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0) ans = (double)(1.0) / (double)(ans);
        return ans;
    }


    public static void main(String args[])
    {
        System.out.println(myPow(2,10));
    }
}
