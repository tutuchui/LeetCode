//Leetcode 122
public class MaxProfit {
    public int maxProfit(int[] prices){
        if(prices.length <= 1){
            return 0;
        }
        int i = 0;
        int start = i;
        int end = 0;
        int profit = 0;
        while(start <= prices.length - 2){
            while(i + 1 < prices.length && prices[i+1] > prices[i]){
                i++;
            }
            end = i;
            if(start!=end){
                profit += prices[end] - prices[start];
            }
            i = end + 1;
            start = i;
        }
        return profit;
    }
}
