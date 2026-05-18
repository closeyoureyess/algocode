package com.algo.tree_traverse;

import java.util.*;

public class TreeTraversal_BFSLevel {


    /**
     * Беседа с DeepSeek по задаче
     * https://chat.deepseek.com/a/chat/s/502480e0-3555-404e-961f-a2883935b74f
     */
    // ========== 4. BFS с накоплением уровня ==========
    // Когда нужна информация о каждом уровне отдельно
    // Находит минимальную глубину, сохраняет структуру уровней
    public List<List<Integer>> bfsLevelByLevel(TreeNode root) {
        // 15
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Integer size = queue.size();

            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                currentLevel.add(current.val);

                if(current.left != null) {
                    queue.offer(current.left);
                }

                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;
    }
}
