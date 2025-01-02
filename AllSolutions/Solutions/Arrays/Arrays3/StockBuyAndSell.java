package Arrays3;

// Memory Based approach,
// if you have seen this before

public class StockBuyAndSell {

    /**
     * 1. BruteForce: Getting all the possible combinations
     * 2. OptimalSolution:
     * a. use a minTracker
     * b. calculate profit at every point
     * c. Track each point for observing maxPrice
     * */
    public static int buyAndSellBruteForce(int[] prices){
        // get all the possible combinations
        int maxProfit = Integer.MIN_VALUE;

        int n = prices.length;
        for(int i = 0; i< n; i++){
            for(int j = i; j<n; j++){

                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit,profit);
            }
        }

        return maxProfit;
    }

    public static int buyAndSell(int[] prices){

        // idea is generate a minPriceTracker.
        // Such that you'll get Profit at each day prices[i]-minPriceTracker.

        // Track a pointer to get maximized profit.

        int minPriceTracker = Integer.MAX_VALUE;

        int maxProfit = Integer.MIN_VALUE;

        int n = prices.length;
        for(int i = 0; i<n; i++){
            minPriceTracker = Math.min(minPriceTracker,prices[i]);
            int profit = prices[i] - minPriceTracker;

            maxProfit = Math.max(maxProfit,profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        //int arr[] = new int[]{7,1,5,3,6,4};
        int arr[] = new int[]{7,6,5,4,3,2,1}; // edge case
        int maxProfit = buyAndSell(arr);
        System.out.println("Max profit is: " + maxProfit);
    }
}
