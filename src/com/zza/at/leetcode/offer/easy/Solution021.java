package com.zza.at.leetcode.offer.easy;

//圆圈中最后剩下的数字
public class Solution021 {
    public int lastRemaining(int n, int m) {
        return  f(n,m);
    }
    //删除的位置 = (当前index + m) % 上一轮剩余数字的个数。
    public int f(int n, int m) {
        if (n == 1) return 0;
        int x = f(n-1,m);        //n本轮剩余个数， x当前索引，也就是删除的位置
        return (m+x) % n;           //返回删除的位置
    }

    public int lastRemaining1(int n, int m) {
        int x = 0;
        for (int i = 2;  i <= n; i++) {
            x = (m + x) % i;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution021().lastRemaining(5,3));//->3
    }
}
