package com.zza.at.leetcode.offer.mid;

//剪绳子
public class Solution016 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution016().cuttingRope(10));//36
    }
}
