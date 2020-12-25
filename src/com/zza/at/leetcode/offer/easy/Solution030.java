package com.zza.at.leetcode.offer.easy;

//不用加减乘除做加法
public class Solution030 {

    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public int add1(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return add1(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution030().add(9 ,10));
    }

}
