package com.zza.at.leetcode.hot100.mid;

import java.util.Arrays;

//不同路径
public class Solution025 {
    //动态规划
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public int uniquePaths1(int m, int n) {
        int[] dp = new int[m];
        for (int i = 0; i < m; ++i) {
            dp[i] = 1;
        }
        for (int j = 1; j < n; j++)
            for (int i = 1; i < m; i++)
                dp[i] += dp[i - 1];
        return dp[m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution025().uniquePaths(3,7));//28
    }
}
