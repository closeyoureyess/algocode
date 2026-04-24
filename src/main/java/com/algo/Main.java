package com.algo;

public class Main {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        for (int[] prereq : prerequisites) {
            System.out.println(prereq[0]);
        }
    }
}
