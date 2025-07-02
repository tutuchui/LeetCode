package classisc;

//Leetcode 121
public class StockMaxPrice {
    public int maxProfit(int[] prices) {
        int start = 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[start]) {
                start = i;
            }
            if(prices[i] - prices[start] > profit){
                profit = prices[i] - prices[start];
            }
        }

        return profit;
    }
}
