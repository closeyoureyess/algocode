package com.algo.tree_traverse.theory_dfs_iterative;

public class Main {

    public static void main(String[] args) {
        check1();
        check2();
        check3();
    }

    static void check1() {
        Theory_DFS_Iterative_Maze tdi = new Theory_DFS_Iterative_Maze();
        var mazeWithSolution =
                new char[][] {
                        {'S', '.', '.', '█', '.', '.', '.'},
                        {'.', '█', '.', '█', '.', '█', '.'},
                        {'.', '█', '.', '.', '.', '█', '.'},
                        {'█', '█', '█', '.', '█', '█', '.'},
                        {'.', '.', '.', '.', '.', '.', 'E'}
                };

        var maze = mazeWithSolution;
        var start = findPosition(maze, 'S');
        var end = findPosition(maze, 'E');
        var result = tdi.pathExists(maze,start,end);
        System.out.println(result);
    }

    static void check2() {
        Theory_DFS_Iterative_Maze tdi = new Theory_DFS_Iterative_Maze();
        var mazeWithNoSolutionsA =
                new char[][] {
                        {'S', '.', '.', '█', '.', '█', '.'},
                        {'.', '█', '.', '█', '.', '█', '.'},
                        {'.', '█', '.', '.', '.', '█', '.'},
                        {'█', '█', '█', '.', '█', '█', '.'},
                        {'.', '.', '.', '.', '.', '█', 'E'}
                };

        var maze = mazeWithNoSolutionsA;
        var start = findPosition(maze, 'S');
        var end = findPosition(maze, 'E');
        var result = tdi.pathExists(maze,start,end);
        System.out.println(result);
    }

    static void check3() {
        Theory_DFS_Iterative_Maze tdi = new Theory_DFS_Iterative_Maze();
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
        var result = tdi.pathExists(maze,start,end);
        System.out.println(result);
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
}
