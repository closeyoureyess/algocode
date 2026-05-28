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
public class BackTracking_Permute_Subsets {

    // <- оставляем бектрекинг, убираем право построения пермутаций
    // и получаем в итоге построение подмножеств
    // (степень множества)
    // так для [1,2,3] получаем [], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]
    //
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            // ... <- правило построения дерева пермутаций
            // пропало - дерево строится как есть
            current.add(nums[i]); // <- добавление пути на месте
            backtrack(nums, i + 1, current, result); // <- рекурсия на месте
            current.removeLast(); // <- откат(бектрек) на месте
        }
    }
}
