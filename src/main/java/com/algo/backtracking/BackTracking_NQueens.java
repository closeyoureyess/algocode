package com.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Переписка с DeepSeek
 *
 * Ключевое слово для поиска - 525 / 736 Решебник. Backtracking_NQueens package ...;
 * https://chat.deepseek.com/a/chat/s/f0211a1d-576b-45d5-a840-a88c6b05ac85
 * https://chat.deepseek.com/a/chat/s/0dae16b7-38d5-40a2-8197-8a95c0db010a
 *
 * Разница между последовательностью, подмножеством, сочетанием, ключевое слово
 * "Множество против последовательности"
 * https://chat.deepseek.com/a/chat/s/d3bba7ea-3cef-4cff-8163-57cb1ce489be
 *
 * Ключевое слово - А не i <= row ?
 * https://chat.deepseek.com/a/chat/s/f0211a1d-576b-45d5-a840-a88c6b05ac85
 */
public class BackTracking_NQueens {

    public List<List<String>> solveNQueens(int n) {
        // 15
        List<List<String>> result = new ArrayList<>();
        char[][] boards = new char[n][n];
        for(int row = 0; row < boards.length; row++) {
            for(int col = 0; col < boards[0].length; col++) {
                boards[row][col] = '.';
            }
        }
        backtrack(boards, 0, result);
        return result;
    }
    private void backtrack(char[][] board, int row, List<List<String>> result) {
        if(row == board.length) {
            result.add(constructSolution(board));
            return;
        }

        for(int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }
    // <- проверка по:
    // 1. столбец сверху
    // 2. левая верхняя диагональ
    // 3. правая верхняя диагональ
    //
    private boolean isSafe(char[][] board, int row, int col) {
        int n = board[0].length;

        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
    private List<String> constructSolution(char[][] board) {
        List<String> result = new ArrayList<>();
        for(char[] boards : board) {
            result.add(new String(boards));
        }
        return result;
    }
}