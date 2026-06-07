package com.algo.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming_0_ClimbingStairs {

    public class Solution {
        public int climbStairs(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) { // <- строим кеш по формуле
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n]; // <- берем из кеша
        }
    }
    public class SolutionRecursive {
        public int climbStairs(int n) {
            Map<Integer, Integer> memo = new HashMap<>();
            return climbStairsRecursive(n, memo);
        }
        private int climbStairsRecursive(int n, Map<Integer, Integer> memo) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            if (memo.containsKey(n)) {
                return memo.get(n);
            }
            // <- по сути как фибоначи
            //
            int result = climbStairsRecursive(n - 1, memo) + climbStairsRecursive(n - 2, memo);
            memo.put(n, result);
            return result;
        }
    }
    // <- очень быстро, но вся логика скрыта за трюками
    //
    public class SolutionOptimization {
        public int climbStairs(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            int first = 1; // <- способы для i-1
            int second = 2; // <- способы для i-2
            int result = 0;
            for (int i = 3; i <= n; i++) {
                result = first + second;
                first = second; // <- сдвигаем first
                second = result; // <- сдвигаем second
            }
            return result;
        }
    }

}
