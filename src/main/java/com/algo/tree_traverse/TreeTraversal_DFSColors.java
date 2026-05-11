package com.algo.tree_traverse;

/**
 * Беседа с DeepSeek по BFS, DFS
 * https://chat.deepseek.com/a/chat/s/df968469-24f5-49d7-ad98-fc221c3c9777
 *
 * https://chat.deepseek.com/a/chat/s/9882c89d-743a-4b8e-830f-fa7ed7e48c9d
 */
public class TreeTraversal_DFSColors {

    public boolean dfsColor(Node[] graph) {
       int[] color = new int[graph.length];

       for(int i = 0; i < graph.length; i++) {
           if(color[i] == 0) {
               if(dfs(graph, i, color)) {
                   return true;
               }
           }
       }

       return false;
    }

    public boolean dfs(Node[] graph, int node, int[] color) {
        color[node] = 1;

        for(Node neighbor : graph[node].neighbors) {
            if(color[neighbor.val] == 0) {
                if(dfs(graph, neighbor.val, color)) {
                    return true;
                }
            } else if(color[neighbor.val] == 1) {
                return true;
            }
        }

        color[node] = 2;
        return false;
    }

    class Node {
        int val; // Номер ноды в графе

        Node[] neighbors; // Соседи
    }
}
