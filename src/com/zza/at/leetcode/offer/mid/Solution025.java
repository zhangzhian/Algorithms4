package com.zza.at.leetcode.offer.mid;

//矩阵中的路径
public class Solution025 {
    //DFS + 剪枝
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    //k: 当前目标字符在 word 中的索引
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j < 0
                || j >= board[0].length
                || board[i][j] != word[k]) return false;
        //符串 word 已全部匹配
        if(k == word.length - 1) return true;
        board[i][j] = '\0';//临时赋值成‘/’，用来标记已访问的元素
        boolean res = dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
