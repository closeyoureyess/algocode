package com.algo.tree_traverse.theory_dfs_iterative;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Беседа с GPT по восстановлению информации об алгоритме
 *
 * https://chatgpt.com/g/g-p-6abbffb379108191868f27e7c2f19ece-algoritmy/c/6abc0088-45c0-83eb-8ff8-8bdd3bae3d1b?src=history_search
 */
public class Theory_DFS_Iterative_Maze {

    private static final int[][] DIRECTIONS = {{0, 1},
            {1, 0},
            {0,-1},
            {-1,0}};

    static public boolean pathExists(
            char[][] maze,
            int[] start,
            int[] end) {

        Deque<int[]> stack = new ArrayDeque<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        stack.push(start);
        visited[start[0]][start[1]] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.peek();

            boolean moved = false;
            for (int[] direction : DIRECTIONS) {
                int newX = current[0] + direction[0];
                int newY = current[1] + direction[1];

                if(isValidMove(maze, newX, newY, visited)) {
                    visited[newX][newY] = true;
                    stack.push(new int[] {newX, newY});
                    if (newX == end[0] && newY == end[1]) {
                        return true;
                    }
                    moved = true;
                    break;
                }
            }
            if (!moved) stack.pop();
        }
        return false;
    }

    // <- вспомогательный метод проверки возможности хода
    // (a) не вышли за пределы лабиринта
    // (b) не напоролись на препятствие
    // (c) не напоролись на уже посещенную клетку
    static boolean isValidMove(
            char[][] maze,
            int x,
            int y,
            boolean[][] visited) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length
                && maze[x][y] != '█' && !visited[x][y];
    }
}
