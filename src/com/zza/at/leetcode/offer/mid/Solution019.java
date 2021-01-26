package com.zza.at.leetcode.offer.mid;

//二叉搜索树的后序遍历序列
public class Solution019 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.println(new Solution019().translateNum(12258));
    }
}
