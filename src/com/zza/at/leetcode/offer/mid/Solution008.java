package com.zza.at.leetcode.offer.mid;

//丑数
public class Solution008 {
    public int nthUglyNumber(int n) {
        //所有的丑数都是 较小丑数 * 某因子（2，3，5）
        //用三个指针，分别指向2，3，5较小丑数的索引
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        //初始化1为丑数
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            //计算当前较小丑数索引对应的新一批丑数
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            //设置当前索引丑数值为新一批中最小的值
            dp[i] = Math.min(Math.min(n2, n3), n5);
            //最新的丑数索引加1
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
