package Arrays4;

//Memorize this Algo
public class GridUniquePaths {
    /**
     * 1. Recursion
     * 2. Memoization
     * 3. BottomUp Solution
     * 4. Combination Solution
     * */
    //Recursion.
    public int countPaths(int i,int j,int n,int m)
    {
        if(i==(n-1)&&j==(m-1)){
            return 1;
        }
        if(i>=n||j>=m){
            return 0;
        }
        int left = countPaths(i+1,j,n,m);
        int right = countPaths(i,j+1,n,m);
        return left + right;
    }

    //BottomUp

    //Combination Solution
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        int r = m - 1;
        double res = 1;

        for (int i = 1; i <= r; i++)
            res = res * (N - r + i) / i;

        return (int)res;
    }

    public static void main(String[] args) {
        GridUniquePaths obj = new GridUniquePaths();
        int totalCount= obj.countPaths(0,0,3,7);
        System.out.println("The total number of Unique Paths are " + totalCount);
    }
}
