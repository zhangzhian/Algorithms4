package com.zza.at.leetcode.offer.mid;

//数字序列中某一位的数字
public class Solution027 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.确定 n 所在 数字 的 位数 ，记为 digit
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.确定 n 所在的 数字 ，记为 num
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.确定 n 是 num 中的哪一数位，并返回结果
    }
}
