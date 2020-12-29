package com.zza.at.leetcode.hot100.mid;

//回文子串
public class Solution021 {
    public int countSubstrings(String s) {
        // 动态规划法
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int countSubstrings1(String s) {
        // 中心扩展法
        int ans = 0;
        // 2 * len - 1 个中心点
        // 中心点不能只有单个字符构成，还要包括两个字符
        // 3 个可以由 1 个扩展一次得到，4 个可以由两个扩展一次得到
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution021().countSubstrings("abcba"));
        System.out.println(new Solution021().countSubstrings1("abcba"));
    }
}
