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
public class BackTracking_Permute_Combine {

    // <- здесь мы из дерева подмножеств берём только «хвост» -
    // только те узлы, которые находятся на определённой глубине k
    // это и будут комбинации (подмножества фиксированного размера)
    //
    // в классической постановке задачи даётся не входной массив,
    // а две переменные - n и k
    // от нас требуют вернуть все возможные комбинации k чисел
    // в диапазоне [1, n] - но это, как мы понимаем, то же самое,
    // что рассматривали выше, просто:
    // n - это количество элементов
    // k - количество цифр в комбинации
    //
    // так, «дай все комбинации для nums={1,2,3}» превратится в:
    // дай решение для n=3 (у нас три элемента)
    // при этом k может быть разным
    //
    // combine(3, 0) -> [[]] // 1 комбинация
    // combine(3, 1) -> [[1], [2], [3]] // 3 комбинации
    // combine(3, 2) -> [[1,2], [1,3], [2,3]] // 3 комбинации
    // combine(3, 3) -> [[1,2,3]] // 1 комбинация
    //
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {
        // <- добавляем только при достижении нужного размера
        //
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return; // <- так как дальше будем только увеличивать размер
        }
        for (int i = start; i <= n; i++) {
            current.add(i); // <- добавляем элемент
            backtrack(n, k, i + 1, current, result); // <- идем глубже
            current.removeLast(); // <- откат
        }
    }
}
