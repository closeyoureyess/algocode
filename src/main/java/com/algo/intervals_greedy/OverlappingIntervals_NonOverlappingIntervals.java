package com.algo.intervals_greedy;

import java.util.Arrays;

/**
 * Беседа с DeepSeek по Greedy https://chat.deepseek.com/a/chat/s/fc6fa5f9-0790-420b-9a11-e0965655acbf
 *
 * Беседа с GPT по Greedy https://chatgpt.com/c/69e1c88c-75d8-83eb-854b-24ee4ed3d5d6
 */
public class OverlappingIntervals_NonOverlappingIntervals {

    public class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {

            /*
            * Условие: дан массив интервалов intervals, где intervals[i] = [starti, endi].
              Найти минимальное количество интервалов для удаления,
              чтобы оставшиеся интервалы не перекрывали
            * */

            if (intervals.length <= 1) {
                return 0;
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

            int count = 0;
            int end = intervals[0][1];

            for(int i = 1; i < intervals.length; i++) {
                int[] currentInterval = intervals[i];

                if (currentInterval[0] < end) {
                    count++;
                } else {
                    end = currentInterval[1];
                }
            }

            return count;
        }
    }
}
