package com.algo.tree_traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Переписка с GPT
 * <p>
 * https://chatgpt.com/g/g-p-6abbffb379108191868f27e7c2f19ece-algoritmy/c/6abc0088-45c0-83eb-8ff8-8bdd3bae3d1b
 */
public class TreeTraversal_KhanTopological {

    // ========== 5. BFS с алгоритмом Кана ==========
    // Топологическая сортировка для DAG (Directed Acyclic Graph)
    // Обнаружение циклов через подсчет входящих рёбер
    // Время: O(V + E), Память: O(V)
    public List<Integer> topologicalSortKahn(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] req : prerequisites) {
            int course = req[0];
            int reqCourse = req[1];

            graph.get(reqCourse).add(course);
            inDegree[course]++;
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        int visitedCount = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            visitedCount++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (visitedCount != numCourses) {
            return new ArrayList<>();
        }
        return result;
    }
}
