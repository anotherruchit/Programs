package Arrays;

/**
 * Created by ruchitmehta on 9/5/17.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BuyAndSellStockI {
    public static void main(String args[]){
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * Time Complexity - O(n)
     *  Space Complexity - O(1)
     */
    public static int maxProfit(int[] prices){
        if(prices == null || prices.length == 0)
            return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
