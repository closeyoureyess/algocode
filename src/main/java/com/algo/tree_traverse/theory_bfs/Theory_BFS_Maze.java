package com.algo.tree_traverse.theory_bfs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * Беседа с GPT по восстановлению информации об алгоритме
 *
 * https://chatgpt.com/g/g-p-6abbffb379108191868f27e7c2f19ece-algoritmy/c/6abc0088-45c0-83eb-8ff8-8bdd3bae3d1b?src=history_search
 */
public class Theory_BFS_Maze {

    private static final int[][] DIRECTIONS = {{0,1},
            {1,0},
            {0,-1},
            {-1,0}};
    // результат с массивами стейтов:
//
    @Data
    @AllArgsConstructor
    static class PathFindResult {
        List<int[]> resultPath;
        Map<String, int[]> parents;
        Map<String, Integer> distances;
    }
    static public PathFindResult findShortestPath(
            char[][] maze,
            int[] start,
            int[] end) {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Map<String, int[]> parents = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();

        queue.offer(start);
        visited[start[0]][start[1]] = true;
        parents.put(start[0] + "," + start[1], null);
        distances.put(start[0] + "," + start[1], 0);

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            String currentKey = x + "," + y;
            if(x == end[0] && y == end[1]) {
                return new PathFindResult(reconstructPath(parents, end), parents, distances);
            }

            for (int[] direction : DIRECTIONS) {
                int newX = current[0] + direction[0];
                int newY = current[1] + direction[1];

                if (isValidMove(maze, newX, newY, visited)) {
                    String neighborKey = newX + "," + newY;
                    visited[newX][newY] = true;
                    parents.put(neighborKey, current);
                    distances.put(neighborKey, distances.get(currentKey) + 1);
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return new PathFindResult(Collections.emptyList(),
                Collections.emptyMap(),
                Collections.emptyMap()
        );
    }

    static List<int[]> reconstructPath(Map<String, int[]> parents, int[] end) {
        List<int[]> resultPath = new ArrayList<>();
        int[] current = end;

        while (current != null) {
            resultPath.add(0, current);
            current = parents.get(current[0] + "," + current[1]);
        }
        return resultPath;
    }

    static boolean isValidMove(
            char[][] maze,
            int x,
            int y,
            boolean[][] visited) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length
                && maze[x][y] != '█' && !visited[x][y];
    }
}
