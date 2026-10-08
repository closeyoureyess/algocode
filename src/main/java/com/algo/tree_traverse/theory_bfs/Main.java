package com.algo.tree_traverse.theory_bfs;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        check1();
        check2();
        check3();
        check4();
    }

    // Решение существует — вариант A
    static void check1() {
        Theory_BFS_Maze bfs = new Theory_BFS_Maze();

        var mazeWithSolutionA = new char[][] {
                {'S', '.', '.', '█', '.', '.', '.'},
                {'.', '█', '.', '█', '.', '█', '.'},
                {'.', '█', '.', '.', '.', '█', '.'},
                {'█', '█', '█', '.', '█', '█', '.'},
                {'.', '.', '.', '.', '.', '.', 'E'}
        };

        var maze = mazeWithSolutionA;
        var start = findPosition(maze, 'S');
        var end = findPosition(maze, 'E');

        var result = bfs.findShortestPath(maze, start, end);

        System.out.println("CHECK 1: Solution A");
        printMazeWithPath(maze, result.getResultPath());
        System.out.println("distances: " + result.getDistances());
        System.out.println();
    }

    // Решение существует — вариант B
    static void check2() {
        Theory_BFS_Maze bfs = new Theory_BFS_Maze();

        var mazeWithSolutionB = new char[][] {
                {'S', '.', '.', '█', '.', '.', '.'},
                {'.', '█', '.', '█', '.', '█', '.'},
                {'.', '█', '.', '.', '.', '█', '.'},
                {'█', '█', '█', '.', '█', '█', '.'},
                {'.', '.', '.', '.', '.', '█', 'E'}
        };

        var maze = mazeWithSolutionB;
        var start = findPosition(maze, 'S');
        var end = findPosition(maze, 'E');

        var result = bfs.findShortestPath(maze, start, end);

        System.out.println("CHECK 2: Solution B");
        printMazeWithPath(maze, result.getResultPath());
        System.out.println("distances: " + result.getDistances());
        System.out.println();
    }

    // Решения нет — вариант A
    static void check3() {
        Theory_BFS_Maze bfs = new Theory_BFS_Maze();

        var mazeWithNoSolutionsA = new char[][] {
                {'S', '.', '.', '█', '.', '█', '.'},
                {'.', '█', '.', '█', '.', '█', '.'},
                {'.', '█', '.', '.', '.', '█', '.'},
                {'█', '█', '█', '.', '█', '█', '.'},
                {'.', '.', '.', '.', '.', '█', 'E'}
        };

        var maze = mazeWithNoSolutionsA;
        var start = findPosition(maze, 'S');
        var end = findPosition(maze, 'E');

        var result = bfs.findShortestPath(maze, start, end);

        System.out.println("CHECK 3: No Solution A");
        printMazeWithPath(maze, result.getResultPath());
        System.out.println("distances: " + result.getDistances());
        System.out.println();
    }

    // Решения нет — вариант B
    static void check4() {
        Theory_BFS_Maze bfs = new Theory_BFS_Maze();

        var mazeWithNoSolutionsB = new char[][] {
                {'S', '█', '.', '█', '.', '.', '.'},
                {'.', '█', '.', '█', '.', '█', '.'},
                {'.', '█', '.', '.', '.', '█', '.'},
                {'█', '█', '█', '.', '█', '█', '.'},
                {'.', '.', '.', '.', '.', '.', 'E'}
        };

        var maze = mazeWithNoSolutionsB;
        var start = findPosition(maze, 'S');
        var end = findPosition(maze, 'E');

        var result = bfs.findShortestPath(maze, start, end);

        System.out.println("CHECK 4: No Solution B");
        printMazeWithPath(maze, result.getResultPath());
        System.out.println("distances: " + result.getDistances());
        System.out.println();
    }

    private static int[] findPosition(char[][] maze, char target) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Определение направления движения
    private static char getDirection(int[] from, int[] to) {
        if (to[0] == from[0]) {
            return to[1] > from[1] ? '→' : '←';
        } else {
            return to[0] > from[0] ? '↓' : '↑';
        }
    }

    // Вывод лабиринта с найденным путём
    private static void printMazeWithPath(char[][] maze, List<int[]> path) {
        char[][] displayMaze = new char[maze.length][maze[0].length];

        // Копируем лабиринт, чтобы не менять оригинал
        for (int i = 0; i < maze.length; i++) {
            System.arraycopy(maze[i], 0, displayMaze[i], 0, maze[i].length);
        }

        // Отмечаем путь стрелками
        if (!path.isEmpty()) {
            for (int i = 0; i < path.size() - 1; i++) {
                int[] current = path.get(i);
                int[] next = path.get(i + 1);

                char direction = getDirection(current, next);

                if (displayMaze[current[0]][current[1]] != 'S'
                        && displayMaze[current[0]][current[1]] != 'E') {
                    displayMaze[current[0]][current[1]] = direction;
                }
            }
        }

        // Печатаем лабиринт
        for (int i = 0; i < displayMaze.length; i++) {
            System.out.print("[" + i + "] ");

            for (int j = 0; j < displayMaze[i].length; j++) {
                System.out.print(" " + displayMaze[i][j] + " ");
            }

            System.out.println();
        }
    }
}

