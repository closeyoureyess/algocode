package com.algo.tree_traverse;

import com.sun.source.tree.WhileLoopTree;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal_BFSClassic {

    // ========== 3. BFS классический ==========
    // Поиск кратчайшего пути (в невзвешенном графе)
    // Поуровневая обработка
    // Время: O(V + E), Память: O(V)
    public void bfsClassic(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    // Для графа в виде списка смежности
    public void bfsClassic(int start, List<Integer>[] adjList) {
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer neighbor : adjList[current]) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    class TreeNode {

        TreeNode left;

        TreeNode right;
    }
}
