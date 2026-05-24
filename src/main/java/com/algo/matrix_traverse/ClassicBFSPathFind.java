package com.algo.matrix_traverse;

import java.util.*;

/**
 * Обсуждение задачи с DeepSeek
 * <p>
 * https://chat.deepseek.com/a/chat/s/03620922-a636-44fb-8ef1-f9282d5b30aa
 * https://chat.deepseek.com/a/chat/s/7e0bec24-2848-47bb-a1ae-661ca49fce69
 * https://chat.deepseek.com/a/chat/s/2e71d42d-de16-4797-a156-413028ccbb98
 */
public class ClassicBFSPathFind {

    static class Point {
        int x, y;
        Point parent;

        Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
    }

    public List<int[]> findPath(int[][] grid, int startX, int startY, int targetValue) {
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Point point = new Point(startX, startY, null);

        queue.offer(point);
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            Point current = queue.poll();

            int x = current.x;
            int y = current.y;

            if(grid[x][y] == targetValue) {
                return reconstructPath(current);
            }

            for(int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if(newX >= 0 && newX < rows &&
                   newY >= 0 && newY < columns &&
                   grid[newX][newY] != 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new Point(newX, newY, current));
                }
            }
        }
        return Collections.emptyList();
    }

    private List<int[]> reconstructPath(Point point) {
        List<int[]> paths = new ArrayList<>();
        for(Point current = point; current != null; current = current.parent) {
            int x = current.x;
            int y = current.y;

            paths.add(new int[] {x, y});
        }
        Collections.reverse(paths);
        return paths;
    }
}
