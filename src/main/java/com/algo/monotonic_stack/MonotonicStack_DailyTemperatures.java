package com.algo.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Беседа с GPT по Монотонному стеку https://chatgpt.com/c/69e1c88c-75d8-83eb-854b-24ee4ed3d5d6
 */
public class MonotonicStack_DailyTemperatures {

    public class SolutionRightToLeft {
        public int[] dailyTemperatures(int[] temperatures) {
            /*
            * Условие: дан массив температур temperatures.
              Для каждого дня нужно найти количество дней до более тёплой температуры.
              Если такой температуры нет, вернуть 0.
            * */
            int n = temperatures.length;
            int[] result = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return result;
        }
    }

    public class SolutionLeftToRight {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] result = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                int currentTemp = temperatures[i];
                while (!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                    int dayPrevIndex = stack.pop();
                    result[dayPrevIndex] = i - dayPrevIndex;
                }
                stack.push(i);
            }
            return result;
        }
    }
}