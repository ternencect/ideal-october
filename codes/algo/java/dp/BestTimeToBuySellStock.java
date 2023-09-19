package codes.algo.java.dp;

/**
 * <b>买卖股票的最佳时机</b>
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润
 * dp[i][0] 为第i天交易完手里没有股票的最大利润
 * dp[i][1] 为第i天交易完手里持有一支股票的最大利润
 * <p>
 * 状态转移方程：
 * <li>dp[i][0] = max {dp[i-1][0], dp[i-1][1]+prices[i]}</li>
 * <li>dp[i][1] = max {dp[i-1][1], dp[i-1][0]-prices[i]}</li>
 *
 * 初始状态，dp[0][0] = 0, dp[0][1] = -prices[0]
 */
public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    public int maxProfitComp(int[] prices) {
        int length = prices.length;
        int dp0 = 0, dp1= -prices[0];
        for (int i = 1; i < length; i++) {
            int temp0 = Math.max(dp0, dp1 + prices[i]);
            int temp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = temp0;
            dp1 = temp1;
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeToBuySellStock sellStock = new BestTimeToBuySellStock();
        int result = sellStock.maxProfit(prices);
        int resultComp = sellStock.maxProfitComp(prices);
        System.out.printf(String.valueOf(result));
        System.out.printf(String.valueOf(resultComp));
    }
}
