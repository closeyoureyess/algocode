package com.algo.backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Обсуждение с DeepSeek
 *
 * Что такое фибоначчи, как понять
 * https://chat.deepseek.com/a/chat/s/8d10726f-fdef-4ea1-a5e6-aa0454533977
 * Ключевое слово "А почему мы, наткнувшись на определенное число фибоначчи в кэше"
 *
 * Обсуждение в марте
 * https://chat.deepseek.com/a/chat/s/088c922b-bdeb-4550-b019-da5e8fc007c1
 */
public class BackTracking_Fibonacchi {

    // Три возможных решения, наивное через простую рекурсию
    // Решение через мемоизацию(дек + массив)
    // Решение через дек с map
    // + оптимальное без неявного дерева

    public static int fibStackSimple(int n) {
        if (n <= 1) {
            return n;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n; i > 1; i--) {
            stack.push(i);
        }
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            cache[current] = cache[current - 1] + cache[current - 2];
        }
        return cache[n];
    }

    public static long fib(int n) {
        if (n <= 1) return n;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
