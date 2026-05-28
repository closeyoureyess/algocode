package com.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Переписка с DeepSeek
 *
 * Ключевое слово для поиска - 525 / 736 Решебник. Backtracking_NQueens package ...;
 * https://chat.deepseek.com/a/chat/s/f0211a1d-576b-45d5-a840-a88c6b05ac85
 * https://chat.deepseek.com/a/chat/s/0dae16b7-38d5-40a2-8197-8a95c0db010a
 *
 * Разница между последовательностью, подмножеством, сочетанием, ключевое слово
 * "Множество против последовательности"
 * https://chat.deepseek.com/a/chat/s/d3bba7ea-3cef-4cff-8163-57cb1ce489be
 */
public class BackTracking_Permute {

    public List<List<Integer>> permute(int[] nums) {
        // 15
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
     }

    private void backtrack(
            int[] nums,
            List<Integer> current,
            boolean[] used,
            List<List<Integer>> result
    ) {
        if(current.size() == nums.length) {
            result.add(current);
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, used, result);
            used[i] = false;
            current.removeLast();
        }
    }
}
