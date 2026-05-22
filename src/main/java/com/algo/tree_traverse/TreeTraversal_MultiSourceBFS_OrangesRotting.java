package com.algo.tree_traverse;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Беседа с DeepSeek по задаче
 *
 * https://chat.deepseek.com/a/chat/s/591651f8-edfd-42e9-9e8a-d3b81769fec6
 *
 * Поиск пути
 * https://chat.deepseek.com/a/chat/s/7e0bec24-2848-47bb-a1ae-661ca49fce69
 * https://chat.deepseek.com/a/chat/s/2e71d42d-de16-4797-a156-413028ccbb98
 * https://chat.deepseek.com/a/chat/s/d389c962-29f7-433e-b1e2-80719ef427c4
 */
public class TreeTraversal_MultiSourceBFS_OrangesRotting {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                if(grid[x][y] == 2) {
                    queue.offer(new int[] {x, y});
                } else if(grid[x][y] == 1) {
                    freshCount++;
                }
            }
        }

        while(!queue.isEmpty() && freshCount > 0) {
            Integer size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                int x = current[0];
                int y = current[1];

                for(int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if(newX >= 0 && newX < rows &&
                       newY >= 0 && newY < columns &&
                       grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshCount--;
                    }
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }
}
