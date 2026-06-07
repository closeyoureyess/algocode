package com.algo.dynamic_programming;

import java.util.Arrays;

/**
 * https://chat.deepseek.com/a/chat/s/4f9abd9c-522e-47db-a9ae-9360a0cc9bd2
 */
public class DynamicProgramming_a_CoinChange {

    public int coinChange(int[] coins, int amount) {
        // 15
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int sum = 1; sum <= amount; sum++) {
            for(int coin : coins) {
                if(coin <= amount) {
                    dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
